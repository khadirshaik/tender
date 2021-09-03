<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="java.time.*"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="com.gdf.tender.details.constants.GdfTenderConstants"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%@page import="java.util.List"%>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/gdf-tender.js"></script>

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
	border-radius: 4px;
	margin-left: 250px;
}

#cancelBtn {
	background-color: #5f366e !important;
	margin: 25px 0px 0px 220px;
	color: white !important;
	border-radius: 4px;
	border-color: #5f366e !important;
}

.popup-inner {
	padding: 0px !important;
	width: auto !important;
}

.successMsg {
	color: green;
	font-weight: bold;
	text-align: center;
	font-size: 1.5em;
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

<%-- FriendlyURLPublic::: ${themeDisplay.getPathFriendlyURLPublic()}
getURLHome::: ${themeDisplay.getURLHome()} --%>

<%-- getURLCurrent:::: ${themeDisplay.getURLCurrent()}
getPortalURL::::: ${themeDisplay.getPortalURL()}

getHomeURL:::: ${portalUtil.getHomeURL(renderRequest)}
getFriendlyURL:::: ${layout.getFriendlyURL(locale)}

getScopeGroupFriendlyURL:::: ${themeDisplay.getScopeGroup().getFriendlyURL()}

getLayoutFriendlyURL:::: ${themeDisplay.getLayout().getFriendlyURL()}


<a href='${themeDisplay.getPortalURL()}/web${themeDisplay.getScopeGroup().getFriendlyURL()}${themeDisplay.getLayout().getFriendlyURL()}'>urltest</a> --%>

<%!public LocalDateTime cetToIst(LocalDateTime timeInCet) {
		ZonedDateTime istTimeZoned = ZonedDateTime.of(timeInCet, ZoneId.of("CET"));
		return istTimeZoned.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();

	}%>

<%--<%
	String str = "2021-08-28 18:20:25";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime dateToConvert = LocalDateTime.parse(str, formatter);

	LocalDateTime istdate = cetToIst(dateToConvert);

	out.println("IST time:::" + istdate);
%> --%>

<portlet:renderURL var="addTenderRenderURL">
	<portlet:param name="mvcRenderCommandName"
		value="renderTenderDetails_Info" />
	<portlet:param name="_jspPath" value="/jsp/createTenderDetails.jsp" />
	<portlet:param name="cmd"
		value="<%=GdfTenderConstants.RENDER_CREATE_TENDER_DETAILS%>" />
</portlet:renderURL>


<liferay-ui:error key="duplicate-entry"
	message="This tender reference number is already exists." />



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

	<%-- <liferay-ui:success key="success"
	message="GDF Tender details has been successfully added." /> --%>

	<c:choose>
		<c:when test="${hasGSORole}">

			<div class="container">
				<div>

					<div class="row">
						<div class="col-sm-12 headingSection">
							<h1>
								<span id="heading">List Of GDF Tenders</span>
							</h1>
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

													<a href="${addTenderRenderURL}" class="linkPrimary">
														Create Tender </a>
													<%-- <c:if test="${hasGSORole}">
														<a href="${addTenderRenderURL}" class="linkPrimary">
															Create Tender </a>
													</c:if>
													<c:if test="${hasGDFRole}">
														<a href="#"></a>
													</c:if> 

													<c:if test="${hasGSORole}">
											<a href="${addTenderRenderURL}" class="linkPrimary">
												Create Tender </a>
										</c:if>--%>
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
													<th>Date Created</th>
													<th style="width: 190px;">GDF Tender Reference Number</th>
													<th style="width: 178px;">Title</th>
													<th>Method</th>
													<th>Date Of Publication</th>
													<th>Deadline for the submission of Technical Bids</th>
													<th>Status</th>
													<th>Date/Time of Status</th>
												</tr>
											</thead>
											<tbody>


												<c:forEach items="${gdfTenderList}" var="gdfTender">


													<portlet:renderURL var="editTenderURl">
														<portlet:param name="mvcRenderCommandName"
															value="renderTenderDetails_Info" />
														<portlet:param name="tenderReferenceNumber"
															value="${gdfTender.tenderReferenceNumber}" />
														<portlet:param name="_jspPath"
															value="/jsp/editTenderDetails.jsp" />
														<portlet:param name="cmd"
															value="<%=GdfTenderConstants.RENDER_EDIT_TENDER_DETAILS%>" />
													</portlet:renderURL>




													<tr>
														<td scope="row"><span> <fmt:formatDate
																	pattern="dd/MM/yyyy" value="${gdfTender.createDate}" /></span>
														</td>

														<td id="tenderRefNum"><a href="${editTenderURl}" scope="row"> <c:out
																	value="${gdfTender.tenderReferenceNumber}" /></a> <%-- <c:choose>
																<c:when test="${hasGSORole}">
																	<a href="${editTenderURl}" scope="row"> <c:out
																			value="${gdfTender.tenderReferenceNumber}" /></a>
																</c:when>
																<c:when test="${hasGDFRole}">
																	<c:out value="${gdfTender.tenderReferenceNumber}" />
																</c:when>
																<c:otherwise>
																	<c:out value="${gdfTender.tenderReferenceNumber}" />
																</c:otherwise>
															</c:choose> 
															<c:choose>
												<c:when test="${hasGSORole}">
												<a href="${editTenderURl}" scope="row"> <c:out
															value="${gdfTender.tenderReferenceNumber}" /></a>
												</c:when>
												<c:otherwise>
												 <c:out
															value="${gdfTender.tenderReferenceNumber}" />
												</c:otherwise>
												</c:choose>	--%></td>

														<td><c:out value="${gdfTender.title}" /></td>

														<td><c:out value="${gdfTender.method}" /></td>

														<td><span> <fmt:formatDate
																	pattern="dd/MM/yyyy HH:mm:ss"
																	value="${gdfTender.publicationDate}" /> CET
														</span></td>



														<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
															value="${gdfTender.deadlineForTechBidsSub}"
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
																	value="${gdfTender.deadlineForTechBidsSub}" /> CET
														</span> <span class="clock istTime"><input type="hidden"
																value="${istConvertedDate}" class="istTime" /> <a
																onclick="popUpOpen('saveTenderPopUp')"><i
																	class="fa fa-clock-o"></i></a></span></td>

														<td id="validateTenderStatus"><c:out value="${gdfTender.tenderStatus}" /></td>

														<td><span> <fmt:formatDate
																	pattern="dd/MM/yyyy" value="${gdfTender.modifiedDate}" /></span></td>





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
		</c:when>

		<c:when test="${hasGDFRole}">

			<div class="container">
				<div>

					<div class="row">
						<div class="col-sm-12 headingSection">
							<h1>
								<span id="heading">List Of GDF Tenders</span>
							</h1>
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


													<%-- <c:if test="${hasGSORole}">
														<a href="${addTenderRenderURL}" class="linkPrimary">
															Create Tender </a>
													</c:if>
													<c:if test="${hasGDFRole}">
														<a href="#"></a>
													</c:if> 

													<c:if test="${hasGSORole}">
											<a href="${addTenderRenderURL}" class="linkPrimary">
												Create Tender </a>
										</c:if>--%>
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
													<th>Date Created</th>
													<th style="width: 190px;">GDF Tender Reference Number</th>
													<th style="width: 178px;">Title</th>
													<th>Method</th>
													<th>Date Of Publication</th>
													<th>Deadline for the submission of Technical Bids</th>
													<th>Status</th>
													<th>Date/Time of Status</th>
												</tr>
											</thead>
											<tbody>


												<c:forEach items="${gdfTenderList}" var="gdfTender">



													<portlet:renderURL var="editTenderURl">
														<portlet:param name="mvcRenderCommandName"
															value="renderTenderDetails_Info" />
														<portlet:param name="tenderReferenceNumber"
															value="${gdfTender.tenderReferenceNumber}" />
														<portlet:param name="_jspPath"
															value="/jsp/editTenderDetails.jsp" />
														<portlet:param name="cmd"
															value="<%=GdfTenderConstants.RENDER_EDIT_TENDER_DETAILS%>" />
													</portlet:renderURL>




													<tr>
														<td scope="row"><span> <fmt:formatDate
																	pattern="dd/MM/yyyy" value="${gdfTender.createDate}" /></span>
														</td>

														<td id="tenderRefNum"><c:out value="${gdfTender.tenderReferenceNumber}" />

															<%-- <c:choose>
																<c:when test="${hasGSORole}">
																	<a href="${editTenderURl}" scope="row"> <c:out
																			value="${gdfTender.tenderReferenceNumber}" /></a>
																</c:when>
																<c:when test="${hasGDFRole}">
																	<c:out value="${gdfTender.tenderReferenceNumber}" />
																</c:when>
																<c:otherwise>
																	<c:out value="${gdfTender.tenderReferenceNumber}" />
																</c:otherwise>
															</c:choose> 
															<c:choose>
												<c:when test="${hasGSORole}">
												<a href="${editTenderURl}" scope="row"> <c:out
															value="${gdfTender.tenderReferenceNumber}" /></a>
												</c:when>
												<c:otherwise>
												 <c:out
															value="${gdfTender.tenderReferenceNumber}" />
												</c:otherwise>
												</c:choose>	--%></td>

														<td><c:out value="${gdfTender.title}" /></td>

														<td><c:out value="${gdfTender.method}" /></td>

														<td><span> <fmt:formatDate
																	pattern="dd/MM/yyyy HH:mm:ss"
																	value="${gdfTender.publicationDate}" /> CET
														</span></td>






														<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
															value="${gdfTender.deadlineForTechBidsSub}"
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
																	value="${gdfTender.deadlineForTechBidsSub}" /> CET
														</span> <span class="clock istTime"><input type="hidden"
																value="${istConvertedDate}" class="istTime" /> <a
																onclick="popUpOpen('saveTenderPopUp')"><i
																	class="fa fa-clock-o"></i></a></span></td>


														<td id="validateTenderStatus"><c:out value="${gdfTender.tenderStatus}" /></td>

														<td><span> <fmt:formatDate
																	pattern="dd/MM/yyyy" value="${gdfTender.modifiedDate}" /></span></td>





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
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="successMsg">
					<span> <!-- No GDF Tenders details available for this role. -->You
						do not have the roles required to access this GDF Tenders.
					</span>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<%-- Popup code Start--%>


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