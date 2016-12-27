Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  A scenario is a collection of executable steps of different type

Given I open the url computer-database.herokuapp.com
When I click on the 'Add new computer' button
And I enter the date 2000-10-10 in the Introduced Date field
Then I click on the 'Create this computer' button
And I verify that no new computer can be created with an empty name
