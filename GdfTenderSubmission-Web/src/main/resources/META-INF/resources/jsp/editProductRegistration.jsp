<portlet:resourceURL id="saveProductsRegistration"
	var="saveProductsRegistration" />
<portlet:resourceURL id="tenderSubNextDetails"
	var="tenderSubNextDetails" />
<script type="text/javascript">
	$(document).on('click', '.accordion-header', function() {

		$(this).next('.panel').toggle();

		$(this).toggleClass('accordion-active');

	});
</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<div id="gl3" class="gl tab-pane fade ">
	<h1>Tender submission process</h1>

	<!--copy content from here for tab content-->
	<div class="tender-submission-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="text-note">
					<p class="ref-num-note">
						You are preparing a tender submission for GDF tender with
						reference number <strong id="tenderReferenceNumber"></strong>
					</p>
					<p>The table below indicates the list and number of countries
						in which your selected products are registered in the CDP module
						"FPP registration". Please check the information in the table and
						click box "Accepted" to confirm your acceptance of the product
						registration information at the time of tender submission</p>
				</div>

				<div class="remark-note">
					<h4>Remarks:</h4>
					<p>
						Only the total number of country product registrations with a GDF
						status "Approved" will be considered for the calculation of the
						points for the criterion "product registration" during the
						technical evaluation of the Bid.<br /> If a product registration
						is not yet with the GDF status "Approved", please provide the
						missing information and/or documents to GDF for review minimum
						five working days before the deadline for submission of Technical
						Bids.<br /> If a product registration in a country is not
						presented in the table below, please create a new country product
						registration in "FPP registration module" and submit it to GDF for
						review minimum five working days before the deadline for
						submission of Technical Bids.
					</p>
				</div>
			</div>
		</div>
		<!-- <input type="hidden" id="tenderSubmissionStatus" disabled value="">
		<input type="hidden" id="tenderDetailsStatus" disabled value=""> -->

		<!--list product start here-->

		<div id="afterRefValChange">

			<div class="list-product prodRegclone">

				<div class="">
					<button class="accordion-header">
						Schedule Number : <label id="schedNum"></label>
					</button>
					<div class="panel tenderRootDiv">
						<table class="table table-data tbl_posts tenderItemTable">
							<thead class="thead-dark">
								<tr>
									<th>GDF Generic Code</th>
									<th>List of countries of registration</th>
									<th>Number of countries of registration</th>
									<th>Approval status</th>
									<th>Accepted</th>
									
								</tr>
							</thead>
							<tbody class="tbl_posts_body">



							</tbody>
						</table>
					</div>
				</div>

			</div>



			<table class="tender">

				<tr class="tenderItemsData prodRegTableclone">


					<td>

						<p>
							<label id="gdfGenCode"></label>
						</p>

					</td>
					<td class="list-of-countries">

						<p>
							<label id="listOfCountries"></label>
						</p>
					</td>
					<td class="text-center">

						<p>
							<label id="noOfCountries"></label>
						</p>
					</td>
					<td class="text-center">

						<p>
							<label id="fppRegStatus"></label>
						</p>
					</td>



					<td class="text-center tender-submission-column"><strong>Accepted</strong>
						<p>
							<input type="checkbox" id="fppRegAcceptedStatus" value="">
						</p></td>
					

							<input type="hidden" class="form-control" disabled value=""
								id="tendItem">
						

					<input type="hidden" class="form-control" disabled value=""
						id="tenderFPPRegRefNumber">

					<input type="hidden" class="form-control" disabled value=""
						id="fppRegId">

					<input type="hidden" class="form-control" disabled value=""
						id="tenderReferenceNumber">

					<input type="hidden" class="form-control" disabled value=""
						id="gdfTenderItemMatRefID">



					<!-- 	<input type="hidden" class="form-control" disabled value=""
						id="countryNames"> -->

				</tr>

			</table>
		</div>

		<div class="product-registration-wrapper"></div>

		<!--list product end here-->

		<%-- Popup code --%>

		<div class="popup" data-popup="saveTenderPopUp">
			<div class="popup-inner">
				<div class="modal-header">
					<h5>Confirmation</h5>
				</div>
				<p>This product is not eligible for tender submission!!!</p>

				<p>
					<a class="btn btn-primary" data-popup-close="saveTenderPopUp"
						href="#" id="cancelBtn">Ok</a>
				</p>

				<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
			</div>
		</div>

		<div class="row text-center">
			<div class="btnWrapperCenter">
				<button type="button" class="btn btn-previous">Previous</button>
				<button type="button" class="btn btn-save" id="savebtn"
					onclick="editProductsRegistration('<%=saveProductsRegistration.toString()%>')">Save</button>
				<button class="btn btn-nxt nextBtnTab1" type="button"
					id="nextBtnTab1"
					onclick="tenderSubNextDetails('<%=tenderSubNextDetails.toString()%>')">Next</button>
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
