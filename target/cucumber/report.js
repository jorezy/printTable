$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/generatePrimes.feature");
formatter.feature({
  "line": 1,
  "name": "generate several primes",
  "description": "As a user\r\nI want a tool to generate a prime",
  "id": "generate-several-primes",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "generate several primes",
  "description": "",
  "id": "generate-several-primes;generate-several-primes",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I have a prime number generator tool",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I ask for genearating the upper bound of the first 100 prime numbers",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the tool should be availbe to generate 100 prime numbers",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Every number in the result should not be divisable",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The first prime number should be 2",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "The prime numbers should be consecutive",
  "keyword": "Then "
});
formatter.match({
  "location": "PrimeToolSteps.i_have_a_prime_number_generator_tool()"
});
formatter.result({
  "duration": 3730555225,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 51
    }
  ],
  "location": "PrimeToolSteps.i_ask_for_genearating_the_upper_bound_of_the_first_prime_numbers(int)"
});
formatter.result({
  "duration": 6850551,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 39
    }
  ],
  "location": "PrimeToolSteps.the_tool_should_be_availbe_to_generate_prime_numbers(int)"
});
formatter.result({
  "duration": 339626,
  "status": "passed"
});
formatter.match({
  "location": "PrimeToolSteps.every_number_in_the_result_should_not_be_divisable()"
});
formatter.result({
  "duration": 239190734,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 33
    }
  ],
  "location": "PrimeToolSteps.the_first_prime_number_should_be(int)"
});
formatter.result({
  "duration": 185600,
  "status": "passed"
});
formatter.match({
  "location": "PrimeToolSteps.the_prime_numbers_should_be_consecutive()"
});
formatter.result({
  "duration": 22379918,
  "status": "passed"
});
formatter.uri("features/generateProducts.feature");
formatter.feature({
  "line": 1,
  "name": "generate a multiplication table",
  "description": "",
  "id": "generate-a-multiplication-table",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "generate the nth primes",
  "description": "",
  "id": "generate-a-multiplication-table;generate-the-nth-primes",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have a multiplication table tool",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "given 10 prime numbers",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "multiplication should be generated",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "The first row of the table should have the 10 primes",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "The First column of the table should have the 10 primes",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Each cell containing the product of the primes for the corresponding row and column",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The table should be symmetric",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductToolSteps.i_have_a_multiplication_table_tool()"
});
formatter.result({
  "duration": 2646001093,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 6
    }
  ],
  "location": "ProductToolSteps.given_prime_numbers(int)"
});
formatter.result({
  "duration": 235947,
  "status": "passed"
});
formatter.match({
  "location": "ProductToolSteps.multiplication_should_be_generated()"
});
formatter.result({
  "duration": 106666,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 43
    }
  ],
  "location": "ProductToolSteps.the_first_row_of_the_table_should_have_the_primes(int)"
});
formatter.result({
  "duration": 130560,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 46
    }
  ],
  "location": "ProductToolSteps.the_First_column_of_the_table_should_have_the_primes(int)"
});
formatter.result({
  "duration": 135680,
  "status": "passed"
});
formatter.match({
  "location": "ProductToolSteps.each_cell_containing_the_product_of_the_primes_for_the_corresponding_row_and_column()"
});
formatter.result({
  "duration": 131840,
  "status": "passed"
});
formatter.match({
  "location": "ProductToolSteps.the_table_should_be_symmetric()"
});
formatter.result({
  "duration": 249600,
  "status": "passed"
});
});