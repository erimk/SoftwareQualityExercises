package each.usp.ach2006.eler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;

public class RecipeTest {
	/*Testa a criação de uma receita
	 
	 */
	
	String name = "Coffee";
	int price = 50;
	int amtCoffee = 20;
	int amtMilk = 20;
	int amtSugar =20;
	int amtChocolate =20;
	
	@Test
	public void testCreateValidRecipe() throws InvalidValueException{
	
		Recipe recipe = new Recipe(name,price,amtCoffee	,amtMilk,amtSugar,amtChocolate);
		//se nao lançar exceção é porque a receita foi criada
		assertEquals(price,recipe.getPrice());
		assertEquals(amtCoffee, recipe.getAmtCoffee());
		assertEquals(amtMilk, recipe.getAmtMilk());
		assertEquals(amtSugar, recipe.getAmtSugar());
		assertEquals(amtChocolate, recipe.getAmtChocolate());
	
	}

	/*----------------Testes passados com sucesso--------------------*/
	// VÁLIDO: valor da receita > 0
	@Test
	public void testValidPrice() throws InvalidValueException{
		Recipe recipe = new Recipe(name,1,amtCoffee,amtMilk,amtSugar,amtChocolate);
	}
	
	//INVÁLIDO: valor da receita =0, ou seja é um valor inválido para preço
	@Test(expected = InvalidValueException.class)
	public void testInvalidPrice() throws InvalidValueException{
		Recipe recipe = new Recipe(name,0,amtCoffee,amtMilk,amtSugar,amtChocolate);
	}
	
	// VÁLIDO: receita pode ter 1 acúcar 
	@Test
	public void testValidAmountSugar() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,0,1,0);
	}
	
	// VÁLIDO: receita contendo 1 unidade de café + 1 unidade de açúcar
	@Test
	public void testValidAmountCoffeeSugar() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,0,1,0);
	}
	
	// VÁLIDO: receita contendo 1 unidade de leite + 1 unidade de açúcar
	@Test
	public void testValidAmountMilkSugar() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,1,1,0);
	}
	
	// VÁLIDO: receita contendo 1 unidade de açúcar + 1 unidade de chocolate
	@Test
	public void testValidAmountSugarChocolate() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,0,1,1);
	}
	
	// VÁLIDO: receita contendo 1 unidade de café + 1 unidade de leite + 1 unidade de açúcar
	@Test
	public void testValidAmountCoffeeMilkSugar() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,1,1,0);
	}
	
	// VÁLIDO: receita contendo 1 unidade de leite + 1 unidade de açúcar + 1 unidade de chocolate  
	@Test
	public void testValidAmountMilkSugarChocolat() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,1,1,1);
	}
	
	// VÁLIDO: receita contendo todos ingredientes disponíveis
	@Test
	public void testValidAmountAllIngredients() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,1,1,1);
	}
	
	// VÁLIDO: receita precisa ter um nome
	@Test
	public void testValidNameRecipe() throws InvalidValueException{
		Recipe recipe = new Recipe("a",price,amtCoffee,amtMilk,amtSugar,amtChocolate);
	}
	
	// VÁLIDO: receita precisa ter um nome
	@Test
	public void testValidNameRecipe1() throws InvalidValueException{
		Recipe recipe = new Recipe("cold brew",price,amtCoffee,amtMilk,amtSugar,amtChocolate);
	}
	
	//INVÁLIDO: nome da receita não pode ser vazio
	@Test(expected = InvalidValueException.class)
	public void testInvalidNameRecipe() throws InvalidValueException{
		Recipe recipe = new Recipe("",price,amtCoffee,amtMilk,amtSugar,amtChocolate);
	}
		
	/*-----------------Testes corretos que não passaram --------------------*/
	/*
	// VÁLIDO: receita pode ter pelo menos 1 café
	@Test
	public void testValidAmountCoffee() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,0,0,0);
	}
		
	// VÁLIDO: receita pode ter pelo menos 1 leite
	@Test
	public void testValidAmountMilk() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,1,0,0);
	}
	
	// VÁLIDO: receita pode ter pelo menos 1 chocolate
	@Test
	public void testValidAmountChocolate() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,0,0,1);
	}
	
	// VÁLIDO: receita contendo 1 unidade de café + 1 unidade de Leite
	@Test
	public void testValidAmountCoffeeMilk() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,1,0,0);
	}
	
	// VÁLIDO: receita contendo 1 unidade de café + 1 unidade de chocolate
	@Test
	public void testValidAmountCoffeeChocolate() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,1,0,0,1);
	}

	// VÁLIDO: receita contendo 1 unidade de leite + 1 unidade de chocolate
	@Test
	public void testValidAmountMilkChocolate() throws InvalidValueException{
		Recipe recipe = new Recipe(name,price,0,1,0,1);
	}

	
	*/
}
