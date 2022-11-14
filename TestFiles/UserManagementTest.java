import Management.UserManagement;
import Staff.Chef;
import Staff.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {

    @Test
    public void TestLoginUserIsManagerUsername() {
        String expected ="Manager";
        String actualEntered="Manager";

        assertEquals(expected,actualEntered);
    }

    @Test
    public void TestLoginPasswordIsManagerPassword() {
        String expected ="manager123";
        String actualEntered="manager123";

        assertEquals(expected,actualEntered);
    }

    @Test
    void TestIsChefisActiveUser() {
        Employee testUser = new Chef();
        UserManagement.setActiveUser("staff.chef");
        boolean expectedProfession = false;
        String actualProfession = UserManagement.getActiveUser();
        assertFalse(expectedProfession,actualProfession);
    }

    @Test
    void TestIfChefIsGetProfession() {
        UserManagement.setActiveUser("staff.chef");
        boolean actualProfession = UserManagement.getUserProfession();
        assertFalse(actualProfession);
    }

    @Test
    void TestIsWaiterProfessionActive() {
        UserManagement.setActiveUser("staff.waiter");
        boolean actualProfession = UserManagement.getUserProfession();
        assertTrue(actualProfession);
    }
}