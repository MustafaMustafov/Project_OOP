package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    private static Scanner sc = new Scanner(System.in);
    private String employeeName;
    private String userName;
    private String password;
    private List<Employee> users;


    public UserManagement() {
        users = new ArrayList<>();
    }

    private static Employee pickupEmployee(String employeeName, String userName, String pswd, String worker) {
        Employee staff = new Employee();
        if (worker.toLowerCase().equalsIgnoreCase("chef")) {
            staff = new Chef(employeeName, userName, pswd);
        } else if (worker.toLowerCase().equalsIgnoreCase("waiter")) {
             staff = new Waiter(employeeName, userName, pswd);
        } else {
            System.out.println("Wrong input!");
        }
        return staff;
    }

    public static void main(String[] args) {
//        registerNewUser();
        UserManagement u = new UserManagement();
        Waiter w1 = new Waiter("Dragan","d2","123");
       Chef c1 = new Chef("Cewe","c32","123");
        u.getUsers().add(w1);
        u.getUsers().add(c1);

        u.registerNewUser();
        u.login(u);


    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Employee> getUsers() {
        return users;
    }
    public void addUser(Employee user){
        users.add(user);
    }

    public void registerNewUser() {
//        UserManagement user = new UserManagement();

        System.out.println("Enter employee name: ");
        this.employeeName = sc.nextLine();
        System.out.println("Enter Username: ");
        this.userName = sc.nextLine();
        System.out.println("Enter password: ");
        this.password = sc.nextLine();
        System.out.println("Enter user position /Chef or Waiter/: ");
        String worker = sc.nextLine();
        Employee user1 = pickupEmployee(employeeName, userName, password, worker);
        if (getUsers().isEmpty()) {
            addUser(user1);
        } else {
            for (Employee emp : getUsers()) {
                if (emp.equals(user1)) {
                    System.out.println("User is already created!");
                    break;
                } else {
                    addUser(user1);
                    System.out.println(userName + " is created!");
                    break;
                }
            }
        }
    }

    public void login(UserManagement user) {


        System.out.println("Enter username: ");
        String tempUserName = sc.nextLine();
        System.out.println("Enter password: ");
        String tempPswd = sc.nextLine();

        for (int i = 0; i < getUsers().size(); i++) {
            if (getUsers().get(i).getUserName().equalsIgnoreCase(tempUserName)) {
                if (getUsers().get(i).getPassword().equals(tempPswd)) {
                    System.out.println(getUsers().get(i).getUserName() + " account was successfully authenticated!");
                    //TODO: load next menu...
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("There is no any user registered with that username! Do you want to create it? " +
                        "Yes/No");
                if (sc.nextLine().toLowerCase().equals("yes")) {
                    user.registerNewUser();
                } else {
                    System.out.println("You chose to exit!");
                    break;
                }
            }
        }

    }
}

