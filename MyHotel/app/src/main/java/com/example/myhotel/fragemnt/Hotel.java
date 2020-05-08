package com.example.myhotel.fragemnt;

public class Hotel {

    private int photoId;
    private String adress;
    private String name;

    public  Hotel(){

    }
    public  Hotel(int photoId,String adress,String name){
        this.photoId=photoId;
        this.name=name;
        this.adress=adress;

    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    public String getAdress(){
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
