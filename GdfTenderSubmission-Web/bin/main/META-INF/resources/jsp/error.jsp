<%@ include file="/jsp/init.jsp"%>


<%-- FriendlyURLPublic::: ${themeDisplay.getPathFriendlyURLPublic()}
getURLHome::: ${themeDisplay.getURLHome()}

 getURLCurrent:::: ${themeDisplay.getURLCurrent()}
getPortalURL::::: ${themeDisplay.getPortalURL()}


getFriendlyURL:::: ${layout.getFriendlyURL()}

getScopeGroupFriendlyURL:::: ${themeDisplay.getScopeGroup().getFriendlyURL()}

getLayoutFriendlyURL:::: ${themeDisplay.getLayout().getFriendlyURL()}


<a href='${themeDisplay.getURLHome()}${layout.getFriendlyURL()}'>urltest</a> --%>

 <div class="parent-container">       

        <div class="container">
          
                <div class="container">
                   

				<div class=" text-center errorBox">
					<div class="row">
						<div class="col-sm-12 form-group pd-top-15 ">
							<i
								class="fa fa-times-circle fa-1x reject-circle-icon pd-rt-5 landing-icon"
								aria-hidden="true"></i>
						</div>
						<div>
							<label> There was an error trying to send your message.
								Please try again later. </label>

						</div>
					</div>
					<br>

				</div>
					<div class="row text-center">
						<div class="btnWrapperCenter">
							<div class="col-sm-12 form-group">
							<%-- 	<a class="link-secondary" href='${themeDisplay.getPortalURL()}${themeDisplay.getPathFriendlyURLPublic()}${themeDisplay.getScopeGroup().getFriendlyURL()}/tendersubmission/view'>OK</a> --%>
							<a class="link-secondary" href="/web/guest/tendersubmission/view">OK</a>
							</div>
						</div>
					</div>
		</div>

	</div>
	</div>