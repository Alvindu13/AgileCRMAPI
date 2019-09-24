package com.agilecrm.api;

import com.agilecrm.stubs.Event;
import com.agilecrm.stubs.EventCollection;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class EventAPI {

        /**
         * Holds a {@link WebResource} object
         */
        private final WebResource resource;

        /**
         * Initializes the field resource with the configured resource from
         * {@link APIManager}
         *
         * @param resource
         * {@link WebResource}
         */
        EventAPI(WebResource resource)
        {
            this.resource = resource;
        }

        /**
         * Adds a deal to Agile CRM with the given {@link Event} object
         *
         * @param event
         * {@link Event} to be added
         * @return Added {@link Event}
         * @throws Exception
         */
        public Event addEvent (Event event) throws Exception
        {
            System.out.println("Adding Event ----------------------------------");

            if (event == null) {
                throw new Exception("Cannot create a event without a Event object");
            }

            event = resource.path("/api/events")
                    .accept(MediaType.APPLICATION_XML).post(Event.class, event);

            return event;
        }


        /**
         * Retrieves all deals from agents Agile CRM account
         *
         * @return {@link List} of {@link Event}
         * @throws Exception
         */
        public List<Event> getEvents ()
        {
            System.out.println("Getting event --------------------------------");

            EventCollection eventCollection = resource.path("/api/events")
                    .accept(MediaType.APPLICATION_JSON).get(EventCollection.class);

            return eventCollection.getEvents();
        }

        /**
         * Retrieves the {@link Event} from Agile CRM based on its Id
         *
         * @param contactId
         *            {@link String} id of the {@link Event}
         * @return {@link Event}
         * @throws Exception
         */
        public List<Event> getEventsByContactId (String contactId) throws Exception
        {
            System.out.println("Getting events by id ---------------------------");

            EventCollection eventCollection = resource.path("/api/contacts/"+contactId+"/events/sort")
                    .accept(MediaType.APPLICATION_JSON).get(EventCollection.class);

            return eventCollection.getEvents();
        }
}
