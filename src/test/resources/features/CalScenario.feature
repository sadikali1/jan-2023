@Regression 
Feature: Title of your feature
  I want to use this template for my feature file

	Background: 
    Given I am background
	
	@Regression  @Smoke
  Scenario: calculation with two int value
    Given I have two integer numbers 10 and 20
    When I added both numbers
    Then I verify both numbers sum is 30

	@Regression 
  Scenario Outline: calculation with two int value
    Given I have two integer numbers <value1> and <value2>
    When I added both numbers
    Then I verify both numbers sum is <result>

    Examples: 
      | value1 | value2 | result |
      |     10 |     20 |     30 |
      |      3 |     10 |     13 |
      |     34 |      5 |     39 |
      |     10 |     30 |     19 |
      |     15 |     25 |     40 |
