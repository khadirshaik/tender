<portlet:resourceURL id="alreadySelectedProducts"
	var="alreadySelectedProducts" />
<portlet:resourceURL id="fetchPrdRegDetails" var="fetchPrdRegDetails" />

<script type="text/javascript">
	$(document).on('click', '.accordion-header', function() {

		$(this).next('.panel').toggle();

		$(this).toggleClass('accordion-active');

	});
</script>
<div id="gl2" class="gl tab-pane fade ">
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
					<p>Verify that all products for which you want to make an offer
						and submit a Technical Bid via the CDP are listed. If not, please
						go back to the Tab 2 to correct the list of selected products for
						tender submission</p>
				</div>
			</div>
		</div>


		<!--list product Start here-->

		<div id="afterRefValChange">

			<div class="list-product selectedProdclone">

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
								</tr>
							</thead>
							<tbody class="tbl_posts_body">



							</tbody>
						</table>
					</div>
				</div>

			</div>



			<table class="tender">

				<tr class="tenderItemsData selectedProdTableclone">

					<td class="xs-small">

						<p>

							<input type="text" class="form-control" disabled value=""
								id="tendItem">
						</p>
					</td>

					<td class="gdf-generic-code">

						<p>
							<input type="text" class="form-control" disabled value=""
								id="gdfGenCode">
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
							<input type="text" class="form-control" disabled value=""
								id="fppMarStauts">
						</p>
					</td>


					<input type="hidden" class="form-control" disabled value=""
						id="tenderFPPMatRefNumber">
					<input type="hidden" class="form-control" disabled value=""
						id="fppMarketId">

				</tr>

			</table>
		</div>

		<div class="alreadySelected-product-wrapper"></div>

		<!--list product end here-->

		<div class="row text-center">
			<div class="btnWrapperCenter">
				<button type="button" class="btn btn-previous">Previous</button>
				<button type="button" class="btn btn-save"
					onclick="alreadySelectedProducts('<%=alreadySelectedProducts.toString()%>')">Save</button>
				<button class="btn btn-nxt nextBtnTab1" type="button"
					onclick="fetchPrdRegDetails('<%=fetchPrdRegDetails.toString()%>')"
					id="nextBtnTab1" disabled>Next</button>
			</div>
		</div>

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
