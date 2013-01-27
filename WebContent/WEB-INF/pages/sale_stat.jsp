<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Статистика</title>
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
		<h3>ОТЧЕТ О ПРОДАЖАХ</h3>
		<form:form  modelAttribute="saleList">
			<c:if test="${!empty saleList}">
				<table cellpadding="3">
					<tr class="header">
						<th>Дата</th>
						<th>№ договора</th>
						<th>Покупатель</th>
						<th>Автомобиль</th>
						<th>Цена</th>
					</tr>
					<c:forEach items="${saleList}" var="sale">
						<tr>
							<td>${sale.saleDate}</td>
							<td>${sale.saleId}</td>
							<td>${sale.customer.customerFio}</td>
							<td>${sale.car.carBrand} ${sale.car.carModel} ${sale.car.carYear} г.в.</td>
							<td>${sale.car.carPrice} у.е.</td>
						</tr>
					</c:forEach>
					<tr> 
							<td></td>
							<td></td>
							<td></td>
							<td>___________</td>
							<td>___________</td>
					</tr>
					<tr> 
							<td></td>
							<td></td>
							<td></td>
							<td>Итого :</td>
							<td>${sum} у.е.</td>
					</tr>
				</table>
			</c:if>
		</form:form>
	</body>
</html>