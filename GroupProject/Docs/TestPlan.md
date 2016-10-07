# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<person or team name\>

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*

|	Test Case	|	Test type	|	Description	|	Purpose	|	Steps	|	Expected Results	|	Actual Results	|	Pass/Fail	|	Additional Information	|
|	---	|	---	|	---	|	---	|	---	|	---	|	---	|	---	|	---	|
|	Add Bread to List	|	Unit Test	|	Add 1 sample item	|	Test the addItemToList function	|	1. Select a List 2. Add 1 loaf of bread using the addItemToList function 3. Check that a ListItem for bread exists on the List	|	ListItem exists for Bread	|		|		|		|
|	Add Bread to List with Bread	|	Unit Test	|	Forbid user from adding the same item to the list twice	|	Test the addItemToList function	|	1. Select a List that already has a bread item 2. Add 1 loaf of bread using the addItemToList function 3. Confirm that the expected error message appears	|	Error Message	|		|		|		|
|	Change # Loaves Bread to 2	|	Unit Test	|	Change 1 loaf bread to 2	|	Test the changeItemQuantityInList function	|	1. Select a List that already has a bread item 2. Change quantity of the bread item using the changeItemQuantityInList function 3. Check that a ListItem for bread exists on the List and that the quantity is 2	|	item quantity = 2	|		|		|		|
|	Delete Bread from List	|	Unit Test	|	Delete 1 sample item	|	Test the deleteItemFromList function	|	1. Select a List that already has a bread item 2. Delete the bread item from the list using the deleteItemFromList function 3. Confirm that the item is no longer on the list	|	item not present on list	|		|		|		|
|	Check Bread on list	|	Unit Test	|	Check the Bread item	|	Test the checkItemInList function	|	1. Select a List that already has a bread item 2. Check the bread item using the checkItemInList function 3. Confirm that the item is checked	|	Bread ListItem will have checked = true	|		|		|		|
|	Uncheck all Items - one item	|	Unit Test	|	Uncheck all Items	|	Test the clearAllCheckedItemsInList function	|	1. Select a List that already has a bread item 2. Uncheck the bread item using the clearAllCheckedItemsInList function 3. Confirm that the item is unchecked	|	Bread ListItem will have checked = false	|		|		|		|
|	Uncheck all Items - multiple items	|	Unit Test	|	Uncheck all Items	|	Test the clearAllCheckedItemsInList function	|	1. Select a List that already has multiple items 2. Uncheck the items using the clearAllCheckedItemsInList function 3. Confirm that the items are unchecked	|	All ListItems will have checked = false	|		|		|		|
|	saveList	|	Unit Test	|	Save the list to the database	|	Test the saveList function	|		|		|		|		|		|
|	Create new Cheerios Item	|	Unit Test	|	Create new Item in the Cereals ItemType	|	Test the createNewItemInstance function	|	1. Add Cheerios to the Cereals ItemType using the createNewItemInstance function 2. Check that the item exists in the Items table	|	Cheerios item exists	|		|		|		|
|	Make a list for Seb	|	Unit Test	|	Create a new list	|	Test the createList function	|	1. Create new list named "Seb's List"	|	Seb's List exists	|		|		|		|
|	Delete Seb's list	|	Unit Test	|	Delete a list	|	Test the deleteList function	|	1. Seb's List has already been created 2. Delete Seb's List	|	Seb's List does not exist	|		|		|		|
|	Select Seb's list	|	Unit Test	|	Select a List	|	Test the selectList function	|	1. Create new list named "Seb's List" 2. Select Seb's List	|	Seb's List is selected	|		|		|		|
|	Change Seb's list name to Team61	|	Unit Test	|	Change the name of a list	|	Test the changeListName function	|	1. Create new list named "Seb's List" 2. Change Seb's List to "Team61"	|	Seb's List does not exist Team61 does exist	|		|		|		|
|	Search for Rice Krispies	|	Unit Test	|	Search for a specific item	|	Test the searchItemsByName function	|	1. Search for Item with name Rice Krispies	|	Rice Krispies item exists	|		|		|		|
|	Add Bagel to List	|	Integration Test	|	Use searchItemsByName to find Item and add it to the list	|	Run the addItemToList function from the searchItemsByName function	|	1. Select a List 2. Search for Bagel using the searchItemsByName function 3. Add item to List using the addItemToList function 4. Check that a ListItem for Honey Nut Cheerios exists on the List	|	ListItem exists for Bagels	|		|		|		|
|	Add 1 Honey Nut Cheerios to List	|	Integration Test	|	Use searchItemsByName to create new Item and add it to the list	|	Run the createNewItemInstance function from the searchItemsByName function	|	1. Select a List 2. Search for Honey Nut Cheerios using the searchItemsByName function 3. Add Honey Nut Cheerios to ItemType Cereals using the createNewItemInstance function 4. Add item to List using the addItemToList function 5. Check that a ListItem for Honey Nut Cheerios exists on the List	|	ListItem exists for Honey Nut Cheerios	|		|		|		|
