package com.agilecrm.stubs;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "events")
public class Event {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("allDay")
    private Boolean allDay;

    @JsonProperty("color")
    private String color;

    @JsonProperty("contacts")
    private String[] contacts;

    @JsonProperty("created_time")
    private Long created_time;

    @JsonProperty("end")
    private Long end;

    @JsonProperty("is_event_starred\t")
    private Boolean is_event_starred;

    @JsonProperty("start")
    private Long start;

    @JsonProperty("title")
    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }

    public Long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Long created_time) {
        this.created_time = created_time;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Boolean getIs_event_starred() {
        return is_event_starred;
    }

    public void setIs_event_starred(Boolean is_event_starred) {
        this.is_event_starred = is_event_starred;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event " +
                "[id=" + id +
                ", allDay='" + allDay + '\'' +
                ", color='" + color + '\'' +
                ", contacts=" + Arrays.toString(contacts) +
                ", created_time='" + created_time + '\'' +
                ", end=" + end +
                ", is_event_starred=" + is_event_starred +
                ", start=" + start +
                ", title='" + title + '\'' +
                ']';
    }
}

