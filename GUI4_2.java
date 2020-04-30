/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import static assignmentoop.AssignmentOOP.addData;
import static assignmentoop.AssignmentOOP.allCustomer;
import static assignmentoop.AssignmentOOP.allManager;
import static assignmentoop.AssignmentOOP.allTechnician;
import static assignmentoop.GUI4_1.addDataTxt;
import static com.sun.java.accessibility.util.AWTEventMonitor.addItemListener;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;
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
public class GUI4_2 extends JFrame implements ActionListener {
    
     // Initialize JFrame and JTable
        private JFrame frame;
        private JTable table;
        
        // Initialize a table model and set a Column Identifiers to this model 
        Object[] columns = {"Username","Password","User Type","Full Name","ID","Gender","Phone", "Date of Birth", "Address","Email Address"};
        private DefaultTableModel model;
        
        private Font font;
        // create JTextFields
        private JTextField textUserName;
        private JTextField textPass;
        private JTextField textUserType;
        private JTextField textFullName;
        private JTextField textId;
        private JTextField textGender;
        private JTextField textPhone;
        private JTextField textDob;
        private JTextField textAddress;
        private JTextField textEmail;
        private JTextField testing;
        
        private JLabel labelUserName;
        private JLabel labelPass;
        private JLabel labelUserType;
        private JLabel labelFullName;
        private JLabel labelId;
        private JLabel labelGender;
        private JLabel labelPhone;
        private JLabel labelDob;
        private JLabel labelAddress;
        private JLabel labelEmail;
        
        private JComboBox user; 
        private String users[] 
        = { "customer","manager","technician" }; 
        
        
        // create JButtons
        private JButton btnDelete;
        private JButton btnUpdate;
        
        private JScrollPane pane;
        
        private Object[] rowData;
        
        private String selecteduserType;
        
        Customer cUpdate;
        Customer cDelete;
        
        Technician tUpdate;
        Technician tDelete;
        
        Manager mUpdate;
        Manager mDelete;
        
        
        public GUI4_2(){
            
            
            setSize(900,950); //set frame size
            
            selecteduserType = "customer"; //initially, the selected userType is customer
            
            cUpdate = null; //assign customer object to update as null
            cDelete = null; //assign customer object to delect as null
            
            table = new JTable();  //create new table
            model = new DefaultTableModel(); //create new model
            model.setColumnIdentifiers(columns);
            
            table.setModel(model);
            table.setBackground(Color.LIGHT_GRAY);
            table.setForeground(Color.black);
            
            font = new Font("",1,10);
            table.setFont(font); //assign font to table
            table.setRowHeight(30);
            Handler myMouseListener = new Handler();
            table.addMouseListener(myMouseListener); // checks if a row is selected
            //create label objects
            labelUserName = new JLabel("User Name: ");
            labelPass = new JLabel("Password: ");
            labelUserType = new JLabel("User Type: ");
            labelFullName = new JLabel("Full Name: ");
            labelId = new JLabel("ID : ");
            labelGender = new JLabel("Gender: ");
            labelPhone = new JLabel("Phone : ");
            labelDob = new JLabel("Date of Birth: ");
            labelAddress = new JLabel("Address: ");
            labelEmail = new JLabel("Email: ");
            //create txt field objects
            textUserName = new JTextField();
            textPass = new JTextField();
            textUserType = new JTextField();
            textFullName = new JTextField();
            textId = new JTextField();
            textGender = new JTextField();
            textPhone = new JTextField();
            textDob = new JTextField();
            textAddress = new JTextField();
            textEmail = new JTextField();
            textEmail = new JTextField();
            
            btnDelete = new JButton("Delete");
            btnUpdate = new JButton("Update");
            
            btnDelete.setBounds(250, 250, 100, 25);
            btnDelete.setVisible(true);
            btnUpdate.setBounds(250, 285, 100, 25);
            btnUpdate.setVisible(true);
//            btnDelete.setBounds(250, 310, 100, 25);
//            btnDelete.setVisible(true);
            
            add(btnDelete);
            add(btnUpdate);
            
            user = new JComboBox(users); 
            user.setFont(font); 
            user.setSize(100, 20); 
            user.setLocation(130, 220); 
            add(user);
            
            
            labelUserName.setBounds(20, 250, 100, 25);
            labelPass.setBounds(20, 280, 100, 25);
            labelUserType.setBounds(20, 310, 100, 25);
            labelFullName.setBounds(20, 340, 100, 25);
            labelId.setBounds(20, 370, 100, 25);
            labelGender.setBounds(20, 400, 100, 25);
            labelPhone.setBounds(20, 430, 100, 25);
            labelDob.setBounds(20, 460, 100, 25);
            labelAddress.setBounds(20, 490, 100, 25);
            labelEmail.setBounds(20, 520, 100, 25);

            textUserName.setBounds(130, 250, 100, 25);
            textPass.setBounds(130, 280, 100, 25);
            textUserType.setBounds(130, 310, 100, 25);
            textFullName.setBounds(130, 340, 100, 25);
            textId.setBounds(130, 370, 100, 25);
            textGender.setBounds(130, 400, 100, 25);
            textPhone.setBounds(130, 430, 100, 25);
            textDob.setBounds(130, 460, 100, 25);
            textAddress.setBounds(130, 490, 100, 25);
            textEmail.setBounds(130, 510, 100, 25);

            
            
            pane = new JScrollPane(table);
            pane.setVisible(true);
            pane.setBounds(0, 0, 880, 200);
        
            add(pane);
            add(labelUserName);
            add(labelPass);
            add(labelUserType);
            add(labelFullName);
            add(labelId);
            add(labelGender);
            add(labelPhone);
            add(labelDob);
            add(labelAddress);
            add(labelEmail);
            
            add(textUserName);
            add(textPass);
            add(textUserType);
            add(textFullName);
            add(textId);
            add(textGender);
            add(textPhone);
            add(textDob);
            add(textAddress);
            add(textEmail);
            
            user.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
                public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                    // The item affected by the event.
                    Object item = event.getItem();


                if (event.getStateChange() == ItemEvent.SELECTED) {
                    selecteduserType = (String)user.getSelectedItem();
                    
                    if ("customer".equals(selecteduserType)) {
                        selecteduserType = (String)user.getSelectedItem() ;
                        addRowToJTable(selecteduserType);
                    } else if ("technician".equals(selecteduserType)) {
                        selecteduserType = (String)user.getSelectedItem() ;
                        addRowToJTable(selecteduserType);
                    }
                    else if ("manager".equals(selecteduserType)) {
                        selecteduserType = (String)user.getSelectedItem() ;
                        addRowToJTable(selecteduserType);
                    }
                    
                }

                if (event.getStateChange() == ItemEvent.DESELECTED) {
                    model.setRowCount(0); //if usertype selected currently is deselected, clear the table
                }
            }
        });
            
            
        
            
            btnDelete.addActionListener(this);
            btnUpdate.addActionListener(this);
            //setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnUpdate){
             // i = the index of the selected row
                int i = table.getSelectedRow();
                switch(selecteduserType){
                case "customer":
                        cUpdate = AssignmentOOP.allCustomer.get(i);
                
                    if(i >= 0) 
                    {
                       model.setValueAt(textUserName.getText(), i, 0);
                       model.setValueAt(textPass.getText(), i, 1);
                       model.setValueAt(textUserType.getText(), i, 2);
                       model.setValueAt(textFullName.getText(), i, 3);
                       model.setValueAt(textId.getText(), i, 4);
                       model.setValueAt(textGender.getText(), i, 5);
                       model.setValueAt(textPhone.getText(), i, 6);
                       model.setValueAt(textDob.getText(), i, 7);
                       model.setValueAt(textAddress.getText(), i, 8);
                       model.setValueAt(textEmail.getText(), i, 9);

                       cUpdate.setUserName(textUserName.getText());
                       cUpdate.setPassword(Integer.parseInt(textPass.getText()));
                       cUpdate.setUserType(textUserType.getText());
                       cUpdate.setFullName(textFullName.getText());
                       cUpdate.setID(Integer.parseInt(textId.getText()));
                       cUpdate.setGender(textGender.getText());
                       cUpdate.setPhoneNumber(Integer.parseInt(textPhone.getText()));
                       cUpdate.setDob(textDob.getText());
                       cUpdate.setAddress(textAddress.getText());
                       cUpdate.setEmail(textEmail.getText());

                        addDataTxt("customer");

                        JOptionPane.showMessageDialog(null, "Customer Update Success");
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Customer Update Error");
                    }
                    break;
                case "technician":
                        tUpdate = AssignmentOOP.allTechnician.get(i);
                
                    if(i >= 0) 
                    {
                       model.setValueAt(textUserName.getText(), i, 0);
                       model.setValueAt(textPass.getText(), i, 1);
                       model.setValueAt(textUserType.getText(), i, 2);
                       model.setValueAt(textFullName.getText(), i, 3);
                       model.setValueAt(textId.getText(), i, 4);
                       model.setValueAt(textGender.getText(), i, 5);
                       model.setValueAt(textPhone.getText(), i, 6);
                       model.setValueAt(textDob.getText(), i, 7);
                       model.setValueAt(textAddress.getText(), i, 8);
                       model.setValueAt(textEmail.getText(), i, 9);

                       tUpdate.setUserName(textUserName.getText());
                       tUpdate.setPassword(Integer.parseInt(textPass.getText()));
                       tUpdate.setUserType(textUserType.getText());
                       tUpdate.setFullName(textFullName.getText());
                       tUpdate.setID(Integer.parseInt(textId.getText()));
                       tUpdate.setGender(textGender.getText());
                       tUpdate.setPhoneNumber(Integer.parseInt(textPhone.getText()));
                       tUpdate.setDob(textDob.getText());
                       tUpdate.setAddress(textAddress.getText());
                       tUpdate.setEmail(textEmail.getText());

                        addDataTxt("technician");

                        JOptionPane.showMessageDialog(null, "Technician Update Success");;
                        
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Technician Update Error");
                    }
                    break;
                
                    case "manager":
                        mUpdate = AssignmentOOP.allManager.get(i);
                
                    if(i >= 0) 
                    {
                       model.setValueAt(textUserName.getText(), i, 0);
                       model.setValueAt(textPass.getText(), i, 1);
                       model.setValueAt(textUserType.getText(), i, 2);
                       model.setValueAt(textFullName.getText(), i, 3);
                       model.setValueAt(textId.getText(), i, 4);
                       model.setValueAt(textGender.getText(), i, 5);
                       model.setValueAt(textPhone.getText(), i, 6);
                       model.setValueAt(textDob.getText(), i, 7);
                       model.setValueAt(textAddress.getText(), i, 8);
                       model.setValueAt(textEmail.getText(), i, 9);

                       mUpdate.setUserName(textUserName.getText());
                       mUpdate.setPassword(Integer.parseInt(textPass.getText()));
                       mUpdate.setUserType(textUserType.getText());
                       mUpdate.setFullName(textFullName.getText());
                       mUpdate.setID(Integer.parseInt(textId.getText()));
                       mUpdate.setGender(textGender.getText());
                       mUpdate.setPhoneNumber(Integer.parseInt(textPhone.getText()));
                       mUpdate.setDob(textDob.getText());
                       mUpdate.setAddress(textAddress.getText());
                       mUpdate.setEmail(textEmail.getText());

                        addDataTxt("manager");

                        JOptionPane.showMessageDialog(null, "Manager Update Success");
                        
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Manager Update Error");
                    }
                    break;
                   
                }
                
        }
        
        if (e.getSource() == btnDelete){
        // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                    
                    if(selecteduserType.equals("customer")){
                        AssignmentOOP.allCustomer.remove(i);
                        addDataTxt("customer");
                        System.out.println("Customer deleted");
                    }
                    else if(selecteduserType.equals("manager")){
                        AssignmentOOP.allManager.remove(i);
                        addDataTxt("manager");
                        System.out.println("Manager deleted");
                    }
                    else if(selecteduserType.equals("technician")){
                        AssignmentOOP.allTechnician.remove(i);
                        addDataTxt("technician");
                        System.out.println("Technician deleted");
                    }
                    
                }
                else{
                    System.out.println("Delete Error");
                }
        }
    }
    

    
    class Handler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent mEvt) {
           // i = the index of the selected row
                int i = table.getSelectedRow();
                 for(int j=0;j<AssignmentOOP.allCustomer.size();j++){ //checks the whole size of login 
                        if(AssignmentOOP.allCustomer.get(i).getUserName().equals(textUserName.getText())){ 
                            cUpdate = AssignmentOOP.allCustomer.get(j); //assign login as the specific customer object
                            break;
                        }
                }
                
                 textUserName.setText(model.getValueAt(i, 0).toString());
                 textPass.setText(model.getValueAt(i, 1).toString());
                 textUserType.setText(model.getValueAt(i, 2).toString());
                 textFullName.setText(model.getValueAt(i, 3).toString()); 
                 textId.setText(model.getValueAt(i, 4).toString());
                 textGender.setText(model.getValueAt(i, 5).toString());
                 textPhone.setText(model.getValueAt(i, 6).toString());
                 textDob.setText(model.getValueAt(i, 7).toString());
                 textAddress.setText(model.getValueAt(i, 8).toString()); 
                 textEmail.setText(model.getValueAt(i, 9).toString()); 
                 
                 
                 
                 

                 
                 
                 

        }
    }
    
    public  void addRowToJTable(String userType){
        
        switch(userType){
        case"customer":

            rowData = new Object[10]; // set the rows according to the number of customers
            for(int i = 0; i < AssignmentOOP.allCustomer.size(); i++){
            rowData[0] = AssignmentOOP.allCustomer.get(i).getUserName();
            rowData[1] = AssignmentOOP.allCustomer.get(i).getPassword();
            rowData[2] = AssignmentOOP.allCustomer.get(i).getUserType();
            rowData[3] = AssignmentOOP.allCustomer.get(i).getFullName();
            rowData[4] = AssignmentOOP.allCustomer.get(i).getID();
            rowData[5] = AssignmentOOP.allCustomer.get(i).getGender();
            rowData[6] = AssignmentOOP.allCustomer.get(i).getPhoneNumber();
            rowData[7] = AssignmentOOP.allCustomer.get(i).getDob();
            rowData[8] = AssignmentOOP.allCustomer.get(i).getAddress();
            rowData[9] = AssignmentOOP.allCustomer.get(i).getEmail();
            model.addRow(rowData);
            }
        break;
        case "technician":
            rowData = new Object[10]; // set the rows according to the number of customers
            for(int i = 0; i < AssignmentOOP.allTechnician.size(); i++){
                    rowData[0] = AssignmentOOP.allTechnician.get(i).getUserName();
                    rowData[1] = AssignmentOOP.allTechnician.get(i).getPassword();
                    rowData[2] = AssignmentOOP.allTechnician.get(i).getUserType();
                    rowData[3] = AssignmentOOP.allTechnician.get(i).getFullName();
                    rowData[4] = AssignmentOOP.allTechnician.get(i).getID();
                    rowData[5] = AssignmentOOP.allTechnician.get(i).getGender();
                    rowData[6] = AssignmentOOP.allTechnician.get(i).getPhoneNumber();
                    rowData[7] = AssignmentOOP.allTechnician.get(i).getDob();
                    rowData[8] = AssignmentOOP.allTechnician.get(i).getAddress();
                    rowData[9] = AssignmentOOP.allTechnician.get(i).getEmail();
                    model.addRow(rowData);
                    
                }
            break;
            case "manager":
                rowData = new Object[10]; // set the rows according to the number of customers
                for(int i = 0; i < AssignmentOOP.allManager.size(); i++){
                    rowData[0] = AssignmentOOP.allManager.get(i).getUserName();
                    rowData[1] = AssignmentOOP.allManager.get(i).getPassword();
                    rowData[2] = AssignmentOOP.allManager.get(i).getUserType();
                    rowData[3] = AssignmentOOP.allManager.get(i).getFullName();
                    rowData[4] = AssignmentOOP.allManager.get(i).getID();
                    rowData[5] = AssignmentOOP.allManager.get(i).getGender();
                    rowData[6] = AssignmentOOP.allManager.get(i).getPhoneNumber();
                    rowData[7] = AssignmentOOP.allManager.get(i).getDob();
                    rowData[8] = AssignmentOOP.allManager.get(i).getAddress();
                    rowData[9] = AssignmentOOP.allManager.get(i).getEmail();
                    model.addRow(rowData);
                }
                break;

        }
    }
    
}



