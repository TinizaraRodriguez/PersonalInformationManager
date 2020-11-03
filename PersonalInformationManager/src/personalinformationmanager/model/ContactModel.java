
package personalinformationmanager.model;

import java.util.ArrayList;
import java.util.Iterator;
import personalinformationmanager.view.ContactView;


public class ContactModel {
    private String firstName;
    private String lastName;
    private String title;
    private String organization;
    
    private ArrayList<ContactView> contactViews = new ArrayList<>();
    
    public ContactModel(){
        
    }
    
    public void addContactView (ContactView view){
        if (!contactViews.contains(view)){
            contactViews.add(view);
        }
    }
    
    public void removeView(ContactView view){
        contactViews.remove(view);
    }
    
    public String getFirtName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getOrganization(){
        return organization;
    }
    
    public void setFirstName (String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName (String lastName){
        this.lastName = lastName;
    }
    
    public void setTitle (String title){
        this.title = title;
    }
    
    public void setOrganization (String organization){
        this.organization = organization;
    }
    
    public void updateContactModel (String firstName, String lastName, String title, String organization){
        if (!firstName.isEmpty()){
            setFirstName(firstName);
        }
        
        if (!lastName.isEmpty()){
            setLastName(lastName);
        }
        
        if (!title.isEmpty()){
            setTitle(title);
        }
        
        if (!organization.isEmpty()){
            setOrganization (organization);
        }
        
        updateContactView();
        
    }
    
    public void updateContactView(){
        Iterator <ContactView> notifyContactViews = contactViews.iterator();
        while (notifyContactViews.hasNext()){
            (notifyContactViews.next()).refreshContactView(firstName, lastName, title, organization);
        }
    }
    
}
