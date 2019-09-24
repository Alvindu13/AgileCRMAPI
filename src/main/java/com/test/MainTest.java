package com.test;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.ContactField;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    private Contact contact1;

    public static void main(String[] args) {
        try
        {

            String baseUrl = "https://jeremie13.agilecrm.com/dev";
            String userEmail = "jeremie@edreamest.com";
            String restAPIKey = "nc969d2826rn781onbeupc9dr5";


            // Create a connection to Agile CRM
            APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

            // Get the Contact API with configured resource
            ContactAPI contactApi = apiManager.getContactAPI();

            // ------------------- Adding a person ----------------------------
            Contact person1 = new Contact();

            person1.setType(Contact.Type.PERSON);
            person1.setLead_score(3);
            person1.setContactField(ContactField.FieldName.FIRST_NAME, "Annie");
            person1.setContactField(ContactField.FieldName.LAST_NAME, "Besant");
            person1.setContactField(ContactField.FieldName.ORGANIZATION, "London School Board");
            person1.setContactField(ContactField.FieldName.EMAIL, "annieds2@henry.com");
            person1.setContactField(ContactField.FieldName.TITLE, "socialist");
            person1.setContactField(ContactField.FieldName.PHONE, "+48624981");
            person1.setContactField(ContactField.FieldName.WEBSITE,
                    "http://agile-crm-cloud.appspot.com");
            JSONObject address = new JSONObject();
            address.put("city", "Clapham");
            address.put("state", "London");
            address.put("country", "United Kingdom");
            person1.setContactField(ContactField.FieldName.ADDRESS, address.toString());

            person1.setCustomField("Date Of Joining", "Test Add Custom Field");

            System.err.println("personne test : " + person1);

            // List of tags to add it to contact
            List<String> tags;

            tags = new ArrayList<String>();
            tags.add("developer");
            tags.add("subscribe");
            tags.add("connection");
            person1.setTags(tags);


            // ---------------- ADD CONTACT ------------------------
            //person1 = contactApi.addContact(person1);

            // ---------------- Get contact from email ------------------------
            Contact contact1 = contactApi.getContactFromEmail("annieds2@henry.com");
            System.out.println(contact1.getProperties().get(1).getValue());

            System.err.println("Got contact by email... " + contact1);




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
