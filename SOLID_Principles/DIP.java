package SOLID_Principles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

/**
 *  DEPENDENCY INVERSION PRINCIPLE(DIP)
 *  a. High-level modules should not depend on low-level modules.
 *  Both should depend on abstractions.
 *
 *  b. Abstractions should not depend on details.
 *  Details should depend on abstractions.
 */

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

// SOLUTION
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

// Low-level module with no business logic
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations
            = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

// High-level module
class Research {
    //  VIOLATION OF DIP
//    public SOLID_Principles.Research(SOLID_Principles.Relationships relationships) {
//        List<Triplet<SOLID_Principles.Person, SOLID_Principles.Relationship, SOLID_Principles.Person>> relations = relationships.getRelations();
//        relations.stream()
//            .filter(x -> x.getValue0().name.equals("John")
//            && x.getValue1() == SOLID_Principles.Relationship.PARENT)
//            .forEach(ch -> System.out.println(
//                    "John has a child called " + ch.getValue2().name
//            ));
//    }

    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person child : children) {
            System.out.println("John has a child called " + child.name);
        }
    }
}

class Demo4 {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}