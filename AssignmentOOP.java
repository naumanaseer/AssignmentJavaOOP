/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nauma
 */
public class AssignmentOOP {

        public static Manager mlogin;
        public static Technician tlogin;
        public static Customer clogin;
        public static Technician assignedTech;
        public static String name;
        public static GUI1 page1;
        public static GUI3 page3;
        public static GUI4 page4;
        public static GUI4_1 page4_1;
        public static GUI4_2 page4_2;
        public static GUI4_3 page4_3;
        public static GUI5 page5;
        public static GUI5_1 page5_1;
        public static GUI6 page6;
        public static GUI6_1 page6_1;
        public static GUI6_2 page6_2;
        
      
        
        public static ArrayList<Manager> allManager;
        public static ArrayList<Technician> allTechnician;
        public static ArrayList<Customer> allCustomer;
        public static ArrayList<Appointment> allAppointment;
        
        
    public static void main(String[] args) {
        
                
            allManager = new ArrayList<Manager>(); // saves the customer input
            allTechnician = new ArrayList<Technician>();
            allCustomer = new ArrayList<Customer>();
            allAppointment = new ArrayList<Appointment>();
            
            addData("manager");
            addData("customer");
            addData("technician");
            try{
                Scanner s = new Scanner(new File("appointment.txt"));
                while(s.hasNext()){
                    int a = Integer.parseInt(s.nextLine()); //appointment id
                    String b = s.nextLine(); //customer username
                    String c = s.nextLine(); //tech assigned username
                    String d = s.nextLine(); //date of booking
                    int e = Integer.parseInt(s.nextLine()); //start time
                    int f = Integer.parseInt(s.nextLine()); //end time
                    String g = s.nextLine(); //type of vehicle
                    s.nextLine();
                
                    Customer owner = null;
                    Technician techassigned = null;
                
                    for(int i=0; i<allCustomer.size(); i++){
                        Customer x = allCustomer.get(i);
                        if(b.equals(x.getUserName())){
                            owner = x;
                            break;
                        }                    
                    }
                    for(int i=0; i<allTechnician.size(); i++){
                        Technician x = allTechnician.get(i);
                        if(c.equals(x.getUserName())){
                            techassigned = x;
                            break;
                        }                    
                    }
                
                    Appointment  appoint = new Appointment(a,owner,techassigned,d,e,f,g);
                    owner.getMyAppointment().add(appoint);
                    techassigned.getMyAppointment().add(appoint);
                    allAppointment.add(appoint);
                }
            } catch(Exception e){
                System.out.println("Unable to find file");
            }
            
                page3 = new GUI3(); //login
                page4 = new GUI4(); //manager home
                page4_1 = new GUI4_1();   //logged in manager can register users
                page4_2 = new GUI4_2(); // logged in manager view/edit/dlt users
                page4_3 = new GUI4_3(); // logged in manager makes appointments
                page5 = new GUI5(); //tech home
                page5_1 = new GUI5_1(); //logged in techs view him appointments
                page6 = new GUI6(); //customer home
                page6_1 = new GUI6_1(); //loggied in customer can make appointments
                page6_2 = new GUI6_2(); //loggied in customer can view appointments
            
            for(int i =0; i<allManager.size();i++){
                System.out.println(allManager.get(i).getUserName());
            }
            System.out.println("");
            
            for(int i =0; i<allTechnician.size();i++){
                System.out.println(allTechnician.get(i).getUserName());
            }
            System.out.println("");
            
            for(int i =0; i<allCustomer.size();i++){
                System.out.println(allCustomer.get(i).getUserName());
            }
            
            
            
            
   }
    
    
    
    public static void addData(String userType){
            try {
                String usertype = userType.toLowerCase();
                
                Scanner s = new Scanner(new File(usertype+".txt"));
                while(s.hasNext()){ //checks if the file has any token, returns true
                String a = s.nextLine(); //xis the user name
                int b = Integer.parseInt(s.nextLine()); //y is the password
                String c = s.nextLine(); //fullname
                String d = s.nextLine(); //usertype
                int f = Integer.parseInt(s.nextLine()); //id
                String g = s.nextLine(); //gender
                int h = Integer.parseInt(s.nextLine()); //phoneno
                String i = s.nextLine(); //dob
                String j = s.nextLine(); //address
                String k = s.nextLine(); //emailaddress
                s.nextLine();  //scans the next line
                
                switch(usertype){
                    case "manager":
                        Manager m = new Manager(a,b,c,d,f,g,h,i,j,k); //saves new Manager object
                        allManager.add(m); //adds manager to the arraylist
                        break;
                    case "technician":
                        Technician t = new Technician(a,b,c,d,f,g,h,i,j,k);
                        allTechnician.add(t);
                        break;
                    
                    case "customer":
                        Customer n = new Customer(a,b,c,d,f,g,h,i,j,k);
                        allCustomer.add(n);
                        break;
                        
                }
                    
                }       
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AssignmentOOP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "file not found");
            }
    }
    
}
