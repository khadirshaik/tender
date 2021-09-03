<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/jsp/init.jsp"%>
<style>
a.link-secondary {
	background: #dc3545;
	color: #fff;
	display: inline-block;
	padding: 8px 12px;
	border-radius: 4px;
	border-color: #bd2130;
}

a.link-secondary:hover {
	color: #fff;
	background-color: #c82333;
	border-color: #bd2130;
	text-decoration: none;
}
</style>


	

<%-- tenderReferenceNumber::::: <c:out value="<%=renderRequest.getAttribute("tenderReferenceNumber")%>" /> --%>

<div class="parent-container">

	<div class="container">
		<div>
			<div class="container">


				<div class=" text-center successBox">
					<div class="row">
						<div class="col-sm-12 form-group pd-top-15 ">
							<i
								class="fa fa-check-circle  fa-1x approve-circle-icon pd-rt-5 landing-icon"
								aria-hidden="true"></i>
						</div>
						<div>
							<p> "You have successfully updated your
								GDF tender with
								tender reference number <strong><%=renderRequest.getParameter("tenderRefNumber")%>
								</strong>
								
							</p>

						</div>
					</div>
					<br>

				</div>
				<div class="row text-center">
					<div class="btnWrapperCenter">
						<div class="col-sm-12 form-group">
							<a class="link-secondary" href='${themeDisplay.getPortalURL()}${themeDisplay.getPathFriendlyURLPublic()}${themeDisplay.getScopeGroup().getFriendlyURL()}${themeDisplay.getLayout().getFriendlyURL()}'>OK</a>
						</div>
					</div>
				</div>


			</div>

		</div>

	</div>
	<br> <br> <br> <br>
</div>





