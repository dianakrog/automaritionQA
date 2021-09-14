# Author diana.gutierrezc
# Date 09/06/2021
Feature: Search in Google

  Scenario Outline: Valid Search
    Given browser is open
    And go to google page
    When user send word to search
    And execute enter key
    Then user see the results
