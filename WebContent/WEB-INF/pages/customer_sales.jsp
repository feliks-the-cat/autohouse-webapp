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
		<form:form  modelAttribute="customerSales">
			<a href="CustomerList.htm" class="button">Вернуться</a>
			<c:if test="${!empty customerSales}">
				<h3>ПОКУПАТЕЛЬ</h3>
				${customer.customerFio} <br/>
				${customer.customerPassportNumber}
				<h3>СПИСОК ДОГОВОРОВ</h3>
				<table cellpadding="3">
					<tr class="header">
						<th>Дата</th>
						<th>№ договора</th>
						<th>Автомобиль</th>
						<th>Цена</th>
						<th colspan="4">Выберите действие</th>
					</tr>
					<c:forEach items="${customerSales}" var="sale">
						<tr>
							<td>${sale.saleDate}</td>
							<td>${sale.saleId}</td>
							<td>${sale.car.carBrand} ${sale.car.carModel} ${sale.car.carYear} г.в.</td>
							<td>${sale.car.carPrice} у.е.</td>
							<td><a href="DealPrint?id=${sale.saleId}" target="_blank" class="button">Распечатать</a></td>
							<td><a href="DealDelete?id=${sale.saleId}" class="button">Аннулировать</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form:form>
	</body>
</html>