package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

public class County {
    private int id;
    private String countyname;
    private String countycode;
    private String weatherid;
    private int cityid;
    public String getCountycode(){return countycode;}
    public void setCountycode(String countycode){this.countycode=countycode;}
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
    public String getWeatherid(){
        return weatherid;
    }
    public void setWeatherid(String weatherid){
        this.weatherid=weatherid;
    }
    public int getCityid(){
        return cityid;
    }
    public void setCityid(int cityid){
        this.cityid=cityid;
    }
}
