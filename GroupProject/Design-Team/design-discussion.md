Design 1
========
![image of design 1](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Design-Individual/ethomas32/design.png)

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
    * Added a ListItem class to handle quantity and checkin off
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
    * Diagram is too busy too early
    * Added more interfaces than necessary


Team Design
===========
![image of team design](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Design-Team/design-team.png)

The team design is a culmination of the individual designs above. We combined the aspects of all three individual designs that we felt were most correct, adding, removing, and tweaking the individual designs to create a simple, complete team design.

`GroceryListManager` effectively performs the same role as `Shopper` and `GroceryListManager` in Designs 1 and 3, respectively; it is what enables a user to manage lists and search items. This functionality was included in `List` in Design 2, but the team agreed that it would be a little strange for a list to be able to create, delete, etc. itself. There is an aggregation between it and `List` since it manages many lists. Similar relationships are shown between the equivalent objects in Designs 1 and 3, and the team decided an aggregation most correctly represented the relationship between the two.

All three individual designs included a `List` (`GroceryList` in Design 1) which can manage items in a list and save the list, so the team design includes this as well. There is an aggregation between this and `ListItem` since a list can contain many list items. Similarly to the relationship between `GroceryListManager` and `List`, the team decided an aggregation was most correct between `List` and `ListItem`.

Designs 2 and 3 include an object that represents an item that belongs to a specific list, `ListItem` and `ListofLineItem`, respectively. This appears in the final design as `ListItem`, and there is an instance for each item in each list. It also holds information about the quantity of an item in a list and whether or not the item in the list is checked. Design 1 tracks quanity and checked status in `Item`, but the team agreed that these attributes cannot live in `Item` because the same item may appear in multiple lists with different quanities or check statuses. Since a list item represents an instance of an item for a particular list, there is a one-to-one association between `ListItem` and `Item`.

Every design had `Item`, which holds information about individual items. All included a name or description to be able to identify items. We decided as a team that each item should have an id, name, and description, names being necessary for searching items. We also decided to explicitly state that `Item` has an attribute, `item_type_id`, which identifies which `ItemType` an `Item` belongs to. This relationship is also shown via an aggregation between `Item` and `ItemType`. Similar to Design 1, an association is shown between `GroceryListManager` and `Item` that represents the relationship between the two when `GroceryListManager` looks up items.

All three individual designs have `ItemType`, which holds information about the types that items can have. As in Designs 2 and 3, `ItemType` has a name and a method for creating a new item that has this type. We also decided to provide an attribute for the description of the type, as in Design 3, similar to what we did for `Item`. Similarly to the other aggregations, the team decided an aggregation most correctly characterized the relationship between `ItemType` and `Item`, since one item type can contain many items, as essentially shown in all three individual designs.


Summary
=======
