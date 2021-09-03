<portlet:resourceURL id="savePrdSelection" var="savePrdSelection" />
<portlet:resourceURL id="prdSelectedNext" var="prdSelectedNext" />

<script type="text/javascript">


	$(document).on('click', '.accordion-header', function () {

	  $(this).next('.panel').toggle();

	  $(this).toggleClass('accordion-active');

	  });


</script>
<div id="gl1" class="gl tab-pane fade ">
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
					<p>The table below indicates the list of your products in the
						CDP module "FPP in the market" which are requested for the
						selected GDF tender reference number. Only products with status
						"Approved" are eligible for tender submission.</p>

					<p>Please ensure that all information related to your products
						in CDP module "FPP in the market" is up to date or update the data
						before tender submission.</p>
					<p>
						For tender submission, select the eligible products for which you
						want to make an offer for the selected GDF tender reference
						number.<br /> Products with different status cannot be selected
						for tender submission.<br /> Eligible products not selected and
						not submitted will not be considered for the tender evaluation
						even if a Financial bid is submitted, or vice versa.
					</p>
				</div>

				<div class="remark-note">
					<h4>Remarks:</h4>
					<p>If a product is not yet with the status "Approved", please
						provide the missing information and/or documents to GDF for review
						minimum five working days before the deadline for submission of
						Technical Bids.</p>

					<p>If you want to add a new product in the list, please create
						the product in the CDP module "FPP in the market" and submit it to
						GDF for review minimum five working days before the tender
						closure.</p>
				</div>
			</div>
		</div>



		<div id="afterRefValChange">

			<div class="list-product prodclone">

				<div class="">
					<button class="accordion-header">
						Schedule Number : <label id="schedNum"></label>
					</button>
					<div class="panel tenderRootDiv">
						<table class="table table-data tbl_posts tenderItemTable">
							<thead class="thead-dark">
								<tr>
									<th>Tender item number</th>
									<th>GDF Generic Code</th>
									<th>Dosage form</th>
									<th>Number of units per primary packaging type</th>
									<th>Number of units per FPP secondary packaging type</th>
									<th>GDF Approval status</th>
									<th>FPP selected for tender submission</th>
								</tr>
							</thead>
							<tbody class="tbl_posts_body">



							</tbody>
						</table>
					</div>
				</div>

			</div>



			<table class="tender">

				<tr class="tenderItemsData prodTableclone">


					<td class="xs-small">

						<p>
							<input type="text" class="form-control" disabled value=""
								id="tendItem">
							</p>
					</td>
					<td class="gdf-generic-code">

						<p>
							<a id="gdfGenCode"></a>
							
						</p>
					</td>
					<td class="dosage-form">

						<p>
							<input type="text" class="sn form-control" disabled value=""
								id="dosageForm">
						</p>
					</td>
					<td class="number-unit-column">

						<p>
							<input type="text" class="sn form-control" disabled value=""
								id="noOfUnitsForPrimPack">
						</p>
					</td>
					<td class="number-unit-column">

						<p>
							<input type="text" class="form-control" disabled value=""
								id="noOfUnitsForSecPack">
						</p>
					</td>
					<td class="gdf-status-column">
						<p>
							<input type="text" class="form-control" disabled value="" id="fppMarStauts">
							
						</p>
					</td>
					<td class="text-center tender-submission-column">
						<p>
							<input type="checkbox" id="fppSelTenderSub" name="fppSelSub" 
								value="">
						</p>
					</td>

						<input type="hidden" class="form-control" disabled value=""
								id="tenderReferenceNumber">
					
							<input type="hidden" class="form-control" disabled value=""
								id="tenderItemRefId">
						
							<input type="hidden" class="form-control" disabled value=""
								id="fppMarketId">
								<input type="hidden" class="form-control" disabled value=""
								id="tenderFPPMatRefNumber">
						

				</tr>

			</table>
		</div>

		<div class="select-product-wrapper"></div>

		<!--list product end here-->
		
		<%-- Popup code --%>

		<div class="popup" data-popup="saveTenderPopUp">
			<div class="popup-inner">
			<div class="modal-header"><h5>Confirmation</h5></div>
				<p>This product is not eligible for tender submission!!!</p>

				<p>
					<a class="btn btn-primary"
						data-popup-close="saveTenderPopUp" href="#" id="cancelBtn">Ok</a>
				</p>

				<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
			</div>
		</div>


		<div class="row text-center">
			<div class="btnWrapperCenter">
				<button type="button" class="btn btn-previous">Previous</button>
				<button type="button" class="btn btn-save"
					onclick="savePrdSelection('<%=savePrdSelection.toString()%>')">Save</button>
				<button class="btn btn-nxt nextBtnTab1" type="button"
					onclick="prdSelectedNext('<%=prdSelectedNext.toString()%>')"
					id="nextBtnTab1" disabled>Next</button>
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

