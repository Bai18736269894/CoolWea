package com.example.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CoolWeatherOpenHelpler extends SQLiteOpenHelper {//列表信息
    String TAG="CoolWeatherOpenHelpler";
    public static final String create_province="create table Province("
            +"id integer primary key autoincrement,"
            +"provincename text,"//name
            +"provincecode text)";//code
    public static final String create_city="create table City("
            +"id integer primary key autoincrement,"
            +"cityname text,"//name
            +"citycode text,"//code
            +"provinceid integer)";//所属省的id
    public static final String create_county="create table County("
            +"id integer primary key autoincrement,"
            +"countyname text,"//name
            +"countycode text,"//code
            +"weatherid text,"
            +"cityid integer)";//所属城市id


    public CoolWeatherOpenHelpler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static CoolWeatherOpenHelpler instance;
    public static synchronized CoolWeatherOpenHelpler getinstance(Context contect, String name, SQLiteDatabase.CursorFactory factory,int version){
        if(instance==null){
            instance=new CoolWeatherOpenHelpler(contect.getApplicationContext(),name,factory,4);
        }
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigure(SQLiteDatabase db){
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(create_province);
            db.execSQL(create_city);
            db.execSQL(create_county);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Province");
            db.execSQL("drop table if exists City");
            db.execSQL("drop table if exists County");
            onCreate(db);
    }
}
