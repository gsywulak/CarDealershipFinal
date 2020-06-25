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

import java.text.DecimalFormat;
import java.util.*;

enum PaymentType {credit, cash, financing}

public class Transaction extends Order {

    ArrayList<Transaction> tList = new ArrayList<Transaction>();

    int sCount = 1;
    private PaymentType paymentType;
    private String transactionId;
    private double commission;
    private double subTotal;
    private double orderTotal;
    private double totalPrice;
    private double tax = 1.06;
    private String empSalesID;
    private String sfullName;





    // GETTERS & SETTERS ------------------------------------------------------------------------------
    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getEmpSalesID() {
        return empSalesID;
    }

    public void setEmpSalesID(String empSalesID) {
        this.empSalesID = empSalesID;
    }

    public String getSfullName() {
        return sfullName;
    }

    public void setSfullName(String sfullName) {
        this.sfullName = sfullName;
    }


    public Transaction sellCar(){
        Scanner scnr = new Scanner(System.in);
        User salesManager = new User(); // Sales Manager constructor
        Transaction tran = new Transaction(); //Sales transaction constructor
        Customer cust = new Customer(); //Customer constructor
        Order order = new Order();
        ArrayList<Order> oList = new ArrayList<Order>();
        Inventory car = new Inventory(); //Car constructor

        System.out.println("Enter transaction ID: ");
        transactionId = Exception.testAlphaNumeric(Exception.getInput());
        tran.setTransactionId(transactionId);

        System.out.println("Please enter employee ID: ");
        empSalesID = Exception.testAlphaNumeric(Exception.getInput());
        salesManager.setUserId(empSalesID);


        System.out.println("Please enter employee name: ");
        salesManager.getUserName();
        sfullName = Exception.testAlpha(Exception.getInput());
        salesManager.setUserType(userType.SalesPerson);
        salesManager.setUserName(sfullName);

        System.out.println("Enter the VIN of the Car: ");
        car.vin = Exception.testAlphaNumeric(Exception.getInput());
        car.setVin(car.vin);

        //TODO: change this into the Order selection
        System.out.println("Enter price as double: ");
        double subTotal = scnr.nextDouble();
        tran.setSubTotal(subTotal);

        // TO GET CUSTOMER NAME INPUT AND PRINT TO THE TRANSACTION RECORD
        System.out.println("Customer Name: ");
        cust.getCustomerName();
        cust.custName = Exception.testAlpha(Exception.getInput());
        cust.setCustomerName(cust.custName);

        tran.setPaymentType();

        tList.add(tran);


        System.out.println(" ");
        System.out.println("---- PSU Car Dealership ----");
        System.out.println("     1600 Woodland Road     ");
        System.out.println("     Abington, PA 19001     ");
        System.out.println("        215-555-1212        ");
        System.out.println("     -- SALE RECORD --      ");
        System.out.println(" ");
        System.out.println("Transaction ID: " + tran.getTransactionId());
        System.out.println("Sold To: " + cust.getCustomerName()); //TO GET CUSTOMER NAME INPUT AND PRINT TO THE TRANSACTION RECORD
        System.out.println("Employee ID #: " + salesManager.getUserId());
        System.out.println("Employee Name: " + salesManager.getUserName());
        System.out.println("Car VIN: " + car.getVin());
        System.out.println("Car Sticker Price: " + tran.getSubTotal());


        //System.out.println("Payment Type: " + this.paymentType);
        //System.out.println("Payment Type: " + PaymentType.cash); //TODO: need to change this to reflect user input from above

        System.out.println(" ");

        tran.setTotalPrice(calculateTransaction(tran.getSubTotal(), tax));
        System.out.println("Total price is w/ taxes: $" + getTotalPrice());
        System.out.println("Commission earned: $" + df2.format(tran.setSalesCommission(getTotalPrice())));
        System.out.println(" ");
        System.out.println("-- TRANSACTION RECORDED -- ");

        tList.add(tran);

        return tran;
    }

    public PaymentType setPaymentType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment type ( 'cash / 'credit' / 'financing' ): ");
        PaymentType _payment = PaymentType.valueOf(scanner.next().toLowerCase());
        return _payment;
    }


    public double setSalesCommission(double _value) {
        double comm = _value*0.15;
        return comm;
    }

    public void listTransactions(ArrayList<Transaction> sList) { //TODO: fix how to add transaction to the slist from the user input
        for (Transaction tran : sList) {
            System.out.println();
            System.out.println("Transaction ID: " + tran.getTransactionId());
            System.out.println("Subtotal: $" + df2.format(tran.getSubTotal()));
            System.out.println("Total price: $" + df2.format(tran.getTotalPrice()));
            System.out.println("Payment type: " + tran.getPaymentType());
            System.out.println("Commission from sale: $" + df2.format(tran.getCommission()));
        }
    }


    private static DecimalFormat df2 = new DecimalFormat("#.00");

    public double calculateTransaction(double transactionSubtotal, double tax) {
        totalPrice = transactionSubtotal * tax;
        totalPrice = Math.round(totalPrice*100.0)/100.0;
        return totalPrice;
    }
}
