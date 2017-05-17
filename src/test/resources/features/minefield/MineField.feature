Feature: mine field mapper

  Scenario: we have the sample data
    Given a field which height is 3 and width is 4
    When hidden field input is [*...\n..*.\n....]
    Then preview field output is [*211\n12*1\n0111]

  Scenario: i ll try my own sample data
    Given a field which height is 3 and width is 4
    When hidden field input is [*...\n..*.\n.**.]
    Then preview field output is [*211\n24*2\n1**2]

  Scenario: if we paint a heart
    Given a field which height is 5 and width is 8
    When hidden field input is [..*...*.\n.*.*.*.*\n..*...*.\n...*.*..\n....*...]
    Then preview field output is [12*222*2\n1*4*2*4*\n12*343*2\n012*3*21\n0012*210]