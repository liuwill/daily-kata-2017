Feature: diversion binary group

  Scenario: list sample group numbers
    Given samples has 5 list
    When the lists are
      |10|2|1|9|7|
    Then combinations result numbers are
      |144|3|2|89|34|