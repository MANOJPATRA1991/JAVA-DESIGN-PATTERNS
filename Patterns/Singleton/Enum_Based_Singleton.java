package Patterns.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Enums are serializable by default
// No way of inheriting

// In this case, only INSTANCE is going to be serialized
enum EnumBasedSingleton {
    INSTANCE;

    EnumBasedSingleton() {
        value = 42;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class DemoEnumBasedSingleton {
    static void saveToFile(EnumBasedSingleton singleton, String filename) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // SERIALIZING THE OBJECT
            out.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // DE-SERIALIZING THE OBJECT
            return (EnumBasedSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        String filename = "myfile.bin";

//        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
//
//        singleton.setValue(111);
//        saveToFile(singleton, filename);

        EnumBasedSingleton singleton1 = readFromFile(filename);

        System.out.println(singleton1.getValue());
    }
}