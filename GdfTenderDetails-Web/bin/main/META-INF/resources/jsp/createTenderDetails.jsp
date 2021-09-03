
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.gdf.tender.details.constants.GdfTenderConstants"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/moment-with-locales.min.js"></script>



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<portlet:resourceURL id="proCategroyDropDown" var="proCatRefDropDown" />


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/gdf-tender.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/gdf-tender.css">

<style type="text/css">
.form-check.form-check-inline label {
	margin-left: 5px;
}

.highLight
{
    background:red;
}
</style>





<portlet:actionURL name="actionTenderDetails_Info"
	var="createTenderActionURL">
	<portlet:param name="mvcActionCommand" value="actionTenderDetails_Info" />
	<portlet:param name="cmd"
		value="<%=GdfTenderConstants.ACTION_CREATE_TENDER_DETAILS%>" />
</portlet:actionURL>




<fmt:formatDate value="${publicationDate}" var="publicationDateForm"
	pattern="dd/MM/yyyy HH:mm:ss" />


<fmt:formatDate value="${deadlineForTechBidsSub}"
	var="deadlineForTechBidsSubForm" pattern="dd/MM/yyyy HH:mm:ss" />

<div class="parent-container">
	<div class="container">
		<div class="col-lg-12 breadcrumb-container">
			<div class="row">
				<a href="/web/guest/home"><span class="fa fa-home"></span></a> <span
					style="margin: 0 9px 0 9px">&#187;</span><a
					href="/web/guest/gdftender"> List Of GDF Tenders</a>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-sm-12 headingSection">
				<h1>
					<span id="heading">GDF Tender Details</span>
				</h1>
			</div>


		</div>



		<c:if test="${error}">
			<div class="errorMsg">
				<span>This tender reference number already exists, please add
					a unique reference number.</span><br /> <br /> <br />
			</div>

		</c:if>

		<form action="${createTenderActionURL}" name="gdfTenderForm"
			id="gdfTenderForm" method="POST">

			<div class="tender-detail-form">
				<div class="row">
					<div class="col-sm-4 form-group">
						<label for="productCategory">Product category</label> <select
							class="form-control" name="<portlet:namespace/>productCategory"
							id="productCategory" onchange="fetchScheduleNosAjax('<%=proCatRefDropDown.toString()%>');">
							<option value="">Select</option>
							<c:forEach items="${prdCategoryList}" var="prdList">
								<option value="${prdList.productCategory}"
									${(prdList.productCategory eq productCategory) ? "selected" : ""}>
									${prdList.productCategory}</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-sm-4 form-group">
						<label for="tenderReferenceNumber">GDF tender reference</label> <input
							type="text" class="form-control"
							name="<portlet:namespace/>tenderReferenceNumber"
							id="tenderReferenceNumber"
							placeholder="enter tender reference number"
							value="${tenderReferenceNumber}">
					</div>

					<div class="col-sm-4 form-group">
						<label for="title">Title</label> <input type="text"
							class="form-control" name="<portlet:namespace/>title" id="title"
							placeholder="enter title" value="${title}">
					</div>

				</div>

				<div class="row">
					<div class="col-sm-4 form-group">
						<label for="publicationDate">Date of publication</label>
						<div class="input-group date" id="datetimepicker1">
							<input type="text" class="form-control"
								name="<portlet:namespace/>publicationDate" id="publicationDate"
								placeholder="DD/MM/YYYY" value="${publicationDateForm}">
							<div class="input-group-append" data-target="#datetimepicker1"
								data-toggle="datetimepicker">
								<div class="input-group-text">Time zone : CET</div>
								<div class="input-group-text">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4 form-group">
						<label for="deadlineForTechBidsSub">Deadline for the
							submission of Technical Bids</label>
						<div class="input-group date" id="datetimepicker2"
							data-target-input="nearest">
							<input type="text" class="form-control datetimepicker-input"
								data-target="#datetimepicker2"
								name="<portlet:namespace/>deadlineForTechBidsSub"
								id="deadlineForTechBidsSub" placeholder="DD/MM/YYYY"
								value="${deadlineForTechBidsSubForm}">
							<div class="input-group-append" data-target="#datetimepicker2"
								data-toggle="datetimepicker">
								<div class="input-group-text">Time zone : CET</div>
								<div class="input-group-text">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="col-sm-4 form-group">
						<label for="method">Method</label>
						<div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" id="inlineRadio1"
									value="ITB" ${method.equalsIgnoreCase("ITB") ? "checked" : ""}
									checked name="<portlet:namespace/>method"> <label
									class="form-check-label" for="inlineRadio1">ITB</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" id="inlineRadio2"
									value="RFQ" ${method.equalsIgnoreCase("RFQ") ? "checked" : ""}
									name="<portlet:namespace/>method"> <label
									class="form-check-label" for="inlineRadio2">RFQ</label>
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<label for="tenderStatus">Status</label> <select
							class="form-control" name="<portlet:namespace/>tenderStatus"
							id="tenderStatus">
							<option value="" ${tenderStatus} selected="selected">Select</option>
							<option value="Active"
								${tenderStatus.equalsIgnoreCase("Active") ? "selected" : ""}>Active</option>
							<option value="Not Active"
								${tenderStatus.equalsIgnoreCase("Not Active") ? "selected" : ""}>Not
								Active</option>
							<option value="Cancelled"
								${tenderStatus.equalsIgnoreCase("Cancelled") ? "selected" : ""}>Cancelled</option>
							<option value="Closed"
								${tenderStatus.equalsIgnoreCase("Closed") ? "selected" : ""}>Closed</option>
						</select>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="col-sm-12 form-group">
					<a class="btn btn-primary float-right" id="addSchedule">Add
						Schedule</a>
				</div>
			</div>

			<div class="row">

				<%@ include file="addScheduleDetails.jsp"%>



				<!-- Start of Wrapper div  -->
				<div class="list-product-wrapper">

					<c:forEach items="${schedularJsonList}" var="gdfSchedule">
						<div class="list-product">

							<!-- Tender Schedules fields START here-->
							<div class="row">

								<div class="col-sm-4 form-group">
									<label for="scheduleNumber">Schedule number</label> <select
										class="form-control scheduleNumberDropdown"
										name="<portlet:namespace/>scheduleNumber" id="scheduleNumber">


										<option value="" id="">Select</option>

										<c:forEach var="tenderscheds" items="${tenderschedList}">
											<c:if
												test="${productCategory eq tenderscheds.productCategory}">
												<option value="${tenderscheds.scheduleNumber}"
													${(tenderscheds.scheduleNumber == gdfSchedule.scheduleNumber) ? "selected" : ""}
													id="${tenderscheds.scheduleName},${tenderscheds.patientTarget}">${tenderscheds.scheduleNumber}</option>
											</c:if>
										</c:forEach>

									</select>
								</div>

								<div class="col-sm-4 form-group schudule-nameDiv">
									<label for="scheduleName">Schedule Name</label> <input
										type="text" class="form-control schedName"
										name="<portlet:namespace/>scheduleName" id="scheduleName"
										value="${gdfSchedule.scheduleName}" readonly>

								</div>
								<div class="col-sm-4 form-group schudule-patientDiv">
									<label for="patientTarget">Patient Target</label> <input
										type="text" class="form-control patTarget"
										value="${gdfSchedule.patientTarget}"
										name="<portlet:namespace/>patientTarget" id="patientTarget"
										readonly>
								</div>



							</div>
							<!-- Tender Schedules fields end here-->

							<!-- Tender Item fields START here-->


							<div class="">

								<a class="accordion-header active"> Schedule Number : <span
									class="scheduleNumber">${gdfSchedule.scheduleNumber}</span>
								</a>
								<div class="panel tenderRootDiv">
									<table class="table table-data tbl_posts tenderItemTable" id="">
										<thead class="thead-dark">
											<tr>
												<th>Tender item <br /> number
												</th>
												<th>GDF Generic Code</th>
												<th>General Description</th>
												<th>Primary packaging</th>
												<th>Secondary Packaging</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody class="tbl_posts_body">
											<c:forEach items="${gdfSchedule.tenderItemDetailsModelList}"
												var="gdfTenderItems">
												<tr id="rec-1">
													<td class="sr-Number xs-small" id="duplicate-number"><strong>Tender item
															number</strong>
														<p>
															 <input
																type="number" min="1" max="100"
																class="sn form-control tenderItem"
																name="<portlet:namespace/>tenderItemNumber"
																id="tenderItemNumber"
																value="${gdfTenderItems.tenderItemNumber}">
														</p></td>
														<input type="hidden" class="form-control tenderRefId"
																name="<portlet:namespace/>tenderItemRefId"
																value="${gdfTenderItems.tenderItemRefId}" />
													<td class="gdf-generic-code"><strong>GDF Generic Code</strong>
														<p>
															<select class="form-control gdfGenCode"
																name="<portlet:namespace/>gdfGenericCode"
																id="gdfGenericCode">
																<option value="Select">Select</option>
																<c:forEach items="${productGenricList}"
																	var="genericCodeList">
																	<option value="${genericCodeList.gdfGenericCode}"
																		${(genericCodeList.gdfGenericCode == gdfTenderItems.gdfGenericCode) ? "selected" : ""}>${genericCodeList.gdfGenericCode}</option>
																</c:forEach>
															</select>
														</p></td>
													<td><strong>General Description</strong>
														<p>
															<textarea class="form-control genDesc"
																name="<portlet:namespace/>generalDescription"
																id="generalDescription"> ${gdfTenderItems.generalDescription}</textarea>
														</p></td>
													<td><strong>Primary packaging</strong>
														<p>
															<textarea class="form-control primPack"
																name="<portlet:namespace/>primaryPackaging"
																id="primaryPackaging">${gdfTenderItems.primaryPackaging}</textarea>
														</p></td>
													<td><strong>Secondary Packaging</strong>

														<p>
															<textarea class="form-control secPack"
																name="<portlet:namespace/>secondaryPackaging"
																id="secondaryPackaging">${gdfTenderItems.secondaryPackaging}</textarea>
														</p></td>

													<td class="action"><strong>Action</strong>
														<p>
															<a class="add-btn"> <i
																class="fa fa-plus-circle fa-2x " aria-hidden="true"></i>
															</a> <a class="remove-row"> <i
																class="fa fa-minus-circle fa-2x remove_fieldTable_page3${fdcCnt}"
																aria-hidden="true"></i>
															</a>
														</p>
												</tr>
											</c:forEach>
										</tbody>
									</table>

									<div class="row">
										<div class="form-group col-sm-12">
											<a class="btn btn-primary float-right deleteSchedule">Delete
												Schedule</a>
										</div>
									</div>
								</div>



							</div>

							<!-- Tender Item fields END here-->

						</div>
					</c:forEach>

				</div>
				<!-- End of Wrapper div  -->


			</div>



			<input type="hidden" class="form-control completeJsonString"
				name="<portlet:namespace/>tenderScheduleJsonString" /> 
				
				<input	type="hidden" id="productCatChanged" value="" />
				


			<!-- <a class="btn btn-primary" class="saveAnchor" onclick="popUpOpen('saveTenderPopUp')">Save</a> -->

			<a class="btn btn-primary" id="saveAnchor">Save</a>





			<%-- Popup code Start--%>

			<div class="popup" data-popup="saveTenderPopUp">

				<div class="popup-inner">
					<div class="modal-header">
						<h5>Confirmation</h5>
					</div>
					<p>Are you sure?</p>

					<p class="mt-5">
						<!-- <button class="btn btn-primary" type="submit" name="" value="save"
						id="save">Yes</button> -->
						<button class="confirmBtn" type="submit" name="" value="save"
							id="save">Yes</button>
						<%-- <div class="successMsg"><span>${successMessage}</span></div> --%>
						&ensp; <a class="cancelBtn" data-popup-close="saveTenderPopUp"
							href="#">Cancel</a>
					</p>

					<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
				</div>
			</div>

			<%-- Popup code End--%>

			<!-- 			<div class="popup" data-popup="popup-1">
				<div class="popup-inner">
					<div class="modal-header"></div>
					<p>Manufacturer/Supplier to confirm if it is Alu/Alu or
						Alu/PvC/or PvDC blister or strip; glass ampoule or plastic vial;</p>

					<p class="mt-5">
						<a data-popup-close="popup-1" class="confirmBtn" href="#">Close</a>
					</p>

					<a class="popup-close" data-popup-close="popup-1" href="#">x</a>
				</div>
			</div> -->


		</form>


	</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/datetimepicker.js"></script>
<script type="text/javascript">
	$(function() {
		$(
				'#datetimepicker1,  #datetimepicker2, #publicationDate, #deadlineForTechBidsSub')
				.datetimepicker({
					format:'DD/MM/YYYY HH:mm:ss'
				});

		moment.locale('en', {
			week : {
				dow : 1
			}
		// Monday is the first day of the week
		});
	});
</script>

<script type="text/javascript">
$(document).ready(
		function() {
$(document).on('click', '#addSchedule', function () {
	
	// for schedule number drop down
var optionArray = [];
	
var productCatVal = $(".tender-detail-form .form-group #productCategory").val();
			console.log(":::productCatVal:::"+productCatVal);
			var url = '<%=proCatRefDropDown%>';
			console.log(":::url:::"+url);
			$("#loaderWrap").show();
			var data = {
					productCatVal : productCatVal
			};
			
			jQuery.post(url, data, function(data) {
				
				 const jsonData = JSON.parse(data);

					var scedList = jsonData.scheduleJsonArray;
					
			        
			        $('#prod-wrapper .form-group #scheduleNumber').empty();
			        $('#prod-wrapper .form-group #scheduleNumber').append('<option value="">Select</option>');
					$.each(scedList, function(key, value) {
						
						var scheduleNo = value.scheduleNumber;
						var schedName = value.scheduleName;
						var patTarget = value.patientTarget;
						
				
						var option = "<option value='" + scheduleNo + "," + schedName + "," + patTarget + "'>" + scheduleNo + "</option>";
						optionArray.push(option);
					
					});
					
					
					
					$.each(optionArray, function(key,value) {    
						
				
				$('#prod-wrapper .form-group #scheduleNumber').append(value);
				
					});
				});
			
		

	});
});
</script>

