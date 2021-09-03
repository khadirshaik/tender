<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />



<portlet:resourceURL id="tenderRefDropDown" var="tenderRefDropDown" />
<portlet:resourceURL id="saveSelGdfTender" var="saveSelGdfTender" />
<portlet:resourceURL id="fetchSelectGdfTenders" var="fetchSelectGdfTenders" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">


<script type="text/javascript">


	$(document).on('click', '.accordion-header', function () {

	  $(this).next('.panel').toggle();

	  $(this).toggleClass('accordion-active');

	  });


</script>

<div id="gl0" class="gl tab-pane fade in active">


	<div class="tender-submission-container">

		<div class="row">
			<div class="col-sm-12">
				<div class="text-note">
					<p>Please select the GDF tender reference number for which you
						want to offer products and submit Technical Bids via the CDP.
						Please note that you need to submit Technical Bids for each tender
						separately - in case of multiple open tenders.</p>
				</div>
				<div class="row">
					<div class="col-sm-6  float-right">
						<div class="row">
							<div class="col-sm-6 form-group text-right">
								<label class="text-right">GDF tender reference</label>
							</div>
							<div class="col-sm-6 form-group">
								<select class="form-control tenderReferenceNumber"
									name="<portlet:namespace/>tenderReferenceNumber"
									id="tenderReferenceNumber"
									onchange="fetchTenderRefNumAjax('<%=tenderRefDropDown.toString()%>', '<portlet:namespace/>');">
									<option value="Select">Select</option>
									<c:forEach items="${activeGdfTenders}" var="gdfTenders">
										<option value="${gdfTenders.tenderReferenceNumber}">${gdfTenders.tenderReferenceNumber}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<hr />
				<div class="text-note">
					<p>Please find below the summary information of the selected
						GDF tender and the full list of products per schedule. You will be
						able to select products for your offer in the next step</p>
				</div>
			</div>
			<input type="hidden" class="form-control" disabled value=""
								id="tenderSubRefId">
			<div class="col-sm-4 form-group">
				<label>Product category</label> <%-- <select class="form-control"
					name="<portlet:namespace/>productCategory" id="productCategory"
					disabled>
					<option value="" id="productCategoryVal"></option>
				</select> --%>
				
				<input type="text" class="form-control"
					name="<portlet:namespace/>productCategory" id="productCategoryVal" value="" disabled>
			</div>
			<div class="col-sm-4 form-group">
				<label>Title</label> <input type="text" class="form-control"
					name="<portlet:namespace/>title" id="title" value="" disabled>
			</div>
			<div class="col-sm-4 form-group">
				<label>Date of publication</label>
				<div class="input-group date" id="datetimepicker1">
					<input type="text" class="form-control"
						name="<portlet:namespace/>publicationDate" id="publicationDate"
						value="" disabled>
					<div class="input-group-append" data-target="#datetimepicker1"
						data-toggle="datetimepicker">
						<div class="input-group-text">
							<span class="input-group-addon"> <i class="fa fa-calendar"></i>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-sm-4 form-group">
				<label>Deadline for the submission of Technical Bids</label>
				<div class="input-group date" id="datetimepicker2"
					data-target-input="nearest">
					<input type="text" class="form-control datetimepicker-input"
						data-target="#datetimepicker2"
						name="<portlet:namespace/>deadlineForTechBidsSub"
						id="deadlineForTechBidsSub" value="" disabled />
					<div class="input-group-append" data-target="#datetimepicker2"
						data-toggle="datetimepicker">
						<div class="input-group-text time-zone-big-screen">Time zone
							: CET</div>
						<div class="input-group-text">
							<span class="input-group-addon"> <i class="fa fa-calendar"></i>
							</span>
						</div>
					</div>
				</div>
				<!-- <div class="time-zone-small-screen">Time zone : CET</div> -->
			</div>
			<div class="col-sm-4 form-group">
				<label>Method</label>
				<div>
					<div class="form-check form-check-inline">
						<label class="form-check-label" for="inlineRadio1" id="method"></label>
					</div>
				</div>
			</div>
		</div>

		<div id="afterRefValChange">

			<div class="list-product clone1">

				<div class="">
					<button class="accordion-header">
						Schedule Number : <label id="schedNum"></label>
					</button>
					<div class="panel tenderRootDiv">
						<table class="table table-data tbl_posts tenderItemTable">
							<thead class="thead-dark">
								<tr>
									<th>Schedule Name</th>
									<th>Patient Target</th>
									<th>Tender Item number</th>
									<th>GDF Generic Code</th>
								</tr>
							</thead>
							<tbody class="tbl_posts_body">



							</tbody>
						</table>
					</div>
				</div>

			</div>



			<table class="tender">

				<tr class="tenderItemsData clone2">
					<td>

						<p>
							<input type="text" class="sn form-control" disabled value=""
								id="schedName">
						</p>
					</td>
					<td>

						<p>
							<input type="text" class="sn form-control" disabled value=""
								id="patTarget">
						</p>
					</td>
					<td>

						<p>
							<input type="text" class="form-control" disabled value=""
								id="tendItem">
						</p>
					</td>
					<td>

						<p>
							<input type="text" class="form-control" disabled value="" id="gdfGenCode">
						
						</p>
					</td>
					
					
							<input type="hidden" class="form-control" disabled value=""
								id="tenderItemMatRefID">
								
								<input type="hidden" class="form-control" disabled value=""
								id="fppMarketId">
							
				</tr>

			</table>
		</div>

		<div class="list-product-wrapper"></div>
</div>
	<%-- 	<input type="hidden" class="form-control completeJsonString"
			name="<portlet:namespace/>tenderScheduleJsonString" /> --%>


		<div class="row text-center">
			<div class="btnWrapperCenter">
				<button type="button" class="btn btn-save" id="save"
				 onclick="saveSelGdfTender('<%=saveSelGdfTender.toString()%>','<portlet:namespace/>')">Save</button>
				<button class="btn btn-primary" type="button" style="background: #d50032 !important; width: 80px; height: 39px; border: none;"
					id="tabNext" disabled>Next</button>
			</div>
		</div>
		<!--list product end here-->
	
	<!-- submission container end here-->
	<!--copy content till here for tab content-->
	
	
</div>

<%-- Popup code --%>

		<div class="popup" data-popup="tenderNextPopUp">
			
			<div class="popup-inner">
			<div class="modal-header"><h5>Confirmation</h5></div>
				<p>please note that after clicking the button "Next", you will no longer be able to change the GDF tender reference number. 
				Please confirm that GDF reference number selected is correct?</p>

				<p>
					
					<button class="btn btn-nxt"  data-popup-close="tenderNextPopUp" id="savePopup"
						onclick="fetchSelectGdfTenders('<%=fetchSelectGdfTenders.toString()%>')">Yes</button>
					&ensp; <a class="btn btn-primary"
						data-popup-close="tenderNextPopUp" href="#" id="cancelBtn">No</a>
				</p>

				<a class="popup-close" data-popup-close="tenderNextPopUp" href="#">x</a>
			</div>

</div>
		

<script src="datetimepicker.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1, #datetimepicker2').datetimepicker();

	});
</script>

