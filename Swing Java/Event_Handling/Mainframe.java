package Event_Handling;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Mainframe extends JFrame{
    
    private DetailsPanel detailsPanel;

    public Mainframe(String title)
    {
        super(title);

        
        setLayout(new BorderLayout());
        
        
        final JTextArea textArea = new JTextArea();
        
        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailsListener(new DetailListener() {

            @Override
            public void detailEventOccurred(DetailEvent event) {
               String text = event.getText();
               
               textArea.append(text);
            }
        });


        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);

    }
}
