<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	ProductVO proVO = (ProductVO) request.getAttribute("proVO"); //EmpServlet.java (Concroller) 存入req的proVO物件 (包括幫忙取出的proVO, 也包括輸入資料錯誤時的proVO物件)
%>




<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
   #pre01 {
	   width: 300px;
	   height: auto;
  }
  .imgsize {
   width: 300px;
   height: auto;
  }
  
  
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料修改 - update_emp_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="pro.do" name="form1" enctype="multipart/form-data">
<table>
<tr>


	<tr>
		<td>商品編號:<font color=red><b>*</b></font></td>
		<td><%=proVO.getPro_no()%></td>
	</tr>
	
	<jsp:useBean id="productClassSvc" scope="page" class="com.productclass.model.ProductClassService" />
	<tr>
		<td>商品類別編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="pro_classid">
			<c:forEach var="productClassVO" items="${productClassSvc.all}">
				<option value="${productClassVO.pro_classid}" ${(productClassVO.pro_classid==productClassVO.pro_classid)?'selected':'' } >${productClassVO.pro_classname}
			</c:forEach>
		</select></td>
	</tr>

<tr>
  <td>商品名稱:</td>
  <td><input type="TEXT" name="ename" size="45" 
     value="<%= proVO.getPro_name()%>" /></td>
</tr>
<!--    ***************************************************** 	 -->

	<tr>
		<td>商品圖片:</td>		
		<td><input type="file" name="pro_pic" id="file01"><br/></td>
	</tr>
	<tr id="preset">
		<td>商品圖片預覽:</td>
		<td><img class="imgsize" src="<%=request.getContextPath()%>/pro/proImg.do?pro_no=<%= proVO.getPro_no()%>">   </td>
	</tr>
	<tr id="display">
		<td>商品圖片預覽:</td>
		<td><img id="pre01">   </td>
	</tr>
<!--    ***************************************************** 	 -->

<tr>
  <td>照片副檔名:</td>
  <td><input type="TEXT" name="pic_ext" size="45"
     value="<%= proVO.getPro_pic_ext()%>" /></td>
</tr>
<tr>
  <td>商品規格:</td>
  <td><input type="TEXT" name="format" size="45"
     value="<%=  proVO.getPro_format()%>" /></td>
</tr>
<tr>
  <td>商品單價:</td>
  <td><input type="TEXT" name="bonus" size="45"
     value="<%= proVO.getPro_bonus()%>" /></td>
</tr>
<tr>
  <td>商品庫存量:</td>
  <td><input type="TEXT" name="stock" size="45"
     value="<%= proVO.getPro_stock()%>" /></td>
</tr>
<tr>
  <td>商品安全庫存量:</td>
  <td><input type="TEXT" name="safestock" size="45"
     value="<%= proVO.getPro_safestock()%>" /></td>
</tr>
<tr>
  <td>商品詳述:</td>
  <td><input type="TEXT" name="details" size="45"
     value="<%=  proVO.getPro_details()%>" /></td>
</tr>
<tr>
  <td>商品狀態:</td>
  <td><input type="TEXT" name="shelve" size="45"
     value="<%=  proVO.getPro_shelve()%>" /></td>
</tr>
<tr>
  <td>商品總評價:</td>
  <td><input type="TEXT" name="assess" size="45"
     value="<%= proVO.getPro_all_assess()%>" /></td>
</tr>
<tr>
  <td>商品評價總人數:</td>
  <td><input type="TEXT" name="assessman" size="45"
     value="<%= proVO.getPro_all_assessman()%>" /></td>
</tr>



</table>
<br>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="pro_no" value="<%=proVO.getPro_no()%>">
	<input type="submit" value="送出修改"></FORM>
<script src="https://code.jquery.com/jquery.js"></script>	
	
<script type="text/javascript"> 
		document.getElementById("display").style.display = 'none';
	    $(function() {  //將圖片預覽
	    	$('input[type=file]').change(function() {
	      	var input = $(this);
	      	document.getElementById("preset").style.display = 'none';
	      	document.getElementById("display").style.display = 'block';
	      	if(!!this.files && !!this.files[0]) {
	        	var reader = new FileReader();
	          reader.onload = function(e) {
	          	$('#pre' + input.prop('id').substr(4,2)).prop('src', e.target.result);
	          }
	          reader.readAsDataURL(this.files[0]);
	        }
	      });
	    });
//******************************************
    
	    
</script>

</body>




</html>