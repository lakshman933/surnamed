@LOGIN
Feature: Sign-page

  @LG
  Scenario Outline: Add Landing  page
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>" and Password as "<Password>"
    And click on signin button

    Examples: 
      | Url                                          | Email | Password |
      | https://central-grievance-web-app.pages.dev/ | Dilli | Pass@123 |

  @LG1
  Scenario Outline: Add Landing  page
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>" and Password as "<Password>"
    And click on signin button
    Then User should redirect to dash board

    Examples: 
      | Url                                          | Email | Password |
      | https://central-grievance-web-app.pages.dev/ | Dilli | Pass@123 |

  @LG2
  Scenario Outline: Landing page with error msg
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>" and Password as "<Password>"
    And click on signin button
    Then User should see Invlid error msg

    Examples: 
      | Url                                          | Email | Password |
      | https://central-grievance-web-app.pages.dev/ | surya | Pass@123 |

  @LG3
  Scenario Outline: Landing page with error msg
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>"
    And click on signin button
    Then User should see Invlid error msg

    Examples: 
      | Url                                          | Email |
      | https://central-grievance-web-app.pages.dev/ | surya |

  @LG4
  Scenario Outline: Landing page with error msg
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Password as "<Password>"
    And click on signin button
    
    Then User verifies the alert message is "The username field is required"
    Then User accepts the alert

    Examples: 
      | Url                                          | Password |
      | https://central-grievance-web-app.pages.dev/ | Pass@123 |
