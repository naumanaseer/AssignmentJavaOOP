/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
public class GUI6_2 extends JFrame implements ActionListener{
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
        
    public GUI6_2(){
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
            
            checkDay = new JLabel("Check for: ");
            date = new JComboBox(dates);
            month = new JComboBox(months);
            year = new JComboBox(years);
            
            
            checkDay.setBounds(20, 250, 75, 25);
            date.setBounds(100,250,60,20);
            month.setBounds(160,250,75,20);
            year.setBounds(230,250,100,20);
            
            
            
            
            
            btnUpdate = new JButton("Update");
            btnCheck = new JButton("Check");
            btnRefresh = new JButton("Clear All");
            
            btnUpdate.setBounds(150, 200, 100, 25);
            btnCheck.setBounds(250, 300, 100, 25);
            btnCheck.setLocation(250, 300);
            btnRefresh.setBounds(20, 200, 130, 25);
            
            
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
        
        btnUpdate.addActionListener(this);
        btnCheck.addActionListener(this);
        btnRefresh.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnUpdate){
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for(int i = 0; i < AssignmentOOP.clogin.getMyAppointment().size(); i++)
            {
                rowData[0] = AssignmentOOP.clogin.getMyAppointment().get(i).getID();
                rowData[1] = AssignmentOOP.clogin.getMyAppointment().get(i).getTechassigned().getUserName();
                rowData[2] = AssignmentOOP.clogin.getMyAppointment().get(i).getDate();
                rowData[3] = AssignmentOOP.clogin.getMyAppointment().get(i).getStartTime();
                rowData[4] = AssignmentOOP.clogin.getMyAppointment().get(i).getEndTime();
                rowData[5] = AssignmentOOP.clogin.getMyAppointment().get(i).getVehicleType();
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
            
            for(int i=0;i<AssignmentOOP.clogin.getMyAppointment().size();i++){
                if(theDate.equals(AssignmentOOP.clogin.getMyAppointment().get(i).getDate())){
                        hasSameDayAppointment = true;
                        Appointment a = AssignmentOOP.clogin.getMyAppointment().get(i);
                        sameDayAppointment.add(a);
                        
                }
            }
            if(!sameDayAppointment.isEmpty()){
                model.setRowCount(0);
                Object rowData[] = new Object[6];
                for(int i = 0; i < sameDayAppointment.size(); i++)

                {
                    System.out.println(sameDayAppointment.get(i).getID());
                    rowData[0] = AssignmentOOP.clogin.getMyAppointment().get(i).getID();
                    rowData[1] = AssignmentOOP.clogin.getMyAppointment().get(i).getTechassigned().getFullName();
                    rowData[2] = AssignmentOOP.clogin.getMyAppointment().get(i).getDate();
                    rowData[3] = AssignmentOOP.clogin.getMyAppointment().get(i).getStartTime();
                    rowData[4] = AssignmentOOP.clogin.getMyAppointment().get(i).getEndTime();
                    rowData[5] = AssignmentOOP.clogin.getMyAppointment().get(i).getVehicleType();
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
    }
        
        
         
    
    
}
    

