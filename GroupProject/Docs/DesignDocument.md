# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team61

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

*Describe any assumption, background, or dependencies of the software, its use, the operational environment, or significant project issues.*

Since this is an Android application, we assume that the application will only be used on Android phones and simulators. The application will only have one user per device, will store data locally on the device, and will not communicate at all with other devices/servers; it will be an isolated single-user application.

### 1.2 Constraints

*Describe any constraints on the system that have a significant impact on the design of the system.*

As an Android application, this will have to be compliant with the Android OS.

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

The application will only be deployed to Android phones and simulators. We will have to determine the appropriate mininum SDK version that is supported by the application. The application will be developed in Android Studio and built with gradle.

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

![image of design 1](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team61/blob/master/GroupProject/Docs/component-diagram.png)
This shows how the the application components are connected together. The **GroceryListManager** is the application component and contains the **GroceryLists**, **Items**, and **ItemTypes** components. 
The only outside component is the **Database** which is connected to the **GroceryListManager** via two interfaces: **Search Database** and **Manage Database**. The **GroceryListManager** provides two interfaces: **ItemSearch** and **ManageLists**.

Bobby to insert component diagram if necessary.

### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely state why.*

Since this is an isolated single-user application, no deployment diagram is needed. The application will be built and deployed in its entirety to each phone/simulator that uses it via Android Studio. The APK built by Android Studio can also be shared via email to install the application on devices. Another deployment method, such as HockeyApp, may be considered as well.

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram

*In the case of an OO design, the internal structure of a software component would typically be expressed as a UML class diagram that represents the static class structure for the component and their relationships.*

Bobby to insert UML from D1.

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

Bobby to insert other diagrams if necessary (not likely).

## 4 User Interface Design
*For GUI-based systems, this section should provide the specific format/layout of the user interface of the system (e.g., in the form of graphical mockups).*

Bobby to insert wireframes/user flow diagrams.
