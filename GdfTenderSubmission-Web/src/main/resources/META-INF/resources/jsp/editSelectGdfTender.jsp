<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />
<script type="text/javascript">
	$('.editmode .list-product-wrapper .list-product .panel').attr('style',
			'display:none');

	$('.editmode .list-product-wrapper .list-product .accordion-header')
			.first().addClass('accordion-active');

	$('.editmode .list-product-wrapper .list-product .panel').first().attr(
			'style', 'display:block');

	 /* $(document).on('click', '.accordion-header', function() {

		$(this).next('.panel').toggle();

		$(this).toggleClass('accordion-active');

	});  */
</script>

<style type="text/css">
 .timeCountDown {
    text-align: center;
    background: #f2f2f2;
    max-width: 295px;
    display: inline-block;
    vertical-align: middle;
    float: right;
    position: relative;
    width: 100%;
    padding: 5px 0px 0px;
    margin:15px 0px;
    box-shadow: 0 5px 7px rgb(0 0 0 / 20%);
    border-radius:5px;
}
.timeCountDown h5{
	margin:0px 0px 5px;
    font-size:16px;
    color:#5f366e !important;
    font-weight: bold;
}
#hours, #mins, #seconds{
display:inline-block;
font-size:24px;
padding:0px 5px;
min-width:50px;
color:#5f366e !important;
font-weight: bold;
line-height: 20px;
}
.hours, .mins, .seconds{
display:inline-block;
font-size:12px;
padding:0px 5px;
min-width:52px;
color:#d50032 !important;
font-weight: bold;
}

.timeCountDown div[class*="col-sm"] {
  float:left;text-align: center;
  }

.col-sm-1.open-bracket { 
  width: 30px;
    font-size: 51px;
    vertical-align: unset;
    text-align: left !important;
    color:#d50032 !important;
    margin-top:-25px;
    margin-left: 15px;
  }

.col-sm-1.close-bracket {width: 30px;
    font-size: 51px;
    vertical-align: unset;
    text-align: left !important;
  color:#d50032 !important;
  margin-left: -15px;
  margin-top:-25px;
  }
.timer { 
    width: 210px;
}
#dealTimeFinished {
    font-size: 16px;
    font-weight: bold;
    color: #d50032 !important;
    margin: 7px 0px;
}
  </style>

<%-- <portlet:resourceURL id="tenderRefDropDown" var="tenderRefDropDown" /> --%>
<portlet:resourceURL id="saveSelGdfTender" var="saveSelGdfTender" />
<portlet:resourceURL id="editSelectGdfTenders"
	var="editSelectGdfTenders" />


<c:set var="tenderList"
	value="<%=renderRequest.getAttribute("gdfTenderEdit")%>" />


<c:set var="submittedTender"
	value="<%=renderRequest.getAttribute("gdfSubmittedTenders")%>" />


<div id="gl0" class="gl tab-pane fade in active">

  <!-- new timer related html code start here-->
  <div class="timeCountDown">
      <h5>Time remaining for Technical Bids</h5>
      <div>
        <div class="col-sm-1 open-bracket">[</div>
        <div class="col-sm-10 timer">
         
          <div id="timeDetails">
            <div id="hours"></div>
            <div id="mins"></div>
            <div id="seconds"></div><br />
            <div class="hours">HRS</div>
            <div class="mins">MINS</div>
            <div class="seconds">SECS</div>
          </div>
          <div id="dealTimeFinished"></div>
        </div>
        <div class="col-sm-1 close-bracket">]</div>
      </div>
      
    </div>

     <!-- new timer related html code end here-->

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
									id="tenderReferenceNumber" disabled>

									<option value="${submittedTender.tenderReferenceNumber}">${submittedTender.tenderReferenceNumber}</option>

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
				<label>Product category</label>
				<%-- <select class="form-control"
					name="<portlet:namespace/>productCategory" id="productCategory"
					disabled>
					<option value="${tenderList.productCategory}"
						id="productCategoryVal">${tenderList.productCategory}</option>
				</select> --%>
				<input type="text" class="form-control"
					name="<portlet:namespace/>productCategory" id="productCategoryVal"
					value="${tenderList.productCategory}" disabled>

			</div>
			<div class="col-sm-4 form-group">
				<label>Title</label> <input type="text" class="form-control"
					name="<portlet:namespace/>title" id="title"
					value="${tenderList.title}" disabled>
			</div>
			<div class="col-sm-4 form-group">
				<label>Date of publication</label>
				<div class="input-group date" id="datetimepicker1">
					<input type="text" class="form-control"
						name="<portlet:namespace/>publicationDate" id="publicationDate"
						value="<fmt:formatDate value="${tenderList.publicationDate}" pattern="dd/MM/yyyy"/>"
						disabled />
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
						id="deadlineForTechBidsSub"
						value="<fmt:formatDate value="${tenderList.deadlineForTechBidsSub}" pattern="dd/MM/yyyy"/>"
						disabled />
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
						<label class="form-check-label" for="inlineRadio1" id="method">${tenderList.method}</label>
					</div>
				</div>
			</div>

			<input type="hidden" class="form-control" disabled
				value="${submittedTender.tenderSubmissionStatus}"
				id="tenderSubmissionStatus">
				
				<input type="hidden" class="form-control" disabled
				value="${tenderList.tenderStatus}"
				id="tenderDetailsStatus">
		</div>
		<div class="editmode">
			<div class="list-product-wrapper">
				<c:forEach items="${schedList}" var="schedList">
					<div class="list-product">

						<div class="">
							<button class="accordion-header">
								Schedule Number : <label id="schedNum">${schedList.scheduleNumber}</label>
							</button>
							<div class="panel tenderRootDiv">
								<table class="table table-data tbl_posts tenderItemTable" id="">
									<thead class="thead-dark">
										<tr>
											<th>Schedule Name</th>
											<th>Patient Target</th>
											<th>Tender Item number</th>
											<th>GDF Generic Code</th>
										</tr>
									</thead>
									<tbody class="tbl_posts_body">
										<c:forEach items="${schedList.tenderItemDetailsModelList}"
											var="gdfTenderItems">

											<tr>
												<td>

													<p>
														<input type="text" class="sn form-control" disabled
															value="${schedList.scheduleName}" id="schedName">
													</p>
												</td>
												<td>

													<p>
														<input type="text" class="sn form-control" disabled
															value="${schedList.patientTarget}" id="patTarget">
													</p>
												</td>

												<td>

													<p>
														<input type="text" class="form-control" disabled
															value="${gdfTenderItems.tenderItemNumber}" id="tendItem">
													</p>
												</td>
												<td>

													<p>
														<input type="text" class="form-control" disabled
															id="gdfGenCode" value="${gdfTenderItems.gdfGenericCode}">

													</p>
												</td>


												<input type="hidden" class="form-control" disabled
													value="${gdfTenderItems.tenderItemRefId}"
													id="tenderItemRefId">

												<input type="hidden" class="form-control" disabled
													value="${gdfTenderItems.tenderReferenceNumber}"
													id="tenderReferenceNumber">
											</tr>
										</c:forEach>


									</tbody>
								</table>
							</div>
						</div>
					</div>


				</c:forEach>
			</div>
		</div>
		<div class="list-product-wrapper"></div>


<input type="hidden" id="deadlineNewDate" value="${tenderList.deadlineForTechBidsSub}"/>
						

		<div class="row text-center">
			<div class="btnWrapperCenter">
				<c:choose>
					<c:when
						test="${submittedTender.tenderSubmissionStatus eq 'Submitted' || tenderList.tenderStatus eq 'Closed'}">
						<button type="button" class="btn btn-save"  id="savebtn"
							onclick="editSelGdfTender('<%=saveSelGdfTender.toString()%>','<portlet:namespace/>')"
							disabled>Save</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-save"  id="savebtn"
							onclick="editSelGdfTender('<%=saveSelGdfTender.toString()%>','<portlet:namespace/>')">Save</button>
					</c:otherwise>
				</c:choose>
				<button class="btn btn-nxt nextBtnTab1" type="button"
					onclick="editSelectGdfTenders('<%=editSelectGdfTenders.toString()%>')"
					id="nextBtnTab1">Next</button>
			</div>
		</div>
		<!--list product end here-->
	</div>
	<!-- submission container end here-->
	<!--copy content till here for tab content-->
</div>



<script src="datetimepicker.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1, #datetimepicker2').datetimepicker();

	});
</script>




<!-- copy JS code for timer from here-->
<script>
  // Set the date we're counting down to new Date("August 14, 2021 20:30:00").getTime();

  //var deadLineDate = $('#deadlineForTechBidsSub').val();
  var deadlineNewDate = $('#deadlineNewDate').val();
  //alert("deadlineNewDate:::"+deadlineNewDate);

  var countDownDate = new Date(deadlineNewDate).getTime();
 // alert("countDownDate:::"+countDownDate);
  // Update the count down every 1 second
  var x = setInterval(function() {
  
    // Get today's date and time
    var now = new Date().getTime();
    
    // Find the distance between now and the count down date
    var distance = countDownDate - now;
    
 
    // Time calculations for days, hours, minutes and seconds 
    var hours =  Math.floor((distance % (1000 * 60 * 60 * 60 * 60)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
     document.getElementById("hours").innerHTML = hours + " : ";
     document.getElementById("mins").innerHTML = minutes + " : ";
      document.getElementById("seconds").innerHTML = seconds;
    // If the count down is over, write some text 
    if (distance < 0) {
      clearInterval(x);
      document.getElementById("dealTimeFinished").innerHTML = "Deal Time Finished";
      document.getElementById("timeDetails").style.display = "none";
    }
  }, 1000);
  </script>
<!-- copy JS code for timer till here-->