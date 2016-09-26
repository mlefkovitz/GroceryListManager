Grocery List Manager - Design Information
=========================================
Note. The design assumes that all Getters and Setters are properly set for all the classes.

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
    * To realize this requirement I added the `Shopper` class to the design. I added the following operations to the `Shopper` class: `addItemToList(item,list), deleteItemFromList(item,list), updateItemCount(item,list,count)`. I also added an `Item` class with a quantity attribute. There is a `Lookup Relation` between the `Shopper` and the `Item` classes. Finally I added the `GroceryList` class with the following operations: `addItem(item), deleteItem(item), updateItemCount(item,count)`. 
    There is a `One-to-Many` Relation between the GroceryList and the Items.
2. The application must contain a database (DB) of items and corresponding item types.
    * To realize this requirement I added a `ItemType` class to the design. There is a `Many-to-One Relation` between the Items and the Item Types. 
3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
    * This requirement is realized by adding a `Lookup Relation` between the `Shopper` and the `Item` classes.
4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type.
    * To realize this requirement I added a `looupupItemByName(itemName)` to the `Shopper` class. Also I added a `save()` operation to the `GroceryList` class.
5. Lists must be saved automatically and immediately after they are modified.
    * This requirement is satistied by adding the `save()` method to the `GroceryList` class.
6. Users must be able to check off items in a list (without deleting them).
    * To realize this requirement I added a `checkOffItem(item, list)` operation to the `Shopper` class, I added a `checkOffItem(item)` to the `GroceryList` class, and I added a `checkedOff` boolean attribute to the `Item` class.
7. Users must also be able to clear all the check-off marks in a list at once.
    * To realize this requirement I added a `clearAllCheckedOffItems(list)` to the `Shopper` class and a `clearAllCheckedOffItems()` to the `GroceryList` class.
8. Check-off marks for a list are persistent and must also be saved immediately.
    * This requirement is already satisfied by adding the `save()` operation to the `GroceryList` class.
9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).
    * That is not considered as it doesn’t affect the design directly.
10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.
    * This is realized by adding a `name` attribute to the `GroceryList` class and adding the following operations to the `Shopper` class: `createList(), deleteList(), setListName(list, name)`.
11. The User Interface (UI) must be intuitive and responsive.
    * This is not considered as it doesn’t affect the design directly.