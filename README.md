# Passing by Value vs Reference Lab

## Learning Goals

- Explore passing by value and passing by reference

## Instructions

We have identified 3 different scenarios for how Java passes parameters:

1. As a general rules, parameters `references` are passed by `value`
2. This is not the case for primitive types (`int`, `boolean`, `short`, ...) as
   they are strictly passed by `value`
3. It is also not the case for variables of immutable types, such as `String`,
   `Integer`, `Short`, `Boolean` ...

Try to come up with specific examples to demonstrate each one of these rules in
action

1. Write a method that multiplies two numbers and stores the result in a
   variable that was passed in as a parameter. Make the calling method display
   the result of the multiplication.
2. Modify the method above so that the calling method cannot see the result of
   the multiplication
3. Write a method that can modify a `String` that is passed in, in such a way
   that the calling method can see the modified new value for the `String`
   parameter
4. Write a method that takes a `String` parameter, modifies it and shows that
   the calling method cannot see the modified value

## Solution 1

This requires two classes - one class that can be used as the container for the
primitive type, so that its reference can be passed by value, and one class that
will hold our `main()` method that we can run

First class

```java
public class NumberContainer {
    public int number;
}
```

Second class

```java
public class SampleClass {
    public static void main(String[] args) {
        NumberContainer myNumber = new NumberContainer();
        multiplyNumbers(myNumber, 12, 3);
        System.out.println("Result = " + myNumber.number);
    }

    public static void multiplyNumbers(NumberContainer result, int firstNumber, int secondNumber) {
        result.number = firstNumber * secondNumber;
    }
}
```

## Solution 2

This is the same as Solution 1, except that the `multiplyNumbers()` method
creates a new instance of the `result` variable, therefore making it local to
the method and making the result not visible to the calling method (`main()` in
our case)

First class

```java
public class NumberContainer {
    public int number;
}
```

Second class

```java
public class SampleClass {
    public static void main(String[] args) {
        NumberContainer myNumber = new NumberContainer();
        multiplyNumbers(myNumber, 12, 3);
        System.out.println("Result = " + myNumber.number);
    }

    public static void multiplyNumbers(NumberContainer result, int firstNumber, int secondNumber) {
        result = new NumberContainer();
        result.number = firstNumber * secondNumber;
    }
}
```

## Solution 3

We take advantage of the same "Container Class" principle in this example,
except that we're using it to contain a `String` object instead of an `int`
primitive

First class:

```java
class StringContainer {
    public String text;
}
```

Second class:

```java
public class SampleClass {
    public static void main(String[] args) {
        StringContainer myString = new StringContainer();
        myString.text = "initial value";
        addText(myString, " - adding new text");
        System.out.println("modified text: " + myString.text);
    }

    public static void addText(StringContainer result, String newText) {
        result.text = result.text + newText;
    }
}
```

## Solution 4

We can demonstrate that references of immutable objects can be modified inside a
method without the calling method seeing the changes by using a `String` object
directly, instead of wrapped in a container class

```java
public class SampleClass {
    public static void main(String[] args) {
        String myString = "initial value";
        addText(myString, " - adding new text");
        System.out.println("modified text: " + myString);
    }

    public static void addText(String result, String newText) {
        result = result + newText;
    }
}
```

You will see that this code does not output the updated value
