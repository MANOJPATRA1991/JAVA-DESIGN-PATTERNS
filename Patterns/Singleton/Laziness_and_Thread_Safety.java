package Patterns.Singleton;

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }

    /**
     * Instance is created when someone requests it => Lazy Singleton

     * PROBLEM: Race condition if we have several threads accessing
     * the getInstance() method

     * SOLUTION: To avoid the constructor from being called more than once,
     * use synchronized =====> PERFORMANCE IMPLICATIONS
     */
//    public static synchronized LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//
//        return instance;
//    }

    /**
     * THREAD-SAFE METHODS OF CHECKING IF A SINGLETON CONSTRUCTOR IS CALLED ONLY ONCE
     * DOUBLE-CHECK LOCKING (OUTDATED)
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            /**
             * The Java synchronized keyword is an essential tool in concurrent programming in Java.
             * Its overall purpose is to only allow one thread at a time into a particular
             * section of code thus allowing us to protect, for example, variables or data from
             * being corrupted by simultaneous modifications from different threads.
             */
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

// ANOTHER WAY: INNER STATIC SINGLETON