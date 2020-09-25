package com.example.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CoolWeaDB {//数据库封装类
    private CoolWeatherOpenHelpler dbhelper;
    SQLiteDatabase db;
    String TAG="CoolWeaDB";
    private static CoolWeaDB coolWeaDB;
    public static final String NAME="cool";
    private CoolWeaDB(Context context){
        CoolWeatherOpenHelpler coolWeatherOpenHelpler=new CoolWeatherOpenHelpler(context,NAME,null,1);
        db=dbhelper.getWritableDatabase();
    }
    public synchronized static CoolWeaDB getInstance(Context context){
        if(coolWeaDB==null)
            coolWeaDB=new CoolWeaDB(context);
        return coolWeaDB;
    }
    public void saveProvince(Province province){//将服务器中读取到的信息存入数据库中
        if(province!=null){
            ContentValues values=new ContentValues();
            values.put("provincename",province.getProvincename());
            values.put("provincecode",province.getProvincecode());
            db.insert("Province",null,values);
        }
    }

    public List<Province> loadprovince(){//从数据库读取省份信息
        List<Province> list=new ArrayList<Province>();
        Cursor cursor=db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Province province=new Province();
                province.setID(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvincename(cursor.getString(cursor.getColumnIndex("provincename")));
                province.setProvincecode(cursor.getString(cursor.getColumnIndex("provincecode")));
                list.add(province);
            }while(cursor.moveToNext());
        }
        if(cursor!=null)
            cursor.close();
        return list;
    }
    public void saveCity(City city){//将解析出来的城市信息存储到数据库中
        if(city!=null){
            ContentValues values=new ContentValues();
            values.put("cityname",city.getCityname());
            values.put("citycode",city.getCitycode());
            values.put("provinceid",city.getProvinceid());
            db.insert("City",null,values);
        }
    }

    public List<City> loadcity(){//从数据库往列表中那个显示信息
        List<City> list=new ArrayList<City>();
        Cursor cursor=db.query("City",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                City city=new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityname(cursor.getString(cursor.getColumnIndex("cityname")));
                city.setCitycode(cursor.getString(cursor.getColumnIndex("citycode")));
                city.setProvinceid(cursor.getInt(cursor.getColumnIndex("provinceid")));
                list.add(city);
            }while(cursor.moveToNext());
        }
        if(cursor!=null)
            cursor.close();
        return list;
    }

    public void saveCounty(County county){//将解析出来的县的信息存储到数据库中
        if(county!=null){
            ContentValues values=new ContentValues();
            values.put("countyname",county.getCountyname());
            values.put("countycode",county.getCountycode());
            values.put("cityid",county.getCityid());
            db.insert("County",null,values);
        }
    }

    public List<County> loadcounty(){//从数据库往县列表里显示信息
        List<County> list=new ArrayList<County>();
        Cursor cursor=db.query("County",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                County county=new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyname(cursor.getString(cursor.getColumnIndex("countyname")));
                county.setCountycode(cursor.getString(cursor.getColumnIndex("countycode")));
                county.setCityid(cursor.getInt(cursor.getColumnIndex("cityid")));
                county.setWeatherid(cursor.getString(cursor.getColumnIndex("weatherid")));
                list.add(county);

            }while (cursor.moveToNext());
        }
        if (cursor!=null)
            cursor.close();
        return list;
    }

}
