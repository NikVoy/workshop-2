# OOP Workshop - Cosmetics Shop 2

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work easier.

## Description

You are given a software system for managing a cosmetics shop. There are several models - three types of products, `Shampoo, Cream, and Toothpaste`, and a `Category`. Your task is to design an object-oriented class hierarchy to model the cosmetics shop, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Encapsulate all fields correctly and use validation whenever needed.

## Architecture

A working `Engine` already executes a sequence of commands read from the console. It uses the classes and interfaces in your project (see the `CosmeticsEngine` class). You do not have to touch anything in it or the `main()` method, but you could try to understand how they work. All models needed are already in the  **cosmetics.models** package. 

## Models

> Note: All validation intervals are inclusive (closed).

### **ShampooImpl**

- Extends `ProductBase`.
- Each `shampoo` in the system has `name, brand, price, gender, milliliters, and usage type`.
- `name` - the name's length should be between `3` and `10` symbols.
- `brand` - the brand name's length should be between `2` and `10` symbols.
- `price` - cannot be negative.
- `Gender type` can be `[Men, Women or Unisex]`.
- `milliliters` cannot be negative.
- `Usage type` can be `[EveryDay or Medical]`.
- Should be convertible to **String** in the format:

```none
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
```

### **ToothpasteImpl**

- Extends `ProductBase`.
- Each `toothpaste` in the system has `name, brand, price, gender, and ingredients`.
- `name` - the name's length should be between `3` and `10` symbols.
- `brand` - the brand name's length should be between `2` and `10` symbols.
- `price` - cannot be negative.
- `Gender type` can be `[Men, Women or Unisex]`.
- Should be convertible to **String** in the format:

```none
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Ingredients: [VALUE, VALUE]
 ===
```

### **CreamImpl**

- Extends `ProductBase`.
- Each `cream` in the system has a `name, brand, price, gender, and scent`
- `name` - the name's length should be between `3` and `10` symbols.
- `brand` - the brand name's length should be between `2` and `10` symbols.
- `price` - cannot be negative.
- `Gender type` can be `[Men, Women or Unisex]`.
- `Scent type` can be `[Rose, Lavender or Vanilla]`.
- Should be convertible to **String** in the format:

```none
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Scent: {scentType}
 ===
```

### **CategoryImpl**

- It has a `name and a list of products`.
- `name` - the name's length should be between `2` and `15` symbols.
- Should be convertible to **String** in the format:

```none
#Category: Shampoos
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
```

```none
#Category: Shampoos
 #No product in this category
```

## Repository

The `CosmeticsRepositoryImpl` class is used to store and retrieve all the information that the application needs. It also contains the `create()` methods of the objects. Your task is to implement all methods that throw `UnsupportedOperationException`. 

## Constraints

- Look into the example below to better understand the printing format.
- Format all floating-point values with **two digits** after the decimal point.
- All models are already in the **cosmetics.models** package. ***You do not need to create new classes!***

## Unit Tests

- You are given unit tests to keep track of your progress.
- Run them by right-clicking the **tests** package and selecting **Run 'All Tests'**.
- If you get stuck, check out the tests' names to guide you on what to do.
 
> Note: Be careful not to change anything in the **tests** folder.

## Step by step guide

1. You are given a skeleton of the cosmetics shop. Please take a look at it carefully before you start working. Try to understand all the classes and interfaces in **cosmetics.models** package and how they work.

> *Note*: The project won't compile initially. First, you need to build the correct interface hierarchy.

2. Build the project and run some commands. You should implement all commands that throw exceptions.

3. Validate all the fields. Yes, again :)

4. Did you notice the repeating code in the `ShampooImpl`, `CreamImpl`, and `ToothpasteImpl` classes? What should you do in the `ProductBase` class?

5. Implement `print()` methods (there are `print()` methods in the `Product` and `Category` interfaces).

6. Go to the `CosmeticsRepositoryImpl` class. Your task is to implement all the methods that throw `UnsupportedOperationException`. Check the already-implemented methods for clues.

### Sample Input

```
CreateShampoo MyMan Nivea 10.99 Men 1000 Every_Day
CreateCream MyCream Nivea 12.99 Men Lavender 
CreateToothpaste White Colgate 10.99 Men calcium,fluoride
CreateCategory Shampoos
CreateCategory Toothpastes
CreateCategory Creams
AddToCategory Shampoos MyMan
AddToCategory Creams MyCream
AddToCategory Toothpastes White
AddToShoppingCart MyMan
AddToShoppingCart White
AddToShoppingCart MyCream
ShowCategory Shampoos
ShowCategory Toothpastes
ShowCategory Creams
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Sample Output

```
Shampoo with name MyMan was created!
Cream with name MyCream was created!
Toothpaste with name White was created!
Category with name Shampoos was created!
Category with name Toothpastes was created!
Category with name Creams was created!
Product MyMan added to category Shampoos!
Product MyCream added to category Creams!
Product White added to category Toothpastes!
Product MyMan was added to the shopping cart!
Product White was added to the shopping cart!
Product MyCream was added to the shopping cart!
#Category: Shampoos
#MyMan Nivea
 #Price: $10.99
 #Gender: Men
 #Milliliters: 1000
 #Usage: EveryDay
 ===
#Category: Toothpastes
#White Colgate
 #Price: $10.99
 #Gender: Men
 #Ingredients: [calcium, fluoride]
 ===
#Category: Creams
#MyCream Nivea
 #Price: $12.99
 #Gender: Men
 #Scent: Lavender
 ===
$34.97 total price currently in the shopping cart.
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
$23.98 total price currently in the shopping cart.
```