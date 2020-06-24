/*
Project: Car Design
Purpose Details: Car Dealership Application
Course: IST 242
Team 4
Developed: June 14, 2020
Last date Changed: June 21, 2020
Rev: 1
*/
package edu.psu.abington.ist.ist242;
import java.util.*;
public class Customer {
    //Class Level Variables - Protect the data
    private int customerId;
    protected String custName, custPhone, custAddress;
    int cCount = 0;

    // ADD A NEW CUSTOMER METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer addCustomer() {
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Address: ");
        cust.setCustAddress(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhone(scnr.nextLine());
        cust.setCustomerId(cCount);
        return cust;
    }
    // PRINT CUSTOMERS METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public static void printCustomer(ArrayList<Customer> cList){
        for (Customer cust: cList){
            System.out.printf("%-10s | %-12s | %-10s\n", cust.getCustomerId(), cust.getCustomerName(), cust.getCustomerPhone());
        }
    }
    // CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer(int _customerId) {
        this.customerId = _customerId;
    }
    // EMPTY CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer() {
    }

    public void setCustomer(int _customerId, String name, String phoneNumber) {
        this.customerId = _customerId;
        this.custName  = name;
        this.custPhone = phoneNumber;
    }
    public static void listCust(ArrayList<Customer> cList) {
        for (Customer customer : cList) {
            System.out.println(customer.getCustomerName());
        }
    }

    // SETTERS AND GETTERS --------------------------------------------------------------------------------------------------------------------------------------------------
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int _customerId) {this.customerId = _customerId;}
    public String getCustomerName() { return custName; }
    public String getCustomerName(int _id) { this.customerId = _id; return custName; }
    public void setCustomerName(String _customerName) {this.custName = _customerName;}
    public String getCustomerPhone() { return custPhone; }
    public void setCustomerPhone(String _customerPhone) {this.custPhone = _customerPhone;}
    public String getCustAddress() {return  custAddress; }
    public void setCustAddress(String _customerAddress) {this.custAddress = _customerAddress;}
    public int getCust() {
        System.out.println("Enter Customer ID: ");
        Scanner scnr = new Scanner(System.in);
        int input = scnr.nextInt();
        return input;
    }

    /*public void printCustomers() {
        getCustomerId();
        getCustomerName();
        getCustAddress();
        getCustomerPhone();
    }*/
}