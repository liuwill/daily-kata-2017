Feature: diversion binary group

  Scenario: binary number diversion numbers
    Given a list of binary number
    When give binary below
      |1001|0001|101|10101|01101|
    Then it has 4 binary match

  Scenario: binary number diversion numbers second
    Given a list of binary number
    When give binary below
      |10101|00011|1101|101101|010101|0|1|11|01|
    Then it has 5 binary match

  Scenario: all three bits binary number diversion
    Given a list of binary number
    When give binary below
      |000|001|010|011|100|101|110|111|
    Then it has 5 binary match

