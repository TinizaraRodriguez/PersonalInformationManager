
package personalinformationmanager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import personalinformationmanager.model.ContactModel;
import personalinformationmanager.view.ContactDisplayView;
import personalinformationmanager.view.ContactEditView;


public class PersonalInformationManager {

    public static void main(String[] args) {
        ContactModel contactModel = new ContactModel();
        
        ContactEditView contactEditView = new ContactEditView(contactModel);
        contactModel.addContactView(contactEditView);
        createGUI(contactEditView, "Contact Edit Window");
        
        ContactEditView contactEditView2 = new ContactEditView(contactModel);
        contactModel.addContactView(contactEditView2);
        createGUI(contactEditView2, "Contact Edit Window 2");
        
        
        ContactDisplayView contactDisplayView = new ContactDisplayView();
        contactModel.addContactView(contactDisplayView);
        createGUI(contactDisplayView, "Contact Display View");

    }
    
    private static void createGUI(JPanel contents, String windowTitle){
        JFrame applicationFrame = new JFrame (windowTitle);
        applicationFrame.getContentPane().add(contents);
        applicationFrame.addWindowListener(new WindowCloseManager());
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }
    
    private static class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
        }
    }
    
}
