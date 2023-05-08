Feature: Search functionality

  Scenario Outline: Java Test is wired together
    Given the communities portal is opened
    When I click the communities button
    Then I click the More Filters button
    And I click the Language button
    And I click the Russian check box
    And I click the Online switch
    Then I type <searchString> in search
    And I see the <title> card
    And I see <amount> card
    Examples:
      | searchString         | title                | amount |
      | "JavaScript testing" | "JavaScript testing" | 1      |
