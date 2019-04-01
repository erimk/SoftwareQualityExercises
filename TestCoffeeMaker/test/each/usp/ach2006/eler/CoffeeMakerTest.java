package each.usp.ach2006.eler;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	private CoffeeMaker CM;
	private Recipe r1;
	private Recipe r2;

	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		r1 = new Recipe("Coffee",50,4,0,1,0);
		r2 = new Recipe("Hot Chocolate",75,0,3,1,3);	

	}
	
	
	/* Testa adicionar uma receita
	 * 
	 */
	
	@Test
	public void testAddOneRecipe() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(r1);
		assertTrue(ok);
	}
	
	@Test(expected = RecipeException.class)
	public void testiCreateValidRecipe() throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException {
		CM = new CoffeeMaker();
		CM.makeCoffee("Pingado", 5);		
	}

	
}
