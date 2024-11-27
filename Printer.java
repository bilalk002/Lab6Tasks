public class Printer {
    private int totalPages = 10;
    synchronized void printPages(int pages) {
        System.out.println("Print job received for " + pages + " pages...");
        if (totalPages < pages) {
            System.out.println("Not enough pages. Waiting for refill...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (totalPages >= pages) {
            totalPages -= pages;
            System.out.println("Printed " + pages + " pages. Remaining pages: " + totalPages);
        }
    }

    synchronized void refillPages(int pages) {
        System.out.println("Refilling " + pages + " pages...");
        totalPages += pages;
        System.out.println("Refill completed. Total pages available: " + totalPages);
        notifyAll();
    }
}

class PrintThread extends Thread {
    private Printer printer;
    private int pages;

    PrintThread(Printer printer, int pages) {
        this.printer = printer;
        this.pages = pages;
    }

    @Override
    public void run() {
        printer.printPages(pages);
    }
}

class RefillThread extends Thread {
    private Printer printer;
    private int pages;

    RefillThread(Printer printer, int pages) {
        this.printer = printer;
        this.pages = pages;
    }

    @Override
    public void run() {
        printer.refillPages(pages);
    }
}

