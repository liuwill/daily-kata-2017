Feature: combined number utils test
  Scenario: find max item
    Given still a list has 4 items
    When we have
      |5|50|56|565|
    Then max item is "56"

  Scenario: compare two string
    Given we has two number string
    When which are 45 and 789
    Then the larger one is "789"

  Scenario: compare two string same large
    Given we has two number string
    When which are 45 and 4
    Then the larger one is "45"

  Scenario: compare two string same small
    Given we has two number string
    When which are 43 and 4
    Then the larger one is "4"

  Scenario: compare two string equal
    Given we has two number string equal
    When which has values 43 and 4
    Then compare value 1

  Scenario: compare two string equal
    Given we has two number string equal
    When which has values 44 and 4
    Then compare value -1