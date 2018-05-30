package Patterns.Prototype;

// DISADVANTAGE: We have to build a copy constructor
// for every single type

class PAddress {
    public String streetAddress, city, country;

    public PAddress(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    //    COPY CONSTRUCTOR

    //    Better than the cloneable interface
    public PAddress(PAddress other) {
        this(other.streetAddress, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                "}";
    }
}

class Employee {
    public String name;
    public PAddress address;

    public Employee(String name, PAddress address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other) {
        name = other.name;
        address = new PAddress(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class CopyConstructorDemo {
    public static void main(String [] args) {
        Employee john = new Employee("John",
                new PAddress("123 London Road", "London", "UK"));

        // Employee chris = john;
        Employee chris = new Employee(john);

        chris.name = "Chris";
        System.out.println(john);
        System.out.println(chris);
    }
}