Scenario:  The purpose of this test case is to verify that the date fields aren't mandatory.

Given I open the url computer-database.herokuapp.com
When I click on the 'Add new computer' button
And I enter 'MandatoryFieldsTest' as computer name
And I choose Samsung Electronics from the Company dropdown
Then I click on the 'Create this computer' button
And I search for the computer with the name of MandatoryFieldsTest
And I open the previously created computer whose name is MandatoryFieldsTest

!-- Tear Down Process --!

Given I DELETE the recently created computer