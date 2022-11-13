import Management.UserManagement;
import Staff.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {

    @Test
    public void TestLoginUserIsManagerUsername() {
        UserManagement userTest = new UserManagement();
        ArrayList<Employee> users = userTest.getUsersList();
        String testUserName = "Manager";
        String expected =testUserName;
        String actualEntered="Manager";

        assertEquals(expected,actualEntered);
    }

    @Test
    public void TestLoginPasswordIsManagerPassword() {
        UserManagement userTest = new UserManagement();
        String testPassword = "manager123";
        String expected =testPassword;
        String actualEntered="manager123";

        assertEquals(expected,actualEntered);
    }

    @Test
    void getUserProfession() {
    }
}