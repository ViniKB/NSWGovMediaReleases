@FilterTest
Feature: Filter By Minister
  As a user i shall be able to filter the information by Minister

  @FilterByMinister
  Scenario Outline: Verify the item cards are displayed as filtered by minister
    Given User is in 'NSWGovAu' Page
    When Select a <Minister>
    And I Click on 'Search' button
    Then I validate the item cards are displayed
    And Filtered for the given minister

    Examples: 
      | Minister                                             |
      | The Premier                                          |
      | Deputy Premier,The Premier                              |
      | Minister for Customer Service and Digital Government,Treasurer |
      | Treasurer,Junk                                            |
#      | Minister for Emergency Services and Resilience       |
#      | Minister for Enterprise, Investment and Trade        |
#      | Minister for Environment and Heritage                |
#      | Minister for Health                                  |

  @ResetTheFilter
  Scenario Outline: Verify the item cards are reset and filter is removed.
    Given User has filtered by <Minister>
    When I click on 'Reset' button
    Then I verify the 'Reset' button is not visible
    Then I verify no filters are selected
    Then I validate the filter is removed

    Examples: 
      | Minister                                             |
      | The Premier                                          |
      | Deputy Premier,The Premier                           |
      | Treasurer                                            |
      | Minister for Customer Service and Digital Government |