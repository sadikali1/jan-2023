package com.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDef {

	int a;
	int b;
	int result;
	
	@Given("I have two integer numbers {int} and {int}")
	public void i_have_two_integer_numbers_and(Integer int1, Integer int2) {
		a = int1;
		b = int2;
	}
	

	@When("I added both numbers")
	public void i_added_both_numbers() {
		result = a + b;
	}

	@Then("I verify both numbers sum is {int}")
	public void i_verify_both_numbers_sum_is(Integer int1) {
		Assert.assertEquals(int1, result);
	}

}
