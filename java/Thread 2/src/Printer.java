public class Printer extends Thread {
    private String label;
    private int start;
    private int end;

    public Printer(String label, int start, int end) {
        this.label = label;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        print();
    }

    public void print() {
        for (int i = start; i <end; i++) {
            System.out.println(label + ": " + i);
        }
    }
}
