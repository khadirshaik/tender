package com.gdf.tender.details.bean;

import java.util.List;

public class ScheduleDetailsModel {

	private long scheduleNumber;

	private String scheduleName;

	private String patientTarget;
	private long userId;
	private String UserName;
	

	List<TenderItemDetailsModel> tenderItemDetailsModelList;

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
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
				+ ", patientTarget=" + patientTarget + ", userId=" + userId + ", UserName=" + UserName
				+ ", tenderItemDetailsModelList=" + tenderItemDetailsModelList + "]";
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
