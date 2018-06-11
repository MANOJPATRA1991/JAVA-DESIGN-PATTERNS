package Patterns.Singleton;

import java.io.*;

// One and only one instance is available for use
class BasicSingleton {

    private BasicSingleton() {

    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {
//    Problems associated with this approach:
//    1. Reflections
//    2. Serialization : The JVM doesn't really care if it is a singleton
//    and it's gonna create a new object on serialization

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);

        singleton.setValue(222);

        BasicSingleton singleton1 = readFromFile(filename);

        System.out.println(singleton == singleton1);
        System.out.println(singleton.getValue());
        System.out.println(singleton1.getValue());
    }
}