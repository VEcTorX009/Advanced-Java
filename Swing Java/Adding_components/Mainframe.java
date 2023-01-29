package Adding_components;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Mainframe extends JFrame{
    public Mainframe(String title)
    {
        super(title);

        //    Set layout manager 
        //➡️ decides what to arrange the componenets on the frame
        
        setLayout(new BorderLayout());
        
        //    Create Swing component
        //➡️
        
        final JTextArea textArea = new JTextArea();
        JButton button = new JButton("Click here");
        
        //     Add swing components to content Pane
        //➡️

        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);

        //     Add Behaviour
        //➡️

        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Congo on new app 😀\n");
            }
            

        });
    }
}
