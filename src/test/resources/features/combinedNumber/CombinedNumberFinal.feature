Feature: integer list concat result

  Scenario: concat integer list to max number
    Given a list has 4 items
    When the list is
      |50|2|1|9|
    Then max number is "95021"

  Scenario: concat same start integer list to max number
    Given a list has 3 items
    When the list is
      |420|42|423|
    Then max number is "42423420"

  Scenario: concat same start integer list to max number last bigger
    Given a list has 4 items
    When the list is
      |420|42|423|425|
    Then max number is "42542423420"

  Scenario: concat other same start integer list to max number
    Given a list has 3 items
    When the list is
      |5|50|56|
    Then max number is "56550"

  Scenario: concat other same start integer list to max number last small
    Given a list has 4 items
    When the list is
      |5|50|56|565|
    Then max number is "56565550"

  Scenario: find max item
    Given still a list has 4 items
    When we have
      |5|50|56|565|
    Then max item is "56"