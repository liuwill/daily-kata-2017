Feature: mine field mapper

  Scenario: we have the sample data
    Given a field which height is 3 and width is 4
    When hidden field input is [*...\n..*.\n....]
    Then preview field output is [*211\n12*1\n0111]
