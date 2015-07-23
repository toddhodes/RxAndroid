package com.example.rxandroid.api;

/**
 */
public class Representative {
    public String name;
    public String party;
    public String state;
    public String district;
    public String phone;
    public String office;
    public String link;

    public boolean isFunny;

    public String toString() {
       return "[Representative "
           + " name=" + name
           + " party=" + party
           + " state=" + state
           + " district=" + district
           + " phone=" + phone
           + " office=" + office
           + " link=" + link
           + "]";
    }
}
