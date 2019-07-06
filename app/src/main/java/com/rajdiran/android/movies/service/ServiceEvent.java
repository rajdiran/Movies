package com.rajdiran.android.movies.service;

public class ServiceEvent<T> {

    private T response;

    private String eventId;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

}
