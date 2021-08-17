<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach items="${resultList}" var="menuList" varStatus="status">
			<li>
				<c:choose>
					<c:when test="${status.count eq 1}">
	        			<a href="<c:out value="${menuList.menuPath}" />" class="title"> <c:out value="${menuList.menuNm}" /></a>
	    			</c:when> 
	    			<c:when test="${currentMenu eq menuList.menuNm}">
	        			<a href="<c:out value="${menuList.menuPath}" />" class="active"> <c:out value="${menuList.menuNm}" /></a>
	    			</c:when>
	    			<c:otherwise>
						<a href="<c:out value="${menuList.menuPath}" />"> <c:out value="${menuList.menuNm}" />  </a>
					</c:otherwise>
				</c:choose> 
			</li>
		</c:forEach>
	</ul>
</body>
</html>
