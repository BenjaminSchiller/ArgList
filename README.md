# ArgList

**ArgList** provides a way to easily create an instance of a Java class based in the input arguments given as a String array (e.g., the *String[] args* parameters of a *main(...)* method).

This is helpful when attempting to parse a large number of arguments in a Java main method.
Also, it is commonly expected to output a list of expected parameters in case an insufficient number is supplied of there are any problems while parsing the arguments given to the HJava program.

**ArgList** provides easy means to do exactly that.
An **ArgList** object is defined as a list of any arguments of arbitrary type with names and descriptions.
Given a list of actual arguments, **ArgList** parses the given Strings and creates an object instance of the desired Java class.
For that, the respective class must provide a constructor matching the order and types of the arguments specified in the **ArgList** instance.

In case any problems occurr during parsing or instantiation, the respective exceptions are thrown and a list of al arguments is printed.
For each argument, the given arguments from the String array input are also printed making the identification of possible mistakes while calling simple.


## Atomic argument types

Atomic arguments represent the most basic single arguments.
They must extend the (abstract) class `argList.types.Arg`.
For their definition (or instantiation), each atomic argument type takes the following parameters:

- **name** - the name of the argument
- **description** - a description of the argument

The main functionality of an atomic argument is to parse an object of a specific type `T` from a given `String` argument.
This functionality is implemented in the (public) method `T parseValue(String s){...}`.
In the following list, the respective object type `T` is given in parentheses.

#### ClassArg (*java.lang.Class*)
Argument for holding a `Class` object.
It is parsed from the given `String` argument using the (static) `Class.forName(s)` method.

#### DoubleArg (*java.lang.Double*)
Argument for holding a `Double` object.
It is parsed form the given `String` argument using the (static) `Double.parseDouble(s)` method.

#### IntArg (*java.lang.Integer*)
Argument for holding a `Integer` object.
It is parsed form the given `String` argument using the (static) `Integer.parseInt(s)` method.

#### LongArg (*java.lang.Long*)
Argument for holding a `Long` object.
It is parsed form the given `String` argument using the (static) `Long.parseLong(s)` method.

#### StringArg (*java.lang.String*)
Argument for holding a `String` object.
Here, no parsing is performed and the `String` object given as argument is simply returned.

#### EnumArg (*java.lang.String*)
Argument for holding the `String` representation of an `enum type`.
The given `String` object is simply returned (as for *StringArg*).

In contrast to *StringArg*, *EnumArg* takes an `Object[]` array as additional parameters for instantiation, e.g., taken from `enumType.values[]`.
Since the enum type cannot be cast directly, the `String` is returned.
The list of enum types is only used for outputting the list of all possible values of this argument.

- **values** - list of enum type values (`Object[]`)


## Array argument types

Array arguments represent a list of atomic arguments.
In addition to name and description, these arguments take a `String` separator as input.
When parsing the list of arguments, the input `String` is split at the separator and each element is then parsed depending on the respective atomic argument type.

- **separator** - `String` used for separating multiple arguments and creating a list of them

#### DoubleArrayArg (*java.lang.Double[]*)
Array of `DoubleArg` arguments.

#### EnumArrayArg (*java.lang.String[]*)
Array of `EnumArg` arguments.

#### IntArrayArg (*java.lang.Integer[]*)
Array of `IntArg` arguments.

#### LongArrayArg (*java.lang.Long[]*)
Array of `LongArg` arguments.

#### StringArrayArg (*java.lang.String[]*)
Array of `StringArg` arguments.

#### CombinedArg (*java.lang.Object[]*)
This argument combined multiple atomic arguments.
As input, it takes as list of the atomic arguments (`Arg[]`) as well as a `String` separator for splitting the input `String` during parsing.
Since the given atomic arguments can be of any type, the return value of the parsing method is `Object[]`.

#### CombinedArrayArg (*java.lang.Object[][]*)
Array of `CombinedArg` arguments.
Note that the separator of *CombinedArrayArg* and *CombinedArg* should be different!



## Source Code

All required java sources are located in `the src/` dir of the repo.
It contains the following packages and important classes:

	argList.ArgList

This is the main class which holds the definition of an argument list and provides mathods to generate an instance of the desired class from a set of given arguments.

	argList.examples.*

Here, we present a set of examples that showcase how **ArgList** can be used.

	argList.types.Arg
	argList.types.ArgArray
	argList.types.array.*
	argList.types.atomic.*

This package contains the basic classes `Arg` and `ArgArray` and their children which represent specific argument types.



## Build file

With `build/build.xml`, we provide a simple ant build file for creating `ArgList.jar`.
It contains all sources and binary files of **ArgList**.




## Examples

Here, we only provide basic examples of how to use **ArgList**.
More complex examples are provided in `src/argList/examples/`.