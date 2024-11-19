import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Food> menu;
    private ArrayList<Table> sits;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.sits = new ArrayList<>();
        Table table1 = new Table(2,1);
        Table table2 = new Table(2,2);
        Table table3 = new Table(4,3);
        Table table4 = new Table(6,4);
        sits.add(table1);
        sits.add(table2);
        sits.add(table3);
        sits.add(table4);
        Food pizza = new Food("Pizza",5);
        Food pasta = new Food("Pasta",5);
        Food burger = new Food("Burger",3);
        Food stake = new Food("Stake",10);
        menu.add(pizza);
        menu.add(pasta);
        menu.add(burger);
        menu.add(stake);
    }

    public void addFood(String food_name , int food_price) {
        Food food = new Food(food_name, food_price);
        this.menu.add(food);
    }

    public void addTable(int table_number , int table_price) {
        Table table = new Table(table_number, table_price);
        this.sits.add(table);
    }

    public ArrayList<Food> showMenu() {
        return this.menu;
    }

    public ArrayList<Table> showSits() {
        return this.sits;
    }

    public String getName() {
        return this.name;
    }





}
