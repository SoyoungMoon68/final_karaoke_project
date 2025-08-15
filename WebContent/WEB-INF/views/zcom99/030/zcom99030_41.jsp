<%@ page
  info         = "Project Management"
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

                    <table class="table form">
                        <caption class="blind">상세정보</caption>
                        <colgroup>
                            <col style="width:15%">
                            <col style="width:35%">
                            <col style="width:15%">
                            <col style="width:35%">
                        </colgroup>
                        <tbody>
                            <jsp:include page="/include/zcom/com/include_co_detail.jsp" />
                            
                            <tr>
                                <th>사용자 번호</th>
                                <td colspan="3">
                                    <input type="text" name="userNum"                       id="userNum"                       value="<c:out value="${resultObject.userNum                        }"/>" title="사용자 번호"                    maxlength="20"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="hidden" name="workType"                   id="workType"                     value="<c:out value="${resultObject.workType                      }"/>" title="작업 종류" />
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" />
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>전화 번호</th>
                                <td>
                                    <input type="text" name="phonNum"                      id="phonNum"                      value="<c:out value="${resultObject.phonNum                       }"/>" title="전화 번호"                    maxlength="60"   class="w-full" />
                                </td>
                                <th>메일 주소</th>
                                <td>
                                    <input type="text" name="mailAddr"                     id="mailAddr"                     value="<c:out value="${resultObject.mailAddr                      }"/>" title="메일 주소"                    maxlength="100"  class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>유효 일자</th>
                                <td>
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
                                </td>
                                <th>사용자 권한 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="userAuthCd"                   id="userAuthCd"                   class="w-full">
                                    <c:forEach var="code" items="${userAuthCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.userAuthCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <jsp:include page="/include/zcom/com/include_reg_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

	$.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("userId                        ")));
        
        if ( document.getElementById("userId").readOnly == true ) {
        	document.getElementById("workType").value = "UPDATE";
        } else {
            document.getElementById("workType").value = "INSERT";
        }
        
        if ( isEmpty(document.getElementById("effStaDt").value) ) {
            var now  = new Date();
            document.getElementById("effStaDt").value = now.format("yyyy-MM-dd");
        }
        if ( isEmpty(document.getElementById("effEndDt").value) ) {
        	document.getElementById("effEndDt").value = "9999-12-31";
        }
    }

    setKeyReadonly();

</script>

