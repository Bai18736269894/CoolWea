package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

public class Province {
        private int ID;
        private String provincename;
        private String provincecode;
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
        public String getProvincecode(){
            return provincecode;
        }
        public void setProvincecode(String provincecode){
            this.provincecode=provincecode;
        }
}
