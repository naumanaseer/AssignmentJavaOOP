/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import java.util.ArrayList;

/**
 *
 * @author nauma
 */
public class Customer  {
    
    private String userName;
    private int password;
    private String userType;
    private String fullName;
    private int ID;
    private String gender;
    private int phoneNumber;
    private String dob;
    private String address;
    private String email;
    private ArrayList<Appointment> myAppointment;

    public Customer(String userName, int password, String userType, String fullName, int ID, String gender, int phoneNumber,String dob , String address, String email) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.fullName = fullName;
        this.ID = ID;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        myAppointment = new ArrayList<Appointment>();
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getFullName() {
        return fullName;
    }

    public int getID() {
        return ID;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Appointment> getMyAppointment() {
        return myAppointment;
    }
    public void addAppointment(Appointment a){
        myAppointment.add(a);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMyAppointment(ArrayList<Appointment> myAppointment) {
        this.myAppointment = myAppointment;
    }

    
    
    
    
    
}
