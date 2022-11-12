package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Management.ObjectFileManagement.readObjectFromFile;
import static Management.ObjectFileManagement.writeObjectToFile;

public class UserManagement {
    private static Scanner scan = new Scanner(System.in);
    private String employeeName;
    private String userName;
    private String password;
    private List<Employee> users;


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

        writeObjectToFile(Collections.singletonList(u.getUsersList()), "users.csv");
        List<Object> temp = readObjectFromFile("users.csv");
        ArrayList<Employee> list = null;
        for (Object obj : temp) {
            System.out.println(obj);
            list = (ArrayList<Employee>) u.getUsersList();
        }
        loginUser(list);


    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Employee> getUsersList() {
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
                    //TODO: load next menu...
                    return;
                }
            }
        }
        System.out.println("Wrong inputs!");
    }
    public static boolean checkPosition(){
        return false;
    }
}






