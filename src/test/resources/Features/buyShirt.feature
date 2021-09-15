# Author diana.gutierrezc
# Date 14/09/2021
Feature: buy in online store

  Scenario Outline: Successful buy t-shirt by existing user. Pay by bank wire
    Given an existing "<user>" and "<password>" accesses to the online store
    When buy a t-shirt
    And pay by bank wire
    Then the order is confirmed

    Examples: 
      | user                  | password |
      | dianacaro46@gmail.com |    12345 |
