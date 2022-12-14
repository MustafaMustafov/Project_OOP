package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.Scanner;

import static Management.ObjectFileManagement.writeObjectToFile;

public class UserManagement {
    private static final Scanner scan = new Scanner(System.in);
    private static String activeUser;
    private final ArrayList<Employee> users;
    private static String name = "";

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserManagement() {
        users = new ArrayList<>();
    }

    public static Employee pickupEmployee(String employeeName, String userName, String pswd, String worker) {
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

    public static void loginUser(ArrayList<Employee> employees) {
        UserManagement manager = new UserManagement();
        System.out.println("Enter username: ");
        String tempUserName = scan.nextLine();
        System.out.println("Enter password: ");
        String tempPassword = scan.nextLine();

        manager.checkUserExists(employees, manager, tempUserName, tempPassword);
//            System.out.println("Incorrect login data entered!");
    }

    public boolean checkUserExists(ArrayList<Employee> employees, UserManagement manager, String tempUserName,
                                          String tempPassword) {
            if (tempUserName.equals("Manager") && tempPassword.equals("manager123")) {  
                manager.registerNewUser(employees);
                return true;
            } else {
                for (var obj : employees) {
                    String[] temp = obj.getUserName().split("=");
                    if (temp[temp.length - 1].equals(tempUserName) && obj.getPassword().equals(tempPassword)) {
                        System.out.println(obj.getUserName() + " account was successfully " +
                                "authenticated!");
                        setActiveUser(obj.getClass().getName().toLowerCase());
                        setName(obj.getName());
                        return true;
                    }
                }
            }
        return false;
    }

    public static boolean getUserProfession() {
        if (getActiveUser().equals("staff.chef")) {
            return false;
        } else {
            return true;
        }
    }

    public static String getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(String activeUser) {
        UserManagement.activeUser = activeUser;
    }

    public ArrayList<Employee> getUsersList() {
        return users;
    }

    private void registerNewUser(ArrayList<Employee> employees) {
        System.out.println("Enter employee name: ");
        String employeeName = scan.nextLine();
        System.out.println("Enter Username: ");
        String userName = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        System.out.println("Enter user position /Chef or Waiter/: ");
        String worker = scan.nextLine();
        Employee newUser = pickupEmployee(employeeName, userName, password, worker);

        if (employees.isEmpty()) {
            employees.add(newUser);
        } else {
            for (Employee emp : employees) {
                if (emp.getUserName().equals(newUser.getUserName())) {
                    System.out.println("User is already created!");
                    return;
                }
            }
            employees.add(newUser);
            System.out.println(userName + " is created!");
            writeObjectToFile(employees, "users.csv");
            loginUser(employees);
        }
    }
}






