# Test Plan

**Author**:Team61

## 1 Testing Strategy

### 1.1 Overall strategy

Our testing  strategy will follow the standard test phases by performing the following type of tests:
Unit testing, Integration testing, System testing and Regression testing on the GroceryListManager system.

#### 1.1.1 Unit testing

In **Unit testing** phase each module of the code or set of related modules of codes will be tested to ensure that the correct input and returns is captures and compared with the expected result.

The **Unit testing** will follow the white box testing methods. We are currently planing to test manually given the limited number modules. Depending on the availability of time and resources, we may consider the use automated tool (Junit or others) for testing and automation.   

**Unit testing** will be completed when all test cases assigned have been completed.

The testing will be performed by **Development Team** - Emmanuel Thomas and Robert Yankou.



#### 1.1.2 Integration testing

In **Integration testing** phase we will be testing a set modules which will together be accomplishing a task resulting in an output. Due to the size of the Project we will be testing any external Interface which may capture (read) some data and send (write) some data. We will consider the writing of an object to a persistent store an interface and test it as part of the integration test steps.   


The **Integration testing**  will follow the white box testing methods. We are currently planing to test manually given the limited number modules. Depending on the availability of time and resources, we may consider the use automated tool (Junit or others) for  testing and automation.   

**Integration testing** will be completed when all test cases assigned have been completed.

The testing will be performed by **Development Team** - Emmanuel Thomas and Robert Yankou.

#### 1.1.3 System testing

**System testing** will be performed with full system implementation in a stable environment. The user interface will be fully functional at this point in development. As part of the system test, we will be performing all our functional and end-to-end testing of the system.  


The **System testing**  will follow the black box testing and we use manual testing methodology.   

**System testing** will be completed when all test cases assigned have been completed.

The testing will be performed by **Quality & Assurance Team** - Myles Lefkovitz and Shahram Amid.


#### 1.1.4 Regression testing

We will use **Regression testing** as verification of overall system integrity after a modification. We intend to select an appropriate series of systems tests which will be re-run to Regression test the system and ensure that not only the modification was successful but also no other portion of the system has been negatively affected.  

The **Regression testing**  will follow the black box testing and we use manual testing methodology.   

**Regression testing**  will be completed when all test cases assigned have been completed.

The testing will be performed by **Quality & Assurance Team** - Myles Lefkovitz and Shahram Amid.


### 1.2 Test Selection

 We are going to use a different strategies at **Unit** and **Integration** testing level as in the **System** and **Regression** testing. The testing for **Unit** and **Integration** testing will be based on white-box testing, we intend to follow some level of automation for this testing.

Due to the time frames and anticipated testing time available, we have ruled out the use of **Branch and condition coverage**, and to some degree **Modified condition/decision coverage** methods in our white-box testing effort. As group we are still discussing the use of the **Condition coverage** and **Data flow coverage** methods in our white-box testing effort. We are currently leaning in the use of **Condition coverage** method to determine our testing effort for the white box testing involved in the unit and integration testing.


For **System** and **Regression** testing we will use the black-box testing mythology, we intend to follow manual testing. Yet, internally as a group, we are still evaluating if using an automated method would be more resource efficient.   But due to the time frames and anticipated testing time available, we are going for manual method for now with the understanding that we can change direction.

As we have UML and class diagrams we will identify the **independent testable features** and their **relevant inputs**. We will use this model to derive the set of test cases to cover the system and the user functionality for our system.  



### 1.3 Adequacy Criterion

For **Unit** and **Integration** testing we are leaning to use the **Condition coverage** method to determine the set of test cases which should be developed for the white box testing effort of our system. Once we have identified these test cases we anticipate to achieve a coverage measure of between (94% and 100%).  As we have not developed the code and have not gone through the exercise of developing the test cases this coverage measure will remain a goal to strive for.

We anticipate that a coverage measure of better than 94% percent would be more than adequate to reduce number potential bugs significantly.  Even with 100%, there may be issue which were not fully discovered. Moreover, commercial software aims in 80 to 90% coverage, we are aiming slightly higher. We feel that the stated goal of 94% to 100% coverage is an adequate criteria for the coverage and good balance between effort spent testing and expected verification result which will achieved from this testing.

For **System** testing and **Regression** testing we are going to identify the **independent testable features** and their **relevant inputs** to determine our set of test cases for the black box testing effort. We have identified these test cases in section 2.0.

We anticipate that our testing will have coverage measure of better than 100% percent of the user functionality.   Even with 100% testing, there may be issue which are not discovers during system and regression testing. We feel that the stated goal of 100% coverage user functionality is an adequate criteria for the coverage and good balance between effort spent testing and expected verification result which will achieve from this testing.    

### 1.4 Bug Tracking

We will use an internal **Excel sheet** to track the bugs and their resolution. This bug tracking and enhancement request system will be maintained by one of the Quality Assurance manager and will be present in a directory in GitHub for all members of the team to view and update.

The following fields will be supported in the Excel Sheet as minimum:

  -  Item Number:
  -  Date:
  -  Phase of Testing:
  -  Name of Originator:
  -  Description:
  -  Priority: P1-Urgent, P2-High, P3-Medium to P4 - low
  -  Severity: S1- Critical, S2-Major, S3-Minor, S4-Trivial  
  -  Resolution Description:
  -  Name of Resolver:
  -  Date of Resolution:
  -  Verification Testing:
  -  Name of Tester:
  -  Date of Retest:
  -  Software Version:
  -  Status: Open,In_progress, Closed


The following are industry default standard definitions for **Severity** and **Priority**. We have copied them as informational. We are planning on using them as a guideline.

**Defect Severity<sup>[1](http://softwaretestingfundamentals.com/defect-severity/)</sup> definition:**

- **Critical:** The defect affects critical functionality or critical data. It does not have a workaround. Example: Unsuccessful installation, complete failure of a feature.
- **Major:** The defect affects major functionality or major data. It has a workaround but is not obvious and is difficult. Example: A feature is not functional from one module but the task is doable if 10 complicated indirect steps are followed in another module/s.
- **Minor:** The defect affects minor functionality or non-critical data. It has an easy workaround. Example: A minor feature that is not functional in one module but the same task is easily doable from another module.
- **Trivial:** The defect does not affect functionality or data. It does not even need a workaround. It does not impact productivity or efficiency. It is merely an inconvenience. Example: Petty layout discrepancies, spelling/grammatical errors.

**Defect Priority<sup>[2](http://softwaretestingfundamentals.com/defect-priority/)</sup> definition:**

Defect Priority (Bug Priority) indicates the importance or urgency of fixing a defect. Though priority may be initially set by the Software Tester, it is usually finalized by the Project/Product Manager.
Priority can be categorized into the following levels:

- **Urgent:** Must be fixed in the next build.
- **High:** Must be fixed in any of the upcoming builds but should be included in the release.
- **Medium:** May be fixed after the release / in the next release.
- **Low:** May or may not be fixed at all.

Priority is also denoted as **P1** for Urgent, **P2** for High and so on.



### 1.5 Technology

We are would like to use automation for the **white box** (Unit and Integration) testing with **JUnit** tool. We feel this activity will be quick to setup and execute within the IDE. These tests can be quickly re-run to perform unit or integration test in case of changes to the code.

For the **System** and **Regression** testing we are leaning toward a manual test method. We feel that the setup of the test environment and maintaining it may add too much overhead to our efforts. In addition, we anticipate that number times we will be running these test cases will be limited and the number of test cases will reasonable.


## 2 Test Cases

|	Test Case	|	Test type	|	Description	|	Purpose	|	Steps	|	Expected Results	|	Actual Results	|	Pass/Fail	|	Additional Information	|
|	---	|	---	|	---	|	---	|	---	|	---	|	---	|	---	|	---	|
|	Add Item to List	|	Unit Test	|	Add sample item to List	|	Test the addItemToList function	|	1. Select a List 2. Add Item using the addItemToList function 3. Check that a ListItem for Item exists on the List	|	ListItem exists for Item	|	ListItem added	|	Pass	|	Manually Tested on 10/13	|
|	Add Item to List with Item	|	Unit Test	|	Forbid user from adding the same item to the list twice	|	Test the addItemToList function	|	1. Select a List that already has ListItem Item 2. Add Item using the addItemToList function 3. Confirm that the expected error message appears	|	Error Message	|	Item is not entered	|	Fail	|	Manually Tested on 10/13	|
|	Change Item Quantity	|	Unit Test	|	Change quantity of item	|	Test the changeItemQuantityInList function	|	1. Select a List that already has Item 2. Change quantity of the Item using the changeItemQuantityInList function 3. Check that a ListItem for Item exists on the List and that the quantity is expected	|	Item quantity is entered number	|	Item quantity is entered number	|	Pass	|	JUnit Test 10/13	|
|	Delete Item from List	|	Unit Test	|	Delete Item	|	Test the deleteItemFromList function	|	1. Select a List that already has Item 2. Delete Item from the list using the deleteItemFromList function 3. Confirm that the item is no longer on the list	|	item not present on list	|	Item removed	|	Pass	|	Manually Tested on 10/13	|
|	Check Item on list	|	Unit Test	|	Check the Item	|	Test the checkItemInList function	|	1. Select a List that already has ListItem 2. Check the ListItem using the checkItemInList function 3. Confirm that the ListItem is checked	|	ListItem will have checked = true	|	Item checked	|	Pass	|	Manually Tested on 10/13	|
|	Uncheck all Items - one item	|	Unit Test	|	Uncheck all Items	|	Test the clearAllCheckedItemsInList function	|	1. Select a List that already has 1 ListItem 2. Uncheck the ListItem using the clearAllCheckedItemsInList function 3. Confirm that the Listitem is unchecked	|	ListItem will have checked = false	|	Item unchecked	|	Pass	|	Manually Tested on 10/13	|
|	Uncheck all Items - multiple items	|	Unit Test	|	Uncheck all Items	|	Test the clearAllCheckedItemsInList function	|	1. Select a List that already has multiple ListItems 2. Uncheck the ListItems using the clearAllCheckedItemsInList function 3. Confirm that the ListItems are unchecked	|	All ListItems will have checked = false	|	All Items unchecked	|	Pass	|	Manually Tested on 10/13	|
|	saveList	|	Unit Test	|	Save the list to the database after a change	|	Test the automatic saveList function	|	1. Select a List 2. Save List using the automatic saveList function 3. Check the log to verify that the list has been saved to the database	|	Log updated	|		|		|	Test not performed	|
|	saveItem	|	Unit Test	|	Save a new Item to the database	|	Test saveItem function	|	1. Select an Item 2. Save Item using saveItem function 3. Check that the Item has been saved to the database	|	New Item exists in the database	|	New item saved to database	|	Pass	|	Manually Tested on 10/13	|
|	saveItem without ItemType	|	Unit Test	|	Save a new Item to the database without specifying item type	|	Test saveItem function	|	1. Select an Item 2. Save Item using saveItem function 3. Check that the Item has been saved to the database	|	Item doesn't get saved to the database	|	Item not added to the database	|	Pass	|	Manually Tested on 10/13	|
|	Create new Item	|	Unit Test	|	Create new Item	|	Test the createNewItemInstance function	|	1. Add new Item to an ItemType using the createNewItemInstance function 2. Check that the Item exists in the Items table	|	New Item exists	|	New item exists in UI	|	Pass	|	Manually Tested on 10/13	|
|	Create a new List 	|	Unit Test	|	Create a new List	|	Test the createList function	|	1. Create new List	|	List exists	|	List exists	|	Pass	|	JUnit Test 10/13	|
|	Delete List	|	Unit Test	|	Delete a List	|	Test the deleteList function	|	1. List has already been created 2. Delete List	|	List does not exist	|	List deleted	|	Pass	|	Manually Tested on 10/14	|
|	Select List	|	Unit Test	|	Select a List	|	Test the selectList function	|	1. Create new List 2. Select List	|	List is selected	|	List selected	|	Pass	|	JUnit Test 10/13	|
|	Change List Name	|	Unit Test	|	Change the name of a list	|	Test the changeListName function	|	1. Create new List 2. Change List name	|	Original List does not exist; new List does exist	|	Sets name of list	|	Pass	|	JUnit Test 10/13	|
|	Search for Item	|	Unit Test	|	Search for a specific item	|	Test the searchItemsByName function	|	1. Search for Item by Name	|	Item exists	|	Search for item by name	|	Pass	|	Manually Tested on 10/13	|
|	Add Item to List	|	Integration Test	|	Use searchItemsByName to find Item and add it to the list	|	Run the addItemToList function from the searchItemsByName function	|	1. Select a List 2. Search for Item using the searchItemsByName function 3. Add Item to List using the addItemToList function 4. Check that a ListItem for Item exists on the List	|	ListItem exists for Item	|	Item added to the list	|	Pass	|	Manually Tested on 10/13	|
|	Add New Item to List	|	Integration Test	|	Use searchItemsByName to create new Item and add it to the list	|	Run the createNewItemInstance function from the searchItemsByName function	|	1. Select a List 2. Search for Item using the searchItemsByName function 3. Add new Item to an ItemType using the createNewItemInstance function 4. Add item to List using the addItemToList function 5. Check that a ListItem for Item exists on the List	|	ListItem exists for Item	|	Item added to the list	|	Pass	|	Manually Tested on 10/13	|
|	Create a small shopping list	|	System Test	|	Use the system to create a new list and add various items, some in the database, some that need to be added	|	Test the system's ability to handle the basic list creation functions	|	1. Create a new List 2. Add a couple of Items to the List by searching by Type 3. Add a couple of Items to the List by searching by Name 4. Add a couple of items to the List by searching by Name and adding them to the database	|	The user is able to efficiently create a grocery list	|	Test Completed Successfully	|	Pass	|	Manually Tested on 10/14	|
|	Check Items on the new shopping List	|	System Test	|	Use the system to check off various items to simulate use in shopping, then uncheck all to simulate the complete lifecycle of the shopping list	|	Test the system's ability to handle the basic list usage functions	|	1. Select a List 2. Check off each item on the List 3. Uncheck all Items	|	The user is able to efficiently manage an existing grocery list	|	Test Completed Successfully	|	Pass	|	Manually Tested on 10/14	|
|	Edit an existing shopping list	|	System Test	|	Use the system to amend an exisitng shopping list	|	Test the system's ability to handle the basic list usage functions	|	1. Select a List 2. Delete an Item 3. Change the quantity of an Item 4. Add a new Item	|	The user is able to efficiently manage an existing grocery list	|	Test Completed Successfully	|	Pass	|	Manually Tested on 10/14	|