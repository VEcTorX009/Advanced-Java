package Panels;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
 
public class Details extends JPanel {
    public Details() 
    {
        java.awt.Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLable = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField namField = new JTextField(10);
        JTextField occupationField= new JTextField(10);

        JButton addBtn = new JButton("Add");
        System.out.println(nameLable);
        System.out.println(namField);
        System.out.println(occupationField);
        System.out.println(addBtn);
        System.out.println(occupationLabel);

    setLayout(new GridBagLayout());

    GridBagConstraints gc = new GridBagConstraints();
    System.out.println(gc);
    }
}
