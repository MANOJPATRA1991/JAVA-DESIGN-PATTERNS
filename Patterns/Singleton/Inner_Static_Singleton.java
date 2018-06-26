package Patterns.Singleton;

/**
 * This approach avoids the problem of synchronization.
 * Guarantees effectively whenever we are going to
 * initialize an instance, we are going to get only one instance
 */

class InnerStaticSingleton {
    private InnerStaticSingleton() {}

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE
                = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}