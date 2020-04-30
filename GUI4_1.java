/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Java program to implement 
// a Simple GUI4_1 Form 
// using Java Swing 
  

package assignmentoop;

import static assignmentoop.AssignmentOOP.allTechnician;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class GUI4_1 extends JFrame  implements ActionListener{


   
    
    String username,password,sex,dateofbirth,address;

    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel userName; 
    private JTextField tuserName; 
    private JLabel pswd; 
    private JPasswordField tpswd;
    
    
    private JLabel userType;
    private JRadioButton rCustomer;
    private JRadioButton rManager;
    private JRadioButton rTechnician;
    private ButtonGroup guserType;
    
    private JLabel fullName; 
    private JTextField tfullName; 
    
    private JLabel id; 
    private JTextField tid; 
    
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female;
    private ButtonGroup gengp;
    
    private JLabel phoneNum; 
    private JTextField tphoneNum; 
    
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year;
  
     
    private JLabel add; 
    private JTextArea tadd; 
    
    private JLabel emailAdd; 
    private JTextArea temailAdd; 
    
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
    
  
    // constructor, to initialize the components 
    // with default values. 
    public GUI4_1() 
    { 
        setTitle("Registration Form"); 
        setBounds(600, 200, 750, 650); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        setLocationRelativeTo(null);
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(275, 30); 
        c.add(title); 
  
        userName = new JLabel("User Name"); 
        userName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userName.setSize(100, 40); 
        userName.setLocation(100, 100); 
        c.add(userName); 
        
        tuserName = new JTextField(); 
        tuserName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tuserName.setSize(190, 20); 
        tuserName.setLocation(200, 100); 
        c.add(tuserName); 
        
        pswd = new JLabel("Password"); 
        pswd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        pswd.setSize(100, 20); 
        pswd.setLocation(100, 150); 
        c.add(pswd); 
        
        tpswd = new JPasswordField(); 
        tpswd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpswd.setSize(190, 20); 
        tpswd.setLocation(200, 150); 
        c.add(tpswd);
        
        userType = new JLabel("User Type"); 
        userType.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userType.setSize(100, 20); 
        userType.setLocation(100, 200); 
        c.add(userType); 
        
        
        //create radio buttons with default labels
        
        rCustomer = new JRadioButton("Customer");
        rCustomer.setFont(new Font("Arial", Font.PLAIN, 15)); 
        rCustomer.setSelected(true); 
        rCustomer.setSize(100, 20); 
        rCustomer.setLocation(200, 200); 
        c.add(rCustomer);
       
        rManager  = new JRadioButton("Manager");
        rManager.setFont(new Font("Arial", Font.PLAIN, 15)); 
        rManager.setSelected(false); 
        rManager.setSize(100, 20); 
        rManager.setLocation(300, 200); 
        c.add(rManager);
        
        
        rTechnician = new JRadioButton("Tech");
        rTechnician.setFont(new Font("Arial", Font.PLAIN, 15)); 
        rTechnician.setSelected(false); 
        rTechnician.setSize(100, 20); 
        rTechnician.setLocation(200, 250); 
        c.add(rTechnician);
        
        // Creates a group that will contain radio buttons
        // You do this so that when 1 is selected the others
        // are deselected

        guserType = new ButtonGroup();
        guserType.add(rCustomer);
        guserType.add(rManager);
        guserType.add(rTechnician);
        
        fullName = new JLabel("Full Name"); 
        fullName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        fullName.setSize(100, 20); 
        fullName.setLocation(100, 300); 
        c.add(fullName); 
        
        tfullName = new JTextField(); 
        tfullName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tfullName.setSize(190, 20); 
        tfullName.setLocation(200, 300); 
        c.add(tfullName); 
        
        id = new JLabel("National ID"); 
        id.setFont(new Font("Arial", Font.PLAIN, 15)); 
        id.setSize(100, 20); 
        id.setLocation(100, 350); 
        c.add(id);
        
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid.setSize(190, 20); 
        tid.setLocation(200, 350); 
        c.add(tid); 
        
        
        gender = new JLabel("Gender"); 
        gender.setFont(new Font("Arial", Font.PLAIN, 15)); 
        gender.setSize(100, 20); 
        gender.setLocation(100, 400); 
        c.add(gender); 
  
        male = new JRadioButton("Male"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(true); 
        male.setSize(75, 20); 
        male.setLocation(200, 400); 
        c.add(male); 
  
        female = new JRadioButton("Female"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(80, 20); 
        female.setLocation(275, 400); 
        c.add(female); 
  
        gengp = new ButtonGroup(); 
        gengp.add(male); 
        gengp.add(female); 
  
  
        phoneNum = new JLabel("Mobile"); 
        phoneNum.setFont(new Font("Arial", Font.PLAIN, 15)); 
        phoneNum.setSize(100, 20); 
        phoneNum.setLocation(100, 450); 
        c.add(phoneNum); 
  
        tphoneNum = new JTextField(); 
        tphoneNum.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tphoneNum.setSize(150, 20); 
        tphoneNum.setLocation(200, 450); 
        c.add(tphoneNum); 
  
        dob = new JLabel("DOB"); 
        dob.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dob.setSize(100, 20); 
        dob.setLocation(100, 500); 
        c.add(dob); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(70, 20); 
        date.setLocation(200, 500); 
        c.add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(90, 20); 
        month.setLocation(272, 500); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(90, 20); 
        year.setLocation(360, 500); 
        c.add(year); 
  
        add = new JLabel("Address"); 
        add.setFont(new Font("Arial", Font.PLAIN, 15)); 
        add.setSize(150, 75); 
        add.setLocation(400, 70); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(200, 60); 
        tadd.setLocation(500, 100); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
        
        emailAdd = new JLabel("Email"); 
        emailAdd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        emailAdd.setSize(100, 20); 
        emailAdd.setLocation(400, 160); 
        c.add(emailAdd); 
  
        temailAdd = new JTextArea(); 
        temailAdd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        temailAdd.setSize(200, 20); 
        temailAdd.setLocation(500, 180); 
        temailAdd.setLineWrap(true); 
        c.add(temailAdd); 
   
        
        
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(500, 550); 
        sub.addActionListener(this); 
        c.add(sub); 
        
        
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(610, 550); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(250, 400); 
        tout.setLocation(750, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 
  
        
        //setVisible(true);

  
        
    } 

   
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    
        @Override
        public void actionPerformed(ActionEvent e) 
        { 
            
            if (e.getSource() == sub) {
                
                    String username = tuserName.getText();
                    int password = Integer.parseInt(tpswd.getText());
                    String fullname = tfullName.getText();
                    int ID = Integer.parseInt(tid.getText());
                    
                    String gender;
                    if (male.isSelected()) {
                        gender = "Male";
                    }
                    else{
                        gender = "Female";
                    }
                    int phoneNumber = Integer.parseInt(tphoneNum.getText());
                    
                    String dob 
                        = (String)date.getSelectedItem() 
                        + "/" + (String)month.getSelectedItem() 
                        + "/" + (String)year.getSelectedItem(); 
                    
                    String address = tadd.getText();
                    String emailaddress = temailAdd.getText();
                
                    String userType = null;
                    
                    if(rCustomer.isSelected()){
                        userType = "Customer";
                    }
                    else if(rManager.isSelected()){
                        userType = "Manager";
                    }
                    else if(rTechnician.isSelected()){
                        userType = "Technician";
                    }
                    
                    
                    
                    
                    tout.setText("User name: " + username +"\n" +
                                "password: " + password + "\n" +
                            "fullname" + fullname + "\n" +
                            "ID" +ID + "\n" +
                            "Gender" + gender + "\n" +
                            "phone number "+ phoneNumber  +"\n" +
                            "Date of birth: " + dob +"\n" +
                            "address: " + address + "\n" + 
                            "emailaddress: " + emailaddress 
                    ); 
                    tout.setEditable(false); 
                    boolean flag = false;
                    
                    switch(userType) {
                        case "Manager":
                            for(int i =0; i <AssignmentOOP.allManager.size();i++){
                            //if the same name is found
                                if (AssignmentOOP.allManager.get(i).getUserName().equals(tuserName.getText())){
                                    flag = true;
                                    break;
                                }
                
                            }
                            //shows dialogue that the name exists, enter another name
                            if(flag){
                                JOptionPane.showMessageDialog(null,"This user name already exists. please enter another username"); 
                                break;
                            }
                            //if same name doesnt exist, complete registration
                            else if(!flag){
                                Manager m = new Manager(username,password,userType,fullname,ID,gender,phoneNumber,dob,address,emailaddress);
                                AssignmentOOP.allManager.add(m);  
                            
                            try{
                                
                            
                                PrintWriter p = new PrintWriter("manager.txt");
                                for(int j=0;j<AssignmentOOP.allManager.size();j++){
                                    
                                p.println(AssignmentOOP.allManager.get(j).getUserName());
                                p.println(AssignmentOOP.allManager.get(j).getPassword());
                                p.println(AssignmentOOP.allManager.get(j).getUserType());
                                p.println(AssignmentOOP.allManager.get(j).getFullName());
                                p.println(AssignmentOOP.allManager.get(j).getID());
                                p.println(AssignmentOOP.allManager.get(j).getGender());
                                p.println(AssignmentOOP.allManager.get(j).getPhoneNumber());
                                p.println(AssignmentOOP.allManager.get(j).getDob());
                                p.println(AssignmentOOP.allManager.get(j).getAddress());
                                p.println(AssignmentOOP.allManager.get(j).getEmail());
                                p.println();
                                }
                                p.println();
                            
                                p.close();
                                JOptionPane.showMessageDialog(null,"New Manager registration successful"); 
                            }
                             catch (FileNotFoundException ex) {
                                 JOptionPane.showMessageDialog(null, "file not found");
                             }
                            }
                            break;
                        case "Technician":
                            for(int i =0; i <AssignmentOOP.allTechnician.size();i++){
                            //if the same name is found
                                if (AssignmentOOP.allTechnician.get(i).getUserName().equals(tuserName.getText())){
                                    flag = true;
                                    break;
                                }
                
                            }
                            //shows dialogue that the name exists, enter another name
                            if(flag){
                                JOptionPane.showMessageDialog(null,"This user name already exists. please enter another username"); 
                                break;
                            }
                            //if same name doesnt exist, complete registration
                            else if(!flag){
                                Technician t = new Technician(username,password,userType,fullname,ID,gender,phoneNumber,dob,address,emailaddress);
                                AssignmentOOP.allTechnician.add(t);  
                            
                            try{
                                
                            
                                PrintWriter p = new PrintWriter("technician.txt");
                                for(int j=0;j<AssignmentOOP.allTechnician.size();j++){
                                    
                                p.println(AssignmentOOP.allTechnician.get(j).getUserName());
                                p.println(AssignmentOOP.allTechnician.get(j).getPassword());
                                p.println(AssignmentOOP.allTechnician.get(j).getUserType());
                                p.println(AssignmentOOP.allTechnician.get(j).getFullName());
                                p.println(AssignmentOOP.allTechnician.get(j).getID());
                                p.println(AssignmentOOP.allTechnician.get(j).getGender());
                                p.println(AssignmentOOP.allTechnician.get(j).getPhoneNumber());
                                p.println(AssignmentOOP.allTechnician.get(j).getDob());
                                p.println(AssignmentOOP.allTechnician.get(j).getAddress());
                                p.println(AssignmentOOP.allTechnician.get(j).getEmail());
                                p.println();
                                }
                                p.println();
                            
                                p.close();
                                JOptionPane.showMessageDialog(null,"New Technician registration successful"); 
                            }
                             catch (FileNotFoundException ex) {
                                 JOptionPane.showMessageDialog(null, "file not found");
                             }
                            }
                            break;
                        case"Customer":
                            for(int i =0; i <AssignmentOOP.allCustomer.size();i++){
                            //if the same name is found
                                if (AssignmentOOP.allCustomer.get(i).getUserName().equals(tuserName.getText())){
                                    flag = true;
                                    break;
                                }
                
                            }
                            //shows dialogue that the name exists, enter another name
                            if(flag){
                                JOptionPane.showMessageDialog(null,"This user name already exists. please enter another username"); 
                                break;
                            }
                            //if same name doesnt exist, complete registration
                            else if(!flag){
                                Customer c = new Customer(username,password,userType,fullname,ID,gender,phoneNumber,dob,address,emailaddress);
                                AssignmentOOP.allCustomer.add(c);  
                           
                            try{
                                
                            
                                PrintWriter p = new PrintWriter("customer.txt");
                                for(int j=0;j<AssignmentOOP.allCustomer.size();j++){
                                    
                                p.println(AssignmentOOP.allCustomer.get(j).getUserName());
                                p.println(AssignmentOOP.allCustomer.get(j).getPassword());
                                p.println(AssignmentOOP.allCustomer.get(j).getUserType());
                                p.println(AssignmentOOP.allCustomer.get(j).getFullName());
                                p.println(AssignmentOOP.allCustomer.get(j).getID());
                                p.println(AssignmentOOP.allCustomer.get(j).getGender());
                                p.println(AssignmentOOP.allCustomer.get(j).getPhoneNumber());
                                p.println(AssignmentOOP.allCustomer.get(j).getDob());
                                p.println(AssignmentOOP.allCustomer.get(j).getAddress());
                                p.println(AssignmentOOP.allCustomer.get(j).getEmail());
                                p.println();
                                }
                                p.println();
                            
                                p.close();
                                JOptionPane.showMessageDialog(null,"New Customer registration successful"); 
                            }
                             catch (FileNotFoundException ex) {
                                 JOptionPane.showMessageDialog(null, "file not found");
                             }
                            }
                            break;
                            
                        
                            
                        default:
                            JOptionPane.showMessageDialog(null,"Please select a user Type");
                            break;
                    
                    
                        
                         
                    }
                    
                            
                    //AssignmentOOP.allManager.add(m);
                }
                   
            if (e.getSource() == reset) { 
                String def = ""; 
                tuserName.setText(def); 
                tpswd.setText(def);
                tfullName.setText(def);
                tadd.setText(def); 
                tphoneNum.setText(def); 
                temailAdd.setText(def);
                tid.setText(def);
               
                tout.setText(def); 
                term.setSelected(false); 
                date.setSelectedIndex(0); 
                month.setSelectedIndex(0); 
                year.setSelectedIndex(0); 
            } 
        
            
    
        }
        
        public static void  addDataTxt(String userType){
                
            try{
                PrintWriter p = new PrintWriter(userType+".txt");
                switch(userType){
                case"customer":
                    for(int j=0;j<AssignmentOOP.allCustomer.size();j++){

                    p.println(AssignmentOOP.allCustomer.get(j).getUserName());
                    p.println(AssignmentOOP.allCustomer.get(j).getPassword());
                    p.println(AssignmentOOP.allCustomer.get(j).getUserType());
                    p.println(AssignmentOOP.allCustomer.get(j).getFullName());
                    p.println(AssignmentOOP.allCustomer.get(j).getID());
                    p.println(AssignmentOOP.allCustomer.get(j).getGender());
                    p.println(AssignmentOOP.allCustomer.get(j).getPhoneNumber());
                    p.println(AssignmentOOP.allCustomer.get(j).getDob());
                    p.println(AssignmentOOP.allCustomer.get(j).getAddress());
                    p.println(AssignmentOOP.allCustomer.get(j).getEmail());
                    p.println();
                    }
                    p.println();

                    p.close();
                    JOptionPane.showMessageDialog(null,"Customer updated");
                    break;
                    
                case"technician":
                    for(int j=0;j<AssignmentOOP.allTechnician.size();j++){
                        p.println(AssignmentOOP.allTechnician.get(j).getUserName());
                        p.println(AssignmentOOP.allTechnician.get(j).getPassword());
                        p.println(AssignmentOOP.allTechnician.get(j).getUserType());
                        p.println(AssignmentOOP.allTechnician.get(j).getFullName());
                        p.println(AssignmentOOP.allTechnician.get(j).getID());
                        p.println(AssignmentOOP.allTechnician.get(j).getGender());
                        p.println(AssignmentOOP.allTechnician.get(j).getPhoneNumber());
                        p.println(AssignmentOOP.allTechnician.get(j).getDob());
                        p.println(AssignmentOOP.allTechnician.get(j).getAddress());
                        p.println(AssignmentOOP.allTechnician.get(j).getEmail());
                        p.println();
                        }
                        p.println();
                        p.close();
                        JOptionPane.showMessageDialog(null,"Technician updated");
                        break;
                case"manager":
                    for(int j=0;j<AssignmentOOP.allManager.size();j++){
                                    
                        p.println(AssignmentOOP.allManager.get(j).getUserName());
                        p.println(AssignmentOOP.allManager.get(j).getPassword());
                        p.println(AssignmentOOP.allManager.get(j).getUserType());
                        p.println(AssignmentOOP.allManager.get(j).getFullName());
                        p.println(AssignmentOOP.allManager.get(j).getID());
                        p.println(AssignmentOOP.allManager.get(j).getGender());
                        p.println(AssignmentOOP.allManager.get(j).getPhoneNumber());
                        p.println(AssignmentOOP.allManager.get(j).getDob());
                        p.println(AssignmentOOP.allManager.get(j).getAddress());
                        p.println(AssignmentOOP.allManager.get(j).getEmail());
                        p.println();
                    }
                    p.println();
                    p.close();
                    JOptionPane.showMessageDialog(null,"Manager updated"); 
                    break;
                
            }
                }
                catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "file not found");
                }
                            
            }
    }
    
    
    
    
    


    

