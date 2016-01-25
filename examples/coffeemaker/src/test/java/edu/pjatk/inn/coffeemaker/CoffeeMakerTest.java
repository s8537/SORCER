package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;
import sorcer.service.Exertion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static sorcer.eo.operator.*;

/**
 * @author Mike Sobolewski
 */
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerTest {
	private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTest.class);

	private CoffeeMaker coffeeMaker;
	private Inventory inventory;
	private Recipe mocha, latte, coffee, hotChoco;

	@Before
	public void setUp() throws ContextException {
		coffeeMaker = new CoffeeMaker();
		inventory = coffeeMaker.checkInventory();

		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(2);
		mocha.setAmtSugar(2);
		mocha.setAmtChocolate(3);

		latte = new Recipe();
		latte.setName("Latte");
		latte.setPrice(60);
		latte.setAmtCoffee(3);
		latte.setAmtMilk(3);
		latte.setAmtSugar(2);
		latte.setAmtChocolate(0);

		hotChoco = new Recipe();
		hotChoco.setName("Hot Chocolate");
		hotChoco.setPrice(60);
		hotChoco.setAmtCoffee(0);
		hotChoco.setAmtMilk(2);
		hotChoco.setAmtSugar(2);
		hotChoco.setAmtChocolate(3);

		coffee = new Recipe();
		coffee.setName("Coffee");
		coffee.setPrice(50);
		coffee.setAmtCoffee(3);
		coffee.setAmtMilk(1);
		coffee.setAmtSugar(1);
		coffee.setAmtChocolate(0);
	}

	@Test
	public void addRecipe1() {
		coffeeMaker.addRecipe(coffee);
		assertEquals(coffeeMaker.getRecipeForName("Coffee").getName(), "Coffee");
	}

	@Test
	public void addRecipe2() {
		coffeeMaker.addRecipe(coffee);
		assertFalse(coffeeMaker.addRecipe(coffee));
	}

	@Test
	public void addRecipe3() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(-50);
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe4() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(-3);
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe5() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(-2);
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe6() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(2);
		mocha.setAmtSugar(-2);
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe7() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(2);
		mocha.setAmtSugar(2);
		mocha.setAmtChocolate(-3);
		assertFalse(coffeeMaker.addRecipe(mocha));
	}


	@Test
	public void addRecipe8() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe9() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe10() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe11() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(2);
		mocha.setAmtSugar(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe12() {
		mocha = new Recipe();
		mocha.setName("Mocha");
		mocha.setPrice(60);
		mocha.setAmtCoffee(3);
		mocha.setAmtMilk(2);
		mocha.setAmtSugar(2);
		mocha.setAmtChocolate(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe13() {
		assertTrue(coffeeMaker.addRecipe(mocha));
	}

	@Test
	public void addRecipe14() {
		assertTrue(coffeeMaker.addRecipe(mocha));
		assertTrue(coffeeMaker.addRecipe(latte));
	}

	@Test
	public void addRecipe15() {
		assertTrue(coffeeMaker.addRecipe(mocha));
		assertTrue(coffeeMaker.addRecipe(latte));
		assertFalse(coffeeMaker.addRecipe(hotChoco));
	}

	@Test
	public void deleteRecipe1() {
		coffeeMaker.addRecipe(coffee);
		assertTrue(coffeeMaker.deleteRecipe(coffee));
	}

	@Test
	public void deleteRecipe2() {
		assertFalse(coffeeMaker.deleteRecipe(coffee));
	}

}

