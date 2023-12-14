
package com.spring.gta.control.vo;

//필드와 게터/세터 메서드 등을 포함한 클래스 정의
public class ControlVO {
 private int bwFloor;
 private String date;
 private double bwInDegc;
 private double bwOutDegc;
 private double bwInLux;
 private double bwOutSun;
 
 
 
public ControlVO() {
	
}
public int getBwFloor() {
	return bwFloor;
}
public void setBwFloor(int bwFloor) {
	this.bwFloor = bwFloor;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public double getBwInDegc() {
	return bwInDegc;
}
public void setBwInDegc(double bwInDegc) {
	this.bwInDegc = bwInDegc;
}
public double getBwOutDegc() {
	return bwOutDegc;
}
public void setBwOutDegc(double bwOutDegc) {
	this.bwOutDegc = bwOutDegc;
}
public double getBwInLux() {
	return bwInLux;
}
public void setBwInLux(double bwInLux) {
	this.bwInLux = bwInLux;
}
public double getBwOutSun() {
	return bwOutSun;
}
public void setBwOutSun(double bwOutSun) {
	this.bwOutSun = bwOutSun;
}
@Override
public String toString() {
	return "ControlVO [bwFloor=" + bwFloor + ", date=" + date + ", bwInDegc=" + bwInDegc + ", bwOutDegc=" + bwOutDegc
			+ ", bwInLux=" + bwInLux + ", bwOutSun=" + bwOutSun + "]";
}

 
 
 
 
 
}

    
    
