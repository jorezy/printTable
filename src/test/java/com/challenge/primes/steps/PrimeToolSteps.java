package com.challenge.primes.steps;

import com.challenge.primes.multiplicaiton.AKS;
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

public class PrimeToolSteps {
	private SieveEratosthenes sieveTool;
	private AKS aksTool;
	private int generatedNumber;
	private int askedNumber;
	private List<Integer> primes;
	
	@Given("^I have a prime number generator tool$")
	public void i_have_a_prime_number_generator_tool() throws Throwable {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		sieveTool = (SieveEratosthenes) context.getBean("sieveEratosthenes");
		aksTool = (AKS) context.getBean("aks");	
	}
	
	@When("^I ask for genearating the upper bound of the first (\\d+) prime numbers$")
	public void i_ask_for_genearating_the_upper_bound_of_the_first_prime_numbers(int arg1) throws Throwable {
		askedNumber = arg1;
		primes = sieveTool.getPrimes(arg1);
		generatedNumber = primes.size();
	}

	@Then("^the tool should be availbe to generate (\\d+) prime numbers$")
	public void the_tool_should_be_availbe_to_generate_prime_numbers(int arg1) throws Throwable {
		assert(arg1==generatedNumber);
	}
	
	@Then("^Every number in the result should not be divisable$")
	public void every_number_in_the_result_should_not_be_divisable() throws Throwable {  
		if(this.primes!=null){
			for(Integer i: this.primes)
			{
				assert( aksTool.checkIsPrime( BigInteger.valueOf(i)) );
			}
		}
	}
	
	@Then("^The first prime number should be (\\d+)$")
	public void the_first_prime_number_should_be(int arg1) throws Throwable {
		if(this.primes!=null){
			assert(primes.get(0).intValue()==2);
		}
	}
	
	@Then("^The prime numbers should be consecutive$")
	public void the_prime_numbers_should_be_consecutive() throws Throwable {
		if(this.primes!=null){
			for(int i=2;i<Collections.max(primes);i++){
				if(!primes.contains(i)){
					assert( aksTool.checkIsPrime(BigInteger.valueOf(i)) ==false );					
				}
			}
		}		
	}

}
