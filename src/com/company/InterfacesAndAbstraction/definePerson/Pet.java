package com.company.InterfacesAndAbstraction.definePerson;

import com.company.InterfacesAndAbstraction.definePerson.interfaces.Birthable;

public class Pet implements Birthable {
    private final String name;
    private final String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}