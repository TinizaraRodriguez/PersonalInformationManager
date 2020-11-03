
package personalinformationmanager.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import personalinformationmanager.control.ContactEditController;
import personalinformationmanager.model.ContactModel;



public class ContactEditView extends JPanel implements ContactView {
    private static final String UPDATE_BUTTON = "Update";
    private static final String EXIT_BUTTON = "Exit";
    private static final String CONTACT_FIRST_NAME = "First Name";
    private static final String CONTACT_LAST_NAME = "Last Name";
    private static final String CONTACT_TITLE = "Title";
    private static final String CONTACT_ORGANIZATION = "Organization";
    
    private static final int FIRST_NAME_COLUMN_WIDTH = 25;
    private static final int LAST_NAME_COLUMN_WIDTH = 40;
    private static final int TITLE_COLUMN_WIDTH = 25;
    private static final int ORGANIZATION_COLUMN_WIDTH = 40;
    
    private ContactEditController contactEditController;
    
    private JLabel firstNameLabel, lastNameLabel, titleLabel, organizationLabel;
    private JTextField firstNameTextField, lastNameTextField, titleTextField, organizationTextField;
    private JButton updateButton, exitButton;
    
    public ContactEditView(ContactModel contactModel){
        this.contactEditController = new ContactEditController(contactModel, this);
        createGUI();
    }
    
    private void createGUI(){
        this.updateButton = new JButton(UPDATE_BUTTON);
        this.exitButton = new JButton (EXIT_BUTTON);
        
        this.firstNameLabel = new JLabel (CONTACT_FIRST_NAME);
        this.lastNameLabel = new JLabel (CONTACT_LAST_NAME);
        this.titleLabel = new JLabel (CONTACT_TITLE);
        this.organizationLabel = new JLabel (CONTACT_ORGANIZATION);
        
        this.firstNameTextField = new JTextField (FIRST_NAME_COLUMN_WIDTH);
        this.lastNameTextField = new JTextField (LAST_NAME_COLUMN_WIDTH);
        this.titleTextField = new JTextField (TITLE_COLUMN_WIDTH);
        this.organizationTextField = new JTextField (ORGANIZATION_COLUMN_WIDTH);
        
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));
        
        JPanel LabelPanel = new JPanel();
        LabelPanel.setLayout(new GridLayout(0,1));
        
        LabelPanel.add(this.firstNameLabel);
        LabelPanel.add(this.lastNameLabel);
        LabelPanel.add(this.titleLabel);
        LabelPanel.add(this.organizationLabel);
        
        editPanel.add(LabelPanel);
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(0,1));
        
        textFieldPanel.add(this.firstNameTextField);
        textFieldPanel.add(this.lastNameTextField);
        textFieldPanel.add(this.titleTextField);
        textFieldPanel.add(this.organizationTextField);
        
        editPanel.add(textFieldPanel);
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(this.updateButton);
        controlPanel.add(this.exitButton);
        this.updateButton.addActionListener((ActionListener) this.contactEditController);
        this.exitButton.addActionListener(new ExitHandler());
        
        setLayout(new BorderLayout());
        add(editPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

    }
    
    public Object getUpdateButtonRef(){
        return this.updateButton;
    }
    
    public String getFirstName(){
        return this.firstNameTextField.getText();
    }
    
    public String getLastName(){
        return this.lastNameTextField.getText();
    }
    
    public String getTitle(){
        return this.titleTextField.getText();
    }
    
    public String getOrganization(){
        return this.organizationTextField.getText();
    }
    
    
    @Override
    public void refreshContactView (String firstName, String lastName, String title, String organization){
        this.firstNameTextField.setText(firstName);
        this.lastNameTextField.setText(lastName);
        this.titleTextField.setText(title);
        this.organizationTextField.setText(organization);
    }
    
    private static class ExitHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            System.exit(0);
        }
    }
    
}
