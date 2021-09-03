package com.gdf.tender.submission.bean;

public class FPPMarketDetailsModel {

	private String gdfGenericCode;
	
	private String dosageForm;

	private String noOfPrimaryPackaging;

	private String noOfSecondaryPackaging;
	
	private String fppMartStatus;
	
	private String tenderReferenceNumber;

	private long tenderItemRefId;
	
	private long fppMarketId;
	
	private long tenderItemNumber;
	
	private boolean fppSelTenderSub;
	
	private long tenderFPPMatRefNumber;
	

	public long getTenderFPPMatRefNumber() {
		return tenderFPPMatRefNumber;
	}

	public void setTenderFPPMatRefNumber(long tenderFPPMatRefNumber) {
		this.tenderFPPMatRefNumber = tenderFPPMatRefNumber;
	}

	public boolean isFppSelTenderSub() {
		return fppSelTenderSub;
	}

	public void setFppSelTenderSub(boolean fppSelTenderSub) {
		this.fppSelTenderSub = fppSelTenderSub;
	}

	public long getTenderItemNumber() {
		return tenderItemNumber;
	}

	public void setTenderItemNumber(long tenderItemNumber) {
		this.tenderItemNumber = tenderItemNumber;
	}

	public long getFppMarketId() {
		return fppMarketId;
	}

	public void setFppMarketId(long fppMarketId) {
		this.fppMarketId = fppMarketId;
	}

	public String getTenderReferenceNumber() {
		return tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		this.tenderReferenceNumber = tenderReferenceNumber;
	}

	public long getTenderItemRefId() {
		return tenderItemRefId;
	}

	public void setTenderItemRefId(long tenderItemRefId) {
		this.tenderItemRefId = tenderItemRefId;
	}

	public String getGdfGenericCode() {
		return gdfGenericCode;
	}

	public void setGdfGenericCode(String gdfGenericCode) {
		this.gdfGenericCode = gdfGenericCode;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public String getNoOfPrimaryPackaging() {
		return noOfPrimaryPackaging;
	}

	public void setNoOfPrimaryPackaging(String noOfPrimaryPackaging) {
		this.noOfPrimaryPackaging = noOfPrimaryPackaging;
	}

	public String getNoOfSecondaryPackaging() {
		return noOfSecondaryPackaging;
	}

	public void setNoOfSecondaryPackaging(String noOfSecondaryPackaging) {
		this.noOfSecondaryPackaging = noOfSecondaryPackaging;
	}

	public String getFppMartStatus() {
		return fppMartStatus;
	}

	public void setFppMartStatus(String fppMartStatus) {
		this.fppMartStatus = fppMartStatus;
	}

	

	@Override
	public String toString() {
		return "FPPMarketDetailsModel [gdfGenericCode=" + gdfGenericCode + ", dosageForm=" + dosageForm
				+ ", noOfPrimaryPackaging=" + noOfPrimaryPackaging + ", noOfSecondaryPackaging="
				+ noOfSecondaryPackaging + ", fppMartStatus=" + fppMartStatus + ", tenderReferenceNumber="
				+ tenderReferenceNumber + ", tenderItemRefId=" + tenderItemRefId + ", fppMarketId=" + fppMarketId
				+ ", tenderItemNumber=" + tenderItemNumber + ", fppSelTenderSub=" + fppSelTenderSub
				+ ", tenderFPPMatRefNumber=" + tenderFPPMatRefNumber + "]";
	}
	
}
