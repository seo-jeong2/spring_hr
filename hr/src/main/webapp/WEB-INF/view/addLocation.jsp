<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
   $('#regionId').change(function() {
      // alert('regionId change');
      // ajax호출 -> 값 -> countryId select append
      if($('#regionId').val() == '') {
         alert('region을 선택하세요');
      } else {
         $('#countryId').empty();
         $('#countryId').append('<option value="">::: country 선택 :::</option>')
         
         $.ajax({
            url : '/rest/getCountryList',
            type : 'get',
            data : {regionId : $('#regionId').val()},
            success : function(json) {
               //let arr = [];
               $(json).each(function(index, item){
                  //arr.push(item);
                  $('#countryId').append('<option value="'+item.countryId+'">'+item.countryName+'</option>')
               });
               //console.log(arr);
            }
         });
      }
   });
});
</script>
</head>
<body>
   <!-- menu.jsp include(forward동일한 기술) -->
   <div>
      <c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
   </div>
   <hr>

	<form method="post" action="${pageContext.request.contextPath}/addLocation">
		
		<div>
			regionId : 
			<select name ="regionId" id="regionId">
			<option value="">==선택해주세요==</option> 
			<c:forEach var="r" items="${regionList}">
			<option value="${r.regionId}">${r.regionName}</option>
			</c:forEach></select>
		</div>
		<div>
			countryId : 
			<select name = "countryId" id="countryId">
			<option value="">==선택해주세요==</option> 
			<c:forEach var="c" items="${countryList}">
			<option value="${c.countryId}">${c.countryName}</option>
			</c:forEach>
			</select>
		</div>
		<div>
			locationId : 
			<input type="text" name="locationId">
		</div>		
		<div>
			streetAddress : 
			<input type="text" name="streetAddress">
		</div>	
		<div>
			postalCode : 
			<input type="text" name="postalCode">
		</div>	
		<div>
			city : 
			<input type="text" name="city">
		</div>	
		<div>
			stateProvince : 
			<input type="text" name="stateProvince">
		</div>	
		<div>
			countryId : 
		<input type="text" name="countryId">
		</div>		
		<div> 
			<button type="submit">addLocation</button>
		</div>		
	</form>
	
	   <!-- footer include -->
   <hr>
   <div>
      <c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
   </div>
</body>
</html>