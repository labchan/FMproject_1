package com.example.fmproject_1.Model;

public class workOrder
{
    int id;
    String location, building, contact, tel, description;
   // int img;

    public workOrder(int id, String location, String building, String contact, String tel, String description) {
        this.id = id;
        this.location = location;
        this.building = building;
        this.contact = contact;
        this.tel = tel;
        this.description = description;
        //this.img = img;
    }

    public workOrder(){};


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    } */
}
