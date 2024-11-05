@Grivanve
Feature: Gallery

  @G1
  Scenario Outline: Gallery
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>" and Password as "<Password>"
    And click on signin button
    Then click on Gallery
    And click on Gallery Add
    Given I open Chrome with microphone permissions
    Then click on a Gallery Mandal name for iteration 1
    #And click on a  Gallery Area
    #When User enter the Gallery Name "<FullName>"
    #Then User enter the  Gallery Event
    #And User enter the Gallery Description "<Gallery Description>"
    #And click on Gallery Dropdown file
    #Then click on the Gallery save

    Examples: 
      | Url                                          | Email | Password |
      | https://central-grievance-web-app.pages.dev/ | Dilli | Pass@123 |
