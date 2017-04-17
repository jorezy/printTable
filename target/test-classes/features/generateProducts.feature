Feature: generate a multiplication table
  
Scenario: generate the nth primes
    Given I have a multiplication table tool
    When given 10 prime numbers
    Then multiplication should be generated
    Then The first row of the table should have the 10 primes
    Then The First column of the table should have the 10 primes
    Then Each cell containing the product of the primes for the corresponding row and column
    Then The table should be symmetric