# Use Case Model

**Author**: Team 61

## 1 Use Case Diagram
![image of design 1](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Docs/use-case-diagram.png)

## 2 Use Case Descriptions

- Lookup Item
    - Requirements: Must allow the user to look an item up by typing its name. Or if no name is entered the list of items is displayed in hierarchical view
    - Pre-conditions: None
    - Post-conditions: 
        - Show items, if any to the user.
        - Item list must be in hierarchical order
    - Scenarios: User is looking for an item to add to his list
- Select Item Type
    - Requirements: Allow user to select a type if no match found from lookup
    - Pre-conditions: Item not found
    - Post-conditions: Type selected for new item
    - Scenarios: User can't find the exact item they are looking for, hence the item with it's type will be saved to the DB.
- Save Item
    - Requirements: Saves new item in DB
    - Pre-conditions: Item has been selected
    - Post-conditions: Item saved in DB
    - Scenarios: The item the user could not find, together with it's type will be saved to the DB.
- Add Item To List
    - Requirements: Allow user to add an item to the list
    - Pre-conditions: User must have a selected list
    - Post-conditions: Item has been added to the list
    - Scenarios: The user is adding a new item to its selected grocery list.
- Delete Item From List
    - Requirements: Allow user to delete an item from the list
    - Pre-conditions: 
        - Must have a selected list
        - Item must be present in the list
    - Post-conditions: Item has been deleted from the list
    - Scenarios: The user is deleting an item from its grocery list.
- Check Off Item In List
    - Requirements: Allow user to check off items in the list
    - Pre-conditions: 
        - Must have a selected list
        - Must have at list one item in the list
    - Post-conditions: items are checked off
    - Scenarios: User is checking off items from his list.
- Clear All Check-Off Marks In List
    - Requirements: Allow the user to clear all checked off items in the list
    - Pre-conditions: 
        - Must have a selected list
    - Post-conditions: All checked off items, if any, are cleared
    - Scenarios: Restore the list to an unchecked state
- Create List
    - Requirements: Allow user to create a new list
    - Pre-conditions: None
    - Post-conditions: New list has been created
    - Scenarios: User is creating a new Grocery list
- Rename List
    - Requirements: Allow user to rename a list
    - Pre-conditions: Must have a selected list
    - Post-conditions: The list has been renamed
    - Scenarios: User is renaming an existing grocery list.
- Delete List
    - Requirements: Allow user to delete a list 
    - Pre-conditions: Must have a selected list
    - Post-conditions: The list has been deleted
    - Scenarios: User is deleting one of its grocery list.
- Select List
    - Requirements: Allow user to select a list
    - Pre-conditions: Must have created at least one list
    - Post-conditions: List has been selected
    - Scenarios: User is selecting one of its created lists.
- Set Item Quantity
    - Requirements: Allow user to set the quantity for an item in the list
    - Pre-conditions: Item must be in the list
    - Post-conditions: Quantity has been updated for item
    - Scenarios: User is updating the quantity of an item in one of its lists.
- Save List
    - Requirements: Allow application to save a list
    - Pre-conditions: List must be selected
    - Post-conditions: List has been saved
    - Scenarios: The list is saved.
