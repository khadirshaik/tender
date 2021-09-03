package com.gdf.tender.details.bean;

public class TenderItemDetailsModel {
	
	private long tenderItemNumber;
	
	private String gdfGenericCode;
	
	private String generalDescription;
	
	private String primaryPackaging;
	
	private String secondaryPackaging;
	
	private String tenderReferenceNumber;
	
	private long tenderItemRefId;
	
	

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

	public String getGeneralDescription() {
		return generalDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public String getPrimaryPackaging() {
		return primaryPackaging;
	}

	public void setPrimaryPackaging(String primaryPackaging) {
		this.primaryPackaging = primaryPackaging;
	}

	public String getSecondaryPackaging() {
		return secondaryPackaging;
	}

	public void setSecondaryPackaging(String secondaryPackaging) {
		this.secondaryPackaging = secondaryPackaging;
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
				+ ", generalDescription=" + generalDescription + ", primaryPackaging=" + primaryPackaging
				+ ", secondaryPackaging=" + secondaryPackaging + ", tenderReferenceNumber=" + tenderReferenceNumber
				+ ", tenderItemRefId=" + tenderItemRefId + "]";
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
