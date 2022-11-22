import Management.ObjectFileManagement;
import Restaurant.Food;
import Restaurant.Order;
import Restaurant.Status;
import Restaurant.Table;
import Staff.Waiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {
	@Test
	public void testReadListOfOrdersFromFile() {
		Waiter testWaiter = new Waiter("Ivan", "ivan", "1234");
		testWaiter.setOrders(ObjectFileManagement.readObjectFromFile("DraganOrderList.csv"));
		int expectedValue = 2;
		int actualValue = testWaiter.getOrders().size();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testTableNumberOneIsExistInTheList(){
		Table testTable = new Table(1,true);
		Waiter testWaiter = new Waiter();
		ArrayList<Order> testOrdersList = new ArrayList<>();
		testOrdersList.add(new Order(testTable,new ArrayList<>(), Status.ACTIVE));
		testWaiter.setOrders(testOrdersList);
		boolean expectedAnswer = testWaiter.checkTableStatus(1);
		assertFalse(expectedAnswer);
	}
	@Test
	public void testTableListShouldBeEmpty(){
		Waiter testWaiter = new Waiter();
		boolean expectedAnswer = testWaiter.checkTableStatus(1);
		assertTrue(expectedAnswer);
	}
	
	@Test
	public void testIfGetPriceIsWorking (){
		Waiter testWaiter = new Waiter();
//		Food testFood = new Food("testFood",5);
		ArrayList<Food> testFoodList = new ArrayList<>();
//		testFoodList.add(testFood);
		Order testOrder = new Order(new Table(1,true),testFoodList,Status.ACTIVE);
		double expectedValue = 2.9;
		double actualValue = testWaiter.totalAmount(1,testOrder,0);
		assertEquals(expectedValue,actualValue);
		
	}
	
}