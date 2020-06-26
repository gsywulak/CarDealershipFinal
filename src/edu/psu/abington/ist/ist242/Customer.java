/*
Project: Lab 9
Purpose Details: Car dealership
Course: IST 242
Author:
Date Developed:
Last Date Changed:
Rev:
 */

package edu.psu.abington.ist.ist242;

import java.util.*;

public class Customer extends User{

    //Class Level Variables - Protect the data
    private int customerId;
    protected String custName, custPhone, custAddress;
    int cCount = 1;

    ArrayList<Customer> cList;

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
    public String getCustomerName(String _custName) {
        this.custName = _custName; return custName;
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
        return  custAddress;
    }
    public void setCustAddress(String _customerAddress) {
        this.custAddress = _customerAddress;
    }


    // ADD A NEW CUSTOMER METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer addCustomer() {
        cList = new ArrayList<Customer>();
        Customer cust = new Customer(cCount, custName, custPhone, custAddress);
        Scanner scnr = new Scanner(System.in);

        cust.setCustomerId(cCount++);

        System.out.println("Please enter customer name: ");
        custName = (Exception.testAlpha(Exception.getInput()));
        cust.setCustomerName(custName);


        System.out.println("Please enter customer Address: ");
        cust.setCustAddress(scnr.nextLine());

        System.out.println("Please enter customer phone number, please use this format (012) 345-6789: ");
        custPhone = (Exception.testPhone(Exception.getInput()));
        cust.setCustomerPhone(custPhone);

        cList.add(cust);
        return cust;
    }

    // PRINT CUSTOMERS METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public Boolean printCustomer(ArrayList<Customer>cList){
        try {
            for (Customer cust : cList) {
                System.out.printf("%-12s | %-20s | %-20s | %-20s\n", cust.getCustomerId(), cust.getCustomerName(), cust.getCustomerPhone(), cust.getCustAddress());
            }
        }
        catch (
                java.lang.Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer(int _cCount, String _custName, String _custPhone, String _custAddress) {
        this.cCount = _cCount;
        this.custName = _custName;
        this.custPhone = _custPhone;
        this.custAddress = _custAddress;

    }

    // EMPTY CUSTOMER CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer() {
    }


    public void setCustomer(int _customerId, String name, String phoneNumber, String custAddress) {
        this.customerId = _customerId;
        this.custName  = name;
        this.custPhone = phoneNumber;
        this.custAddress = custAddress;
    }

    public static void listCust(ArrayList<Customer> cList) { //TODO: listCust
        for (Customer customer : cList) {
            System.out.println(customer.getCustomerName());
        }
    }
}
