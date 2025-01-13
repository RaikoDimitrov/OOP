package com.company.ExceptionsAndErrorHandling.validPerson;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        InputUtils.validateName("First", firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        InputUtils.validateName("Last", lastName);
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        InputUtils.validateAge(age);
        this.age = age;
    }

}
