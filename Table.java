import java.util.ArrayList;

public class Table {
    private int number;
    private ArrayList<Chair> chairs;
    private boolean full;

    public Table(int capacity, int number) {
        this.number = number;
        this.full = false;
        this.chairs = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.chairs.add(new Chair());
        }
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Chair> getChairs() {
        return chairs;
    }

    public int getCapacity() {
        return chairs.size();
    }

    public void addChair(Chair chair) {
        chairs.add(chair);
    }

    public boolean isFull() {
        return full;
    }

    public void changeFull() {
        this.full = !this.full;
    }
}
