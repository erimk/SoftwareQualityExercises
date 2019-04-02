package each.usp.ach2006.eler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	private Recipe r0;
	private Recipe r1;
	private Recipe r2;

	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		r1 = new Recipe("Coffee",50,4,0,1,0);
		r2 = new Recipe("Hot Chocolate",5,4,3,2,1);
		r0 = new Recipe("Cappuccino",1,1,1,1,1);
	}
	
	/**
	 * Testa adicionar uma receita corretamente.
	 */
	@Test
	public void testAddOneRecipe() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(r1);
		assertTrue(ok);
	}
	
	/**
	 * Testa o nome único das receitas.
	 * @throws InvalidValueException 
	 */
	@Test
	public void testValidDiferentNameRecipes() throws AmountOfRecipeException, DuplicatedRecipeException, InvalidValueException{
		CM.addRecipe(r1);
		CM.addRecipe(r2);
	}
	
	/**
	 * Testa adicionar uma receita repetida
	 */
	@Test(expected = DuplicatedRecipeException.class)
	public void testAddSameRecipe() throws AmountOfRecipeException, DuplicatedRecipeException {
		CM.addRecipe(r1);
		CM.addRecipe(r1);		
	}
	
	/**
	 * Testa pedido de uma receita que não existe
	 */	
	@Test(expected = RecipeException.class)
	public void testOrderingInexistentRecipe()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException {
		CM = new CoffeeMaker();
		CM.makeCoffee("Pingado", 5);
	}
	
	/**
	 * Testa pedido de receitas com mesmos ingredientes e nomes diferentes.
	 * @throws DuplicatedRecipeException 
	 * @throws AmountOfRecipeException 
	 */	
	@Test(expected = DuplicatedRecipeException.class)
	public void testAllSameIngredientRecipes()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate());
		r2.setAmtCoffee(r1.getAmtCoffee());
		r2.setAmtMilk(r1.getAmtMilk());
		r2.setAmtSugar(r1.getAmtSugar());
		r2.setPrice(r1.getPrice());
		CM.addRecipe(r2);
	}
	/**
	 * Testa pedido de receitas com mesmos ingredientes e nomes diferentes.
	 * @throws DuplicatedRecipeException 
	 * @throws AmountOfRecipeException 
	 */	
	@Test
	public void testSameIngredientRecipesButNameAndChocolate()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate()+1);
		r2.setAmtCoffee(r1.getAmtCoffee());
		r2.setAmtMilk(r1.getAmtMilk());
		r2.setAmtSugar(r1.getAmtSugar());
		r2.setPrice(r1.getPrice());
		CM.addRecipe(r2);
	}
	@Test
	public void testSameIngredientRecipesButNameAndCoffe()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate());
		r2.setAmtCoffee(r1.getAmtCoffee()+1);
		r2.setAmtMilk(r1.getAmtMilk());
		r2.setAmtSugar(r1.getAmtSugar());
		r2.setPrice(r1.getPrice());
		CM.addRecipe(r2);
	}
	@Test
	public void testSameIngredientRecipesButNameAndMilk()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate());
		r2.setAmtCoffee(r1.getAmtCoffee());
		r2.setAmtMilk(r1.getAmtMilk()+1);
		r2.setAmtSugar(r1.getAmtSugar());
		r2.setPrice(r1.getPrice());
		CM.addRecipe(r2);
	}
	@Test
	public void testSameIngredientRecipesButNameAndSugar()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate());
		r2.setAmtCoffee(r1.getAmtCoffee());
		r2.setAmtMilk(r1.getAmtMilk());
		r2.setAmtSugar(r1.getAmtSugar()+1);
		r2.setPrice(r1.getPrice());
		CM.addRecipe(r2);
	}
	@Test(expected = DuplicatedRecipeException.class)
	public void testSameIngredientRecipesButNameAndPrice()
			throws RecipeException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		CM.addRecipe(r1);
		r2.setName(r1.getName()+"2");
		r2.setAmtChocolate(r1.getAmtChocolate());
		r2.setAmtCoffee(r1.getAmtCoffee());
		r2.setAmtMilk(r1.getAmtMilk());
		r2.setAmtSugar(r1.getAmtSugar());
		r2.setPrice(r1.getPrice()+1);
		CM.addRecipe(r2);
	}
	@Test(expected = Exception.class)
	public void testNotIntegerPrice()
			throws RecipeException, InsufficientAmountOfMoneyException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
	r1.setPrice(1/2);
	}

	//Era pra falhar no chocolate
	@Test
	public void testIntegerCoffeRecipesChocolate()
			throws RecipeException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		r0.setAmtChocolate(r0.getAmtChocolate()/2);
		r0.setAmtCoffee(r0.getAmtCoffee());
		r0.setAmtMilk(r0.getAmtMilk());
		r0.setAmtSugar(r0.getAmtSugar());
		r0.setPrice(r0.getPrice());
		CM.addRecipe(r0);
	}
	@Test
	public void testIntegerCoffeRecipeCoffe()
			throws RecipeException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		r0.setAmtChocolate(r0.getAmtChocolate());
		r0.setAmtCoffee(r0.getAmtCoffee()/2);
		r0.setAmtMilk(r0.getAmtMilk());
		r0.setAmtSugar(r0.getAmtSugar());
		r0.setPrice(r0.getPrice());
		CM.addRecipe(r0);
	}
	@Test
	public void testIntegerCoffeRecipeMilk()
			throws RecipeException, InventoryException, InvalidValueException, AmountOfRecipeException, DuplicatedRecipeException {
		CM = new CoffeeMaker();
		r0.setAmtChocolate(r0.getAmtChocolate());
		r0.setAmtCoffee(r0.getAmtCoffee()/2);
		r0.setAmtMilk(r0.getAmtMilk());
		r0.setAmtSugar(r0.getAmtSugar());
		r0.setPrice(r0.getPrice());
		CM.addRecipe(r0);
	}
}
