Narrative:
The purpose of this test case is to add a new computer to the DataBase
					 
Scenario:  Adding a new computer.

Given I open the url computer-database.herokuapp.com
When I click on the 'Add new computer' button
And I enter ' для тестов' as computer name
And I enter the date 2000-10-10 in the Introduced Date field
And I enter the date 2100-10-10 in the Discontinued Date field
And I choose Samsung Electronics from the Company dropdown
Then I click on the 'Create this computer' button
And I search for the computer with the name of для тестов
And I open the previously created computer whose name is для тестов

!-- Tear Down Process --!

Given I DELETE the recently created computer