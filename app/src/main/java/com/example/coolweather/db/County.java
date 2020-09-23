package com.example.coolweather.db;

public class County {
    private int id;
    private String countyname;
    private int weatherid;
    private int cityid;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCountyname(){
        return countyname;
    }
    public void setCountyname(String countyname){
        this.countyname=countyname;
    }
    public int getWeatherid(){
        return weatherid;
    }
    public void setWeatherid(int weatherid){
        this.weatherid=weatherid;
    }
    public int getCityid(){
        return cityid;
    }
    public void setCityid(int cityid){
        this.cityid=cityid;
    }
}
