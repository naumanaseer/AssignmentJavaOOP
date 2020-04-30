/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import static assignmentoop.AssignmentOOP.allAppointment;
import static assignmentoop.AssignmentOOP.allCustomer;
import static assignmentoop.AssignmentOOP.allTechnician;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nauma
 */
public class GUI5_1 extends JFrame implements ActionListener{
    
    // Initialize JFrame and JTable
        private JFrame frame;
        private JTable table;
        private Container d;
        
        private JComboBox date;
        private JComboBox month;
        private JComboBox year;
        
        private ArrayList<Appointment> sameDayAppointment;
        
        // Initialize a table model and set a Column Identifiers to this model 
        Object[] columns = {"Appointment ID","Technician","Date","Start time","End Time","Vehicle Type"};
        private DefaultTableModel model;
        
        //initialize font
        private Font font;
        //initialize scrollpane
        private JScrollPane pane;
        JLabel checkDay;
        //intialize columns
        private Object[] rowData;
        private JButton btnUpdate;
        private JButton btnCheck;
        private JButton btnBs;
        private JButton btnRefresh;
        private JButton btnPayment;
        private JButton btnGenerate;
        private JTextField provide; 
        private JTextField textId;
        private JLabel labelId;
        private JLabel labelfeedback;
        private Appointment selectedAppointment;
        
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
    private String theDate;
        
    public GUI5_1(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        
            
            
    }
    
    public void createWindow(){
        setTitle("View my appointments");
        setBounds(60,60,900,900);
        d = getContentPane();
        d.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        
    }
    public void setLocationAndSize(){
            
            sameDayAppointment  = new ArrayList<Appointment>();
            selectedAppointment = null;
            
            
            table = new JTable();  //create new table
            model = new DefaultTableModel(); //create new model
            model.setColumnIdentifiers(columns);
            
            table.setModel(model);
            table.setBackground(Color.LIGHT_GRAY);
            table.setForeground(Color.black);
            
            font = new Font("",1,10);
            table.setFont(font);
            table.setRowHeight(30);
            Handler myMouseListener = new Handler();
            table.addMouseListener(myMouseListener); //checks if a row is selected
            
            checkDay = new JLabel("Check for: ");
            date = new JComboBox(dates);
            month = new JComboBox(months);
            year = new JComboBox(years);
            
            
            checkDay.setBounds(20, 250, 75, 25);
            date.setBounds(100,250,60,20);
            month.setBounds(160,250,75,20);
            year.setBounds(230,250,100,20);
            
            labelId = new JLabel("Selected ID: ");
            labelId.setBounds(460, 280, 100, 25);
            provide = new JTextField();
            textId = new JTextField();
            textId.setBounds(450, 300, 100, 25);
            
            
            
            btnUpdate = new JButton("Update");
            btnCheck = new JButton("Check");
            btnRefresh = new JButton("Clear All");
            btnPayment = new JButton("Payment");
            btnGenerate = new JButton("Generate");
            
            btnUpdate.setBounds(150, 200, 100, 25);
            btnCheck.setBounds(250, 300, 100, 25);
            btnCheck.setLocation(250, 300);
            btnRefresh.setBounds(20, 200, 130, 25);
            
            btnPayment.setBounds(450, 340, 100, 25);
            btnGenerate.setBounds(450, 380, 100, 25);
            labelfeedback = new JLabel("Provide feedback: ");
            labelfeedback.setBounds(600, 275, 190, 25);
            provide.setBounds(600,300,300,300);
            
            pane = new JScrollPane(table);
            pane.setVisible(true);
            pane.setBounds(0, 0, 880, 200);
            //frame.setVisible(true);
    }
    public void addComponentsToFrame(){
        d.add(pane);
        d.add(checkDay);
        d.add(date);
        d.add(month);
        d.add(year);
        d.add(btnUpdate);
        d.add(btnCheck);
        d.add(btnRefresh);
        d.add(btnPayment);
        d.add(btnGenerate);
        d.add(labelId);
        d.add(labelfeedback);
        d.add(textId);
        d.add(provide);
        btnUpdate.addActionListener(this);
        btnCheck.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnPayment.addActionListener(this);
        btnGenerate.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnUpdate){
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for(int i = 0; i < AssignmentOOP.tlogin.getMyAppointment().size(); i++)
            {
                rowData[0] = AssignmentOOP.tlogin.getMyAppointment().get(i).getID();
                rowData[1] = AssignmentOOP.tlogin.getMyAppointment().get(i).getTechassigned().getUserName();
                rowData[2] = AssignmentOOP.tlogin.getMyAppointment().get(i).getDate();
                rowData[3] = AssignmentOOP.tlogin.getMyAppointment().get(i).getStartTime();
                rowData[4] = AssignmentOOP.tlogin.getMyAppointment().get(i).getEndTime();
                rowData[5] = AssignmentOOP.tlogin.getMyAppointment().get(i).getVehicleType();
                model.addRow(rowData);
            } 
        }
        
        if(e.getSource() == btnCheck){
            model.setRowCount(0);
            sameDayAppointment.clear();
            boolean hasSameDayAppointment = false;
            theDate = (String)date.getSelectedItem()
                        +"/" + (String)month.getSelectedItem()
                        +"/" + (String)year.getSelectedItem();
            System.out.println(theDate);
            
            for(int i=0;i<AssignmentOOP.tlogin.getMyAppointment().size();i++){
                if(theDate.equals(AssignmentOOP.tlogin.getMyAppointment().get(i).getDate())){
                        hasSameDayAppointment = true;
                        Appointment a = AssignmentOOP.tlogin.getMyAppointment().get(i);
                        sameDayAppointment.add(a);
                        
                }
            }
            if(!sameDayAppointment.isEmpty()){
                model.setRowCount(0);
                Object rowData[] = new Object[6];
                for(int i = 0; i < sameDayAppointment.size(); i++)

                {
                    System.out.println(sameDayAppointment.get(i).getID());
                    rowData[0] = AssignmentOOP.tlogin.getMyAppointment().get(i).getID();
                    rowData[1] = AssignmentOOP.tlogin.getMyAppointment().get(i).getTechassigned().getFullName();
                    rowData[2] = AssignmentOOP.tlogin.getMyAppointment().get(i).getDate();
                    rowData[3] = AssignmentOOP.tlogin.getMyAppointment().get(i).getStartTime();
                    rowData[4] = AssignmentOOP.tlogin.getMyAppointment().get(i).getEndTime();
                    rowData[5] = AssignmentOOP.tlogin.getMyAppointment().get(i).getVehicleType();
                    model.addRow(rowData);
                } 
            }
            else{
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "No Appointments for the selected day ;)");
            }
        
        }
        if(e.getSource() == btnRefresh){
            model.setRowCount(0);
                   
        }
        if(e.getSource() == btnPayment){
                
            int bookingid = table.getSelectedRow();
            int duration = (AssignmentOOP.tlogin.getMyAppointment().get(bookingid).getEndTime()) - (AssignmentOOP.tlogin.getMyAppointment().get(bookingid).getStartTime());
            int myCharge = duration*10; //setting a random price for charging based on duration
            
            
                 
                if(AssignmentOOP.allAppointment.get(bookingid).getCharge()==0 && AssignmentOOP.tlogin.getMyAppointment().get(bookingid).getCharge() ==0 ){
                    String bill = JOptionPane.showInputDialog("Please pay "+ myCharge+ "rm, for this booking");
                    int a = Integer.parseInt(bill);
                    
                    if(a>= myCharge){
                    AssignmentOOP.allAppointment.get(bookingid).setCharge(a);
                    AssignmentOOP.tlogin.getMyAppointment().get(bookingid).setCharge(a);
             
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Thats not sufficient!");
                        
                    }
                    
                    JOptionPane.showMessageDialog(null, "Congratulations! You have paid the bill.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "You have paid for this.");
                }
            
        }  
        
        if(e.getSource() == btnGenerate){
                int bookingnumber = table.getSelectedRow();
            
                String a = provide.getText();
             try{
                        Document document = new Document();
                        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("receipt.pdf"));
                        document.open();
                        PdfContentByte cb = writer.getDirectContent();
                        cb.beginText();
                        BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN , BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                        cb.setFontAndSize(bf, 12);
                        cb.setRGBColorFill(0, 0, 0);
//                        cb.showTextAligned(Element.ALIGN_LEFT,"Booking ID:", 36, 788, 0);
//                        cb.showTextAligned(Element.ALIGN_LEFT,Integer.toString(AutomativeCarSystem.allAppoinments., 120, 788, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT,"Technician:", 36, 788, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AssignmentOOP.allAppointment.get(bookingnumber).getTechassigned().getUserName(), 120, 788, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "Name: ", 36, 760, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AssignmentOOP.allAppointment.get(bookingnumber).getOwner().getUserName(), 120, 760, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "Date: ", 36, 730, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AssignmentOOP.allAppointment.get(bookingnumber).getDate(), 120, 730, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "Amount paid: ", 36, 700, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, (""+AssignmentOOP.allAppointment.get(bookingnumber).getCharge()), 120, 700, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "~~~~~Completed~~~~~~~", 36, 670, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT,("Comments: "+ a), 36, 640, 0);
                        cb.endText();
                        document.close();
                        // printWriting.writeAppDetails();
                     
                    }catch(Exception t){
                        System.out.println(t);
                    }
                    JOptionPane.showMessageDialog(null,"reciept generated!");
        }
            
        
        
    
    }
        
    class Handler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent mEvt) {
           // i = the index of the selected row
                int i = table.getSelectedRow(); //gets row number
//                for(int j=0;j<AssignmentOOP.allCustomer.size();j++){ //checks the whole size of login 
//                        if(AssignmentOOP.allCustomer.get(i).getUserName().equals(textUserName.getText())){ 
//                            cUpdate = AssignmentOOP.allCustomer.get(j); //assign login as the specific customer object
//                            break;
//                        }
//                }
                 textId.setText(model.getValueAt(i, 0).toString()); //assigns the text field as per the row number
                 

                 
                 
                 

        }
    }
        
    }
    

