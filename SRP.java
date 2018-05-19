/**
 * SINGLE RESPONSIBILITY PRINCIPLE(SRP):
 * A class should have only one single responsibility
 * There should be SEPARATION OF CONCERN
 */

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * The Journal class has a single responsibility of
 * adding and removing journals
 */
class Journal {
    private final List<String> entries = new ArrayList<>();

    //  This variable keeps a count of the total number of journals
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // VIOLATION OF SRP
    public void save(String filename) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {

    }

    public void load(URL url) {

    }
}

/**
 * Persistence class has a single responsibility
 * of saving journals to a file and loading journals
 * from a file
 */
class Persistence {
    public void saveToFile(Journal journal,
                           String filename,
                           boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try(PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }

//    public Journal load(String filename) {}

//    public Journal load(URL url) {}
}

class Demo {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I ate today");
        j.addEntry("I jogged today");

        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "C:\\temp\\journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}