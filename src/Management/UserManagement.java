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
    private static String activeUser;
    private final ArrayList<Employee> users;
    private String userName;
    private String password;

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
        UserManagement u = new UserManagement();
        System.out.println("Enter username: ");
        String tempUserName = scan.nextLine();
        System.out.println("Enter password: ");
        String tempPassword = scan.nextLine();

        if (tempUserName.equals("Manager") && tempPassword.equals("manager123")) {
            u.registerNewUser(employees);
            return;
        } else {
            for (var obj : employees) {
                String[] temp = obj.getUserName().split("=");
                if (temp[temp.length - 1].equals(tempUserName) && obj.getPassword().equals(tempPassword)) {
                    System.out.println(obj.getUserName() + " account was successfully " +
                            "authenticated!");
                    setActiveUser(obj.getClass().getName().toLowerCase());
                    return;
                }
            }
        }
        System.out.println("Wrong inputs!");
    }

    public static boolean getUserProfession() {
        if(getActiveUser().equals("staff.chef")){
            return false;
        }else{
            return true;
        }
    }

    public static String getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(String activeUser) {
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
        String employeeName = scan.nextLine();
        System.out.println("Enter Username: ");
        this.userName = scan.nextLine();
        System.out.println("Enter password: ");
        this.password = scan.nextLine();
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






