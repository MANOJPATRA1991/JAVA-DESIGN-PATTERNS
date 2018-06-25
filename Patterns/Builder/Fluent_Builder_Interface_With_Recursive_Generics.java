package Patterns.Builder;

class Person {
    public String name;
    public String position;

    /**
     * Returns a string representation of the Person instance
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    /**
     * This method sets the name field on the Person instance
     * @param name String
     * @return Instance which calls the withName function (SELF)
     */
    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    /**
     * This method returns the Person instance which is acted upon
     * @return Person instance
     */
    public Person build() {
        return person;
    }

    /**
     * @return Instance which acts upon the Person instance
     */
    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    /**
     * This method sets the position field on the Person instance
     * @param position String
     * @return Instance which calls the worksAt function (SELF)
     */
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    /**
     * @return EmployeeBuilder instance
     */
    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

/**
 * Demonstrates fluent builder interface with recursive generics
 */
class Demo {
    /**
     * This is the main method which demonstrates HTMLBuilder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        /**
         * The idea is to cast to the most-derived type that we are working with
         */
        EmployeeBuilder pb = new EmployeeBuilder();
        Person mike = pb.withName("Mike").worksAt("NY").build();
        System.out.println(mike);
    }
}