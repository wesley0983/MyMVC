<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	ProdouctVO prodouctVO = (ProdouctVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�ӫ~���O��� - listOneEmp.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<td>�ӫ~�s��</td>
		<td>�ӫ~���O�s��</td>
		<td>�ӫ~�W��</td>
		<td>�ӫ~�Ϥ�</td>
		<td>�Ӥ����ɦW</td>
		<td>�ӫ~�W��</td>
		<td>�ӫ~���</td>
		<td>�ӫ~�w�s�q</td>
		<td>�ӫ~�w���w�s�q</td>
		<td>�ӫ~�ԭz</td>
		<td>�ӫ~���A</td>
		<td>�ӫ~�`����</td>
		<td>�ӫ~�����`�H��</td>
	
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