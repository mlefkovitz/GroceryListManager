# Design Document

**Author**: Team61

## 1 Design Considerations

### 1.1 Assumptions

Since this is an Android application, we assume that the application will only be used on Android phones and simulators. The application will only have one user per device, will store data locally on the device, and will not communicate at all with other devices/servers; it will be an isolated single-user application.

### 1.2 Constraints

As an Android application, this will have to be compliant with the Android OS.

### 1.3 System Environment

The application will only be deployed to Android phones and simulators. The application will be developed to support all Android devices after version 4.4 (KitKat) / API 19. The application will be developed in Android Studio and built with gradle.

## 2 Architectural Design

### 2.1 Component Diagram

![image of design 1](./component-diagram.png)
This shows how the the application components are connected together. The **GroceryListManager** is the application component and contains the **GroceryLists**, **Items**, and **ItemTypes** components. 
The only outside component is the **Database** which is connected to the **GroceryListManager** via two interfaces: **Search Database** and **Manage Database**. The **GroceryListManager** provides two interfaces: **ItemSearch** and **ManageLists**.

### 2.2 Deployment Diagram

Since this is an isolated single-user application, no deployment diagram is needed. The application will be built and deployed in its entirety to each phone/simulator that uses it via Android Studio. The APK built by Android Studio can also be shared via email to install the application on devices. Another deployment method, such as HockeyApp, may be considered as well.

## 3 Low-Level Design

### 3.1 Class Diagram

![image of team design](https://github.com/mlefkovitz/GroceryListManager/blob/master/Design-Team/design-team.png)
This shows the UML Class Diagram that the team created for the first deliverable of the project.

### 3.2 Other Diagrams

The group determined that no other diagrams were necessary. Sections 2.1, 3.1, and 4 cover everything visually.

## 4 User Interface Design

![user flow diagram](./user-flow-diagram.png)
This shows the user flow diagram for the views of the application. Each view has a bulleted list of actions that the user can perform from the view, and arrows are shown for actions that cause view transitions. A modal is a view within a view.

[Download our interactive wireframe to see how views change and interact with each other.](./interactive-wireframe.pdf)

Here are some sample wireframes corresponding to the views in the user flow diagram:


| Home Screen | Add New List Modal | List View |
| --- | --- | --- |
| ![home screen](./home-screen.png) | ![add new list modal](./home-screen_add-list_name.png) | ![list view](./list.png) |


| Search View | Add Exisiting Item Modal | Add New Item Modal |
| --- | --- | --- |
| ![search view](./item-search_matching-text.png) | ![add existing item modal](./item-search_select_quantity.png) | ![add new item modal](./item-search_new-item_type_selected.png) |
