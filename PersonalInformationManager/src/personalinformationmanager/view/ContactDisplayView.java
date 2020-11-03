
package personalinformationmanager.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ContactDisplayView extends JPanel implements ContactView {
    private JTextArea display;
    
    public ContactDisplayView(){
        createGUI();;
    }
    
    @Override
    public void refreshContactView (String firstName, String lastName, String title, String organization){
        display.setText("UPDATE CONTACT: \nNEW VALUES: \n\tName: " + firstName + " " + lastName + "\n\tTitle: " + title + "\n\tOrganization: " + organization);
    }

    private void createGUI() {
        setLayout (new BorderLayout());
        display = new JTextArea (10,40);
        display.setEditable(false);
        JScrollPane scrollDisplay = new JScrollPane (display);
        this.add(scrollDisplay, BorderLayout.CENTER);
    }
    
    
}
