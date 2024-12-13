package com.company.Inheritance.animals;

public class TomCat extends Cat {
    private final static String GENDER = "Male";

    public TomCat(String name, int age) {
        this(name, age, GENDER);
    }

    public TomCat(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
