import Management.ObjectFileManagement;
import Restaurant.Food;
import Restaurant.Order;
import Restaurant.Status;
import Restaurant.Table;
import Staff.Waiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WaiterTest {
    @Test
    public void testReadListOfOrdersFromFile() {
        Waiter testWaiter = new Waiter("Ivan", "ivan", "1234");
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        int expectedValue = 2;
        int actualValue = testWaiter.getOrders().size();
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void testTableNumberOneIsExistInTheList() {
        Table testTable = new Table(1, true);
        Waiter testWaiter = new Waiter();
        ArrayList<Order> testOrdersList = new ArrayList<>();
        testOrdersList.add(new Order(testTable, new ArrayList<>(), Status.ACTIVE));
        testWaiter.setOrders(testOrdersList);
        boolean expectedAnswer = testWaiter.checkTableStatus(1);
        assertFalse(expectedAnswer);
    }

    @Test
    public void testIfPriceIsTwoPointOne() {
        Waiter testWaiter = new Waiter();
        ArrayList<Food> testFoodList = new ArrayList<>();
        Order testOrder = new Order(new Table(1, true), testFoodList, Status.ACTIVE);
        double expectedValue = 2.1;
        double actualValue = testWaiter.totalAmount(1, testOrder, 0);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testIfDisplayOrdersMethodShowOnlyActiveOrders() {
        Waiter testWaiter = new Waiter();
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        testWaiter.displayOrders();
        assertTrue(testWaiter.isFlag());
    }

    @Test
    public void testTotalAmountValueIsFive() {
        Waiter testWaiter = new Waiter();
        double expectedValue = 5;
        double actualValue = testWaiter.totalAmount(1, new Order(), 2.9);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testReadOrdersIfCountIsTwo() {
        Waiter testWaiter = new Waiter();
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        testWaiter.readOrders();
        int expectedValue = 2;
        int actualValue = testWaiter.getOrders().size();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSetStatusIfStatusChangedToServed() {
        Waiter testWaiter = new Waiter();
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        testWaiter.setStatus(testWaiter.getOrders(), 0, "s");
        Status expectedValue = Status.SERVED;
        Status actualValue = (Status) testWaiter.getOrders().get(0).getStatus();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSetStatusIfStatusChangedToActive() {
        Waiter testWaiter = new Waiter();
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        testWaiter.setStatus(testWaiter.getOrders(), 0, "a");
        Status expectedValue = Status.ACTIVE;
        Status actualValue = (Status) testWaiter.getOrders().get(0).getStatus();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSetStatusIfStatusChangedToPaid() {
        Waiter testWaiter = new Waiter();
        testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("TestDraganOrderList.csv"));
        testWaiter.setStatus(testWaiter.getOrders(), 0, "p");
        int expectedValue = 1;
        int actualValue = testWaiter.getOrders().size();
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void testIfTotalOrderCostIsTen(){
        Waiter testWaiter = new Waiter();
        ArrayList<Food> testFoods = new ArrayList<>();
        testFoods.add(new Food("testDriinks",6.5));
        testFoods.add(new Food("testBread",3.5));
        Order testOrder = new Order(new Table(10,true),testFoods,Status.SERVED);
        double expectedValue = 10.0;
        double actualValue = testWaiter.getTotalOrderCost(testOrder);
        assertEquals(expectedValue,actualValue);
    }
}