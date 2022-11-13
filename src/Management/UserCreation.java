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
        Waiter w1 = new Waiter("Dragan", "waiter", "1234");
        Chef c1 = new Chef("Tonkin", "chef", "1234");
//        Employee m1 = new Employee("Manager","Manager","Manager123");
        u.getUsersList().add(w1);
        u.getUsersList().add(c1);
//        u.getUsersList().add(m1);

        writeObjectToFile((u.getUsersList()), "users.csv");
        ArrayList<Employee> list = readObjectFromFile("users.csv");
        for (Employee obj : list) {
            System.out.println(obj);
            list = u.getUsersList();
        }
    }
}
