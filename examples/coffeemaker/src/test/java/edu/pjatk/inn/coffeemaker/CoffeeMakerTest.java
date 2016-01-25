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
	private Recipe addRecipe_t1, addRecipe_t2, addRecipe_t3, addRecipe_t4;

	@Before
	public void setUp() throws ContextException {
		coffeeMaker = new CoffeeMaker();
		inventory = coffeeMaker.checkInventory();

		addRecipe_t1 = new Recipe();
		addRecipe_t1.setName("Caffee");
		addRecipe_t1.setPrice(50);
		addRecipe_t1.setAmtCoffee(3);
		addRecipe_t1.setAmtMilk(1);
		addRecipe_t1.setAmtSugar(1);
		addRecipe_t1.setAmtChocolate(0);

		addRecipe_t2 = new Recipe();
		addRecipe_t2.setName("Latte");
		addRecipe_t2.setPrice(60);
		addRecipe_t2.setAmtCoffee(3);
		addRecipe_t2.setAmtMilk(3);
		addRecipe_t2.setAmtSugar(2);
		addRecipe_t2.setAmtChocolate(0);

		addRecipe_t3 = new Recipe();
		addRecipe_t3.setName("Hot Chocolate");
		addRecipe_t3.setPrice(60);
		addRecipe_t3.setAmtCoffee(0);
		addRecipe_t3.setAmtMilk(2);
		addRecipe_t3.setAmtSugar(2);
		addRecipe_t3.setAmtChocolate(3);

		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(2);
		addRecipe_t4.setAmtSugar(2);
		addRecipe_t4.setAmtChocolate(3);
	}

	@Test
	public void addRecipe1() {
		coffeeMaker.addRecipe(addRecipe_t1);
		assertEquals(coffeeMaker.getRecipeForName("Coffee").getName(), "Coffee");
	}

	@Test
	public void addRecipe2() {
		coffeeMaker.addRecipe(addRecipe_t1);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t1));
	}

	@Test
	public void addRecipe3() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(-50);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe4() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(-3);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe5() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(-2);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe6() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(2);
		addRecipe_t4.setAmtSugar(-2);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe7() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(2);
		addRecipe_t4.setAmtSugar(2);
		addRecipe_t4.setAmtChocolate(-3);
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}


	@Test
	public void addRecipe8() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe9() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe10() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe11() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(2);
		addRecipe_t4.setAmtSugar(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe12() {
		addRecipe_t4 = new Recipe();
		addRecipe_t4.setName("Mocha");
		addRecipe_t4.setPrice(60);
		addRecipe_t4.setAmtCoffee(3);
		addRecipe_t4.setAmtMilk(2);
		addRecipe_t4.setAmtSugar(2);
		addRecipe_t4.setAmtChocolate(Integer.getInteger("a"));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe13() {
		assertTrue(coffeeMaker.addRecipe(addRecipe_t4));
	}

	@Test
	public void addRecipe14() {
		assertTrue(coffeeMaker.addRecipe(addRecipe_t4));
		assertTrue(coffeeMaker.addRecipe(addRecipe_t2));
	}

	@Test
	public void addRecipe15() {
		assertTrue(coffeeMaker.addRecipe(addRecipe_t4));
		assertTrue(coffeeMaker.addRecipe(addRecipe_t2));
		assertFalse(coffeeMaker.addRecipe(addRecipe_t3));
	}

	@Test
	public void deleteRecipe1() {
		coffeeMaker.addRecipe(addRecipWe_t1);
		assertTrue(coffeeMaker.deleteRecipe(addRecipe_t1));
	}

	@Test
	public void deleteRecipe2() {
		assertFalse(coffeeMaker.deleteRecipe(addRecipe_t1));
	}

}

