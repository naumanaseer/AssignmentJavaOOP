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
public class GUI4 extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title; 
    private JButton register;
    private JButton view;
    private JButton book;
    public GUI4(){
        
        setTitle("Manager Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
        setTitle("Manager Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Welcome Manager "); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(150, 30); 
        c.add(title);
        
        register = new JButton("Register User"); 
        register.setFont(new Font("Arial", Font.PLAIN, 15)); 
        register.setSize(300, 20); 
        register.setLocation(100, 100); 
        register.addActionListener(this); 
        c.add(register); 
        
        view = new JButton("View User"); 
        view.setFont(new Font("Arial", Font.PLAIN, 15)); 
        view.setSize(300, 20); 
        view.setLocation(100, 130); 
        view.addActionListener(this); 
        c.add(view); 
        
        book = new JButton("Book Appointment"); 
        book.setFont(new Font("Arial", Font.PLAIN, 15)); 
        book.setSize(300, 20); 
        book.setLocation(100, 160); 
        book.addActionListener(this); 
        c.add(book);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == register){
            setVisible(false);
            AssignmentOOP.page4_1.setVisible(true); //if register button is clicked, open the user registration form
        }
        
        if(e.getSource() == view){
            setVisible(false);
            AssignmentOOP.page4_2.setVisible(true); //if view user button is clicked, open the gui for viewing users
        }
        
        if(e.getSource() == book){
            setVisible(false);
            AssignmentOOP.page4_3.setVisible(true); //if book button is clicked,go back to  booking 
        }
    
    }
    
}
