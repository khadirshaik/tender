package com.gdf.tender.details.bean;

import java.util.List;

public class GdfTenderDetailsCommandBean {
	

	
	private String productCategory;
	
	private String title;
	
	private String dateOfPulication;
	
	private String deadLineSubmissionDate;
	
	private String method;
	
	private String status;
	
	List<ScheduleDetailsModel> scheduleDetailsModel;

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

	public String getDateOfPulication() {
		return dateOfPulication;
	}

	public void setDateOfPulication(String dateOfPulication) {
		this.dateOfPulication = dateOfPulication;
	}

	public String getDeadLineSubmissionDate() {
		return deadLineSubmissionDate;
	}

	public void setDeadLineSubmissionDate(String deadLineSubmissionDate) {
		this.deadLineSubmissionDate = deadLineSubmissionDate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ScheduleDetailsModel> getScheduleDetailsModel() {
		return scheduleDetailsModel;
	}

	public void setScheduleDetailsModel(List<ScheduleDetailsModel> scheduleDetailsModel) {
		this.scheduleDetailsModel = scheduleDetailsModel;
	}

	@Override
	public String toString() {
		return "GdfTenderDetailsCommandBean [productCategory=" + productCategory + ", title=" + title
				+ ", dateOfPulication=" + dateOfPulication + ", deadLineSubmissionDate=" + deadLineSubmissionDate
				+ ", method=" + method + ", status=" + status + ", scheduleDetailsModel=" + scheduleDetailsModel + "]";
	}
	
	
	
	

}
