package com.gdf.tender.submission.bean;

import java.util.List;

public class ScheduleDetailsModel {

	private long scheduleNumber;

	private String scheduleName;

	private String patientTarget;
	private long userId;
	private String userName;

	List<TenderItemDetailsModel> tenderItemDetailsModelList;

	List<FPPMarketDetailsModel> fppMartModelList;

	List<FPPRegDetailsModel> fppRegDetailsModelList;

	
	
	public List<FPPRegDetailsModel> getFppRegDetailsModel() {
		return fppRegDetailsModelList;
	}

	public void setFppRegDetailsModelList(List<FPPRegDetailsModel> fppRegDetailsModelList) {
		this.fppRegDetailsModelList = fppRegDetailsModelList;
	}

	public List<FPPMarketDetailsModel> getFppMartModelList() {
		return fppMartModelList;
	}

	public void setFppMartModelList(List<FPPMarketDetailsModel> fppMartModelList) {
		this.fppMartModelList = fppMartModelList;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getScheduleNumber() {
		return scheduleNumber;
	}

	public void setScheduleNumber(long scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public String getPatientTarget() {
		return patientTarget;
	}

	public void setPatientTarget(String patientTarget) {
		this.patientTarget = patientTarget;
	}

	public List<TenderItemDetailsModel> getTenderItemDetailsModelList() {
		return tenderItemDetailsModelList;
	}

	public void setTenderItemDetailsModelList(List<TenderItemDetailsModel> tenderItemDetailsModelList) {
		this.tenderItemDetailsModelList = tenderItemDetailsModelList;
	}

	@Override
	public String toString() {
		return "ScheduleDetailsModel [scheduleNumber=" + scheduleNumber + ", scheduleName=" + scheduleName
				+ ", patientTarget=" + patientTarget + ", userId=" + userId + ", userName=" + userName
				+ ", tenderItemDetailsModelList=" + tenderItemDetailsModelList + ", fppMartModelList="
				+ fppMartModelList + ", fppRegDetailsModelList=" + fppRegDetailsModelList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientTarget == null) ? 0 : patientTarget.hashCode());
		result = prime * result + ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + (int) (scheduleNumber ^ (scheduleNumber >>> 32));
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
		ScheduleDetailsModel other = (ScheduleDetailsModel) obj;
		if (patientTarget == null) {
			if (other.patientTarget != null)
				return false;
		} else if (!patientTarget.equals(other.patientTarget))
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (scheduleNumber != other.scheduleNumber)
			return false;
		return true;
	}

}
