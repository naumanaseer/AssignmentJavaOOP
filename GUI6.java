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
public class GUI6 extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title; 
    public JButton view;
    public JButton book;
    public GUI6(){
        
        setTitle("Customer Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
        setTitle("Customer Home Page"); 
        setBounds(300, 100, 500, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Customer Home Page"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(150, 30); 
        c.add(title);
        
        book = new JButton("Book an appointment"); 
        book.setFont(new Font("Arial", Font.PLAIN, 15)); 
        book.setSize(300, 20); 
        book.setLocation(100, 100); 
        book.addActionListener(this); 
        c.add(book);
        
        view = new JButton("View my appointments"); 
        view.setFont(new Font("Arial", Font.PLAIN, 15)); 
        view.setSize(300, 20); 
        view.setLocation(100, 130); 
        view.addActionListener(this); 
        c.add(view); 
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == book){
            setVisible(false);
            AssignmentOOP.page6_1.setVisible(true); //if register button is clicked, open the user registration form
        }
        if(e.getSource() == view){
            setVisible(false);
            AssignmentOOP.page6_2.setVisible(true); //if register button is clicked, open the user registration form
        }
        
        }
}
