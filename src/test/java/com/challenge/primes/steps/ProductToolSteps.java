package com.challenge.primes.steps;

import com.challenge.primes.multiplicaiton.AKS;
import com.challenge.primes.multiplicaiton.ProductMatrix;
import com.challenge.primes.multiplicaiton.SieveEratosthenes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductToolSteps {
	private SieveEratosthenes sieveTool;
	private ProductMatrix productTool;
	private List<Integer> primes;
	private int[][] products;
	
	@Given("^I have a multiplication table tool$")
	public void i_have_a_multiplication_table_tool() throws Throwable {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		sieveTool = (SieveEratosthenes) context.getBean("sieveEratosthenes");
		productTool = (ProductMatrix) context.getBean("productMatrix");
		SieveEratosthenes sieveTool = (SieveEratosthenes) context.getBean("sieveEratosthenes");
	}
	
	@When("^given (\\d+) prime numbers$")
	public void given_prime_numbers(int arg1) throws Throwable {
		primes = sieveTool.getPrimes(arg1);		
	}
	
	@Then("^multiplication should be generated$")
	public void multiplication_should_be_generated() throws Throwable {
		productTool.initilize(primes, primes);
		products = productTool.getSymmetricProducts();
		assert(products!=null);
	}
	
	@Then("^The first row of the table should have the (\\d+) primes$")
	public void the_first_row_of_the_table_should_have_the_primes(int arg1) throws Throwable {
		for(int i=1;i< products.length;i++)
			assert(products[0][i] == primes.get(i-1) );
	}
	
	@Then("^The First column of the table should have the (\\d+) primes$")
	public void the_First_column_of_the_table_should_have_the_primes(int arg1) throws Throwable {
		for(int i=1;i< products.length;i++)
			assert(products[i][0] == primes.get(i-1) );
	}
	
	@Then("^Each cell containing the product of the primes for the corresponding row and column$")
	public void each_cell_containing_the_product_of_the_primes_for_the_corresponding_row_and_column() throws Throwable {
		for(int i=1;i< products.length;i++){
			for(int j=1;j<products.length;j++){
					assert(products[i][j]==products[i][0]*products[0][j]);
			}
		}
	}
	
	@Then("^The table should be symmetric$")
	public void the_table_should_be_symmetric() throws Throwable {
		for(int i=1;i< products.length;i++){
			for(int j=1;j<products.length;j++){
				assert(products[i][j]==products[j][i]);					
			}
		}
	}
}

