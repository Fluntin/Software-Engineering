# Lab 4 - Design Patterns in Java

This repository contains Java code examples that demonstrate the implementation of two design patterns: Composite Pattern and Factory Technique. Additionally, it includes an extra task involving the Iterator Pattern.

## Composite Pattern

The Composite Pattern is a structural design pattern that allows you to compose objects into tree-like structures to represent part-whole hierarchies. In this lab, we apply the Composite Pattern to represent a suitcase and its contents. The key concepts of the Composite Pattern are as follows:

- **Component (Abstract Class)**: Serves as the base class for both Composite and Leaf classes. It defines common methods and attributes.
- **Composite (Class)**: Represents a composite component that can contain other components (either Composite or Leaf objects). It organizes items hierarchically.
- **Leaf (Class)**: Represents a leaf component that cannot contain other components. It represents individual items within the composite structure.

### How to Use the Composite Pattern Example

1. Create instances of Composite and Leaf to represent items you want to organize hierarchically.
2. Use the `addChild()` method of the Composite class to add child components to composites.
3. Use the `removeChild()` method of the Composite class to remove child components from composites.
4. Call the `toString()` method on the root Composite object to obtain a string representation of the entire hierarchy.
5. Call the `getWeight()` method on the root Composite object to calculate the total weight of the hierarchy.
6. Modify the code as needed to suit your specific use case.

## Factory Technique

The Factory Technique involves creating objects through factory methods rather than using the `new` keyword directly. In this lab, we implement a factory method in the Human class to create objects of subclasses (NonBinary, Woman, and Man) based on a provided parameter (personal identification number).

### Key Concepts

- **Factory Method**: A method that creates objects based on certain criteria. It allows the class to have control over the object creation process.
- **Abstract Class**: An abstract class named Human with three concrete subclasses: NonBinary, Woman, and Man.
- **Static Factory Method**: The `create()` method in the Human class serves as a factory method for creating instances of different subclasses based on the parameter.
- **Visibility Modifiers**: We use visibility modifiers (public, private, etc.) to create a factory method that ensures objects are created according to specific rules and restricts direct object creation.

### How to Use the Factory Technique Example

1. Use the `Human.create()` method to create instances of Human subclasses based on a provided personal identification number (PIN).
2. The factory method determines the type of object (NonBinary, Woman, or Man) based on the PIN's characteristics.
3. Ensure that direct object creation (`new NonBinary(...)`, etc.) and anonymous subclass creation are not allowed.

## Iterator Pattern (Extra Task)

The Iterator Pattern allows you to iterate through composite structures without needing to understand their underlying structure. In the extra task, we implement two iterators for a Composite tree structure: one using breadth-first search and another using pre-order (depth-first) traversal.

### Key Concepts

- **Iterator**: An object that provides a way to access elements of a composite structure without exposing its internal details.
- **Breadth-First Iterator**: Iterates through elements in breadth-first search order.
- **Depth-First Iterator**: Iterates through elements in pre-order (depth-first) traversal order.
- **Composite as Iterable**: The Composite class implements the Iterable interface to enable for-each loop traversal.
- **Simplified Iterator**: In this task, we assume that the tree structure remains intact during iteration, simplifying the iterator implementation.

### How to Use the Iterator Pattern (Extra Task)

1. Implement two iterators for the Composite tree structure: one for breadth-first search and another for pre-order traversal.
2. Demonstrate traversal using the iterator's methods and for-each loop in the same program that demonstrates the Composite structure.

Feel free to explore the code and understand how these design patterns are applied in Java.