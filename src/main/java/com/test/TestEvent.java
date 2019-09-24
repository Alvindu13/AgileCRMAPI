package com.test;


import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.ContactField;
import com.agilecrm.stubs.Tag;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestEvent {
    public static void main(String[] args)
    {

        try
        {
            String baseUrl = "https://jeremie13.agilecrm.com/dev";
            String userEmail = "jeremie@edreamest.com";
            String restAPIKey = "nc969d2826rn781onbeupc9dr5";

            // Create a connection to Agile CRM
            APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

            ContactAPI contactApi = apiManager.getContactAPI();

            // List of tags to add it to contact
            List<String> tags;

            // -------------------- Adding a company --------------------------
            Contact company = new Contact();

            company.setType(Contact.Type.COMPANY);
            company.setContactField(ContactField.FieldName.COMPANY, "ClickDesk");
            company.setContactField(ContactField.FieldName.URL, "https://www.clickdesk.com");

            tags = new ArrayList<String>();
            tags.add("Product based");
            tags.add("Service based");
            company.setTags(tags);

            company = contactApi.addContact(company);

            System.out.println("Added company... " + company);

            // -------------------- Adding a company end ------------------------

            // ------------------- Adding a person ----------------------------
            Contact person1 = new Contact();

            person1.setType(Contact.Type.PERSON);
            person1.setLead_score(3);
            person1.setContactField(ContactField.FieldName.FIRST_NAME, "Annie");
            person1.setContactField(ContactField.FieldName.LAST_NAME, "Besant");
            person1.setContactField(ContactField.FieldName.ORGANIZATION, "London School Board");
            person1.setContactField(ContactField.FieldName.EMAIL, "annie@henry.com");
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

            tags = new ArrayList<String>();
            tags.add("developer");
            tags.add("subscribe");
            tags.add("connection");
            person1.setTags(tags);

            //person1 = contactApi.addContact(person1);

            System.out.println("Added person... " + person1);

            // ------------------- Adding a person end--------------------------

            // ------------------- Update Contact properties ---------------------
            String contactDeailJson = "{\"id\":5698246273925120, "
                    + "\"properties\":[{\"type\":\"SYSTEM\", \"name\":\"email\",\"value\":\"jason123@gmail.com\"},"
                    + " {\"type\":\"SYSTEM\", \"name\":\"first_name\", \"value\":\"Jason\"}, "
                    + " {\"type\":\"SYSTEM\", \"name\":\"website\", \"value\":\"https://github.com/agilecrm/rest-api\"},"
                    + " {\"type\":\"SYSTEM\", \"name\":\"address\", \"value\":'{\"address\":\"225 George Street\",\"city\":\"NSW\",\"state\":\"Sydney\",\"zip\":\"2000\",\"country\":\"Australia\"}'},"
                    + "{\"type\":\"SYSTEM\", \"name\":\"phone\", \"value\":\"918888888888\"}]}";

            contactApi.updateContactPartialUpdate(contactDeailJson);

            // ------------------- Update Contact properties end -----------------

            // --------------------- Get contacts -----------------------------
            JSONArray contacts = contactApi.getContacts("10","first_page");;

            System.out.println("All contacts.." + contacts);

            // ----------------- Get contact by contact id --------------------
            Contact contact = new Contact();

            contact = contactApi.getContact(String.valueOf("5755821854031872"));

            System.out.println("Got contact by id... " + contact);

            // ---------------- Get contact from email ------------------------
            Contact contact1 = contactApi.getContactFromEmail("annie@henry.com");

            System.out.println("Got contact by email... " + contact1);

            // ------------ Adding tag to contact based on email -------------
            Tag tag = new Tag();
            tags = new ArrayList<String>();
            tags.add("alfa1");
            tags.add("alfa2");
            tags.add("alfa3");
            tag.setTags(tags);


            contactApi.addTagsToEmail(tag, "mark@henry.com");

            System.out.println("Added tag based on email..............");

            // ---- Adding tags to contact based on contact id ---------------

            String TagsJson = "{\"id\":\"5750240208486400\",\"tags\":[\"tag1\", \"tag2\"]}";
            contactApi.addTagsByContactId(TagsJson);

            System.out.println("Added tag based on contact id..............");

            // ---------Delete tags to contact based on email ------------------
            Tag tag1 = new Tag();
            tags = new ArrayList<String>();
            tags.add("alfa2");
            tags.add("alfa4");
            tag1.setTags(tags);
            contactApi.deleteTags(tag1, "mark@henry.com");
            System.out.println("Delete tag based on email..............");

            // ------------ delete contact by contact id --------------------
            contactApi.deleteContact("5170081277411328");

            // ------------- delete bulk contacts ------------------------
            List<String> contactIds;
            contactIds = new ArrayList<String>();
            contactIds.add("5655368558444544");
            contactIds.add("5769320147714048");

            contactApi.deleteBulkContacts(contactIds);

            // ---------Add Score to a Contact using Email-ID------------------
            contactApi.addScoreToEmail("5", "mark@henry.com");
            System.out.println("Addedd score based on email..............");


            // ---------Get contacts by custom field------------------
            contactApi.getContactsByDynamicFilter("tags","Lead","5","first_page");
        }
        catch (Exception e)
        {
            System.out.println("message" + e.getMessage());
            e.printStackTrace();
        }
    }
}
