/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nauma
 */
public class GUI3 extends JFrame implements ActionListener {
    
    private Container c; 
    private JLabel title; 
    private JLabel userName; 
    private JTextField tuserName; 
    private JLabel pswd; 
    private JPasswordField tpswd;
    private JLabel dob; 
    private JComboBox users; 
    private JLabel userType;
    private String userTypes[] 
        = { "customer","manager","technician","staff"}; 
    private JButton login;
    
    public GUI3(){
        
        setTitle("Login Form"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("APU Automotive Service Centre"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(300, 30); 
        title.setLocation(100, 30); 
        c.add(title);
        
        userName = new JLabel("User Name"); 
        userName.setFont(new Font("Arial", Font.PLAIN, 16)); 
        userName.setSize(100, 40); 
        userName.setLocation(100, 100); 
        c.add(userName); 
        
        tuserName = new JTextField(); 
        tuserName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tuserName.setSize(190, 20); 
        tuserName.setLocation(200, 100); 
        c.add(tuserName); 
        
        pswd = new JLabel("Password"); 
        pswd.setFont(new Font("Arial", Font.PLAIN, 16)); 
        pswd.setSize(100, 20); 
        pswd.setLocation(100, 150); 
        c.add(pswd); 
        
        tpswd = new JPasswordField(); 
        tpswd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpswd.setSize(190, 20); 
        tpswd.setLocation(200, 150); 
        c.add(tpswd);
        
        userType = new JLabel("User Type"); 
        userType.setFont(new Font("Arial", Font.PLAIN, 16)); 
        userType.setSize(100, 20); 
        userType.setLocation(100, 200); 
        c.add(userType);
        
        users = new JComboBox(userTypes); 
        users.setFont(new Font("Arial", Font.PLAIN, 15)); 
        users.setSize(175, 20); 
        users.setLocation(200, 200); 
        c.add(users);
        
        login = new JButton("Login"); 
        login.setFont(new Font("Arial", Font.PLAIN, 15)); 
        login.setSize(100, 20); 
        login.setLocation(300, 250); 
        login.addActionListener(this); 
        c.add(login);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String userType = (String)users.getSelectedItem();
        
        if(e.getSource() == login){
            boolean flag = false;
            
            
            String a = tuserName.getText();
            String b = tpswd.getText();
            
            switch(userType){
                case "manager":
                    
                    for(int i=0;i<AssignmentOOP.allManager.size();i++){ //checks the whole size of login 
                        if(AssignmentOOP.allManager.get(i).getUserName().equals(a)){ //if the name entered in mlogin is found, name is =a
                            AssignmentOOP.mlogin = AssignmentOOP.allManager.get(i); //assign login as the specific customer object
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                             //saves the entered password as b
                            
                            if(Integer.parseInt(b)==AssignmentOOP.mlogin.getPassword()){  //if the password is same as object logins password
                                setVisible(false);
                                AssignmentOOP.page4.setVisible(true); //show GUI4
                                AssignmentOOP.page4.setTitle(AssignmentOOP.mlogin.userName + ",welcome");
                            }       
                            else{
                            JOptionPane.showMessageDialog(null,"Wrong password!"); //since name is found, say password typed in for that object is wrong
                            }
                    } 
                    else{
                        JOptionPane.showMessageDialog(null,"Wrong name!");//if name is not found in allManager array, say that 
                    }
                    
                    break;
                case "technician":
                    for(int i=0;i<AssignmentOOP.allTechnician.size();i++){ //checks the whole size of login 
                        if(AssignmentOOP.allTechnician.get(i).getUserName().equals(a)){ //if the name entered in login is found, name is =a
                            AssignmentOOP.tlogin = AssignmentOOP.allTechnician.get(i); //assign login as the specific customer object
                            flag = true;
                            break;
                        }
                    }
                        if(flag){
                            if(Integer.parseInt(b)==AssignmentOOP.tlogin.getPassword()){  //if the password is same as object logins password
                                setVisible(false);
                                AssignmentOOP.page5.setVisible(true); //show GUI2
                                AssignmentOOP.page5.setTitle(AssignmentOOP.tlogin.userName + ",welcome");
                            } else{
                                JOptionPane.showMessageDialog(null,"Wrong password!"); //since name is found, say password typed in for that object is wrong
                            }
                        } 
                        else{
                        JOptionPane.showMessageDialog(null,"Wrong name!");//if name is not found in allCustomer file, say that 
                        
                    }
                    break;
                    
                
                
                case "customer":
                    String enteredUserName = tuserName.getText();
                    if(enteredUserName != null && (!"".equals(enteredUserName))){
                        for(int i=0;i<AssignmentOOP.allCustomer.size();i++){ //checks the whole size of login 
                            if(AssignmentOOP.allCustomer.get(i).getUserName().equals(enteredUserName)){ //if the name entered in login is found, name is =a
                                AssignmentOOP.clogin = AssignmentOOP.allCustomer.get(i); //assign login as the specific customer object
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            String enteredpass = tpswd.getText();

                            if(Integer.parseInt(enteredpass)==AssignmentOOP.clogin.getPassword()){  //if the password is same as object logins password
                                setVisible(false);
                                AssignmentOOP.name = enteredUserName;
                                AssignmentOOP.page6.setVisible(true); //show GUI7
                                
                            } else{
                                JOptionPane.showMessageDialog(null,"Wrong password!"); //since name is found, say password typed in for that object is wrong
                            }
                        } 
                        else{
                            JOptionPane.showMessageDialog(null,"Wrong name!");//if name is not found in allCustomer file, say that 
                        }
                            
                    }
                    else {
                        setVisible(true);
                    }
                    
                }
            
        }
    }   
}


