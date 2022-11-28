package Staff;

import Restaurant.Order;

import java.util.ArrayList;

public interface Settable {
    void setStatus(ArrayList<Order> orderList, int choice, String setStatusTo);
}
