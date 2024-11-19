public class Chair {
    private boolean full;

    public Chair() {
        this.full = false;
    }

    public boolean isFull() {
        return full;
    }

    public void changeFull() {
        this.full = !this.full;
    }

}
