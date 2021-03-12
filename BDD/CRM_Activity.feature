@CRMactivity
Feature: CRM Activities

Background: Open browser ang login CRM
    Given Open firefox browser
    When User opens CRM portal
    Then Login CRM portal
    
@CRM_activity1
Scenario: Counting Dashlets
    Given User count the number of dashlets 
    When User print the number and title of each dashlet
    And Browser close
    
@CRM_activity2
Scenario: Create leads using parameterization
    Given User navigates to Sales, Leads and to create lead page
    When User fills "Amrutha" and "V" to create lead account and save	
    Then User navigates view lead page to verify lead account is created
    And Browser close
    
@CRM_activity3
Scenario Outline: Schedule a meeting and invite members
     Given User navigates to activities, meetings and to schedule meeting page
     When User enters details of the meeting
     Then User search for user "<FirstName>" and "<LastName>" add them to meeting and save
     And User navigates to meeting page to verify meeting invite is created
     And Browser close
     
Examples:
| FirstName | LastName |
| Amrutha   | V        |
     
@CRM_activity4
Scenario Outline: Creating a Product
      Given User navigates to products and create products page
      When Enter details of the product "<Product Name>" and "<Price>" and save
      Then User navigates to view products page to verify products listed
      And Browser close
      
Examples:
| Product Name | Price |
| Book         | 100   |