Scenario:  This test creates a new entry with all the parameters, saves it, re opens it and then deletes it and then creates the same entry once again.

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
When I click on the 'Add new computer' button
And I enter 'Test123' as computer name
And I enter the date 2000-10-10 in the Introduced Date field
And I enter the date 2100-10-10 in the Discontinued Date field
And I choose Samsung Electronics from the Company dropdown
Then I click on the 'Create this computer' button
And I search for the computer with the name of Test123
And I open the previously created computer whose name is Test123

!-- Tear Down Process --!

Given I DELETE the recently created computer
