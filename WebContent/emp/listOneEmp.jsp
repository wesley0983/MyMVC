<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	ProdouctVO prodouctVO = (ProdouctVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>商品類別資料 - listOneEmp.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<td>商品編號</td>
		<td>商品類別編號</td>
		<td>商品名稱</td>
		<td>商品圖片</td>
		<td>照片副檔名</td>
		<td>商品規格</td>
		<td>商品單價</td>
		<td>商品庫存量</td>
		<td>商品安全庫存量</td>
		<td>商品詳述</td>
		<td>商品狀態</td>
		<td>商品總評價</td>
		<td>商品評價總人數</td>
	
	</tr>
	<tr>
	     <td><%=prodouctVO.getPro_no()%></td>
		 <td><%=prodouctVO.getPro_classid()%></td>
		 <td><%=prodouctVO.getPro_name()%></td>
		 <td><%=prodouctVO.getPro_pic()%></td>
		 <td><%=prodouctVO.getPro_pic_ext()%></td>
		 <td><%=prodouctVO.getPro_format()%></td>
		 <td><%=prodouctVO.getPro_bonus()%></td>
		 <td><%=prodouctVO.getPro_stock()%></td>
		 <td><%=prodouctVO.getPro_safestock()%></td>
		 <td><%=prodouctVO.getPro_details()%></td>
		 <td><%=prodouctVO.getPro_shelve()%></td>
		 <td><%=prodouctVO.getPro_all_assess()%></td>
		 <td><%=prodouctVO.getPro_all_assessman()%></td>
	
	</tr>
</table>

</body>
</html>