<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Список</title>
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
		<a href="CustomerList" class="button">Справочник клиентов</a>
		<a href="CarList"      class="button">Справочник автомобилей</a>
		<a href="SaleStat"     class="button">Отчет о продажах</a>
		<h3>ПОИСК</h3>
		<table>
			<tr>
				<td>
					<form:form  action="CustomerList.htm" method="POST" >
						Введите № паспорта
						<input type="text" name="request"/>
						<input type="submit" value="Поиск">
					</form:form>
				</td>
				<td>
					<form:form  action="CustomerAdd.htm" method="POST" modelAttribute="customerList">
						<input type="submit" value="Новый клиент">
					</form:form>
				</td>
			</tr>
		</table>
		<c:if test="${!empty customerList}">
			<h3>СПИСОК</h3>
			<table cellpadding="3">
				<tr class="header">
					<th>Ф.И.О.</th>
					<th>Адрес</th>
					<th>Паспорт</th>
					<th>Кем выдан</th> 
					<th>Дата выдачи</th> 
					<th>Телефон</th> 
					<th colspan="7">Выберите действие</th>
				</tr>
				<c:forEach items="${customerList}" var="customer">
					<tr>
						<td>${customer.customerFio}</td>
						<td>${customer.customerAddress}</td>
						<td>${customer.customerPassportNumber}</td>
						<td>${customer.customerPassportIssuePlace}</td>
						<td>${customer.customerPassportIssueDate}</td>
						<td>${customer.customerPhoneNumber}</td>
						<td><a href="CustomerUpdate?id=${customer.customerId}" class="button">Изменить</a></td>
						<td><a href="CustomerSales?id=${customer.customerId}"  class="button">Договора</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>