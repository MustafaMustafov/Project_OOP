package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.Scanner;

import static Management.ObjectFileManagement.readObjectFromFile;
import static Management.ObjectFileManagement.writeObjectToFile;

public class UserManagement {
    private static Scanner sc = new Scanner(System.in);
    private String employeeName;
    private String userName;
    private String password;
    private ArrayList<Employee> users;


    public UserManagement() {
        users = new ArrayList<>();
    }

    private static Employee pickupEmployee(String employeeName, String userName, String pswd, String worker) {
        Employee staff = new Employee();
        if (worker.equalsIgnoreCase("chef")) {
            staff = new Chef(employeeName, userName, pswd);
        } else if (worker.equalsIgnoreCase("waiter")) {
            staff = new Waiter(employeeName, userName, pswd);
        } else {
            System.out.println("Wrong input!");
        }
        return staff;
    }

    //Main method for tests
    public static void main(String[] args) {
//        registerNewUser();
        UserManagement u = new UserManagement();
        Waiter w1 = new Waiter("Dragan", "d2", "123");
        Chef c1 = new Chef("Cewe", "c32", "123");
        u.getUsersList().add(w1);
        u.getUsersList().add(c1);
//        u.registerNewUser();

        writeObjectToFile((u.getUsersList()), "users.csv");
        ArrayList<Employee> list = readObjectFromFile("users.csv");
        for (Employee obj : list) {
            System.out.println(obj);
            list = u.getUsersList();
        }
        u.loginUser(list);


    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Employee> getUsersList() {
        return users;
    }

    public void registerNewUser() {

        System.out.println("Enter employee name: ");
        this.employeeName = sc.nextLine();
        System.out.println("Enter Username: ");
        this.userName = sc.nextLine();
        System.out.println("Enter password: ");
        this.password = sc.nextLine();
        System.out.println("Enter user position /Chef or Waiter/: ");
        String worker = sc.nextLine();
        Employee user1 = pickupEmployee(employeeName, userName, password, worker);
        if (getUsersList().isEmpty()) {
            getUsersList().add(user1);
        } else {
            for (Employee emp : getUsersList()) {
                if (emp.equals(user1)) {
                    System.out.println("User is already created!");
                    break;
                } else {
                    getUsersList().add(user1);
                    System.out.println(userName + " is created!");
                    break;
                }
            }
        }
    }

    public void loginUser(ArrayList<Employee> objects) {

        System.out.println("Enter username: ");
        String tempUserName = sc.nextLine();
        System.out.println("Enter password: ");
        String tempPswd = sc.nextLine();
        if (tempUserName.equals("Manager") && tempPswd.equals("manager123")) {
            registerNewUser();
        } else {
            for (var ob : objects) {
                String[] temp = ob.getUserName().split("=");
                if (temp[temp.length - 1].equals(tempUserName) && ob.getPassword().equals(tempPswd)) {
                    System.out.println(ob.getUserName() + " account was successfully " +
                            "authenticated!");
                    //TODO: load next menu...
                    return;
                }
            }
        }
        System.out.println("Wrong inputs!");
    }
}






