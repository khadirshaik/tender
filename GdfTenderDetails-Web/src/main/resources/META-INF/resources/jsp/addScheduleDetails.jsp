<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<input type="hidden" id="productCatChanged" value="" />


<!-- TenderItem row start when click on the + button  -->
<div style="display: none;">
	<table id="sample_table">
		<tr id="">
			<td class="sr-Number  xs-small" id="duplicate-number"><input
				type="number" min="1" max="100" class="sn form-control tenderItem"
				name="<portlet:namespace/>tenderItemNumber" id="tenderItemNumber"></td>
			<input type="hidden" class="form-control tenderRefId"
				name="<portlet:namespace/>tenderItemRefId" value="0" />
			<td class="gdf-generic-code"><strong>GDF Generic Code</strong>
				<p>
					<select class="form-control gdfGenCode"
						name="<portlet:namespace/>gdfGenericCode" id="gdfGenericCode">
						<option value="" selected="selected">Select</option>
						<c:forEach items="${productGenricList}" var="genericCodeList">
							<option value="${genericCodeList.gdfGenericCode}">${genericCodeList.gdfGenericCode}</option>
						</c:forEach>
					</select>
				</p></td>
			<td><strong>General Description</strong>
				<p>
					<textarea class="form-control genDesc"
						name="<portlet:namespace/>generalDescription"
						id="generalDescription"></textarea>
				</p></td>
			<td><strong>Primary packaging</strong>
				<p>
					<textarea class="form-control primPack"
						name="<portlet:namespace/>primaryPackaging" id="primaryPackaging"></textarea>
				</p></td>
			<td><strong>Secondary Packaging</strong>

				<p>
					<textarea class="form-control secPack"
						name="<portlet:namespace/>secondaryPackaging"
						id="secondaryPackaging"></textarea>
				</p></td>
			<td class="action"><a class="add-btn-tb"> <i
					class="fa fa-plus-circle fa-2x " aria-hidden="true"></i>
			</a> <a class="remove-row" data-id="0"> <i
					class="fa fa-minus-circle fa-2x remove_fieldTable_page3${fdcCnt}"
					aria-hidden="true"></i>
			</a></td>
		</tr>
	</table>
</div>

<!-- TenderItem row END  -->

<!-- Add Schedule START  -->
<div class="list-product clone"  id="prod-wrapper">
	<div class="row">

		<div class="col-sm-4 form-group">
			<label for="scheduleNumber">Schedule number</label> <select
				class="form-control scheduleNumberDropdown"
				name="<portlet:namespace/>scheduleNumber" id="scheduleNumber">
				<option value="" id="">Select</option>

				<%-- <option value="" id="">Select</option>
						<c:forEach var="tenderscheds" items="${tenderschedList}">
						
							<option value="${tenderscheds.scheduleNumber}"
								id="${tenderscheds.scheduleName},${tenderscheds.patientTarget}">${tenderscheds.scheduleNumber}</option>
								
						</c:forEach> --%>

			</select>
		</div>

		<div class="col-sm-4 form-group schudule-nameDiv">
			<label for="scheduleName">Schedule Name</label> <input type="text"
				class="form-control schedName"
				name="<portlet:namespace/>scheduleName" id="scheduleName"
				value="${tenderscheds.scheduleName}" readonly>

		</div>
		<div class="col-sm-4 form-group schudule-patientDiv">
			<label for="patientTarget">Patient Target</label> <input type="text"
				class="form-control patTarget" value="${tenderscheds.patientTarget}"
				name="<portlet:namespace/>patientTarget" id="patientTarget" readonly>
		</div>



	</div>
	<!-- fields end here-->
	<div class="">

		<a class="accordion-header active"> Schedule Number : <span
			class="scheduleNumber"></span>
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
					<tr id="rec-1">
						<td class="sr-Number  xs-small" id="duplicate-number"><strong>Tender
								item number</strong>
							<p>
								<input class="sn form-control tenderItem"
									name="<portlet:namespace/>tenderItemNumber"
									id="tenderItemNumber" type="number" min="1" max="100" value="">
							</p></td>
						<td class="gdf-generic-code"><strong>GDF Generic
								Code</strong>
							<p>
								<select class="form-control gdfGenCode"
									name="<portlet:namespace/>gdfGenericCode" id="gdfGenericCode">
									<option value="" selected="selected">Select</option>
									<c:forEach items="${productGenricList}" var="genericCodeList">
										<option value="${genericCodeList.gdfGenericCode}">${genericCodeList.gdfGenericCode}</option>
									</c:forEach>
								</select>
							</p></td>
						<td><strong>General Description</strong>
							<p>
								<textarea class="form-control genDesc"
									name="<portlet:namespace/>generalDescription"
									id="generalDescription"></textarea>
							</p></td>
						<td><strong>Primary packaging</strong>
							<p>
								<textarea class="form-control primPack"
									name="<portlet:namespace/>primaryPackaging"
									id="primaryPackaging"></textarea>
							</p></td>
						<td><strong>Secondary Packaging</strong>

							<p>
								<textarea class="form-control secPack"
									name="<portlet:namespace/>secondaryPackaging"
									id="secondaryPackaging"></textarea>
							</p></td>
						<td class="action"><strong>Action</strong>
							<p>
								<a class="add-btn"> <i class="fa fa-plus-circle fa-2x "
									aria-hidden="true"></i>
								</a> <a class="remove-row"> <i
									class="fa fa-minus-circle fa-2x remove_fieldTable_page3${fdcCnt}"
									aria-hidden="true"></i>
								</a>
							</p>
					</tr>

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
</div>
<!-- Add Schedule END  -->





