package each.usp.ach2006.eler_old;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

public class RecipeTest{

	/**
	 * Testa a criação de uma receita
	 */

	String name = "Coffee";
	int price = 50;
	int amtCoffee = 4;
	int amtMilk = 0;
	int amtSugar = 1;
	int amtChocolate = 0;
	private CoffeeMaker CM;

	@Test
	public void testCreateValidRecipe() throws InvalidValueException {

		Recipe recipe = new Recipe(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);
		// se nao lançar excessão é porque a receita foi criada
		assertEquals(price, recipe.getPrice());
		assertEquals(amtCoffee, recipe.getAmtCoffee());
		assertEquals(amtMilk, recipe.getAmtMilk());
		assertEquals(amtSugar, recipe.getAmtSugar());
		assertEquals(amtChocolate, recipe.getAmtChocolate());

	}	

	@Test(expected = InvalidValueException.class)
	public void testInvalidPrice() throws InvalidValueException {
		Recipe recipe = new Recipe(name, 0, amtCoffee, amtMilk, amtSugar, amtChocolate);
	}

	@Test
	public void testValidPrice() throws InvalidValueException {
		Recipe recipe = new Recipe(name, 1, amtCoffee, amtMilk, amtSugar, amtChocolate);
	}
	
	/**
	 * Testa criar uma receita sem nome
	 */
	@Test(expected = InvalidValueException.class)
	public void testAddOneRecipeUnnamed() throws InvalidValueException {
		Recipe recipe = new Recipe("", price, amtCoffee, amtMilk, amtSugar, amtChocolate);
		
	}
	
	/**
	 * Testa criar uma receita sem ingredientes
	 */
	@Test(expected = InvalidValueException.class)
	public void testAddRecipeWithoutItems() throws InvalidValueException {
		Recipe recipe = new Recipe(name, 0, 0, 0, 0, 0);		
	}
	/**
	 * Testa criar uma receita sem ingredientes
	 */
	//@Test(expected = InvalidValueException.class)
	@Test
	public void testRecipeWithOneitem() throws InvalidValueException {
		Recipe recipe = new Recipe(name, price, 0, 0, 0, amtSugar);	
		//each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException: Units of sugar must be a positive integer
		//at each.usp.ach2006.adaptedfromcsc326.eler.Recipe.setAmtSugar(Recipe.java:94)
	}

}
