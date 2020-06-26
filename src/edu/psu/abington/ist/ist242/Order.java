package edu.psu.abington.ist.ist242;

import java.util.*;


public class Order {

    int cCount = 0;

    //Class Level Variables - Protect the data
    private Customer cust;
    private Inventory menu;
    private int orderId, menuID;
    private int custID, quantity;
    private double price;
    private double totalPrice;
    double subTotal;
    double orderTotal = 0;


    // CONSTRUCTOR METHOD -----------------------------------------------------------------------------------------------
    public Order() {
    }
    public Order order() {
        Order or = new Order(cCount++);
        return or;
    }
    public Order(int _orderId) {
        this.orderId = _orderId;
    }
    public Order(int _orderId, double _totalPrice) {
        this.orderId = _orderId;
        this.price = _totalPrice;
    }


    // GETTERS AND SETTERS ---------------------------------------------------------------------------------------------
    public int getOrder (){
        return orderId;
    }
    public int getorderId() {
        return orderId;
    }
    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }
    public int getID (int _menuID) {
        return menuID;
    }

    // METHODS -------------------------------------------------------------------------------------------------------

    // PRINT ORDER
    public void printOrder(double _subtotal, double _price, String make, String model) { //int _quantity, String menuItem) {
        System.out.println("You have selected: \n" + make + " " + model + " " + "\nList Price: " + "$" + _price +" \n"); //" * " +  _quantity + " = " + "$ " + _subtotal); //TODO: possibly delete some part of this line
    }

    // PRINT ORDER DETAILS
    public static void listOrder(ArrayList<Order> oList) {
        for (Order orderDetails : oList) {
            System.out.println(orderDetails.getOrder());
        }
    }

    // GET SUBTOTAL
    public double getSubTotal(double _price) { //double quantity) {
        double subTotal = _price; //* quantity;
        totalPrice += subTotal;
        return subTotal;
    }
}
