**1 Introduction**


The Assignment five (5) introduced us to the GroceryListManager.  This system allows to manage a Grocery list to go shopping at grocery store or a farmers market.

**2 Assumptions**


1. The Grocery List Manager is single user system.  
1. An Item (as presented in the assignment 5) has only one type (as presented in the assignment 5).
1. User will not be required nor allowed to add Type (as presented in the assignment 5) only Item will be inputted by the user.
1. The Type information which is static in nature will be uploaded to the TypeCatalog and related objects once during the setup of the system and periodically updated.   
1. Given as an assumption that we not have to do anything about the GUI in our design.


**3 Requirement Realization Comments**



* .1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).

	**Describe how it is achieved:**

	Class **List** is added to UML class diagram. This class is associated 1 to many to the **ListofLineItem** class; This could have been represented as an Attribute such as "list: listofLineItem" but instead I choose to represent it as an associated class for clarity.

	The methods addItemtoList(), deleteItemFromList() and changeQuantityofItem() are all called form the List object.

	Note that the Attribute for quantity is listed in the **ListofLineItem** class (it  is better fit on per item nature of this class) , however, I have chosen to have the update (or change)  method be called from the associated class of List.






* .2. The application must contain a database (DB) of items and corresponding item types.

	**Describe how it is achieved:**

	The **TypeCatalog** class is added. I have assumed this this catalog and related objects (Type and Item) will be updated accordingly.   The mechanism for the updated has been by intention allowed to remain open as this is static reference data which does not change often.  Therefore, the option of using the **PresitentClassStorageAdoptor interface** and adding an external data source (DB) from which this reference is sourced is available but not shown to keep the UML diagram less crowded and focused on the object interactions. The end result is illustrated via loading note on the TypeCatalog Object and related objects (Type and Item).



* .3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.

  **Describe how it is achieved:**


 The List class is where the hierarchical list will be called from.  There is an association between the List class and the Type class which will allow the method ViewHierarchialList() to get the data and objects to present the hierarchical list to the user.

	The user will be able to navigate   hierarchical list add, delete, and specify the quantity per item.  These changes will be achieved via the following methods in the List object: addItemtoList(), deleltItemFromLis() and addQuantity().     


	Note that addItemtoList(), deleltItemFromLis() and addQuantity() will be called from the **List** class but will update the **ListofLineItem** class. In addition, it is important to observe that the **ListofLineItem** class has access to both the **Type** Class and the **Item** class to pull information. 


* .4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type.

	 **Describe how it is achieved:**

	The **List** class is where the searchItem() method will be called from.  There is an association between the **List** class and the **Type** class which will allow the method searchItem to get the data and objects to present the search result to the user repeatedly.
	As previously mentioned the Type and Item data was loaded through the **TypeCatalog** class.

	Now the searchItem() method to the user and if a match is not found, the user can be prompted to choose a Type.

	This Type instance will be matched to existing data via method VerifyType(). Then the user can input the new Item and this will be updated with the Type via the addItemtoCatalog() to the existing list of items.




* .5. Lists must be saved automatically and immediately after they are modified.

	**Describe how it is achieved:**

	In UML 2 the Interaction diagram have been introduced. In the case of saving the list automatically, the option I chosen is have "SelfMessage" sent from the List object to its self , any  time that is modified. This message will request autosaveList methods to be executed.

	This approach can be represented in  UML 2 by an Interaction diagram which grafts the activity diagram and the sequence diagram. For clarity of the UML Class diagram I have not included the Interaction diagram. However, I have modeled the Message generated back to the **list** class object. These   "SelfMessage" can request the execution of method which in this case is autosaveList method which will re-save the list when it has finished the current transaction.

	Note that the autosaveList() list can and should take advantage **PresitentClassStorageAdoptor interface**. I have modeled the interface and the adaptor for the Persistent Class Storage. However, for clarity that is where I have stopped per instruction of keeping with the level detail discussed during class sessions.  





* .6. Users must be able to check off items in a list (without deleting them).


	  **Describe how it is achieved:**


	The Check off attribute is included as part of the **ListofLineItem** class. This indicates that there is a "check off" attribute per line item or more precisely one per Item selected in the List. The  Check off attribute is modelled as Boolean with setCheckOff() method called form the **list** class object. The setCheckOff() will set the boolean to "true", which means the flag is set for Check off. The clearCheckOff() will remove the flag for the Check off by setting the boolean  to "false".





* .7. Users must also be able to clear all the check-off marks in a list at once.

	   **Describe how it is achieved:**

	The Check off attribute is included as part of the **ListofLineItem** class. A method called clearAllCheckoff()  which uses collection and may implement a lambda function to only address the instances of the object which have the check-off flag set to "on"  i.e.  (The Boolean is set to true) and will efficiently iterate only on those and set them to off i.e.  (The Boolean is set to false). Note that I have chosen to implement the clearAllCheckoff() method in the **List** Class.



* .8. Check-off marks for a list are persistent and must also be saved immediately.

	**Describe how it is achieved:**

	The Check off attribute is included as part of the **ListofLineItem** class. This is associated with the **List** class. The three methods which clearAllCheckoff(), setCheckoff() and clearCheckoff() were all in the List Class.  The reason this choice was made is to take advantage of the message mechanism to request autosaveList() method described in requirement  5.  Since, these three  methods clearAllCheckoff(), setCheckoff() and clearCheckoff() all called from the **List** object they trigger the "SelfMessage" that  requests the execution of method which in this case is autosaveList() method which will re-save the list.


* .9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).


	**Describe how it is achieved:**


	Class **List** is added to UML class diagram. This class is associated 1 to many to the **ListofLineItem** class; This associated is organized as ordered list and it is to be ordered by the Type. The idea behind this ordering is that all items associated by Type will be organized in the same area of the list.



*  .10. The application must support multiple lists at a time (e.g., ìweekly grocery listî, ìmonthly farmerís market listî). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.)

	**Describe how it is achieved:**

	The Grocery List Manager was added as class to allow for the user to manage the **List** class. The "listId" attribute was added to the **list** class to provide unique identifier for the lists to maintain a list of them in the   Grocery List Manager (list: listofListId).  The following methods creatList(), deleteList(), selectList() and  renameList() are implemented for the management of the **List** object in the **GroceryListManager** class. There is one to many association between the  **GroceryListManager** class and the **List**  class.


* .11. The User Interface (UI) must be intuitive and responsive.

	**Describe how it is achieved:**

	Ignored as a requirement since it was given as an assumption that we not have to do anything about the GUI in our design.
