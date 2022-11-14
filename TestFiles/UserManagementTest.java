import Management.UserManagement;
import Staff.Chef;
import Staff.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {

    @Test
    public void TestIsChefisActiveUser() {
        UserManagement.setActiveUser("staff.chef");
        boolean expectedProfession = false;
        String actualProfession = UserManagement.getActiveUser();
        assertFalse(expectedProfession, actualProfession);
    }

    @Test
    public void TestIfChefIsGetProfession() {
        UserManagement.setActiveUser("staff.chef");
        boolean actualProfession = UserManagement.getUserProfession();
        assertFalse(actualProfession);
    }

    @Test
    public void TestIsWaiterProfessionActive() {
        UserManagement.setActiveUser("staff.waiter");
        boolean actualProfession = UserManagement.getUserProfession();
        assertTrue(actualProfession);
    }

    @Test
    public void TestIfPickupEmployeeIsChef() {
        String expectedChefEmployee = "Staff.Chef";
        String actualEmployee = UserManagement.pickupEmployee("Ivan", "ivan", "1234", "chef").getClass().getName();
        assertEquals(expectedChefEmployee, actualEmployee);
    }

    @Test
    public void TestIfPickupEmployeeIsWaiter() {
        String expectedChefEmployee = "Staff.Waiter";
        String actualEmployee = UserManagement.pickupEmployee("Ivan", "ivan", "1234", "waiter").getClass().getName();
        assertEquals(expectedChefEmployee, actualEmployee);
    }

    @Test
    public void TestIfPickupEmployeeIsNotChef() {
        String expectedChefEmployee = "Staff.Chef";
        String actualEmployee = UserManagement.pickupEmployee("Ivan", "ivan", "1234", "unknown").getClass().getName();
        assertNotEquals(expectedChefEmployee, actualEmployee);
    }

    @Test
    public void CheckUserExists() throws Exception {
        UserManagement testManager = new UserManagement();
        Chef testChef = new Chef("Test","test","test123");
        ArrayList<Employee> testUsers = new ArrayList<>();
        testUsers.add(testChef);
        String testUserName = "test";
        String testUserPassword = "test123";

        assertTrue(UserManagement.checkUserExists(testUsers,testManager,testUserName,testUserPassword));
    }

    @Test
    public void CheckUserDoesNotExists() throws Exception {
        UserManagement testManager = new UserManagement();
        Chef testChef = new Chef("Test","test","test123");
        ArrayList<Employee> testUsers = new ArrayList<>();
        testUsers.add(testChef);
        String testUserName = "test1";
        String testUserPassword = "test123";

        assertFalse(UserManagement.checkUserExists(testUsers,testManager,testUserName,testUserPassword));
    }


}