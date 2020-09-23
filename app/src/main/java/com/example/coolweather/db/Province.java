package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport {
        private int ID;
        private String provincename;
        private int provincecode;
        public int getID(){
            return ID;
        }
        public void setID(int ID){
            this.ID=ID;
        }
        public String getProvincename(){
            return provincename;
        }
        public void setProvincename(String provincename){
            this.provincename=provincename;
        }
        public int getProvincecode(){
            return provincecode;
        }
        public void setProvincecode(int provincecode){
            this.provincecode=provincecode;
        }
}
