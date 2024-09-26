import java.util.Scanner;

public class Main {
  // public static void main(String[] args) {
  // Scanner scanner = new Scanner(System.in);

  // System.out.println("Enter your name:");
  // String name = scanner.nextLine();

  // System.out.println("Hello, " + name + "!");

  // Variables
  // salary grade isEmployed name

  // int age = 26;
  // double salary = 100000.50;
  // char grade = 'A';
  // boolean isEmployed = true;
  // String name = "Robbie del Rosario";

  // System.out.println("Name: " + name);
  // System.out.println("Age: " + age);
  // System.out.println("Salary: " + salary);
  // System.out.println("Grade: " + grade);
  // System.out.println("Is Employed: " + isEmployed);

  // Operations

  // int a = 10;
  // int b = 5;

  // int sum = a + b;
  // int difference = a - b;
  // int product = a * b;
  // int quotient = a / b;
  // int remainder = a % 2;

  // System.out.println("Sum: " + sum);
  // System.out.println("Difference: " + difference);
  // System.out.println("Product: " + product);
  // System.out.println("Quotient: " + quotient);
  // System.out.println("Remainder: " + remainder);

  // Comparison equations
  // int x = 10;
  // int y = 20;

  // System.out.println("x == y: " + (x == y));
  // System.out.println("x != y: " + (x != y));
  // System.out.println("x > y: " + (x > y));
  // System.out.println("x < y: " + (x < y));
  // System.out.println("x >= y: " + (x >= y));
  // System.out.println("x <= y: " + (x <= y));

  // Control Flow
  // int age = 20;
  // int age2 = 17;

  // if (age2 >= 18) {
  // System.out.println("You are an adult!");
  // } else {
  // System.out.println("You are a minor!");
  // }

  // int day = 5;

  // switch (day) {
  // case 1:
  // System.out.println("It's Monday!");
  // break;
  // case 2:
  // System.out.println("It's Tuesday!");
  // break;
  // case 3:
  // System.out.println("It's Wednesday!");
  // break;
  // default:
  // System.out.println("It's Other day!");
  // break;
  // }
  // }

  // public static void main(String[] args) {
  // // for (int i = 1; i <= 5; i++) {
  // // System.out.println("Number: " + i);
  // // }
  // // int i = 1;

  // // while (i <= 5) {
  // // System.out.println("Number: " + i++);
  // // }
  // // int i = 6;

  // // do {
  // // System.out.println("Number: " + i++);
  // // } while (i <= 5);
  // int[] numbers = { 10, 20, 30, 40, 50 };

  // // for (int i = 0; i < numbers.length; i++) {
  // // System.out.println("Element at index " + i + ": " + numbers[i]);
  // // }

  // for (int number : numbers) {
  // System.out.println("Number: " + number);
  // }
  // }

  // methods

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter num1: ");
    int num1 = scanner.nextInt();
    System.out.println("Enter num2: ");
    int num2 = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter a string: ");
    String str = scanner.nextLine();

    double result = 0.0;

    result = simpleCalculator(num1, num2, '+');
    displayResult(result);
    result = simpleCalculator(num1, num2, '-');
    displayResult(result);
    result = simpleCalculator(num1, num2, '*');
    displayResult(result);
    result = simpleCalculator(num1, num2, '/');
    displayResult(result);
    result = simpleCalculator(num1, num2, '%');
    displayResult(result);
    result = simpleCalculator(num1, num2, '^');
    displayResult(result);

    result = calculateFactorial(num1);
    displayResult(result);
    result = calculateFactorial(num2);
    displayResult(result);

    for (int i = 10; i >= 0; i--) {
      System.out.println("Factorial of " + i + " is " + calculateFactorial(i));
    }

    System.out.println("str: " + str);
    boolean isPalindrome = isPalindrome(str);
    System.out.println(str + " is a palindrome: " + isPalindrome);

    Dog dog = new Dog("max", "aspin", 3);
    Cat tom = new Cat("tom");

    System.out.println("Dog's info:");
    System.out.println("Name: " + dog.name);
    System.out.println("Breed: " + dog.breed);
    System.out.println("Age: " + dog.age);
    System.out.println("Dog's action: ");
    dog.bark();
    dog.eat();
    tom.eat();
  }

  public static double simpleCalculator(double num1, double num2, char operator) {
    double answer = 0.0;

    switch (operator) {
      case '+':
        answer = num1 + num2;
        break;

      case '-':
        answer = num1 - num2;
        break;

      case '*':
        answer = num1 * num2;
        break;

      case '/':
        answer = num1 / num2;
        break;

      case '%':
        answer = num1 % num2;
        break;

      default:
        displayError();
        break;
    }

    return answer;
  }

  public static void displayResult(double result) {
    System.out.println("Result: " + result);
  }

  public static void displayError() {
    System.out.println("Invalid operator!");
  }

  public static int calculateFactorial(int number) {
    if (number == 0) {
      return 1;
    }

    int answer = number;

    while (number > 1) {
      answer *= --number;
    }

    return answer;
  }

  public static boolean isPalindrome(String str) {
    str = str.toLowerCase().trim();
    boolean answer = true;

    StringBuilder tempStr = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      tempStr.append(str.charAt(i));
    }

    answer = str.equalsIgnoreCase(tempStr.toString());

    System.out.println("str: " + str);
    System.out.println("tempStr: " + tempStr);

    return answer;
  }
}

class Animal {
  String name;

  public Animal(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println(name + " is eating!");
  }
}

class Dog extends Animal {
  String breed;
  int age;

  public Dog(String name, String breed, int age) {
    super(name);
    this.breed = breed;
    this.age = age;
  }

  public void bark() {
    System.out.println(name + " says woof!");
  }

  @Override
  public void eat() {
    System.out.println(name + " eats pedigree!");
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  @Override
  public void eat() {
    System.out.println(name + " eats whiskas!");
  }
}