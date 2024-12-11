package com.company.Encapsulation.validationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0);
    }

    public void setFirstName(String firstName) {
        ensureNameLength(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        ensureNameLength(lastName, "Last");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative or zero integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva.");
        }
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double increase) {
        if (age < 30) increase = increase / 2;

        this.salary = this.salary * (1.00 + increase / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
    }

    private void ensureNameLength(String nameParam, String filedName) {
        if (nameParam.length() < 3) {
            throw new IllegalArgumentException(filedName + " name cannot be less than 3 symbols.");
        }
    }
}
