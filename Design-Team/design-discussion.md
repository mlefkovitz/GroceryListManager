Design 1
========
![image of design 1](/../Design-Individual/ethomas32/design.png)

* Pros
    * Simple and concise.
    * Right cardinality between classes
* Cons
    * Ties the quantity and checked off to the item itself
    * Adding item to list was not necessary in the shopper
    * No attributes in item type
    * Doesn't keep track of the selected list

Design 2
========
![image of design 2](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Design-Individual/gth836x/design.png)

* Pros
    * Simple and concise
    * Has most main elements
    * Added a ListItem class to handle quantity and checking off
* Cons
    * Doesn't have a manager
    * Doesn't specify arguments for methods
    * Ties the quantity to the item itself

Design 3
========
![image of design 3](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Design-Individual/samid3/design.png)

* Pros
    * Very detailed
    * Has LineItem to handle count and checked off
* Cons
    * Diagram is too busy (TypeCatalog is not needed)
    * Added more interfaces than necessary


Team Design
===========
![image of team design](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Design-Team/design-team.png)

`GroceryListManager` effectively performs the same role as `Shopper` and `GroceryListManager` in Designs 1 and 3, respectively; it enables a user to manage lists and search items. This functionality was included in `List` in Design 2, but the team agreed that it would be necessary for the manager object to be included. There is an aggregation between `GroceryListManager` and `List` since it manages many lists.

All three individual designs included a `List` (`GroceryList` in Design 1) which can manage items in a list and save the list, so the team design includes this as well. There is an aggregation between this and `ListItem` since a list can contain many list items.

Designs 2 and 3 include an object that represents an item that belongs to a specific list, `ListItem` and `ListofLineItem`, respectively. This appears in the final design as `ListItem`. It also holds information about the quantity of an item in a list and whether or not the item in the list is checked. `ListItem` is needed in addition to `Item` because multiple items can appear on multiple lists with different quantities and checked statuses. Since a list item represents an instance of an item for a particular list, there is a one-to-one association between `ListItem` and `Item`.

Every design had `Item`, which holds information about individual items. All included a name or description to be able to identify items. We decided as a team that each item should have an id, name, and description, names being necessary for searching items. We also decided to explicitly state that `Item` has an attribute, `item_type_id`, which identifies which `ItemType` an `Item` belongs to. This relationship is also shown via an aggregation between `Item` and `ItemType`. Similar to Design 1, an association is shown between `GroceryListManager` and `Item`, which looks up an item.

All three individual designs have `ItemType`, which organizes items into categories. As in Designs 2 and 3, `ItemType` has a name and a method for creating a new item. We also decided to provide an attribute for the description of the type, as in Design 3, similar to what we did for `Item`. The correct relationship between `ItemType` and `Item` is an aggregation, since one item type can contain many items.


Summary
=======

The team design is a culmination of the individual designs above. We combined the aspects of all three individual designs that we felt were most correct, adding, removing, and tweaking the individual designs to create a simple, complete team design. Even though we all had different perspectives on what was important, we were able to find common ground after trying a few combinations of the design. The team was very focused on finding the right design and accepting logical arguments.
