/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author:
Date Developed:
Last Date Changed:
Rev:
 */

package edu.psu.abington.ist.ist242;

import java.util.*;

public class Inventory {


    //Class Level Variables - Protect the data
    int iCount = 101;
    ArrayList<Inventory> invList;

    public int carID;
    public String vin;
    public double price;
    public String year;
    public String make;
    public String model;



    //Constructor Method
    public Inventory(int _iCount, String _vin, String _year, String _make, String _model, double _price) {
        this.iCount = _iCount;
        this.vin = _vin;
        this.make = _make;
        this.year = _year;
        this.model = _model;
        this.price = _price;
    }

    public Inventory() {

    }


    // SETTERS AND GETTERS --------------------------------------------------------------------------------------------------------------------------------------------------------------
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


    public ArrayList getInvList() {
        return invList;
    }

    public void setInvList(ArrayList invList) {
        this.invList = invList;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice(String _vin) {
        this.vin = _vin;
        return price;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //add method to change menuItem price depending on the size
    public static void listMenu(ArrayList<Inventory> invList) {
        for (Inventory invItem : invList) {
            System.out.println(invItem);


        }
    }


    public Inventory addInventory() {
        invList = new ArrayList<Inventory>();
        Inventory invt = new Inventory(iCount, vin, year, make, model, price);
        Scanner input = new Scanner(System.in);

        invt.setCarID(iCount++);

        System.out.print("Please Enter a Vin Number: ");
        vin = (Exception.testAlphaNumeric(Exception.getInput()));
        invt.setVin(vin);

        System.out.print("Please Enter the year of Car: ");
        invt.setYear(input.nextLine());

        System.out.print("Please Enter the Make of Car: ");
        make = (Exception.testAlpha(Exception.getInput()));
        invt.setMake(make);

        System.out.print("Please Enter the Model of Car: ");
        model = (Exception.testAlpha(Exception.getInput()));
        invt.setModel(model);

        System.out.print("Please Enter the price of Car: ");
        invt.setPrice(input.nextDouble());

        invList.add(invt);
        return invt;
    }


    public static void removeCar(ArrayList<Inventory> invList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a Vin number to delete the Car: ");
        String vin = input.nextLine();

        for (Inventory inv : invList) {
            if (vin == inv.getVin()) {
                invList.remove(vin);
                break;
            }
            invList.remove(vin);
            break;
        }
    }

    /*public Inventory removeCar(String vin) {

        //Remove Search string by vehicleId set Color
        System.out.println("Enter VIN to remove: ");
        getVin();
        vin = Exception.testAlphaNumeric(Exception.getInput());
        setVin(vin);
        try{
            for (Inventory v : invList) {
                if (v.vin.equals(vin)) {
                    invList.remove(v);
                    break;
                }
            }
        }catch (java.lang.Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return vin;
    }*/

    @Override
    public String toString() {
        return String.format("%-12s |%-12s | %-12s | %-12s | %-20s | %-12s", iCount, vin, year, make, model, "$" + price);
    }
}
