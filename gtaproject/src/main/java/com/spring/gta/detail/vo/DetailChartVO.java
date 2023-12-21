package com.spring.gta.detail.vo;

public class DetailChartVO {
	private String beFloor;
	private String label;
	private float  beAcEnergy;
	private float  bePlugEnergy;
	private float  beLightEnergy;
	private String currentDataset;
	
	public DetailChartVO() {
		
	}
	
	public String getCurrentDataset() {
		return currentDataset;
	}

	public void setCurrentDataset(String currentDataset) {
		this.currentDataset = currentDataset;
	}

	public String getBeFloor() {
		return beFloor;
	}
	public void setBeFloor(String beFloor) {
		this.beFloor = beFloor;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public float getBeAcEnergy() {
		return beAcEnergy;
	}
	public void setBeAcEnergy(float beAcEnergy) {
		this.beAcEnergy = beAcEnergy;
	}
	public float getBePlugEnergy() {
		return bePlugEnergy;
	}
	public void setBePlugEnergy(float bePlugEnergy) {
		this.bePlugEnergy = bePlugEnergy;
	}
	public float getBeLightEnergy() {
		return beLightEnergy;
	}
	public void setBeLightEnergy(float beLightEnergy) {
		this.beLightEnergy = beLightEnergy;
	}

	@Override
	public String toString() {
		return "DetailChartVO [beFloor=" + beFloor + ", label=" + label + ", beAcEnergy=" + beAcEnergy
				+ ", bePlugEnergy=" + bePlugEnergy + ", beLightEnergy=" + beLightEnergy + ", currentDataset="
				+ currentDataset + "]";
	}
	

	
}
