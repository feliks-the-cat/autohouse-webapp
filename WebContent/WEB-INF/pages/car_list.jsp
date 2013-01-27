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
					<form:form  action="CarList.htm" method="POST" >
						Введите марку
						<input type="text" name="request"/>
						<input type="submit" value="Поиск">
					</form:form>
				</td>
				<td>
					<form:form  action="CarAdd.htm" method="POST" modelAttribute="carList">
						<input type="submit" value="Новый автомобиль">
					</form:form>
				</td>
			</tr>
		</table>
		<c:if test="${!empty carList}">
			<h3>СПИСОК</h3>
			<table cellpadding="3">
				<tr class="header">
					<th>Марка</th>
					<th>Модель</th>
					<th>Год выпуска</th>
					<th>Пробег</th> 
					<th>Цена</th> 
					<th>VIN-код</th>
					<th>Тип кузова</th>
					<th>Объем двигателя</th>
					<th colspan="9">Выберите действие</th>
				</tr>
				<c:forEach items="${carList}" var="car">
					<tr>
						<td>${car.carBrand}</td>
						<td>${car.carModel}</td>
						<td>${car.carYear}</td>
						<td>${car.carMileage}</td>
						<td>${car.carPrice} у.е.</td>
						<td>${car.carVin}</td>
						<td>${car.body.bodyName}</td>
						<td>${car.carCapacity}</td>
						<td><a href="CarUpdate?id=${car.carId}" class="button">Изменить</a></td>
						<td><a href="CarSale?id=${car.carId}"   class="button">Продать</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>