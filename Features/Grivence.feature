@Grivanve
Feature: Sign-page

  @Griv1
  Scenario Outline: Add Landing  page
    Given User Launch Chrome Browser
    When User opens URL "<Url>"
    When User enters Username as "<Email>" and Password as "<Password>"
    And click on signin button
    Then click on Grievance
    And click on My Grievance
    Given I open Chrome with microphone permissions
    Then click on complaint category  
    And click on Mandal 
    And click on Area  
    When User enter the Name "< FullName>"
    Then User enter the  Phone No "< MobileNO>"
    And User enter the Complaint Deatails "<complaint Details>"
    And click on Record
    And click on the upload the photo
    Then click on  create on complaint

    Examples: 
      | Url                                          | Email | Password |
      | https://central-grievance-web-app.pages.dev/ | Dilli | Pass@123 |
