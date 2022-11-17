package Management;

import Staff.Chef;
import Staff.Employee;
import Staff.Waiter;

import java.util.ArrayList;

import static Management.ObjectFileManagement.readObjectFromFile;
import static Management.ObjectFileManagement.writeObjectToFile;

public class UserCreation {
    public static void main(String[] args) {
        UserManagement u = new UserManagement();
        Waiter w1 = new Waiter("Dragan", "w1", "1234");
        Chef c1 = new Chef("Tonkin", "c1", "1234");

        u.getUsersList().add(w1);
        u.getUsersList().add(c1);


        writeObjectToFile((u.getUsersList()), "users.csv");
        ArrayList<Employee> list = readObjectFromFile("users.csv");
        for (Employee obj : list) {
            System.out.println(obj);
            list = u.getUsersList();
        }
    }
}
