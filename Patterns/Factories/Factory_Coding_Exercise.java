package Patterns.Factories;

import java.util.ArrayList;
import java.util.List;

class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private int user_id = 0;

    public Person createPerson(String name)
    {
        return new Person(user_id++, name);
    }
}

class PersonFactoryDemo {
    public static void main(String[] args) {
        PersonFactory pf = new PersonFactory();

        Person p = pf.createPerson("Mike");
        System.out.println(p.id);
        System.out.println(p.name);

        Person p2 = pf.createPerson("James");
        System.out.println(p2.id);
        System.out.println(p2.name);
    }
}