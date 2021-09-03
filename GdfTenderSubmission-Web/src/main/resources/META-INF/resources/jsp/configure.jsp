<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<liferay-theme:defineObjects />
<portlet:defineObjects />
<% 
String currentPage= (String)renderRequest.getAttribute("currentPage");
%>
<c:set var="currentPage"  value="${currentPage}"  scope="page" />


<c:if test = "${currentPage == 'create'}">
     <%@ include file="create.jsp" %>     
</c:if>

<c:if test = "${currentPage == 'success'}">
     <%@ include file="success.jsp" %>     
</c:if>

<c:if test = "${currentPage == 'edit'}">
     <%@ include file="edit.jsp" %>     
</c:if>

<c:if test = "${currentPage == 'view'}">
     <%@ include file="view.jsp" %>     
</c:if>

<c:if test = "${currentPage == 'error'}">
     <%@ include file="error.jsp" %>     
</c:if>

