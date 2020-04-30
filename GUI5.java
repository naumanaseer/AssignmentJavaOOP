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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author nauma
 */
public class GUI5 extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title; 
    public JButton view,reciept;
    public GUI5(){
        
        setTitle("Technician Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
        setTitle("Technician Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Technician Home Page"); 
        title.setFont(new Font("Arial", Font.PLAIN, 22)); 
        title.setSize(300, 30); 
        title.setLocation(130, 30); 
        c.add(title);
        
        view = new JButton("View my appointments"); 
        view.setFont(new Font("Arial", Font.PLAIN, 15)); 
        view.setSize(300, 20); 
        view.setLocation(100, 100); 
        view.addActionListener(this); 
        c.add(view); 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == view){
            setVisible(false);
            AssignmentOOP.page5_1.setVisible(true); //if view user button is clicked, open the gui for viewing users is opened
            AssignmentOOP.page5_1.setTitle(AssignmentOOP.tlogin.userName + ",welcome");
        }
        
        
    }
}
