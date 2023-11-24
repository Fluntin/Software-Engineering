# Lab 4 - Some Design Patterns

Design patterns describe proven solutions that can be used in various but similar contexts in object-oriented programming. With design patterns in the "toolbox," design problems can be solved more quickly and securely than without them. Some patterns are simple and easy to learn, while others are more complex.

When learning to practically use a new pattern, it's a good idea to implement the pattern in a small "toy example" to truly understand how it's supposed to work.

In this lab, we will study some common and popular patterns by implementing small examples.

## Goals
- To be able to construct objects according to the Composite pattern and perform simple but characteristic operations on such objects.
- To use the Factory technique: using packages and modifiers to create a factory method that generates objects of subclasses inaccessible to the user.

## Composite Pattern
The idea behind the Composite pattern is that a group of objects arranged hierarchically in a tree structure can be treated the same way as individual objects. An operation (a method call) on the composite object should result in the operation being performed on all parts of the object. The same call on a leaf object affects only the leaf. In the call c.op(), c can refer to either a leaf or a composite object.

Here's a description of Composite: [Composite Pattern](www.dofactory.com/Patterns/PatternComposite.asp)

Comment on the pattern description above: You can choose to have only the attributes and methods that make sense in both Leaf and Composite in the common superclass Component. Therefore, add(), remove(), and getChild() are removed from Component and implemented only in Composite, where they can be performed. If, for example, add() exists in Component, it also exists in Leaf due to inheritance, but add() is meaningless and even prohibited in Leaf. You can choose how to handle this. Attributes to be used in both subclasses Leaf and Composite must be defined in Component without exception.

## Task 1 – Suitcase as Composite
A suitcase can be packed according to the Composite pattern.

Your task is to implement a program for a suitcase following the UML diagram for the Composite design pattern. A suitcase is a container that can contain various items such as T-shirts, jeans, pants, soap, shampoo, toothbrush, book, and similar things that one wants to take on a trip. In addition to these items, the suitcase can also contain different types of containers (items designed to hold other containers and items), such as smaller bags, toiletry bags, and bags to collect items that somehow belong together, such as a toothbrush and toothpaste.

In the design pattern, apart from the Client in the UML diagram, we have three other classes. By studying the UML diagram on this page, choose which classes and interfaces are needed in your program to implement the Composite design pattern.

At least ten items should be packed, and at least three different levels of compositions should be used. For example, hairpins can be in a bag inside a toiletry bag with soap and shampoo, and the toiletry bag can be in the suitcase next to larger clothing items.

The weight of a suitcase is crucial for a flight. Therefore, it is important to calculate the weight of the suitcase with all items and containers. You should also be able to easily choose to remove some items or a container containing some items to ensure that the total weight of the suitcase can be approved at check-in at the airport. So, determine which attributes your program needs and in which class they fit best according to the pattern.

Use the toString() methods to get a description of the item or container and its contents. Also, use getWeight() to determine the weight of the suitcase and its contents. Answer questions like "In which classes should these methods be defined?" "Should this attribute be placed in the subclass or the superclass?" and so on.

Write a test program, Client in the UML diagram, that does the following:

1. Builds a suitcase, named 'suitcase.'

2. Prints out the total weight of the suitcase. For example, a call to the method suitcase.getWeight() calculates the total weight and returns it. Keep in mind that the suitcase and other containers have their own weight in addition to the weight of the contents!

3. Also, print out the "entire suitcase," meaning a list of the contents is printed out.

4. Then, remove some items and containers from the contents.

5. Print out the weight and contents again and check if it's correct!

It's important that getWeight() and toString() are implemented according to the pattern. Just providing the correct answers is not enough. This means that every call on a Composite object should go through all the object's children.

## Factory Technique
There are several design patterns that include the word Factory. What they have in common is that objects are not created in the usual way with 'new,' but through a method call. The methods are seen as "factories" where objects are created. Common names for these methods are 'getInstance()' or 'create().' The type of the created object is determined in some cases within the method, out of reach for the client (user). Inside the factory methods, 'new' is used, but the client, the one using the class, does not have direct access to 'new.' Common reasons for using this technique are to allow the user to not worry about the type of the object or to ensure that the correct type is chosen by the method, not the user, or for the class itself to have full control over which objects are created.

## Task 2 – Human Factory
Implement an abstract class, Human, with three concrete subclasses: NonBinary, Woman, and Man. In Human, a factory method should exist:

```java
public static Human create(String pnr) {
    // method body
}
Certainly, here's the text you provided formatted in Markdown:

```markdown
We assume that the parameter is a nearly valid personal identification number (PIN) of ten digits with a dash before the last four. You don't need to validate the PIN; just use its tenth character. If the second-to-last character is '0', return an instance of NonBinary. If it's an odd digit, return an instance of Man, and if it's an even digit but not '0', return an instance of Woman. Please note that this interpretation of personal identification numbers is the course leader's idea. The official registration only uses even and odd for female and male, respectively.

Write a test program that creates objects of NonBinary, Woman, and Man using the method above. Ensure that it's not possible to create objects of NonBinary, Woman, or Man in any other way than using the method above. So, it should not be possible to compile 'new NonBinary(...)' and so on in the test program. Creating an anonymous subclass of Human should also not be allowed. The following code should not compile in the test program:

```java
Human h = new Human(){}; // Creates an object of a subclass of Human, the class body is empty.
```

Note: Create a 'human' package that contains Human and its subclasses. Place the package in a subdirectory with the same name. By using appropriate visibility modifiers (public, private, etc.), you can achieve the requested structure. Place the test program at the directory level above the package. Also, ensure that the test program confirms that objects of the correct type have been created by having the toString() method print information about the objects, as:

```java
Human billie = Human.create("Billie", "xxxxxx-560x");
Human anna = Human.create("Anna", "xxxxxx-642x");
Human magnus = Human.create("Magnus","xxxxxx-011x");
System.out.println(billie);
System.out.println(anna);
System.out.println(magnus);
```

This can produce the following output:

```
I am non-binary and my name is Billie
I am a woman and my name is Anna
I am a man and my name is Magnus
```

**Presentation and Requirements for the Programs**
1. Implement the Composite pattern according to the lab instructions.
2. Demonstrate the execution of a test program where at least ten items are used to build a Composite with at least three levels. Print the total weight and contents. Remove some items from the suitcase. Print the total weight and contents again.
3. A UML class diagram is not required if it follows the linked content above. You can have different names for your classes without needing to redraw. If you have fewer or more classes, feel free to create your own!
4. Create an object diagram showing the objects created by the test program. The diagram does not need to follow the UML standard but should clearly show the existing objects. Draw the diagram as a tree!
5. Demonstrate the execution of the Human Factory program where objects of the three subclasses are created.
6. Demonstrate another version of the program where you attempt to use 'new NonBinary(...)' and so on, and 'new Human(){}' but the compilation fails.

**Extra Task - Iterator Pattern**
Note: Everyone who wants to receive an A grade in the lab course must complete this extra task.

The purpose of the Iterator pattern is to iterate through or go through all elements in a composite structure without having to deal with the underlying structure. Using an iterator on a list is natural, and the implementation of a list iterator is often straightforward.

Even for more complex structures, iterators are very useful. Composite compositions and other tree structures can easily be equipped with iterators. The iterator "delivers" the elements in sequence without needing to know how the structure is built. "Man" here is the one who uses the iterator. The one who programs the iterator, of course, needs to understand the structure. Natural choices for traversals of a tree structure are pre-order, in-order, post-order, or the order used in breadth-first search.

More about the Iterator pattern can be found here: [Iterator Pattern](www.dofactory.com/Patterns/PatternIterator.asp)

Also, read about Iterable, Iterator, and the enhanced for statement in the Java API and the tutorial linked above.

**Tasks:**

Write two iterators that go through the Composite tree structure. One iterator should use the order given by breadth-first search, and the other iterator should use pre-order tree traversal (depth-first search) order. When demonstrating the iterators, print the name in each tree node so that you can check if the order is correct. For this task, do not use the toString() method written in the main task as it provides the entire tree's content. Write a method with a different name to return the node's name, or change toString() for this task.

**Breadth-First Iterator:**

First, visit the root, then all the root's children, then the root's grandchildren, and so on.

Let the Composite class implement Iterable (as mentioned above) so that it has the iterator() method. Define iterator() to return an iterator object. With this approach, it becomes possible to go through the Composite structure with a for-each loop (see the code below) as well as with the iterator's methods. Show both in the test program!

```java
for (YourComponentClass co: YourCompositeObject){
    System.out.println(co);
}
```

**Depth-First Iterator:**

Implement a depth-first iterator as well.

Handling Two Iterators for the Same Class

The Iterable interface assumes that there is a single iterator, which should be returned when the interface's iterator() method is called. You are required to demonstrate two iterators. You can handle this by having two statements that create objects of different iterator classes, but always have one commented out. It's a good idea to think of a solution that doesn't require recompilation, but it's not required.

Simplified Iterator

We assume that the tree structure remains intact during an iterator's lifespan. This makes the iterator implementation much simpler than if we allowed removal (remove() in the iterator) or addition (add() in Composite) during the iteration. Of course, it's allowed to implement a more advanced iterator that can handle changes to the structure during traversal.

**Presentation**

Demonstration of the iterators can be done in the same program that demonstrates the Composite structure in the first part of the lab. Show both traversal with calls to the iterator's methods and traversal with the for-each loop.
```

You can paste this Markdown content into your document or README.md file for clear formatting.

Certainly, here's the text you provided formatted in Markdown:

```markdown
```java
for (YourComponentClass co: YourCompositeObject){
    System.out.println(co);
}
```

**Depth-First Iterator:**

Implement a depth-first iterator as well.

**Handling Two Iterators for the Same Class**

The Iterable interface assumes that there is a single iterator, which should be returned when the interface's iterator() method is called. You are required to demonstrate two iterators. You can handle this by having two statements that create objects of different iterator classes, but always have one commented out. It's a good idea to think of a solution that doesn't require recompilation, but it's not required.

**Simplified Iterator**

We assume that the tree structure remains intact during an iterator's lifespan. This makes the iterator implementation much simpler than if we allowed removal (remove() in the iterator) or addition (add() in Composite) during the iteration. Of course, it's allowed to implement a more advanced iterator that can handle changes to the structure during traversal.

**Presentation**

Demonstration of the iterators can be done in the same program that demonstrates the Composite structure in the first part of the lab. Show both traversal with calls to the iterator's methods and traversal with the for-each loop.
```

You can paste this Markdown content into your document or README.md file for clear formatting.