<%-- <%@ include file="/jsp/init.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page
	import="com.gdf.tender.submission.constants.GdfTenderSubmissionConstants"%>

<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.time.*"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js"></script>
<style type="text/css">
.clock {
	font-size: 18px;
}

.clockDate {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 25px;
}

.clockCancelbtn {
	background-color: #5f366e !important;
	padding: 7px 24px !important;
	color: white !important;
	border-radius: 4px !important;
	margin-left: 250px !important;
}

#cancelBtn {
	background-color: #5f366e !important;
	margin: 10px 0px -35px 175px;
	color: white !important;
	border-radius: 4px !important;
	border-color: #5f366e !important;
}

.popup-inner {
	width: 35% !important;
	
}

.successMsg {
	color: green;
	font-weight: bold;
	text-align: center;
	font-size: 2em;
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6 {
	float: left;
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6 label {   
	display:block;    width:100%;
	
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6 input {   
	min-width:40%!important;    float:right!important;
	
}

.table-responsive div.dataTables_wrapper div.dataTables_length select {
	width: 100% !important;
	display: inline-block;
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6:first-child label
	{    text-align:left;
	
}

.table-responsive #dtBasicExample_wrapper {    margin-top:15px!important;
	
}

.table-responsive #dtBasicExample_wrapper .dataTables_filter label {   
	text-align:right!important;
	
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-7 {
	    float: right !important;
	display: block !important;
	position: absolute;
	right: 0;
}

.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-5 {
	    float: left !important;
	display: block !important;
	position: absolute;
	left: 0;
}

.table-responsive #dtBasicExample_wrapper .row:after {
	    clear: both;
	    display: block;
	    content: '';
}

@media ( max-width : 767px) {
	.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6 {    width:100%; 
		  float:none;    text-align:left;
		
	}
	.table-responsive #dtBasicExample_wrapper .dataTables_filter label {   
		text-align:left!important;
		
	}
	.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-6 input {   
		min-width:40%;    float:none;
		
	}
	.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-7 {
		position: relative;
		right: auto;
	}
	.table-responsive #dtBasicExample_wrapper .col-sm-12.col-md-5 {
		position: relative;
		left: auto;
	}
}
</style>

<script>
	$(document).ready(function() {
		$('#dtBasicExample').DataTable({
			//"paging":   false,
			"order" : [ [ 6, "desc" ] ],
		//"info":     false
		});
		$('.dataTables_length').addClass('bs-select');
	});
</script>


<%!public LocalDateTime cetToIst(LocalDateTime timeInCet) {
		ZonedDateTime istTimeZoned = ZonedDateTime.of(timeInCet, ZoneId.of("CET"));
		return istTimeZoned.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();

	}%>

<%-- <portlet:renderURL var="addTenderRenderURL">
	<portlet:param name="mvcRenderCommandName"
		value="renderTenderDetails_Info" />
	<portlet:param name="_jspPath" value="/jsp/createTenderDetails.jsp" />
	<portlet:param name="cmd"
		value="<%=GdfTenderSubmissionConstants.RENDER_CREATE_TENDER_DETAILS%>" />
</portlet:renderURL> --%>


<!-- <liferay-ui:error key="duplicate-entry"
	message="This tender reference number is already exists." /> -->


<%-- <portlet:actionURL var="renderGdfTenderURL" name="addTender" /> --%>



<%-- <div class="successMsg">
		<span>${successMessage}</span>
	</div>
 --%>

<div class="parent-container">
	<div class="container">
		<div class="col-lg-12 breadcrumb-container">
			<div class="row">
				<a href="/web/guest/home"><span class="fa fa-home"></span></a> <span
					style="margin: 0 9px 0 9px">&#187;</span> <a
					href="/web/guest/tendersubmission/view">Tender submission</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div>

			<div class="row">
				<div class="col-sm-12 headingSection">
					<h1>
						<span id="heading">Tender submission</span>
					</h1>

					<p>The tender submission module of the CDP allows to
						automatically submit your Technical Bids for the products you want
						to make an offer for the selected GDF tender. The Financial Bids
						cannot be submitted via the CDP, and the supplier must follow the
						procedure for the Financial Bids submission as stated in the
						tender documentation.</p>

					<p>The table below presents the status of your Technical Bids
						submission for the selected tender</p>

					<h3>
						<span id="heading">Status of submission of technical Bids
							to GDF tender(s)</span>
					</h3>
				</div>


			</div>

		</div>

		<div class="col-lg-12">
			<div class="row">
				<form name="" action="" class="form-margin">
					<div class="tab-content">
						<div id="gl0">


							<div class="row">
								<div class="col-sm-12 ">
									<div class="pull-right">
										<div class="col-sm-12 form-group">

											<%-- <a href='${themeDisplay.getPortalURL()}${themeDisplay.getPathFriendlyURLPublic()}${themeDisplay.getScopeGroup().getFriendlyURL()}/tendersubmission/create' class="linkPrimary">
												Create a new tender submission </a> --%>

											<a href='/web/guest/tendersubmission/create'
												class="linkPrimary"> Create a new tender submission </a>

										</div>
									</div>
								</div>
							</div>

							<div class="table-responsive">
								<table
									class="table table-striped table-hover resposiveTbl adminlistview table-bordered table-sm"
									id="dtBasicExample" cellspacing="0" width="100%">
									<thead class="thead-h">
										<tr>
											<th style="display: none;">ModifiedDate</th>
											<th>Date Created</th>
											<th style="width: 190px;">GDF Tender Reference Number</th>
											<th style="width: 178px;">Title</th>
											<th>Method</th>
											<th>Deadline for the submission of Technical Bids</th>
											<th>Tender Submission Status</th>
											<th>Preparation/Submission status Date</th>
											<th>Status of GDF Tender</th>

										</tr>
									</thead>
									<tbody>


										<c:forEach items="${tenderSubViewList}" var="gdfTender">





											<portlet:actionURL name="actionTenderSubmissionDetails_Info"
												var="editTenderActionURL">
												<portlet:param name="tenderReferenceNumber"
													value="${gdfTender.tenderReferenceNumber}" />
												<portlet:param name="mvcActionCommand"
													value="actionTenderSubmissionDetails_Info" />
												<portlet:param name="cmd"
													value="<%=GdfTenderSubmissionConstants.ACTION_EDIT_TENDER_DETAILS%>" />
											</portlet:actionURL>


											<tr>
												<td style="display: none;"><fmt:formatDate
														pattern="dd/MM/yyyy" value="${gdfTender.modifiedDate}" /></td>
												<td scope="row"><span> <fmt:formatDate
															pattern="dd/MM/yyyy" value="${gdfTender.createdDate}" /></span>
												</td>

												<td><a href="${editTenderActionURL}" scope="row"> <c:out
															value="${gdfTender.tenderReferenceNumber}" /></a></td>

												<td><c:out value="${gdfTender.title}" /></td>

												<td><c:out value="${gdfTender.method}" /></td>


												<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
													value="${gdfTender.deadLineSubmissionDate}"
													var="deadLineDate" />
												<%
													String istDate = (String) pageContext.getAttribute("deadLineDate"); //No exception.

														DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
														LocalDateTime dateToConvert = LocalDateTime.parse(istDate, formatter);
														LocalDateTime convertIstDate = cetToIst(dateToConvert);

														String convertedDate = convertIstDate.toString().replace("T", " ");
														String istConvertedDate = new String();
														StringBuilder newConvertedDatesbf = new StringBuilder(convertedDate);
														if (convertedDate.length() == 16) {
															newConvertedDatesbf.append(":00");

														}
														istConvertedDate = newConvertedDatesbf.toString().replace("-", "/");
														SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
														SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

														pageContext.setAttribute("istConvertedDate", sdf2.format(sdf.parse(istConvertedDate)));
												%>
												<td><span> <fmt:formatDate
															pattern="dd/MM/yyyy HH:mm:ss"
															value="${gdfTender.deadLineSubmissionDate}" /> CET
												</span> <span class="clock istTime"><input type="hidden"
														value="${istConvertedDate}" class="istTime" /> <a
														onclick="popUpOpen('saveTenderPopUp')"><i
															class="fa fa-clock-o"></i></a></span></td>

												<%-- <td><span> <fmt:formatDate pattern="dd/MM/yyyy"
															value="${gdfTender.deadLineSubmissionDate}" /></span></td> --%>


												<td><c:out value="${gdfTender.tenderSubmissionStatus}" /></td>
												<td><span> <fmt:formatDate pattern="dd/MM/yyyy"
															value="${gdfTender.submissionStatusDate}" /></span></td>

												<td><c:out value="${gdfTender.tenderStatus}" /></td>



											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>

<div class="popup" data-popup="saveTenderPopUp">
	<div class="popup-inner">
		<div class="modal-header">
			<h5>Deadline for the submission of Technical Bids</h5>
		</div>
		<p style="padding-top: 20px; padding-left: 40px; font-weight: bold;"
			id="clockIstTime"></p>

		<p>
			<a class="btn btn-primary" data-popup-close="saveTenderPopUp"
				href="#" id="cancelBtn">Close</a>
		</p>

		<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(document).on('click', '.istTime', function() {
			var clockTime = $(this).find('.istTime').val();
			$('.popup-inner #clockIstTime').text(clockTime).append("  IST");

		});

	});
</script>