#Grocery List 
##Design Information

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).  
   This requirement was realized by adding a classes List and ListItem. A List has ListItems. The List class has operators addItemToListByType and addItemToListByName. The ListItem class has operators deleteItem and changeQuantity.

2. The application must contain a database (DB) of items and corresponding item types.  
   To realize this requirement, I added to the design a class ItemType with the itemTypeName attribute and class Item with the itemName and itemUnit attributes.  

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.  
   This requirement was realized through the operation addItemToListByType in the List class.

4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type.  
   This requirement was realized through the addItemToListByName operation in the List class and the addNewItemToType operation in the ItemType class.

5. Lists must be saved automatically and immediately after they are modified.  
   This requirement was realized through the operation save in the List class. The automatic and immediacy portion of this requirement do not affect the design directly and are not considered.

6. Users must be able to check off items in a list (without deleting them).  
   This requirement was realized through the checkItem operation in the ListItem class.

7. Users must also be able to clear all the check-off marks in a list at once.  
   This requirement was realized through the uncheckAllItems operation in the List class.

8. Check-off marks for a list are persistent and must also be saved immediately.  
   This requirement was realized through the checkStatus attribute in the ListItem class. The immediate saving portion was realized through the previously mentioned save operation in the List class.

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).  
   This requirement was not considered because it does not affect the design directly.

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.  
   This requirement was realized through the createList, renameList, deleteList, and selectList operations and selectedList attribute in the List class

11. The User Interface (UI) must be intuitive and responsive.  
  Not considered because it does not affect the design directly.
