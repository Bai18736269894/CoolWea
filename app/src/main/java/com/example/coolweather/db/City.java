package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

public class City extends DataSupport {
    private int id;
    private String cityname;
    private int citycode;
    private int provinceid;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCityname(){
        return cityname;
    }
    public void setCityname(String cityname){
        this.cityname=cityname;
    }
    public int getCitycode(){
        return citycode;
    }
    public void setCitycode(int citycode){
        this.citycode=citycode;
    }
    public int getProvinceid(){
        return provinceid;
    }
    public void setProvinceid(int provinceid){
        this.provinceid=provinceid;
    }
}
