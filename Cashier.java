import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cashier {
    private Restaurant rest;

    public Cashier(Restaurant restaurant) {
        this.rest = restaurant;
    }
int sit;

    public void help() {
        System.out.println("Welcome to " + rest.getName() + " restaurant!\n" + "How can i help you sir?\n");

        int choice;

        do {
            System.out.println("1. Add Food to menu");
            System.out.println("2. Show menu");
            System.out.println("3. Show sits");
            System.out.println("4. Choose a sit");
            System.out.println("5. Order food");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean flag = true;
                    System.out.print("Enter Food name: ");
                    String foodName = scanner.next();
                    for (Food foodTemp : this.rest.showMenu()) {
                        if (foodTemp.getName().equals(foodName)) {
                            System.out.println("food " + foodName + " is already in the menu");
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.print("Enter Food price: ");
                        int foodPrice = scanner.nextInt();
                        rest.addFood(foodName, foodPrice);
                        System.out.println("\nFood added to menu\n");
                    }
                    break;

                case 2:
                    System.out.println();
                    for (Food foodTemp : this.rest.showMenu()) {
                        System.out.println(foodTemp.getName() + " ..... " + foodTemp.getPrice() + "$");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    for (Table tableTemp : this.rest.showSits()) {
                        if (!tableTemp.isFull()) {
                            System.out.println("Table Number " + tableTemp.getNumber() + " is with " + tableTemp.getCapacity() + " capacity is empty" );
                        }
                        else {
                            System.out.println("Table Number " + tableTemp.getNumber() + " is with " + tableTemp.getCapacity() + " capacity is full");
                        }
                    }
                    System.out.println();

                case 4:
                    int flag1 = 0;
                    System.out.print("Please enter the number of table you would like to sit: ");
                    int tableNumber = scanner.nextInt();
                    for (Table table2 : rest.showSits()) {
                        if (table2.getNumber() == tableNumber) {
                            if (!table2.isFull()) {
                                table2.changeFull();
                                flag1 = 1;
                                break;
                            }
                            else {
                                flag1 = 2;
                            }
                        }
                    }
                    switch (flag1) {
                        case 1:
                            sit = tableNumber;
                            System.out.println("\nYou sat on table number " + sit + "\n");
                            break;
                        case 2:
                            System.out.println("\nTable is full\n");
                            break;
                        case 0:
                            System.out.println("\nTable is not exist\n");
                    }
                    break;

                case 5:
                    String choice2;
                    int time = 0;
                    Timer timer = new Timer();
                    do {
                        System.out.println("Please enter the name of food you would like to order: ");
                        String name = scanner.next();
                        for (Food foodTemp : this.rest.showMenu()) {
                            if (foodTemp.getName().equals(name)) {
                                System.out.println("food " + foodTemp.getName() + " ordered for table number " + sit);
                                time += 5000;
                                break;
                            }
                        }
                        System.out.println("Anything else? (y/n)\n" + "enter your choice: ");
                        choice2 = scanner.next();
                    } while (choice2 == "y" || choice2 == "Y" || choice2 == "yes" || choice2 == "Yes");
            }

        } while (choice != 6);
        System.out.println("Goodbye!");
    }
}

