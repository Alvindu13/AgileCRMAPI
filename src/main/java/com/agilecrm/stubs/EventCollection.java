package com.agilecrm.stubs;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "collection")
public class EventCollection
{
    private List<Event> events;

    public List<Event> getEvents()
    {
        return events;
    }

    @XmlElement(name = "events")
    public void setEvents(List<Event> events)
    {
        this.events = events;
    }
}

