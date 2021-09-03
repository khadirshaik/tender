<portlet:resourceURL id="regCerificate" var="regCerificate" />
<portlet:resourceURL id="downloadTechBidsFile" var="downloadTechBidsFile" />
<portlet:resourceURL id="downloadCountryProdRegFile" var="downloadCountryProdRegFile" />
<portlet:resourceURL id="saveTenderSubDetails" var="saveTenderSubDetails" />
<portlet:resourceURL id="submitTenderSubDetails" var="submitTenderSubDetails" />
<portlet:resourceURL id="cancelTenderSubDetails" var="cancelTenderSubDetails" />
<%@ page
	import="com.gdf.tender.submission.constants.GdfTenderSubmissionConstants"%>
<portlet:actionURL name="actionTenderSubmissionDetails_Info" var="submitTenderActionURL">
	<portlet:param name="mvcActionCommand" value="actionTenderSubmissionDetails_Info" />
	<portlet:param name="cmd" value="<%=GdfTenderSubmissionConstants.ACTION_SUBMIT_TENDER_DETAILS%>" />
</portlet:actionURL>
<script type="text/javascript">
$(document).ready(function () {

	$('.proof_Sub_file').multifile();
	
	$('input[type="file"].uploadFile').change(function (e) {
		$(this).siblings('input[type="text"]').val(e.target.files[0].name);
	});
});
</script>

<div id="gl4" class="gl tab-pane fade ">
	<h1>Tender submission process</h1>
<form name="tenderSubmissionForm" id="tenderSubmissionForm" method="post" action="${submitTenderActionURL}">
	<!--copy content from here for tab content-->
	<div class="successMsg" style="display:none;"><span>You have successfully Saved technical bids for the tender.</span><br /> </div>
	<div class="cancelMsg" style="display:none;"><span>You have successfully cancelled technical bids for the tender.</span><br /> </div>
	<div class="tender-submission-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="text-note">
					<p class="ref-num-note">
						You are preparing a tender submission for GDF tender with
						reference number <strong id="tenderReferenceNumber"></strong>
					</p>
					<input type="hidden" class="tenderRefNumber" name="<portlet:namespace/>tenderRefNumber"/>
					<input type="hidden" class="nameOfSupplier" name="<portlet:namespace/>nameOfSupplier"/>
					<input type="hidden" class="form-control" value=""	id="deadLineDate">
					<p>Submissions of Technical Bids must be received by GDF prior
						to the tender submission deadline as mentioned in the tender
						document and in tab "Select GDF tender". Technical Bids submitted
						after the deadline will be rejected.</p>
					<p>GDF accepts no responsibility for Bidders misunderstanding
						instructions or for incorrect use of the system.</p>
					<p>Please click on the two buttons below to see and check your
						Technical Bids in Excel files. These files will be automatically
						emailed to the dedicated email address as stated in the tender
						document once you click on the button "Submit" If you need to make
						a change to your submission go back to the respective tabs to make
						the changes The date and time of tender submission is
						automatically recorded in the system.</p>
				</div>

				<div class="row">
					<div class="col-sm-12  text-right mt-4">
						<a class="linkPrimary" onclick="downloadTechBidsFile('<%=downloadTechBidsFile.toString()%>')">Download
							Technical Bids</a>
						<a class="linkPrimary"  onclick="downloadCountryProdRegFile('<%=downloadCountryProdRegFile.toString()%>')">Download
							Country product registration</a>
					</div>
				</div>

				<div class="text-note">
					<p>Please upload here the annex related to the supplier's
						authorization for GDF access to WHO PQP/ERP supplier information</p>
				</div>


				<div class="row">
					<div class="col-sm-5 form-group  upload-section">
						<label>Upload copy of the GDF tender technical bids certificate</label>
						<!-- <div class="file-upload">
							<div class="file-select">

								<div class="file-select-name" id="noFile">No file
									chosen...</div>
								<div class="file-select-button" id="fileName">Choose a
									file</div>
								<input type="file" name="chooseFile" id="chooseFile">
							</div>

						</div> -->
						
						<%-- multiselect --%>
					<div class="input-group multiInputGroup">
						<%-- multiselect --%>
						<input type="file" class="uploadFile proof_Sub_file  regCerti"
							name="<portlet:namespace/>regCerti" id="regCerti"
							>
						<div class="multifile_container"></div>
						<%-- multiselect --%>
						<input type="text" class="form-control" id="nameChoosen"
							maxlength="75" required="required">
						<div class="input-group-btn">
							<span class="fileUpload btn btn"> <span class="upl upload">Choose
									a file</span>
							</span>
							<%-- btn-orange --%>
						</div>

						<%-- btn --%>

					</div>

					<%-- <span>Accepted File type : xls, xlsx, doc, txt, ppt, png, jpg(Max file size 10 MB)</span> --%>
					<%-- group --%>
					
					</div>
					
					<div class="col-sm-4 form-group">
					<button type="button" name="<portlet:namespace/>regCertiFile"
						id="regCertiFile" value="regCertiFile"
						class="btn btn-upload uploadFilesButton"
						onclick="regCerificate('<%=regCerificate.toString()%>','<portlet:namespace/>')">Upload</button>
				</div>
					
					
					
					<!-- <div class="col-sm-4 form-group">
						<button class="btn btn-upload">Upload</button>
					</div> -->
					<div class="clearfix"></div>
					<div class="col-sm-12">
						<div class="validation submissionProofFile" style="margin-left: 0px;">Incorrect file
						format or size!</div>
					<div class="fileLimitWarning" id="fileLimitWarning"></div>
					<span style="color: #f2a900; font-weight: bold;">Please choose a file, check that the file chosen is correct, if correct click on the Upload button. The file uploaded is presented at the bottom of the screen</span> 
				
					</div>
				</div>



				<div class="text-note">
					<p>
						<label><span class="condition-checkbox"><input
								type="checkbox" id="iAgree"></span> <span class="condition-text">I
								confirm that the product technical information has been verified
								and the information is up to date for the selected products
								submitted by me for this tender.<br /> I confirm that I have
								read the terms and conditions of the selected GDF tender
								reference number and I accept them<br /> I confirm that the
								company complies with the code of conduct for suppliers of GDF's
								contracted procurement agent <br /> I confirm I have the full
								authority to submit the technical Bids for the selected products
								on behalf of the company. <br /> I confirm that inserting my
								name in the form as a signature is the legal equivalent of my
								manual/handwritten signature on this form. <br /> By selecting
								"Submit" using any device, I consent to the legally binding
								submission of this technical information for the selected
								eligible products.
						</span></label>
					</p>
				</div>



				<div class="tender-detail-form">
					<div class="row">
						<div class="col-sm-4 form-group">
							<label>Name of supplier</label> <input type="text" id="supplierName" name="<portlet:namespace/>supplierName"
								class="form-control" value="<%=themeDisplay.getUser().getScreenName()%>" disabled>
						</div>
						<div class="col-sm-4 form-group">
							<label>Name of authorized representative</label> <input
								type="text" class="form-control" id="authRepresenName" name="<portlet:namespace/>authRepresenName"
								 placeholder="enter authorized representative name" required="required">
						</div>
						<div class="col-sm-4 form-group">
							<label>Title</label> <input type="text" class="form-control" id="supplierTitle" name="<portlet:namespace/>supplierTitle"
								 placeholder="enter title" required="required">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4 form-group">
							<label>Email address</label> <input type="text" id="emailAddr" name="<portlet:namespace/>emailAddr"
								class="form-control"  placeholder="enter email address" required="required">
						</div>
						<div class="col-sm-4 form-group">
							<label>Telephone</label> <input type="text" class="form-control" id="telephone" name="<portlet:namespace/>telephone"
								 placeholder="enter telephone number" required="required">
						</div>
					</div>
				
				</div>
			</div>
		</div>


	</div>
	
<%-- 		<input type="hidden" name="<portlet:namespace/>regCount" id="regCount"
		value="${regCertificateFileName.size()>0}">
	<div class="row">
		<div class="col-sm-12 form-group regcertificate">
			<label>Uploaded Copy of Registration Certificate:</label>
			<ul id="certiReg">
				<c:forEach items="${regCertificateFileName}" var="payment">
					<li><a href="${payment.key}" target="_blank"> ${payment.value}</a> <c:if
							test="${regCertificateFileName.size()>1}">
						</c:if></li>
				</c:forEach>
			</ul>
		</div>

	</div> --%>
	<!-- submission container end here-->
	
	
		<%-- Popup code --%>

		<div class="popup" data-popup="saveTenderPopUp">
			<div class="popup-inner">
			<div class="modal-header"><h5>Confirmation</h5></div>
				<p>Are you sure?</p>

				<p>
					<!-- <button class="btn btn-primary" type="submit" name="" value="save"
						id="save">Yes</button> -->
					<button class="btn btn-primary" type="submit" name="" value="Yes"
						id="saveTenderSub">Yes</button>
					&ensp; <a class="btn btn-primary"
						data-popup-close="saveTenderPopUp" href="#" id="cancelBtn">No</a>
				</p>

				<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
			</div>
		</div>
		
		<div class="popup" data-popup="deadLineDateTenderSubmitPopUp">
			<div class="popup-inner">
			<div class="modal-header"><h5>Confirmation</h5></div>
				<p>The deadline for Technical Bid Submission has passed, no tender submission can be done.</p>

				<p>
					<a class="btn btn-primary" data-popup-close="saveTenderPopUp"
						href="#" id="cancelBtn">Ok</a>
				</p>

				<a class="popup-close" data-popup-close="saveTenderPopUp" href="#">x</a>
			</div>
		</div>
		
		</form>
	<!--copy content till here for tab content-->
	<div class="row text-center">
		<div class="btnWrapperCenter">
			<button type="button" class="btn btn-previous">Previous</button>
			<button type="button" class="btn btn-save" onclick="saveTenderSubDetails('<%=saveTenderSubDetails.toString()%>')">Save</button>
			<button style ="padding: 7px 24px !important; color: white !important;" class="btn submitbuttton" id="submitbtn" type="button"  onclick="validateForm()" disabled>Submit</button>
			<button class="btn btn-save" id="cancelbtn" type="button" onclick="cancelTenderSubDetails('<%=cancelTenderSubDetails.toString()%>')" disabled>Cancel</button>
		</div>
	</div>
</div>

<!-- <script src="datetimepicker.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1, #datetimepicker2').datetimepicker();

	});

	/*code for file upload*/
	$('#chooseFile').bind('change', function() {
		var filename = $("#chooseFile").val();
		if (/^\s*$/.test(filename)) {
			$("#noFile").text("No file chosen...");
		} else {
			$("#noFile").text(filename.replace("C:\\fakepath\\", ""));
		}
		/*code for file upload end here*/
	});
</script> -->
