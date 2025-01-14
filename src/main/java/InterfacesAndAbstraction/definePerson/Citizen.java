package InterfacesAndAbstraction.definePerson;

import InterfacesAndAbstraction.definePerson.interfaces.Birthable;
import InterfacesAndAbstraction.definePerson.interfaces.Identifiable;
import InterfacesAndAbstraction.definePerson.interfaces.Person;

public class Citizen implements Person, Identifiable, Birthable {
    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
    @Override
    public String getID() {
        return this.id;
    }
}
