package org.example;

public class Copy {

    String copyID;
    Boolean available = true;
    public Copy(String copyID){
        this.copyID = copyID;
    }

    public String getCopyID() {
        return copyID;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }
}
