public class Main {
    public static void main(String[] args) {
        Printer printer1 = new Printer("Printer 1", 0, 100000);
        Printer printer2 = new Printer("Printer 2", 0, 100000);
        Printer printer3 = new Printer("Printer 3", 0, 100000);
        Printer printer4 = new Printer("Printer 4", 0, 100000);
        Printer printer5 = new Printer("Printer 5", 0, 100000);

//        printer1.print();
//        printer2.print();
//        printer3.print();
//        printer4.print();
//        printer5.print();

        printer1.start();
        printer2.start();
        printer3.start();
        printer4.start();
        printer5.start();
    }
}