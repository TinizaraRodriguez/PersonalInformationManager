
package personalinformationmanager.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import personalinformationmanager.model.ContactModel;
import personalinformationmanager.view.ContactEditView;

public class ContactEditController implements ActionListener {
    private ContactModel contactModel;
    private ContactEditView contactEditView;
    
    public ContactEditController (ContactModel contactModel, ContactEditView contactEditView){
        this.contactModel = contactModel;
        this.contactEditView = contactEditView;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("actionPerformed ini...");
        Object source = event.getSource();
        if (source == contactEditView.getUpdateButtonRef()){
            System.out.println("actionPerformed: if...");
            updateModel();
        }
    }
    
    private void updateModel(){
        System.out.println("updateModel: init...");
        String firstName = null;
        String lastName = null;
        
        if (isAlphabet(this.contactEditView.getFirstName())){
            firstName = this.contactEditView.getFirstName();
                    
        }
        
        if(isAlphabet(this.contactEditView.getLastName())){
            lastName = this.contactEditView.getLastName();
        }
        
        this.contactModel.updateContactModel(firstName, lastName, this.contactEditView.getTitle(), this.contactEditView.getOrganization());
    }
    
    private boolean isAlphabet (String input){
        char [] testChars = {'1', '2', '3', '4', '5', '6'. '7', '8', '9', '0'};
        for (int i = 0; i < testChars.length; i++) {
            if (input.indexOf(testChars[i]) !=-1){
                return false;
            }
        }
        
        return true;
    }
    
}
