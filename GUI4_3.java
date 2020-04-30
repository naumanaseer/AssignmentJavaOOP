/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author nauma
 */
public class GUI4_3 extends JFrame implements ActionListener{
     
   private Technician t = null;
    private Customer c = null;
    private Container d;
    private ButtonGroup serviceHour;
    JComboBox customers = new JComboBox();
    private JComboBox typeofVehicle;
    private JComboBox time;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
   JComboBox technicians = new JComboBox();
    
    JLabel customersLabel = new JLabel("Customer: ");
    JLabel typeofVehicleLabel = new JLabel("Type of vehicle:");
    JLabel timecolLabel = new JLabel(":");
    JLabel Time = new JLabel ("Start Time:");
    JTextField timeText = new JTextField();
    JTextField time2 = new JTextField();
    JLabel bookdates = new JLabel("Date: ");
    JLabel serviceHourLabel = new JLabel("Service Type : ");
    JRadioButton oneHour = new JRadioButton(" 1 Hour");
    JRadioButton threeHour = new JRadioButton(" 3 Hours");
    JLabel assignTech = new JLabel ("Technician: ");
    JButton book = new JButton ("BOOK");
    
    private Integer times[] =
    {10,11,12,13,14,15,16,17,18};
    
    private String dates[]
            = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14","15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
    private String months[]
            ={ "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
    
    private String years[]
            ={"2015", "2016", "2017", "2018", 
            "2019","2020","2021","2022","2023","2024" }; 
    private String typeofVehicles[] =
    {"car","truck","lorry","motorcycle","van"};
    public GUI4_3(){
    createWindow();
    setLocationAndSize();
    addComponentsToFrame();
    }
    
    
public void createWindow(){
    setTitle("Booking");
    setBounds(60,60,500,600);
    d = getContentPane();
    d.setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    
}
public void setLocationAndSize(){
    customersLabel.setBounds(100,100,100,20);
    customers.setBounds(200,100,190,20);
    typeofVehicleLabel.setBounds(100, 150, 150, 20);
    typeofVehicle = new JComboBox(typeofVehicles);
    typeofVehicle.setBounds(200,150,150,20);
    Time.setBounds(100,200,100,20);
    time = new JComboBox(times);
    time.setBounds(200,200,70,20);
    timecolLabel.setBounds(300,200,10,10);
    time2.setBounds(320,200,70,20);
    time2.setText("00");
    time2.setEditable(false);
    bookdates.setBounds(100,250,100,20);
    date = new JComboBox(dates);
    date.setBounds(200,250,60,20);
    month = new JComboBox(months);
    month.setBounds(260,250,75,20);
    year = new JComboBox(years);
    year.setBounds(330,250,100,20);
    serviceHourLabel.setBounds(100,300,100,20);
    oneHour.setBounds(200,300,100,20);
    threeHour.setBounds(300,300,100,20);
    assignTech.setBounds(100,350,100,20);
    technicians.setBounds(200,350,190,20);
    book.setBounds(270,400,100,35); 
      
}
public void addComponentsToFrame(){
    d.add(customersLabel);
    d.add(typeofVehicleLabel);
    d.add(typeofVehicle);
    d.add(Time);
    d.add(time2);
    d.add(timecolLabel);
    d.add(time);
    d.add(bookdates);
    d.add(serviceHourLabel);
    d.add(customers);
    d.add(typeofVehicle);
    d.add(timeText);
    d.add(date);
    d.add(month);
    d.add(year);
    d.add(oneHour);
    d.add(threeHour);
    d.add(assignTech);
    d.add(technicians);
   
    book.addActionListener(this);
    serviceHour = new ButtonGroup();
    serviceHour.add(oneHour);
    oneHour.isSelected();
    serviceHour.add(threeHour);
    d.add(book);
    
    ArrayList<String> customerArray = new ArrayList<>();
    for(int i =0; i<AssignmentOOP.allCustomer.size();i++){
        customerArray.add(AssignmentOOP.allCustomer.get(i).getUserName());   
    }
    customers.removeAllItems();
    customerArray.forEach((s)->{
        customers.addItem(s);
        d.add(customers);
        
    });
    ArrayList<String> techArray = new ArrayList();
    for(int i = 0;i<AssignmentOOP.allTechnician.size();i++){
        techArray.add(AssignmentOOP.allTechnician.get(i).getUserName());
    }
       technicians.removeAllItems();
       techArray.forEach((t)->{
       technicians.addItem(t);
       d.add(technicians);
        
    });
    
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==book){
            
             
            
            
            int ID;
            if(AssignmentOOP.allAppointment.size()==0){
                ID = 10001; //if there arents any appointments, set the first ID as 10001
            } else{ //if theres more than 1 appointment
                int size = AssignmentOOP.allAppointment.size(); //check the size of appointments array list
                Appointment last = AssignmentOOP.allAppointment.get(size-1); //get the last appointment
                ID = last.getID()+1; //add one to the last appointment id to get a new appointment id
            }
            
            
            int bookingStartTime = (Integer)time.getSelectedItem();
            int duration =1;
            if(oneHour.isSelected()){
                duration = 1;
            }
            else if(threeHour.isSelected()){
                duration =3;
            }
            int bookingEndTime = bookingStartTime + duration;
            
            String theVehicle = (String)typeofVehicle.getSelectedItem();
            
            String theDate = (String)date.getSelectedItem()
                        +"/" + (String)month.getSelectedItem()
                        +"/" + (String)year.getSelectedItem();
            
            //get the customer object from the selected customer
            for(int i =0;i<AssignmentOOP.allCustomer.size();i++){
                        Customer a = AssignmentOOP.allCustomer.get(i);
                        if(customers.getSelectedItem().toString().equals(a.getUserName())){
                            
                            c = AssignmentOOP.allCustomer.get(i);
                            System.out.println(c.getUserName());
                            break;
                        }
            }
            
            
            
            //get the technician object from the selected technician
            for(int i =0;i<AssignmentOOP.allTechnician.size();i++){
                        Technician a = AssignmentOOP.allTechnician.get(i);
                        if(technicians.getSelectedItem().toString().equals(a.getUserName())){
                            
                            t = AssignmentOOP.allTechnician.get(i);
                            System.out.println(t.getUserName());
                            break;
                        }
            }
            boolean flag = false;
            
            boolean hasAnAppointmentSameDay = false; //initially the tech selected doesnt have an appointment the same day
            Appointment sameDayAppointment = null; //intially there arent any same day appointments
            ArrayList<Appointment> sameDayAppointments = new ArrayList(); //intially the arraylist for same day appointment is null
            
            for(int i=0; i<t.getMyAppointment().size(); i++){ //goes through the all the appointments of selected technician
                if(t.getMyAppointment().get(i).getDate().equals(theDate)){ //is the selected technician has an appointment the same day as selected day
                    hasAnAppointmentSameDay = true; //decalres has same day appointments as true
                    sameDayAppointment = t.getMyAppointment().get(i); // gets the same day appointment
                    sameDayAppointments.add(sameDayAppointment); //adds the same day appointments into an array
                   
                }
            }
            
            for (Appointment element: sameDayAppointments) {
            System.out.println(element.getID());
            } //this is for my checking, if the arraylist for same Day appointment works
            
            boolean OverLap = false; //to check if there is any overlap of timing for the req booking time
            
            if(hasAnAppointmentSameDay){ //if has same day appointment
                for(int i = 0; i<sameDayAppointments.size(); i++){ //goes through the array of same days
                    if((((bookingStartTime >= sameDayAppointments.get(i).getStartTime())) && (bookingStartTime <= sameDayAppointments.get(i).getEndTime())) ||
                               ((bookingEndTime >= sameDayAppointments.get(i).getStartTime()) && (bookingEndTime <= sameDayAppointments.get(i).getEndTime())))
                    { //checked if the requested booking time overlaps currently booked appointments
                        OverLap = true; //if it does assign overlap as true
                     
                    }
                 
                }
                
            }
            
            else{ //if the tech doesnt have any appointments that date no need to check for overlap
                AssignmentOOP.assignedTech = t;
                flag = true;
                
            }
            
            if(OverLap){ //if there is an overlap show error msg
                JOptionPane.showMessageDialog(this, t.getFullName()+" has an appointment booked for this time. \n Change the time or date ");
            }
            if (!OverLap || flag){
                
                     AssignmentOOP.assignedTech = t; //if there is no overlap or is there is no appointments for the selected date, the selected technician is assigned
                     
            }
                
         
            if(!OverLap || flag){  //if there is no overlap or is there is no appointments for the selected date, proceed with the booking
                Appointment a = new Appointment(ID,c,AssignmentOOP.assignedTech,theDate,bookingStartTime,bookingEndTime,theVehicle);
                AssignmentOOP.allAppointment.add(a);
                c.addAppointment(a);
                AssignmentOOP.assignedTech.addAppointment(a);
                
                JOptionPane.showMessageDialog(null,"New Appointment registration successful" +
                                            "\n For Customer, " + c.getUserName() + 
                                            "\n Appointment ID is: " + ID+
                                            "\n Appointment Date is: " + theDate + 
                                            "\n Appointment Start Time: " + bookingStartTime +":00"+
                                            "\n Appointment End Time: "     +bookingEndTime +":00"                                        ); 
                
                
            }
            
            
            
            
            
            try{
                
                PrintWriter q = new PrintWriter("appointment.txt");
                for(int i=0;i<AssignmentOOP.allAppointment.size();i++){
                    q.println(AssignmentOOP.allAppointment.get(i).getID());
                    q.println(AssignmentOOP.allAppointment.get(i).getOwner().getUserName());
                    q.println(AssignmentOOP.allAppointment.get(i).getTechassigned().getUserName());
                    q.println(AssignmentOOP.allAppointment.get(i).getDate());
                    q.println(AssignmentOOP.allAppointment.get(i).getStartTime());
                    q.println(AssignmentOOP.allAppointment.get(i).getEndTime());
                    q.println(AssignmentOOP.allAppointment.get(i).getVehicleType());
                    q.println();
                    
                    
                }
                q.close();
//                System.exit(0);
                

            } catch(FileNotFoundException ex){ JOptionPane.showMessageDialog(null, "file not found");}
            
                     
        }
        
                
                
            
    }
    
}
