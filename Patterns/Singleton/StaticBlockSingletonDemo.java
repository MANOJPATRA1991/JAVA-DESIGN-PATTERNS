package Patterns.Singleton;

import java.io.File;
import java.io.IOException;

// This approach is useful when we are trying to achieve
// additional behaviors in terms of accessing the singleton

class StaticBlockSingleton {
    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing!!");

        // Singleton throws exception
        File.createTempFile(".", ".");
    }

    // INITIALISE SINGLETON
    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("Failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}