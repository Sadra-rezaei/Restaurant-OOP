public class Table {
    private int number;
    private int capacity;
    private boolean full;

    public Table(int capacity, int number) {
        this.number = number;
        this.capacity = capacity;
        this.full = false;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return full;
    }

    public void changeFull() {
        this.full = !this.full;
    }
}
