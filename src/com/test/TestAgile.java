package com.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Contact.Type;
import com.agilecrm.stubs.ContactField.FieldName;

public class TestAgile
{
    public static void main(String[] args)
    {
	try
	{

		String baseUrl = "https://jeremie13.agilecrm.com/dev";
		String userEmail = "jeremie@edreamest.com";
		String restAPIKey = "nc969d2826rn781onbeupc9dr5";
		/*
	    String baseUrl = "https://labatisse.agilecrm.com/dev";
	    String userEmail = "alexandre@labatisse.org";
	    String restAPIKey = "dmb4uph5fceeha5i7r4gho7enj";
	    */

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

	    // Get the Contact API with configured resource
	    ContactAPI contactApi = apiManager.getContactAPI();

	 // ------------------- Adding a person ----------------------------
	    Contact person1 = new Contact();

	    person1.setType(Type.PERSON);
	    person1.setLead_score(3);
	    person1.setContactField(FieldName.FIRST_NAME, "Annie");
	    person1.setContactField(FieldName.LAST_NAME, "Besant");
	    person1.setContactField(FieldName.ORGANIZATION, "London School Board");
	    person1.setContactField(FieldName.EMAIL, "annieds2@henry.com");
	    person1.setContactField(FieldName.TITLE, "socialist");
	    person1.setContactField(FieldName.PHONE, "+48624981");
	    person1.setContactField(FieldName.WEBSITE,
		    "http://agile-crm-cloud.appspot.com");
	    JSONObject address = new JSONObject();
	    address.put("city", "Clapham");
	    address.put("state", "London");
	    address.put("country", "United Kingdom");
	    person1.setContactField(FieldName.ADDRESS, address.toString());
	    
	    person1.setCustomField("Date Of Joining", "Test Add Custom Field");
	    
	    // List of tags to add it to contact
	    List<String> tags;
	    
	    tags = new ArrayList<String>();
	    tags.add("developer");
	    tags.add("subscribe");
	    tags.add("connection");
	    person1.setTags(tags);

	   // person1 = contactApi.addContact(person1);
	    
	   // Update a contact
	 // ------------------- Update Contact properties ---------------------
	    String contactDeailJson = "{\"id\":4791549457989632, "
	    	+ "\"properties\":["
	    	+ " {\"type\":\"SYSTEM\", \"name\":\"first_name\", \"value\":\"Jason\"}, "
	    	+ " {\"type\":\"SYSTEM\", \"name\":\"address\", \"value\":'{\"address\":\"225 George Street\",\"city\":\"NSW\",\"state\":\"Sydney\",\"zip\":\"2000\",\"country\":\"Australia\"}'},"
	    	+ "{\"type\":\"CUSTOM\", \"name\":\"My custom field of type date\", \"value\":\"1481871525\"}]}";
	    
            contactApi.updateContactPartialUpdate(contactDeailJson); 
	    
	    
	    
	    
	   // ---------Get contacts by filter field------------------
	   // pass type of filter,filter value,page_size,cursor 
	   //contactApi.getContactsByDynamicFilter("tags","Lead","5","first_page");
	    
	  // Get list of contacts based on page size and cursor 
	  //contactApi.getContacts("10","first_page");
	    
	    
	}
	catch (Exception e)
	{
	    System.out.println("Exception message.. " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
