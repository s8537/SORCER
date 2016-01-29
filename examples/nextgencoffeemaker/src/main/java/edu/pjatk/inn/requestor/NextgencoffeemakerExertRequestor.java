package edu.pjatk.inn.requestor;

import edu.pjatk.inn.nextgencoffeemaker.NextgencoffeeService;
import edu.pjatk.inn.nextgencoffeemaker.Delivery;
import edu.pjatk.inn.nextgencoffeemaker.Payment;
import edu.pjatk.inn.nextgencoffeemaker.RMA;
import sorcer.core.requestor.ExertRequestor;
import sorcer.service.*;
import sorcer.service.modeling.Model;

import java.io.File;

import static sorcer.co.operator.*;
import static sorcer.eo.operator.*;
import static sorcer.mo.operator.responseUp;
import static sorcer.po.operator.invoker;

public class NextgencoffeemakerExertRequestor extends ExertRequestor {

    public Mogram getMogram(String... args) throws MogramException {

        String option = "exertion";
        if (args != null && args.length == 2) {
            option = args[1];
        } else if (this.args != null) {
            option = this.args[0];
        } else {
            throw new MogramException("wrong arguments for: ExertRequestor type, mogram type");
        }
        try {
            if (option.equals("netlet")) {
                return (Exertion) evaluate(new File("src/main/netlets/nextgencoffeemaker-exertion-remote.ntl"));
            } else if (option.equals("model")) {
                return createModel();
            } else if (option.equals("exertion")) {
                return createExertion();
            }
        } catch (Exception e) {
            throw new MogramException(e);
        }
        return null;
    }

    private Context getEspressoContext() throws ContextException {
        return context(ent("name", "espresso"), ent("price", 50),
                ent("amtCoffee", 6), ent("amtMilk", 0),
                ent("amtSugar", 1), ent("amtChocolate", 0));
    }

    private Task getRecipeTask() throws MogramException, SignatureException {
        // make sure we have a recipe for required coffee
       return task("recipe", sig("addRecipe", NextgencoffeeService.class), getEspressoContext());
    }

    private Exertion createExertion() throws Exception {
        Task coffee = task("coffee", sig("makeCoffee", NextgencoffeeService.class), context(
                ent("recipe/name", "espresso"),
                ent("coffee/paid", 0),
                ent("coffee/change"),
                ent("payment/paid"),
                ent("payment/method"),
                ent("recipe", getEspressoContext())));

//        Task payment = task("payment", sig("payment", Payment.class), context(
//                ent("amount", 120),
//                ent("method", "mobile"),
//                ent("paid")));

        Task rma = task("rma", sig("rma", RMA.class), context(
                ent("description", "Coffee is lacking milk")
        ));

        Job payCoffee = job(rma, coffee,
                pipe(outPoint(rma, "rma/result"), inPoint(coffee, "coffee/name")));

        return payCoffee;
    }

    private Model createModel() throws Exception {
        exert(getRecipeTask());

        Model mdl = model(
                ent("recipe/name", "espresso"),
                ent("paid$", 120),

                srv(sig("makeCoffee", NextgencoffeeService.class,
                        result("coffee$", inPaths("recipe/name")))),
                srv(sig("payment", Payment.class,
                        result("payment$", inPaths("amount", "paid")))),
                srv(sig("rma", RMA.class,
                        result("rma$", inPaths("description", "result")))));

        dependsOn(mdl, ent("change$", "makeCoffee"), ent("change$", "pay"));
        responseUp(mdl, "makeCoffee", "pay", "change$", "paid$");



        return mdl;
    }

}