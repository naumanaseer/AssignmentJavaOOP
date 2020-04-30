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
public class Appointment {
    private int ID;
    private Customer owner;
    private Technician techassigned;
    private String date;
    private int startTime;
    private int endTime;
    private String vehicleType;
    private int charge=0;
    private boolean notPaid = false;

    public Appointment(int ID, Customer owner, Technician techassigned,  String date,  int startTime,
            int endTime, String vehcileType) {
        this.ID = ID;
        this.owner = owner;
        this.techassigned = techassigned;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.vehicleType = vehicleType;
        
        
        
    }
    
    public Appointment(int ID, Customer owner, Technician techassigned,  String date,  
            int startTime, int endTime)
    {
        this(ID,  owner,  techassigned,   date,   startTime, endTime,"motorcycle");
        
    }

    public int getID() {
        return ID;
    }

    

    public Customer getOwner() {
        return owner;
    }

    public Technician getTechassigned() {
        return techassigned;
    }

    public String getDate() {
        return date;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setCharge(int charge) {
        this.charge += charge;
    }

    public int getCharge() {
        
        return charge;
    }

    public boolean isNotPaid() {
        return notPaid;
    }

    

    public void setNotPaid(boolean notPaid) {
        this.notPaid = notPaid;
    }

    
       
    
    
}
