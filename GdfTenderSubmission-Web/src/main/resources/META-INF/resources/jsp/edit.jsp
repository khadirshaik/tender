<%@ include file="/jsp/init.jsp"%>



	<%@ include file="/jsp/breadcrum.jsp"%>

	<div class="container">
		<div>
			<%@ include file="tabs.jsp"%>

		</div>

		<div class="col-lg-12">
			<div class="row">
				<div class="tab-content">

					<ul class="errorMessages"></ul>
					<div id="loaderWrap" class="grayout" style='display: none;'>
						<img id="loadingSpinner"
							src='${portalUrl}/o/StopTBTheme/images/loading.gif'>
					</div>



					<%@ include file="editSelectGdfTender.jsp"%>

					<%@ include file="editProductSelection.jsp"%>

					<%@ include file="editAlreadySeletedProducts.jsp"%>

					<%@ include file="editProductRegistration.jsp"%>

					<div id="gl4" class="gl tab-pane fade ">
						<span class="row adhocSupplier"> </span>
						
						<%@ include file="editTenderSubmission.jsp"%>

						
							<!-- <div class="row text-center">
								
									<div class="btnWrapperCenter">
										<button class="btn btn-nxt sub" id="createSubmit"
											type="submit">Submit</button>
									</div>
								</div> -->
							</div>
						</div>

					</div>
				</div>
			</div>


