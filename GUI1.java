/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoop;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.rmi.activation.Activatable.register;
import javax.swing.*;

public class GUI1 extends JFrame implements ActionListener{
    private Button login, quit;
    private JLabel title;

    public GUI1() {
        
        title = new JLabel("Login Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 20); 
        title.setLocation(150, 30); 
        add(title);
        
        setSize(600,200);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login = new Button("Login");
        login.setLocation(150, 100); 
        quit = new Button("Quit");
        quit.setLocation(150, 120); 
        login.addActionListener(this);
        quit.addActionListener(this);
        setLayout(new FlowLayout());
        
        add(login);
        add(quit);
        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
         if(e.getSource() == login){
            setVisible(false);
            AssignmentOOP.page3.setVisible(true);
        
                
        }
         if(e.getSource() == quit){
             System.exit(0);
         }
        
    }
    
}
