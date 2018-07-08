package Patterns.Singleton;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

interface Database {
    int getPopulation(String name);
}

class SingletonDatabase implements Database {
    private Dictionary<String, Integer> capitals
            = new Hashtable <>();
    private static int instanceCount = 0;

    public static int getInstanceCount() {
        return instanceCount;
    }

    private SingletonDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        try {
            File f = new File(
                    SingletonDatabase.class.getProtectionDomain()
                            .getCodeSource().getLocation().getPath()
            );
            System.out.println(f.getPath());
            Path fullPath = Paths.get(f.getPath(), "populations.txt");
            List <String> lines = Files.readAllLines(fullPath);
            System.out.println(lines);
            Iterables.partition(lines, 2)
                    .forEach(keyValue -> capitals.put(
                            keyValue.get(0).trim(),
                            Integer.parseInt(keyValue.get(1))
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final SingletonDatabase INSTANCE
            = new SingletonDatabase();

    public static SingletonDatabase getINSTANCE() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }
}

class SingletonRecordFinder {
    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for(String name : names) {
            result += SingletonDatabase.getINSTANCE().getPopulation(name);
        }
        return result;
    }
}

class ConfigurableRecordFinder {
    private Database database;

    public ConfigurableRecordFinder(Database database) {
        this.database = database;
    }

    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for(String name : names) {
            result += database.getPopulation(name);
        }
        return result;
    }
}

class DummyDatabase implements Database {
    private Dictionary<String, Integer> data
            = new Hashtable <>();

    public DummyDatabase() {
        data.put("alpha", 1);
        data.put("beta", 2);
        data.put("gamma", 3);
    }

    @Override
    public int getPopulation(String name) {
        return data.get(name);
    }
}

class Tests {
    @Test // not a unit test! It's an integration test
    public void singletonPopulationTest() {
        SingletonRecordFinder rf = new SingletonRecordFinder();
        List <String> cities = List.of("Seoul", "Mexico City");
        int tp = rf.getTotalPopulation(cities);
        Assert.assertEquals(17500000+17400000, tp);
    }

    @Test
    public void dependentPopulationTest() {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
        Assert.assertEquals(4, rf.getTotalPopulation(
                List.of("alpha", "gamma")
        ));
    }
}

class Stuff {
    public static void main(String[] args) {
        Tests t = new Tests();
        t.dependentPopulationTest();
    }
}