/*
Project: Car Dealership
Purpose Details: Car dealership
Course: IST 242
Author:
Date Developed:
Last Date Changed:
Rev:
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

        System.out.println("\nPlease Enter Customer Details below: ");
        System.out.print("Please Enter Customer Name: ");
        custName = (Exception.testAlpha(Exception.getInput()));
        cust.setCustomerName(custName);

        //cust.setCustomerName(scnr.nextLine());

        System.out.print("Please Enter Customer Address: ");
        cust.setCustAddress(scnr.nextLine());

        System.out.print("Please Enter Customer Phone number, please use this format (012) 345-6789: ");
        custPhone = (Exception.testPhone(Exception.getInput()));
        cust.setCustomerPhone(custPhone);


        //cust.setCustomerPhone(scnr.nextLine());
        cust.setCustomerId(cCount);

        return cust;
    }

    // PRINT CUSTOMERS METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public static void printCustomer(ArrayList<Customer> cList) {
        for (Customer cust : cList) {
            System.out.printf("%-15s | %-15s | %-15s | %-15s\n", cust.getCustomerId(), cust.getCustomerName(), cust.getCustomerPhone(), cust.getCustAddress());
        }
    }

    // CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer(int _customerId) {
        this.customerId = _customerId;
    }

    // EMPTY CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer() {
    }


    public void setCustomer(int _customerId, String name, String phoneNumber, String custAddress) {
        this.customerId = _customerId;
        this.custName = name;
        this.custPhone = phoneNumber;
        this.custAddress = custAddress;
    }

    public static void listCust(ArrayList<Customer> cList) { //TODO: listCust
        for (Customer customer : cList) {
            System.out.println(customer.getCustomerName());
        }
    }


    // SETTERS AND GETTERS --------------------------------------------------------------------------------------------------------------------------------------------------
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int _customerId) {
        this.customerId = _customerId;
    }

    public String getCustomerName() {
        return custName;
    }

    public String getCustomerName(int _id) {
        this.customerId = _id;
        return custName;
    }

    public void setCustomerName(String _customerName) {
        this.custName = _customerName;
    }

    public String getCustomerPhone() {
        return custPhone;
    }

    public void setCustomerPhone(String _customerPhone) {
        this.custPhone = _customerPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String _customerAddress) {
        this.custAddress = _customerAddress;
    }

    public int getCust() { //TODO: this line gets read after typing 'N' or 'E' for new or existing customer
        System.out.println("Enter Customer ID: ");
        Scanner scnr = new Scanner(System.in);
        int input = scnr.nextInt();
        return input;
    }


    
}
