# Java Code Examples README

This README provides an overview of two Java code examples:

1. **Problem1_StringIndexer**: This code demonstrates how to find the index of a given string in a `HashMap`. If the string is not found, it returns -1.

2. **Problem2_PersonSortingExample**: This code showcases sorting `Person` objects using Java collections and custom comparators.

---

## Problem1_StringIndexer

### Description

The `Problem1_StringIndexer` class defines a method, `index`, that searches for a string in a `HashMap` and returns its index if found. If the string is not in the map, it returns -1.

### Usage

1. Create a `HashMap` named `indexMap` to store strings and their corresponding indices.
2. Populate `indexMap` with strings and their indices.
3. Use the `index` method to find the index of a given string in `indexMap`.
4. The code in the `main` method demonstrates how to use the `index` method to search for "SAX" and "HOPP" in `indexMap`.

---

## Problem2_PersonSortingExample

### Description

The `Problem2_PersonSortingExample` class demonstrates various sorting scenarios with `Person` objects. It includes the following:

- Creating a sorted tree (`TreeSet`) of `Person` objects based on their `pnr` (personal identification number).
- Sorting a list of `Person` objects by `pnr` using `Collections.sort()`.
- Creating a new list of `Person` objects sorted by `namn` (name) while preserving the original order by `pnr`.

### Usage

1. Create a `TreeSet` named `personerna` to automatically sort `Person` objects based on their `pnr`.
2. Use the `skapaPerson()` method (replace with your actual logic) to create `Person` objects and add them to `personerna`.
3. Print the sorted `Person` objects using an iterator.
4. Sort a list of `Person` objects by `pnr` using `Collections.sort()`.
5. Create a new list of `Person` objects sorted by `namn` using a custom comparator while preserving the original order by `pnr`.

### Note

The code includes a simulated `skapaPerson()` method to create `Person` objects. Replace this method with your actual logic for creating `Person` objects.
