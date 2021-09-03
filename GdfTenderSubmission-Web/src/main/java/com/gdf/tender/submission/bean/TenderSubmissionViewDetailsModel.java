package com.gdf.tender.submission.bean;

import java.util.Date;

public class TenderSubmissionViewDetailsModel {

	private long tenderRefID;

	private String tenderReferenceNumber;

	private String productCategory;

	private String title;

	private Date dateOfPublication;

	private Date deadLineSubmissionDate;

	private String method;

	private String tenderStatus;

	private Date createdDate;

	private Date modifiedDate;
	
	private String tenderSubmissionStatus;
	
	private Date submissionStatusDate;

	public long getTenderRefID() {
		return tenderRefID;
	}

	public void setTenderRefID(long tenderRefID) {
		this.tenderRefID = tenderRefID;
	}

	public String getTenderReferenceNumber() {
		return tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		this.tenderReferenceNumber = tenderReferenceNumber;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public Date getDeadLineSubmissionDate() {
		return deadLineSubmissionDate;
	}

	public void setDeadLineSubmissionDate(Date deadLineSubmissionDate) {
		this.deadLineSubmissionDate = deadLineSubmissionDate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTenderStatus() {
		return tenderStatus;
	}

	public void setTenderStatus(String tenderStatus) {
		this.tenderStatus = tenderStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getTenderSubmissionStatus() {
		return tenderSubmissionStatus;
	}

	public void setTenderSubmissionStatus(String tenderSubmissionStatus) {
		this.tenderSubmissionStatus = tenderSubmissionStatus;
	}

	
	public Date getSubmissionStatusDate() {
		return submissionStatusDate;
	}

	public void setSubmissionStatusDate(Date submissionStatusDate) {
		this.submissionStatusDate = submissionStatusDate;
	}

	@Override
	public String toString() {
		return "TenderSubmissionViewDetailsModel [tenderRefID=" + tenderRefID + ", tenderReferenceNumber="
				+ tenderReferenceNumber + ", productCategory=" + productCategory + ", title=" + title
				+ ", dateOfPublication=" + dateOfPublication + ", deadLineSubmissionDate=" + deadLineSubmissionDate
				+ ", method=" + method + ", tenderStatus=" + tenderStatus + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", tenderSubmissionStatus=" + tenderSubmissionStatus
				+ ", submissionStatusDate=" + submissionStatusDate + "]";
	}
	
	

}
