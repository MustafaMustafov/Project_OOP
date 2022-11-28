import Management.ObjectFileManagement;
import Management.UserManagement;
import Restaurant.FoodMenu;
import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Management.UserManagement.getUserProfession;

public class RMS {
    static int select;
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> staff = ObjectFileManagement.readObjectFromFile("users.csv");

    public static void main(String[] args) {
        System.out.println("Welcome to RMS!");
        do {
            UserManagement.loginUser(staff);
            try {
                boolean key = getUserProfession();
                if (key) {
                    runMenuWaiter();
                } else {
                    runMenuChef();
                }
            } catch (NullPointerException e) {
                System.out.println("Incorrect login data entered!");
            }

        } while (select != 0);
    }

    public static void runMenuWaiter() {
        Waiter waiter = new Waiter();
        FoodMenu foodMenu = new FoodMenu();
        do {
            System.out.println("\n------- Waiter MENU -------");
            System.out.println("1.ADD new food to MENU");
            System.out.println("2.REMOVE food from MENU");
            System.out.println("3.DISPLAY food menu");
            System.out.println("4.DISPLAY active orders");
            System.out.println("5.CREATE new order");
            System.out.println("6.EDIT order");
            System.out.println("7.PAY bill / CHANGE order status");
            System.out.println("8.Logout account");
            System.out.println("0.EXIT");
            System.out.println("----------------------------");
            System.out.println("Select: ");
            try {
                select = sc.nextInt();
                switch (select) {
                    case 0:
                        System.out.println("The program ended!");
                        return;
                    case 1:
                        chooseFoodToAdd(foodMenu);
                        break;
                    case 2:
                        chooseFoodToRemove(foodMenu);
                        break;
                    case 3:
                        FoodMenu.displayMenu();
                        break;
                    case 4:
                        waiter.displayOrders();
                        break;
                    case 5:
                        waiter.inputNewOrder();
                        break;
                    case 6:
                        waiter.editOrder();
                        break;
                    case 7:
                        waiter.changeOrderStatus();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Please enter again your choice(0 to 8)!");
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not numbers type!!!" + "\n ____________");
                return;
            }
        } while (select != 0);
    }

    private static void chooseFoodToAdd(FoodMenu foodMenu) {
        System.out.println("(1) Add to Meals\n(2) Add to Drinks\n-----------------------");
        int choice = sc.nextInt();
        if (choice == 1) {
            foodMenu.addMealToMenu();
        } else if (choice == 2) {
            foodMenu.addDrinkToMenu();
        } else {
            System.out.println("Wrong input!");
        }
    }

    private static void chooseFoodToRemove(FoodMenu foodMenu) {
        System.out.println("(1) Remove to Meals\n(2) Remove to Drinks\n-----------------------");
        int choice = sc.nextInt();
        if (choice == 1) {
            foodMenu.removeMealFromMenu();
        } else if (choice == 2) {
            foodMenu.removeDrinkFromMenu();
        } else {
            System.out.println("Wrong input!");
        }
    }

    public static void runMenuChef() {
        Chef chef = new Chef();
        do {
            System.out.println("------- Chef MENU -------");
            System.out.println("1.DISPLAY order");
            System.out.println("2.UPDATE order status");
            System.out.println("3.Logout account");
            System.out.println("0.EXIT");
            System.out.println("----------------------------");
            System.out.println("Select: ");
            try {
                select = sc.nextInt();
                switch (select) {
                    case 0:
                        System.out.println("The program is ending!");
                        return;
                    case 1:
                        chef.displayOrders();
                        break;
                    case 2:
                        chef.updateOrderStatus();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Please enter again your choice(0 to 3)!");
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not numbers type!!!" + "\n ____________");
                break;
            }
        } while (select != 0);
    }
}

