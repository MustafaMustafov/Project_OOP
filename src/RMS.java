import Management.ObjectFileManagement;
import Management.UserManagement;
import Staff.Employee;

import java.util.ArrayList;

public class RMS {
    static int select;
    static ArrayList<Employee> staff = ObjectFileManagement.readObjectFromFile("users.csv");


    public static void main(String[] args) {
            System.out.println("Welcome to RMS!");

            do {
                UserManagement.loginUser(staff);


            } while (select != 0);
        }
    }

