package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.Scanner;

import static Management.ObjectFileManagement.readObjectFromFile;
import static Management.ObjectFileManagement.writeObjectToFile;

public class UserManagement {
    private static final Scanner scan = new Scanner(System.in);
    private static String activeUser = null;
    private final ArrayList<Employee> users;
    private String employeeName;
    private String userName;
    private String password;

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
        loginUser(list);
    }

    public static void loginUser(ArrayList<Employee> employees) {
        UserManagement u = new UserManagement();

        System.out.println("Enter username: ");
        String tempUserName = scan.nextLine();
        System.out.println("Enter password: ");
        String tempPswd = scan.nextLine();
        if (tempUserName.equals("Manager") && tempPswd.equals("manager123")) {
            u.registerNewUser(employees);
            return;
        } else {
            for (var ob : employees) {
                String[] temp = ob.getUserName().split("=");
                if (temp[temp.length - 1].equals(tempUserName) && ob.getPassword().equals(tempPswd)) {
                    System.out.println(ob.getUserName() + " account was successfully " +
                            "authenticated!");
                    setActiveUser(ob.getClass().getName().toLowerCase());
                    return;
                }
            }
        }
        System.out.println("Wrong inputs!");
    }

    public static boolean checkPosition() {
        if (getActiveUser().equals("staff.chef")) {
            return false;
        } else{
            return true;
        }

    }

    public static String getActiveUser() {
        return activeUser;
    }

    //Main method for tests
    private static void setActiveUser(String activeUser) {
        UserManagement.activeUser = activeUser;
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

    private void registerNewUser(ArrayList<Employee> employees) {
        System.out.println("Enter employee name: ");
        this.employeeName = scan.nextLine();
        System.out.println("Enter Username: ");
        this.userName = scan.nextLine();
        System.out.println("Enter password: ");
        this.password = scan.nextLine();
        System.out.println("Enter user position /Chef or Waiter/: ");
        String worker = scan.nextLine();
        Employee user1 = pickupEmployee(employeeName, userName, password, worker);

        if (employees.isEmpty()) {
            employees.add(user1);
        } else {
            for (Employee emp : employees) {
                if (emp.getUserName().equals(user1.getUserName())) {
                    System.out.println("User is already created!");
                    return;
                }
            }
            employees.add(user1);
            System.out.println(userName + " is created!");
            writeObjectToFile(employees, "users.csv");
        }
    }
}






