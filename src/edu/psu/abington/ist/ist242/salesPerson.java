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



public class salesPerson extends User{

    public int userId;
    public String userName;


    public salesPerson(int _userId, String _userName) {
        this.userId = _userId;
        this.userName = _userName;

    }
}