package Patterns.Singleton;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.function.Supplier;

class SingletonTester {
    public static boolean isSingleton(Supplier<Object> func) {
        return func.get() == func.get();
    }
}

class Evaluate {
    @Test
    public void test()
    {
        Object obj = new Object();
        assertTrue(SingletonTester.isSingleton(() -> obj));
        assertFalse(SingletonTester.isSingleton(Object::new));
    }
}

class Tester {
    public static void main(String[] args) {
        Evaluate e = new Evaluate();

        e.test();
    }
}


