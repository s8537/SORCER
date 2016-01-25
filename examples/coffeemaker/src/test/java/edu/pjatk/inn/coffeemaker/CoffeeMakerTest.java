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
	private Recipe testCoffee testCoffee3 testCoffee4 testCoffee5 testCoffee6;

	@Before
	public void setUp() throws ContextException {
		coffeeMaker = new CoffeeMaker();
		inventory = coffeeMaker.checkInventory();

		testCoffee = new Recipe();
		testCoffee.setName("Caffee");
		testCoffee.setPrice(50);
		testCoffee.setAmtCoffee(6);
		testCoffee.setAmtMilk(1);
		testCoffee.setAmtSugar(1);
		testCoffee.setAmtChocolate(0);
		//
		testCoffee3 = new Recipe();
		testCoffee3.setName("Mocha");
		testCoffee3.setPrice(-50);
		testCoffee3.setAmtCoffee(6);
		testCoffee3.setAmtMilk(1);
		testCoffee3.setAmtSugar(1);
		testCoffee3.setAmtChocolate(0);
		//
		testCoffee4 = new Recipe();
		testCoffee4.setName("Mocha");
		testCoffee4.setPrice(60);
		testCoffee4.setAmtCoffee(-3);
		testCoffee4.setAmtMilk(1);
		testCoffee4.setAmtSugar(1);
		testCoffee4.setAmtChocolate(0);
		//
		testCoffee5 = new Recipe();
		testCoffee5.setName("Mocha");
		testCoffee5.setPrice(60);
		testCoffee5.setAmtCoffee(3);
		testCoffee5.setAmtMilk(-2);
		testCoffee5.setAmtSugar(1);
		testCoffee5.setAmtChocolate(0);
		//
		testCoffee6 = new Recipe();
		testCoffee6.setName("Mocha");
		testCoffee6.setPrice(60);
		testCoffee6.setAmtCoffee(3);
		testCoffee6.setAmtMilk(2);
		testCoffee6.setAmtSugar(-2);
		testCoffee6.setAmtChocolate(0);



	}

	@Test
	public void testAddRecipe1() {
		assertTrue(coffeeMaker.addRecipe(testCoffee));
	}
	@Test
	public void testAddRecipe2() {
		assertTrue(coffeeMaker.addRecipe(testCoffee));
		assertTrue(coffeeMaker.addRecipe(testCoffee));
	}

	@Test
	public void testAddRecipe3() {
		assertTrue(coffeeMaker.addRecipe(testCoffee3));
	}

	@Test
	public void testAddRecipe4() {
		assertTrue(coffeeMaker.addRecipe(testCoffee4));
	}

	@Test
	public void testAddRecipe5() {
		assertTrue(coffeeMaker.addRecipe(testCoffee5));
	}

	@Test
	public void testAddRecipe6() {
		assertTrue(coffeeMaker.addRecipe(testCoffee6));
	}
/*

	@Test
	public void testContextCofee() throws ContextException {
		assertTrue(americano.getAmtCoffee() == 7);
	}
/*
	@Test
	public void testContextMilk() throws ContextException {
		assertTrue(espresso.getAmtMilk() == 1);
	}

	@Test
	public void addRecepie() throws Exception {
		coffeeMaker.addRecipe(mocha);
		assertEquals(coffeeMaker.getRecipeForName("mocha").getName(), "mocha");
	}

	@Test
	public void addContextRecepie() throws Exception {
		coffeeMaker.addRecipe(Recipe.getContext(mocha));
		assertEquals(coffeeMaker.getRecipeForName("mocha").getName(), "mocha");
	}

	@Test
	public void addServiceRecepie() throws Exception {
		Exertion cmt = task(sig("addRecipe", coffeeMaker),
						context(parameterTypes(Recipe.class), args(espresso),
							result("recipe/added")));

		logger.info("isAdded: " + value(cmt));
		assertEquals(coffeeMaker.getRecipeForName("espresso").getName(), "espresso");
	}

	@Test
	public void addRecipes() throws Exception {
		coffeeMaker.addRecipe(mocha);
		coffeeMaker.addRecipe(macchiato);
		coffeeMaker.addRecipe(americano);

		assertEquals(coffeeMaker.getRecipeForName("mocha").getName(), "mocha");
		assertEquals(coffeeMaker.getRecipeForName("macchiato").getName(), "macchiato");
		assertEquals(coffeeMaker.getRecipeForName("americano").getName(), "americano");
	}

	@Test
	public void makeCoffee() throws Exception {
		coffeeMaker.addRecipe(espresso);
		assertEquals(coffeeMaker.makeCoffee(espresso, 200), 150);
	}
*/
	@Test
	public void checkInventory() throws Exception {
		
	}
}

