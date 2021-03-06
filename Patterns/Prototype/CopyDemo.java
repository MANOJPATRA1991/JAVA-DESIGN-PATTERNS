package Patterns.Prototype;

import java.util.Arrays;

/**
 * A class implements the Cloneable interface to indicate
 * to the Object.clone() method that it is legal for that
 * method to make a field-for-field copy of
 * instances of that class
 */
class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    //    Default function of clone() is to perform a
    //    shallow copy instead of a deep copy

    //    It is better to use other mechanisms for implementing
    //    deep copy instead of Cloneable interface

    //    DEEP COPY
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable{
    public String [] names;
    public Address address;

    public Person(String [] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address) address.clone());
    }
}

class Demo {
    public static void main(String[] args)
        throws Exception {
        Person john = new Person(new String[]{"John", "Smith"},
                new Address("London Road", 123));

//        jane and john both refer to the same object
//        SHALLOW COPY
//        Person jane = john;
//        jane.names[0] = "Jane";
//        jane.address.houseNumber = 124;

        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);
    }
}