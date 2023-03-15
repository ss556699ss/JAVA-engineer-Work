package com.mark.javaengineerwork.resttemplate.model;

import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;

import java.util.Map;

public class CoinDesk {

   public Time time;
   public String disclaimer;
   public String chartName;
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

   public String getDisclaimer() {
      return disclaimer;
   }

   public void setDisclaimer(String disclaimer) {
      this.disclaimer = disclaimer;
   }

   public String getChartName() {
      return chartName;
   }

   public void setChartName(String chartName) {
      this.chartName = chartName;
   }
}
