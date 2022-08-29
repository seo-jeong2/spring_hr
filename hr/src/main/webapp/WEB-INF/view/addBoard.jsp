<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
   $('#removeFile').click(function(){
      $('#fileSection').empty();
   });
   
   $('#addFile').click(function(){
      let isFileEmpty = false;
      
      let html = '<div><input type="file" name="multiList" class="multiList"></div>';
      
      $('.multiList').each(function(index, item){
         // $(this) --> item
         if($(item).val() == '') {
            isFileEmpty = true;
         }
      });
      if(isFileEmpty == false) {
         $('#fileSection').append(html);
      }
   });
   
   $('#addButton').click(function(){
      let isFileEmpty = false;
      // board 유효성검사 후...
      
      $('.multiList').each(function(index, item){
         // $(this) --> item
         if($(item).val() == '') {
            isFileEmpty = true;
         }
      });
      
      if($('#boardTitle').val() == '') {
         alert('boradTitle를 입력하세요');
      } else if(isFileEmpty == true) {
         alert('boradTitle를 입력하세요');
      } else {
    	  addButton.submit();
         // submit....
      }
   });
});
</script>
</head>
<body>
   <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/addBoard">
      <!-- 보드 내용들... -->
      <div>
         boardTitle 
         <input type="text" name="board.boardTitle" id="boardTitle">
      </div>
      <!-- 보드 내용들... -->
      
      <button type="button" id="addFile">파일추가</button> <!--  input type="file" -->
      <button type="button" id="removeFile">파일삭제</button>
      <div id="fileSection">      
      </div>
      
      <button type="submit" id="addButton">addBoard</button>
   </form>
</body>
</html>