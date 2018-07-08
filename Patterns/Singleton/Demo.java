package Patterns.Singleton;

import java.io.*;

// DEMONSTRATES PROBLEMS WITH SERIALIZATION AND SOLUTION

// One and only one instance is available for use
class BasicSingleton implements Serializable {

    // A private constructor
    private BasicSingleton() {

    }

    // Only single instance is exposed
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

    // SOLUTION TO SECOND PROBLEM:
    // Whenever serialization happens, it has to happen
    // in the context of this object

    /**
     * readResolve is used for replacing the object read from the stream.
     * The only use I've ever seen for this is enforcing singletons;
     * when an object is read, replace it with the singleton instance.
     * This ensures that nobody can create another instance
     * by serializing and de-serializing the singleton.
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {
//    Problems associated with this approach:
//    1. Reflections : With Reflections API, we can get constructor
//    and create more than one instances of the class
//    2. Serialization : The JVM doesn't really care if the constructor is private
//    and it's gonna create a new object on deserialization

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // SERIALIZING THE OBJECT
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // DE-SERIALIZING THE OBJECT
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

// OUTPUT
// true
// 222
// 222