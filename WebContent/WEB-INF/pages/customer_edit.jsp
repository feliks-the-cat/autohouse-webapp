<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Редактирование</title>
		<style>
			.error {
				color: #ff0000;
			}
			.header {
				background-color: #DAE4EF;
			}
			a {
				color: #000000;
				text-decoration: none;
				background: transparent;
			}
			a:hover {
				color: #000000;
				text-decoration: none;
				background: #F8F8F8;
			}
			.button { 
				background: #F4F4F4;
				border-color: #BFBFBF;
				border-radius: 4px;
				border-width: 1px;
				border-style: solid;
				cursor: pointer;
				display: inline-block;
				line-height: 19px;
				padding-bottom: 1px;
				padding-left: 7px;
				padding-right: 7px;
			}
		</style>		
	</head>
	<body>
		<form:form action="CustomerAdd.htm" method="POST" modelAttribute="customer">
			<form:hidden path="customerId"/>
			<h3>ПОКУПАТЕЛЬ</h3> 
			<table>
				<tr>
					<td>Ф.И.О. :</td>
					<td><form:input path="customerFio" style="width: 300px"/></td>
					<td><form:errors path="customerFio" cssClass="error"/></td>
				</tr>
				<tr> 
					<td>Адрес :</td>
					<td><form:input path="customerAddress" style="width: 300px"/></td>
					<td><form:errors path="customerAddress" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Паспорт :</td>
					<td><form:input path="customerPassportNumber" style="width: 300px"/></td>
					<td><form:errors path="customerPassportNumber" cssClass="error"/></td>
				</tr>	
				<tr>
					<td>Кем выдан :</td>
					<td><form:input path="customerPassportIssuePlace" style="width: 300px"/></td>
					<td><form:errors path="customerPassportIssuePlace" cssClass="error"/></td>
				</tr>	
				<tr>
					<td>Дата выдачи :</td>
					<td><form:input path="customerPassportIssueDate" style="width: 300px"/></td>
					<td><form:errors path="customerPassportIssueDate" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Телефон :</td>
					<td><form:input path="customerPhoneNumber" style="width: 300px"/></td>
					<td><form:errors path="customerPhoneNumber" cssClass="error"/></td>
				</tr>	
				<tr>
					<td><input type="submit" value="Принять"></td>
					<td colspan="2"><a href="CustomerList" class="button">Отменить</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>