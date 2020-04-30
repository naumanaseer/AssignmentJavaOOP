/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

/**
 *
 * @author nauma
 */
public abstract class Employee {
    public String userName;
    protected int password;
    public String userType;
    protected String fullName;
    protected int ID;
    protected String gender;
    protected int phoneNumber;
    protected String dob;
    protected String address;
    protected String email;

    public Employee(String userName, int password, String userType, String fullName, int ID, String gender, int phoneNumber, String dob, String address, String email) {
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
    
    public abstract int weeklySalary();

    
    

    
}
