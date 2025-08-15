<%@ page
  info         = "DongHun Yu"
  language     = "java"
  session      = "true"
  buffer       = "16kb" 
  autoFlush    = "true"
  isThreadSafe = "true"
  isErrorPage  = "false"
  contentType  = "text/html; charset=utf-8"
%>

<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <div class="input-group w-full">
                                <strong>업체 ID</strong>
                                <p>
                                    <span class="select-box">
                                    <select name="srchGrpCoId" id="srchGrpCoId" class="w-full" onchange="requestSrch(); return false;">
                                    <c:forEach var="code" items="${coList}" varStatus="status">
		                                <c:if test="${status.index == 0}">
		                                    <c:set var="srchGrpCoId" value="${code.grpCoId}"/>
		                                    <c:set var="srchGrpCoNm" value="${code.grpCoNm}"/>
		                                </c:if>
		                                <c:if test="${code.coId == srchCoId}">
		                                    <c:set var="srchGrpCoId" value="${code.grpCoId}"/>
		                                    <c:set var="srchGrpCoNm" value="${code.grpCoNm}"/>
		                                </c:if>
                                        <option value="${code.grpCoId}" <c:if test="${code.grpCoId == srchGrpCoId}">selected</c:if>>[ ${code.grpCoId} ] ${code.grpCoNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </p>
                                <input type="hidden" name="srchGrpCoNm" id="srchGrpCoNm" value="<c:out value="${srchGrpCoNm}"/>" class="w-full" title="그룹사 명" />
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="srchGrpCoId" id="srchGrpCoId" value="<c:out value="${sessionUser.grpCoId}"/>" class="w-full" title="그룹사 ID" />
                                <input type="hidden" name="srchGrpCoNm" id="srchGrpCoNm" value="<c:out value="${sessionUser.grpCoNm}"/>" class="w-full" title="그룹사 명" />
</c:if>

