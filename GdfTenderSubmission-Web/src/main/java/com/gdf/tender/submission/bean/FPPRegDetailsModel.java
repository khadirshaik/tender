package com.gdf.tender.submission.bean;

import java.util.Set;

public class FPPRegDetailsModel {

	private String gdfGenericCode;

	private String fppRegStatus;

	private String tenderReferenceNumber;

	private String gdfTenderItemMatRefID;
	
	private String fppRegId;

	private String listOfCountries;
	
	private int noOfCountries;

	private boolean fppRegAcceptedStatus;

	private String tenderFPPRegRefNumber;
	
	Set<String> countryNames;
	
	private long tenderItemNumber;
	
	


	public long getTenderItemNumber() {
		return tenderItemNumber;
	}

	public void setTenderItemNumber(long tenderItemNumber) {
		this.tenderItemNumber = tenderItemNumber;
	}

	public String getGdfTenderItemMatRefID() {
		return gdfTenderItemMatRefID;
	}

	public void setGdfTenderItemMatRefID(String gdfTenderItemMatRefID) {
		this.gdfTenderItemMatRefID = gdfTenderItemMatRefID;
	}

	public Set<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(Set<String> countryNames) {
		this.countryNames = countryNames;
	}

	public String getGdfGenericCode() {
		return gdfGenericCode;
	}

	public void setGdfGenericCode(String gdfGenericCode) {
		this.gdfGenericCode = gdfGenericCode;
	}

	public String getFppRegStatus() {
		return fppRegStatus;
	}

	public void setFppRegStatus(String fppRegStatus) {
		this.fppRegStatus = fppRegStatus;
	}

	public String getTenderReferenceNumber() {
		return tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		this.tenderReferenceNumber = tenderReferenceNumber;
	}

	

	public String getFppRegId() {
		return fppRegId;
	}

	public void setFppRegId(String fppRegId) {
		this.fppRegId = fppRegId;
	}

	public String getListOfCountries() {
		return listOfCountries;
	}

	public void setListOfCountries(String listOfCountries) {
		this.listOfCountries = listOfCountries;
	}

	public int getNoOfCountries() {
		return noOfCountries;
	}

	public void setNoOfCountries(int noOfCountries) {
		this.noOfCountries = noOfCountries;
	}

	public boolean isFppRegAcceptedStatus() {
		return fppRegAcceptedStatus;
	}

	public void setFppRegAcceptedStatus(boolean fppRegAcceptedStatus) {
		this.fppRegAcceptedStatus = fppRegAcceptedStatus;
	}

	public String getTenderFPPRegRefNumber() {
		return tenderFPPRegRefNumber;
	}

	public void setTenderFPPRegRefNumber(String tenderFPPRegRefNumber) {
		this.tenderFPPRegRefNumber = tenderFPPRegRefNumber;
	}

	@Override
	public String toString() {
		return "FPPRegDetailsModel [gdfGenericCode=" + gdfGenericCode + ", fppRegStatus=" + fppRegStatus
				+ ", tenderReferenceNumber=" + tenderReferenceNumber + ", gdfTenderItemMatRefID="
				+ gdfTenderItemMatRefID + ", fppRegId=" + fppRegId + ", listOfCountries=" + listOfCountries
				+ ", noOfCountries=" + noOfCountries + ", fppRegAcceptedStatus=" + fppRegAcceptedStatus
				+ ", tenderFPPRegRefNumber=" + tenderFPPRegRefNumber + ", countryNames=" + countryNames
				+ ", tenderItemNumber=" + tenderItemNumber + "]";
	}
	
	

}
