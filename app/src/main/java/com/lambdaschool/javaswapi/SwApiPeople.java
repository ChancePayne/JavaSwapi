package com.lambdaschool.javaswapi;

import java.util.List;

public class SwApiPeople {
    private String count;
    private String next, previous;
    private List<Person> results;

    public SwApiPeople(String count, String next, String previous, List<Person> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public List<Person> getResults() {
        return results;
    }

    public String getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }
}
