<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- menu.jsp include(forward동일한 기술) -->
   <div>
      <c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
   </div>
   <hr>

	<form method="post" action="${pageContext.request.contextPath}/addCountry">
		<div>
			countryId : 
			<input type="text" name="countryId">
		</div>
		<div>
			countryName : 
			<input type="text" name="countryName">
		</div>
		<div>
			regionId : 
			<select name ="regionId">
			<option value="">==선택해주세요==</option> 
			<c:forEach var="r" items="${regionList}">
			<option value="${r.regionId}">${r.regionId}</option>
			</c:forEach></select>
		</div>
				
		<div> 
			<button type="submit">addCountry</button>
		</div>		
	</form>
	
	   <!-- footer include -->
   <hr>
   <div>
      <c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
   </div>
</body>
</html>