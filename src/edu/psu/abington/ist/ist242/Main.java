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

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double subTotal;
        double orderTotal = 0;

        // Main object
        Main main = new Main();
        // Customer obj
        Customer cust = new Customer();
        // Order obj
        Order or = new Order();
        // Inventory object
        Inventory inv = new Inventory();
        // Transaction object
        Transaction trans = new Transaction();

        // ARRAYLISTS -------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Inventory> invList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        // INVENTORY LIST ---------------------------------------------------------------------------------------------------------------------------------------------
        Inventory inv1 = new Inventory(101, "1TU57UU", "2020", "Honda", "Civic", 26899.99);
        inv1.setCarID(inv.iCount++);
        invList.add(inv1);

        Inventory inv2 = new Inventory(102, "15TNHH6", "2021", "Ford", "Explorer", 46799.99);
        inv1.setCarID(inv.iCount++);
        invList.add(inv2);

        Inventory inv3 = new Inventory(103, "1R4TEEG", "2021", "Jeep", "Grand Cherokee", 39899.99);
        inv1.setCarID(inv.iCount++);
        invList.add(inv3);

        Inventory inv4 = new Inventory(104, "14TTD99", "2021", "Land Rover", "Range Rover Sport", 89899.99);
        inv1.setCarID(inv.iCount++);
        invList.add(inv4);

        // SALESPERSON LIST ----------------------------------------------------------------------
        salesPerson sales1 = new salesPerson(1, "Mark Smith");
        sales1.setUserType(userType.SalesPerson);

        salesPerson sales2 = new salesPerson(2, "Jennifer Green");
        sales2.setUserType(userType.SalesPerson);

        // CUSTOMERS LIST --------------------------------------------------------------------------
        Customer cust1 = new Customer(1, "Barbara Schwarz", "(610) 541-8547", "1234 Main Street, Philadelphia, PA 19234");
        cust1.setCustomerId(cust.cCount++);
        cust1.setUserType(userType.Customer);
        cList.add(cust1);

        Customer cust2 = new Customer(2, "Robert Black", "(215) 854-8542", "2366 Blackhorse Circle, Philadelphia, PA 19345" );
        cust2.setCustomerId(cust.cCount++);
        cust2.setUserType(userType.Customer);
        cList.add(cust2);


        System.out.println("---------------------------------------------------------");
        System.out.println("                   Car Dealership                        ");
        System.out.println("                        by:                              ");
        System.out.println("                      Team 4                             ");
        System.out.println("---------------------------------------------------------");

        final char CUST_CODE = '1'; //customer page
        final char PRINT_CUST = '2'; //print cust
        final char INV_CODE = '3'; //inventory page
        //final char SALES_CODE = '4'; //sales person
        final char ORDER_CODE = '4'; //order page
        final char TRANS_CODE = '5'; //transaction page
        final char HELP_CODE = '?';
        final char EXIT_CODE = 'E';
        char userAction;


        final String PROMPT_ACTION = "\nMAIN MENU: \n1 - Add Customer\n2 - Print Customers\n3 - Inventory Page\n4 - Sell Car\n5 - Transaction Page\nE - Exit\nPlease make a selection: ";

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE: // Customers page
                    cList.add(cust.addCustomer());
                    System.out.println(" ");
                    break;
                case PRINT_CUST:
                    System.out.printf("%-12s | %-20s | %-20s | %-20s\n", "ID", "Name", "Phone Number", "Address");
                    Customer.printCustomer(cList);
                    break;
                case INV_CODE: //Inventory Page
                    Scanner input2 = new Scanner(System.in);
                    String answer = "";
                    System.out.print("Please make a selection: \n[A]dd Inventory \n[B]rowse Inventory \n[D]elete from Inventory: \n");
                    answer = input2.nextLine().toUpperCase() + " ";
                    char firstChar = answer.charAt(0);
                    switch(firstChar){
                        case 'A':
                            invList.add(inv.addInventory());
                            break;
                        case 'B':
                            System.out.println("---------------------------------------------");
                            System.out.println("           Currently in Inventory            ");
                            System.out.println("---------------------------------------------");
                            System.out.printf("%-12s |%-12s | %-12s | %-12s | %-20s | %-12s\n", "ID", "VIN", "YEAR", "MAKE", "MODEL", "PRICE");
                            Inventory.listMenu(invList);
                            break;
                        case 'D':
                            Inventory.removeCar(invList);
                            break;
                    }
                    break;
                case ORDER_CODE: //Order Page
                    String userInput = "[Y]es to sell a car \n[N]o to go back to the main menu\nPlease make a selection: ";
                    userAction = getAction(userInput);
                    while (userAction != 'N') {

                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("                            ORDER - INVENTORY                            ");
                        System.out.println("-------------------------------------------------------------------------");
                        Scanner input = new Scanner(System.in);
                        Inventory.listMenu(invList);
                        System.out.println(" ");
                        System.out.println("Enter Car ID: ");
                        int menuId = input.nextInt();

                        oList.add(or.order());

                        switch (menuId) {
                            case 101:
                                subTotal = or.getSubTotal(inv1.getPrice("1")); //subTotal = or.getSubTotal(inv1.getPrice(1), qty);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv1.getPrice("1"), inv1.getMake(), inv1.getModel()); //or.printOrder(subTotal, inv1.getPrice(1), /*qty*/, inv1.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 102:
                                subTotal = or.getSubTotal(inv2.getPrice("2")); //subTotal = or.getSubTotal(inv2.getPrice(2), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv2.getPrice("2"), inv2.getMake(), inv2.getModel()); //or.printOrder(subTotal, inv2.getPrice(2), /*qty*/, inv2.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 103:
                                subTotal = or.getSubTotal(inv3.getPrice("3")); //subTotal = or.getSubTotal(inv3.getPrice(3), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv3.getPrice("3"), inv3.getMake(), inv3.getModel()); //or.printOrder(subTotal, inv3.getPrice(3), /*qty*/, inv3.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 104:
                                subTotal = or.getSubTotal(inv4.getPrice("4")); //subTotal = or.getSubTotal(inv4.getPrice(4), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv4.getPrice("4"), inv4.getMake(), inv4.getModel()); //or.printOrder(subTotal, inv4.getPrice(4), /*qty*/, inv4.getMake());
                                userAction = getAction(userInput);
                                break;
                        }
                    }
                    break;
                case TRANS_CODE: //Transaction Page
                    Transaction transaction = new Transaction();
                    System.out.println("Your order total is: $ " + orderTotal);
                    transaction.sellCar();
                    break;
                case HELP_CODE: //
                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
    }

    // METHOD TO GET USER CHOICE FOR MENU --------------------------------------------------------------------
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }
}