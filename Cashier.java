import java.util.Scanner;

public class Cashier {
    private Restaurant rest;

    public Cashier(Restaurant restaurant) {
        this.rest = restaurant;
    }
int sit;
int number;
Table myTableSit;

    public void help() {
        System.out.println("Welcome to " + rest.getName() + " restaurant!\n");
        System.out.print("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("How many are you? ");
        int group = scanner.nextInt();
        System.out.print("How many dolors do you have? ");
        int dolor = scanner.nextInt();
        Customer customer = new Customer(name, group, dolor);
        System.out.println("\nHow can i help you " + customer.getNameCustomer() + "?\n");

        int choice;

        do {
            System.out.println("1. Add Food to menu");
            System.out.println("2. Show menu");
            System.out.println("3. Show sits");
            System.out.println("4. Choose a sit");
            System.out.println("5. Order food");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean isTrue = true;
                    System.out.print("Enter Food name: ");
                    String foodName = scanner.next();
                    for (Food foodTemp : this.rest.showMenu()) {
                        if (foodTemp.getName().equals(foodName)) {
                            System.out.println("food " + foodName + " is already in the menu");
                            isTrue = false;
                            break;
                        }
                    }
                    if (isTrue) {
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
                    int flag = 0;
                    System.out.print("Please enter the number of table you would like to sit: ");
                    int tableNumber = scanner.nextInt();

                    for (Table myTableSit : rest.showSits()) {
                        if (myTableSit.getNumber() == tableNumber) {
                            if (customer.getSitNumber() == 0) {
                                if (customer.getGroupOfCustomer() <= myTableSit.getCapacity() && customer.getGroupOfCustomer() >= (myTableSit.getCapacity()) / 2) {
                                    if (!myTableSit.isFull()) {
                                        customer.setTable(myTableSit);
                                        for (Chair chairTemp : myTableSit.getChairs()) {
                                            if (!chairTemp.isFull()) {
                                                chairTemp.changeFull();
                                            }
                                        }
                                        myTableSit.changeFull();
                                        flag = 1; //for you sat on table
                                        break;
                                    } else {
                                        flag = 2; //for table is full
                                    }
                                } else if (customer.getGroupOfCustomer() < (myTableSit.getCapacity()) / 2) {
                                    flag = 4; //to low for capacity
                                } else {
                                    flag = 3;
                                }
                            }
                            else{
                                flag = 5; // if you already sat ot a table
                            }
                        }
                    }


                    switch (flag) {
                        case 1:
                            customer.setSitNumber(tableNumber);
                            System.out.println("\nYou sat on table number " + customer.getSitNumber() + "!\n");
                            break;
                        case 2:
                            System.out.println("\nTable is full!\n");
                            break;
                        case 3:
                            System.out.println("\nYou are too many people!\n");
                            break;
                        case 4:
                            System.out.println("\nYou are too less people!\n");
                            break;
                        case 5:
                            System.out.println("\nYou already sat on table number " + customer.getSitNumber() + "!");
                            System.out.println("Do you want to change your sit?(Yes/No)");
                            String choose = scanner.next();
                            if (choose.equals("Yes")) {
                                customer.setSitNumber(0);
                                System.out.println("\nPlease choose a sit again!\n");
                            }
                            break;
                        case 0:
                            System.out.println("\nTable is not exist!\n");
                    }
                    break;

                case 5:
                    String true_false_choose;
                    if (customer.getSitNumber() == 0){
                        System.out.println("\nChoose a table first!\n");
                        break;
                    }

                    do {
                        System.out.print("Please enter the name of food you would like to order: ");
                        String foodNameForOrder = scanner.next();
                        System.out.print("How many do you want? ");
                        int foodNumberForOrder = scanner.nextInt();

                        flag = 0;
                        for (Food order_Food_Finder : this.rest.showMenu()) {
                            if (order_Food_Finder.getName().equals(foodNameForOrder)) {
                                System.out.println("\n" + foodNumberForOrder + " " + order_Food_Finder.getName() + " ordered for table number " + customer.getSitNumber() + "!\n");
                                customer.setBill(foodNumberForOrder * order_Food_Finder.getPrice());
                                flag = 1; //food ordered
                                break;
                            }
                        }
                        if (flag == 0) { //food is not in menu
                            System.out.println("\nFood is not in menu!\n");
                        }

                        System.out.println("Anything else? (Yes/No)\n" + "enter your choice: ");
                        true_false_choose = scanner.next();
                    } while (true_false_choose.equals("Yes"));

                    System.out.println("Your bill is: " + customer.getBill() + "\n");

                    if (customer.getWallet() < customer.getBill()) {
                        System.out.println("You dont have enough money!\n");
                        System.out.print("Do you want change the order?(Yes/No)\n");
                        true_false_choose = scanner.next();
                        if (true_false_choose.equals("Yes")) {
                            System.out.println("Please order again!\n");
                            customer.setBill(0);
                            break;
                        }
                        else{
                            System.out.println("Would you like wash the dishes instead?(Yes/No)");
                            true_false_choose = scanner.next();
                            if (true_false_choose.equals("Yes")) {
                                System.out.println("You washed the dishes!\n");
                                customer.setBill(0);
                            }
                            else {
                                System.out.println("Sorry we can't service you!");
                                customer.setSitNumber(0);
                                customer.getTable().changeFull();
                                choice = 6;
                                break;
                            }
                        }
                    }
                    System.out.println("Enjoy you food " + customer.getNameCustomer() + "!\n");
                    customer.setWallet(customer.getBill());

            }
        } while (choice != 6);
        System.out.println("Goodbye!");
    }
}