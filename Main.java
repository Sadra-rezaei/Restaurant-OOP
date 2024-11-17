public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Shandiz");
        Cashier cashier = new Cashier(restaurant);
        cashier.help();
    }
}
