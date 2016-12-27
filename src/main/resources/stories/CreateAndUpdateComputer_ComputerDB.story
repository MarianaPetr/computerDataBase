Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  A scenario is a collection of executable steps of different type

Given I open the url computer-database.herokuapp.com
When I click on the 'Add new computer' button
And I enter 'Test123' as computer name
And I enter the date 2000-10-10 in the Introduced Date field
And I enter the date 2100-10-10 in the Discontinued Date field
And I choose Samsung Electronics from the Company dropdown
Then I click on the 'Create this computer' button
And I search for the computer with the name of Test123
And I open the previously created computer whose name is Test123
And I update the name of the computer with UpdatedName
And I update the Introduced and Discontinued dates with 2010-11-19 and 2012-12-12 respectively
And I choose Moore School of Electrical Engineering from the Company dropdown
And I save the updated computer
And I verify that the message 'Done! Computer UpdatedName has been updated' is displayed on screen
And I search for the computer with the name of UpdatedName
And I open the previously created computer whose name is UpdatedName

!-- Tear Down Process --!

Given I DELETE the recently created computer