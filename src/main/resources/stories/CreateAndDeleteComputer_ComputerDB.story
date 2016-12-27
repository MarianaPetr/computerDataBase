Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  The purpose of this test is to create and to delete a computer.

Given I open the url computer-database.herokuapp.com
When I click on the 'Add new computer' button
And I enter 'Test123' as computer name
And I enter the date 2000-10-10 in the Introduced Date field
And I enter the date 2100-10-10 in the Discontinued Date field
And I choose Samsung Electronics from the Company dropdown
Then I click on the 'Create this computer' button
And I search for the computer with the name of Test123
And I open the previously created computer whose name is Test123
And I click on the 'Delete this computer' button
