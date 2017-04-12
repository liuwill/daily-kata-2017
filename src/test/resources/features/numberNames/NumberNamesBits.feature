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

  Scenario: test sample data 1
    Given we will offer a int number with 8 bit
    When it is 43112603
    Then result is [forty three million, one hundred and twelve thousand, six hundred and three]
  Scenario: test sample data 2
    Given we will offer a int number with 6 bit
    When it is 512607
    Then result is [five hundred and twelve thousand, six hundred and seven]
  Scenario: test sample data 3
    Given we will offer a int number with 5 bit
    When it is 12609
    Then result is [twelve thousand, six hundred and nine]

  Scenario: test sample data 4
    Given we will offer a int number with 4 bit
    When it is 1501
    Then result is [one thousand, five hundred and one]
  Scenario: test sample data 5
    Given we will offer a int number with 3 bit
    When it is 310
    Then result is [three hundred and ten]
  Scenario: test sample data 6
    Given we will offer a int number with 3 bit
    When it is 300
    Then result is [three hundred]
  Scenario: test sample data 7
    Given we will offer a int number with 2 bit
    When it is 99
    Then result is [ninety nine]
