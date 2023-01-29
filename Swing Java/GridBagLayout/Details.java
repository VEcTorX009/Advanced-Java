package GridBagLayout;

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

        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField namField = new JTextField(10);
        JTextField occupationField= new JTextField(10);

        JButton addBtn = new JButton("Add");

    setLayout(new GridBagLayout());

    GridBagConstraints gc = new GridBagConstraints();

    //  First column /////////
    
    gc.anchor = GridBagConstraints.LINE_END;
    gc.weightx = 0.5;
    gc.weighty = 0.5;


    gc.gridx = 0;
    gc.gridy = 0;
    add(nameLabel ,gc);
    
    gc.gridx = 0;
    gc.gridy = 1;
    add(occupationLabel, gc);

    // Second column //////
    
    gc.anchor = GridBagConstraints.LINE_START;

    gc.gridx = 1;
    gc.gridy= 0;
    add(namField, gc);

    gc.gridx =1;
    gc.gridy = 1;
    add(occupationField, gc);
    
    // Final Row
    gc.weighty = 10;
    
    gc.anchor = GridBagConstraints.FIRST_LINE_START;
    gc.gridx =1;
    gc.gridy = 2;
    add(addBtn , gc);
    }
}
