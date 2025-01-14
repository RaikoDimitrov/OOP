package Inheritance.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isValidInput(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Invalid input!");
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        isValidInput(gender);
        this.gender = gender;
    }

    private void isValidInput(String input) {
        if (input.trim().isEmpty()) throw new IllegalArgumentException("Invalid input!");
    }

    public String produceSound() {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName())
                .append(" ")
                .append(this.getAge())
                .append(" ")
                .append(this.getGender()).append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }
}
