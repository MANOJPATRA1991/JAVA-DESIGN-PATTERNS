package SOLID_Principles;

/**
 *  Interface Segregation Principle(ISP)
 *
 *  It is a recommendation on how to separate interfaces
 *  into smaller interfaces
 */

class Document {

}

interface Machine {
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d);
}

// Multi-function printer
class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

// Old fashioned printer can only print not fax or scan
class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    @Override
    public void scan(Document d) {

    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// YAGNI = You Ain't Gonna Need It

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {

    }
}

class PhotoCopier implements Printer, Scanner {
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {}

// DECORATOR PATTERN
class MultiFunctionMachine implements MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}