package Patterns.Builder;

class Person {
    public String name;
    public String position;

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

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class Demo {
    public static void main(String[] args) {
        /**
         * The idea is to cast to the most-derived type that we are working with
         */
        EmployeeBuilder pb = new EmployeeBuilder();
        Person manoj = pb.withName("Manoj").worksAt("India").build();
        System.out.println(manoj);
    }
}