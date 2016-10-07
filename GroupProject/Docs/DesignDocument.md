# Design Document

**Author**: Team61

## 1 Design Considerations

### 1.1 Assumptions

Since this is an Android application, we assume that the application will only be used on Android phones and simulators. The application will only have one user per device, will store data locally on the device, and will not communicate at all with other devices/servers; it will be an isolated single-user application.

### 1.2 Constraints

As an Android application, this will have to be compliant with the Android OS.

### 1.3 System Environment

The application will only be deployed to Android phones and simulators. We will have to determine the appropriate mininum SDK version that is supported by the application. The application will be developed in Android Studio and built with gradle.

## 2 Architectural Design

### 2.1 Component Diagram

![image of design 1](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Docs/component-diagram.png)
This shows how the the application components are connected together. The **GroceryListManager** is the application component and contains the **GroceryLists**, **Items**, and **ItemTypes** components. 
The only outside component is the **Database** which is connected to the **GroceryListManager** via two interfaces: **Search Database** and **Manage Database**. The **GroceryListManager** provides two interfaces: **ItemSearch** and **ManageLists**.

### 2.2 Deployment Diagram

Since this is an isolated single-user application, no deployment diagram is needed. The application will be built and deployed in its entirety to each phone/simulator that uses it via Android Studio. The APK built by Android Studio can also be shared via email to install the application on devices. Another deployment method, such as HockeyApp, may be considered as well.

## 3 Low-Level Design

### 3.1 Class Diagram

Bobby to insert UML from D1.

### 3.2 Other Diagrams

Bobby to insert other diagrams if necessary (not likely).

## 4 User Interface Design

![user flow diagram](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/development-bobby-d2/GroupProject/Docs/user-flow-diagram.png)

[Download our interactive wireframe to see how views change and interact with each other.](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/development-bobby-d2/GroupProject/Docs/interactive-wireframe.pdf)
