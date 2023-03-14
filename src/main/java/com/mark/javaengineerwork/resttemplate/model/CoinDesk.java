package com.mark.javaengineerwork.resttemplate.model;

import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;

import java.util.Map;

public class CoinDesk {

   public Time time;
   public Map<String, Bpi> bpi;

   public Time getTime() {
      return time;
   }

   public void setTime(Time time) {
      this.time = time;
   }

   public Map<String, Bpi> getBpi() {
      return bpi;
   }

   public void setBpi(Map<String, Bpi> bpi) {
      this.bpi = bpi;
   }
}
