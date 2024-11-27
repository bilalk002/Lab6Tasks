public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        PrintThread printJob = new PrintThread(printer, 15);
        RefillThread refillJob = new RefillThread(printer, 10);

        printJob.start();
        refillJob.start();
    }
}
