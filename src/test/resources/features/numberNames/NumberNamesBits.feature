Feature: number names transform

  Scenario: test one bit
    Given we will offer a int number with 1 bit
    When it is 7
    Then result is [seven]

  Scenario: test two bit
    Given we will offer a int number with 2 bit
    When it is 12
    Then result is [twelve]

  Scenario: test three bit
    Given we will offer a int number with 3 bit
    When it is 916
    Then result is [nine hundred and sixteen]

  Scenario: test three bit with middle zero
    Given we will offer a int number with 3 bit
    When it is 304
    Then result is [three hundred and four]

  Scenario: test three bit with last zero
    Given we will offer a int number with 3 bit
    When it is 520
    Then result is [five hundred and twenty]

  Scenario: test three bit with both zero
    Given we will offer a int number with 3 bit
    When it is 800
    Then result is [eight hundred]