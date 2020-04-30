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
public class Manager extends Employee{
    int hoursWorked;
    int pay;

    public Manager(String userName, int password, String userType, String fullName, int ID, 
            String gender,  int phoneNumber,String dob, String address, String email) {
        super(userName, password, userType, fullName, ID, gender, phoneNumber,dob, address, email);
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

    @Override
    public int weeklySalary() {
        
    
    if(this.hoursWorked>= 40){
            return pay*15;
        }
        else{
            return pay*12;
        }
    }
    
    
    

   

    
   
}
