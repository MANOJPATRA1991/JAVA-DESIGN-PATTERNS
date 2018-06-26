package Patterns.Prototype;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

class CopyBySerializationDemo {
    public static void main(String[] args) {
        Foo foo = new Foo(42, "life");

        // COPY BY VALUE : SERIALIZATION AND DESERIALIZATION
        byte[] s = SerializationUtils.serialize(foo);
        Foo foo2 = (Foo) SerializationUtils.deserialize(s);

        foo2.whatever = "xyz";

        System.out.println(foo);
        System.out.println(foo2);

    // Foo{stuff=42, whatever='life'}
    // Foo{stuff=42, whatever='xyz'}
    }
}