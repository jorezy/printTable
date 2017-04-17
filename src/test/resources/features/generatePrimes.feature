Feature: generate several primes
  As a user
  I want a tool to generate a prime
  
Scenario: generate several primes
    Given I have a prime number generator tool
    When I ask for genearating the upper bound of the first 100 prime numbers
    Then the tool should be availbe to generate 100 prime numbers
    Then Every number in the result should not be divisable
    Then The first prime number should be 2
    Then The prime numbers should be consecutive