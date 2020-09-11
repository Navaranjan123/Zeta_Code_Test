package com.he.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddressBook {

    public AddressBook() {
        //TODO
    }
    private List<Contact> contactList = new CopyOnWriteArrayList<Contact>();
	
	public static boolean isStringOnlyAlphabet(String str) 
	{ 
	    return ((!str.equals("")) 
	            && (str != null) && (str.matches("^[a-zA-Z0-255 ]*$"))); 
	}
	public static boolean checkMobileNumber(String str) 
	{ 
	    return ((!str.equals("")) 
	            && (str != null)  && (str.length() ==10 ) && (str.matches("^[0-9a-zA-Z]+$"))); 
	}


    public void addContact(Contact contact) {
    	
            if(contactList != null && contactList.size() >0 && contact.getName() != null) {
			
			  for (Contact contact1 : contactList) {
				   if(contact1.getName().equalsIgnoreCase(contact.getName())) {
					  try {
					    throw new Exception("Name already exist ! pls enter new name");
					  }catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}else {
					contactList.add(contact);
				}
			 }
		   }else {
			   contactList.add(contact);
		   }

    }

    public void deleteContact(String name) {
    	
    		if (name != null && !name.isEmpty()) {
     			  for (Contact contact : contactList) {
    			  if(contact.getName().equalsIgnoreCase(name)) {
    			  contactList.remove(contact); 
    			  }else {
    				  try { throw new Exception("Not Exist");
    			  }catch (Exception e) { 
    			  System.out.println(e.getMessage()); 
    			  } } }
    			 
    		} else {
    			try {
    				throw new Exception("contact Name Empty ! Please enetr Name");
    			} catch (Exception e) {
     				System.out.println(e.getMessage());
    			}
    		}

    	}
    	

    

    public void updateContact(String name, Contact contact) {
    	
    		if(contact !=null) {
    			if(name.equalsIgnoreCase(contact.getName())) {
    				try {
    					throw new Exception("Duplicate value");
    				} catch (Exception e) {
    					// TODO: handle exception
    					System.out.println(""+e.getCause());
    				}
    			}else {
    				contact.setName(name);
    				
    			}
    		
    		}
       }

    public List<Contact> searchByName(String name) {
    	
    		if(contactList != null && contactList.size()>0 && (name.trim() != null && !name.trim().isEmpty())) {
    			List<Contact> searchContact=new ArrayList<Contact>();
    			for (Contact contact : contactList) {
    				if(contact.getName().toLowerCase().contains(name.toLowerCase())) {
    					searchContact.add(contact);
    					return searchContact;
    				}else {
    					System.out.println("contact not exist");
    				}
    			}
    		}else {
    			if(name.trim().isEmpty()) {
    				return contactList;
    			}
    		}
    	
        return null;
    }

    public List<Contact> searchByOrganisation(String organisation) {
    	
    		if(contactList != null && contactList.size()>0 && (organisation.trim() != null && !organisation.trim().isEmpty())) {
    			List<Contact> searchContact=new ArrayList<Contact>();
    			for (Contact contact : contactList) {
    				if(contact.getOrganisation().toLowerCase().contains(organisation.toLowerCase())) {
    					searchContact.add(contact);
    					return searchContact;
    				}else {
    					System.out.println("contact not exist");
    				}
    			}
    		}else {
    			if(organisation.trim().isEmpty()) {
    				return contactList;
    			}
    		}
    
        return null;
    }
 

}