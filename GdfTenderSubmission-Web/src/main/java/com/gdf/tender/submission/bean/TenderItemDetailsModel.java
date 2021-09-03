package com.gdf.tender.submission.bean;

import java.util.List;

public class TenderItemDetailsModel {

	private long tenderItemNumber;

	private String gdfGenericCode;

	private String tenderReferenceNumber;

	private long tenderItemRefId;

	/*private String dosageForm;

	private String noOfPrimaryPackaging;

	private String noOfSecondaryPackaging;
	
	private String fppMartStatus;
	
	private String fppGenericCode;*/
	
	private String fppRegGenericCode;
	
	private List<?> listOfRegCountries;
	
	private String noOfCountries;
	
	private String fppRegApprStatus;
	

	public String getFppRegGenericCode() {
		return fppRegGenericCode;
	}

	public void setFppRegGenericCode(String fppRegGenericCode) {
		this.fppRegGenericCode = fppRegGenericCode;
	}

	public List<?> getListOfRegCountries() {
		return listOfRegCountries;
	}

	public void setListOfRegCountries(List<?> listOfRegCountries) {
		this.listOfRegCountries = listOfRegCountries;
	}

	public String getNoOfCountries() {
		return noOfCountries;
	}

	public void setNoOfCountries(String noOfCountries) {
		this.noOfCountries = noOfCountries;
	}

	public String getFppRegApprStatus() {
		return fppRegApprStatus;
	}

	public void setFppRegApprStatus(String fppRegApprStatus) {
		this.fppRegApprStatus = fppRegApprStatus;
	}

	

	public long getTenderItemRefId() {
		return tenderItemRefId;
	}

	public void setTenderItemRefId(long tenderItemRefId) {
		this.tenderItemRefId = tenderItemRefId;
	}

	public long getTenderItemNumber() {
		return tenderItemNumber;
	}

	public void setTenderItemNumber(long tenderItemNumber) {
		this.tenderItemNumber = tenderItemNumber;
	}

	public String getGdfGenericCode() {
		return gdfGenericCode;
	}

	public void setGdfGenericCode(String gdfGenericCode) {
		this.gdfGenericCode = gdfGenericCode;
	}


	public String getTenderReferenceNumber() {
		return tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		this.tenderReferenceNumber = tenderReferenceNumber;
	}

	

	@Override
	public String toString() {
		return "TenderItemDetailsModel [tenderItemNumber=" + tenderItemNumber + ", gdfGenericCode=" + gdfGenericCode
				+ ", tenderReferenceNumber=" + tenderReferenceNumber + ", tenderItemRefId=" + tenderItemRefId
				+ ", fppRegGenericCode=" + fppRegGenericCode + ", listOfRegCountries=" + listOfRegCountries
				+ ", noOfCountries=" + noOfCountries + ", fppRegApprStatus=" + fppRegApprStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (tenderItemRefId ^ (tenderItemRefId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenderItemDetailsModel other = (TenderItemDetailsModel) obj;
		if (tenderItemRefId != other.tenderItemRefId)
			return false;
		return true;
	}

}
