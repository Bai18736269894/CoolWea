package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.CoolWeaDB;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Utility {
    public static boolean handleProvinceResponse(String response){//返回省级数据
        CoolWeaDB coolWeaDB=null;
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvincename(provinceObject.getString("name"));
                    province.setProvincecode(provinceObject.getString("id"));
                    coolWeaDB.saveProvince(province);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    public static boolean handleCityResponse(String response,int provinceid){//返回城市数据
        CoolWeaDB coolWeaDB=null;
        if(!TextUtils.isEmpty(response)){
                try {
                    JSONArray allcitys=new JSONArray(response);
                    for(int i=0;i<allcitys.length();i++){
                        JSONObject cityObject =allcitys.getJSONObject(i);
                        City city=new City();
                        city.setCityname(cityObject.getString("name"));
                        city.setCitycode(cityObject.getString("id"));
                        city.setProvinceid(provinceid);
                        coolWeaDB.saveCity(city);
                    }
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
                return false;
            }
    public static boolean handleCountyResponse(String response,int cityid){
        CoolWeaDB coolWeaDB=null;
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allcountys=new JSONArray(response);
                for(int i=0;i<allcountys.length();i++){
                    JSONObject countyObject=allcountys.getJSONObject(i);
                    County county=new County();
                    county.setCountyname(countyObject.getString("name"));
                    county.setWeatherid(countyObject.getString("Weather_id"));
                    county.setCityid(cityid);
                    coolWeaDB.saveCounty(county);
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
