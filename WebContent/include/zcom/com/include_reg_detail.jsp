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
                            <tr>
                                <th>등록자</th>
                                <td>
                                    <input type="text" name="regUserNum"                   id="regUserNum"                   value="<c:out value="${resultObject.regUserNum                    }"/>" class="w-p40" title="등록 사용자 ID" readonly="readonly" placeholder="등록 사용자 ID">
                                    <input type="text" name="regUserNm"                    id="regUserNm"                    value="<c:out value="${resultObject.regUserNm                     }"/>" class="w-p40" title="등록 사용자 명" readonly="readonly" placeholder="등록 사용자 명">
                                </td>
                                <th>등록 일시 / IP</th>
                                <td>
                                    <input type="text" name="rgstDtm"                      id="regDtm"                       value="<c:out value="${resultObject.regDtmFormat                  }"/>" class="w-p50" title="등록 일시"      readonly="readonly" placeholder="등록 일시">
                                    <input type="text" name="rgstIp"                       id="regIp"                        value="<c:out value="${resultObject.regIp                         }"/>" class="w-p40" title="등록 IP"        readonly="readonly" placeholder="등록 IP">
                                </td>
                            </tr>
                            <tr>
                                <th>수정자</th>
                                <td>
                                    <input type="text" name="updUserNum"                   id="updUserNum"                   value="<c:out value="${resultObject.updUserNum                    }"/>" class="w-p40" title="수정 사용자 ID" readonly="readonly" placeholder="수정 사용자 ID">
                                    <input type="text" name="updUserNm"                    id="updUserNm"                    value="<c:out value="${resultObject.updUserNm                     }"/>" class="w-p40" title="수정 사용자 명" readonly="readonly" placeholder="수정 사용자 명">
                                </td>
                                <th>수정 일시 / IP</th>
                                <td>
                                    <input type="text" name="updtDtm"                      id="updDtm"                       value="<c:out value="${resultObject.updDtmFormat                  }"/>" class="w-p50" title="수정 일시"      readonly="readonly" placeholder="수정 일시">
                                    <input type="text" name="updtIp"                       id="updIp"                        value="<c:out value="${resultObject.updIp                         }"/>" class="w-p40" title="수정 IP"        readonly="readonly" placeholder="수정 IP">
                                </td>
                            </tr>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
</c:if>
