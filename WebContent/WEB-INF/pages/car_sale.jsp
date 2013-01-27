<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Продажа</title>
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
		<form:form action="CarSaleConfirm.htm" method="POST" modelAttribute="sale">
			<form:hidden path="saleId"/>
			<form:hidden path="car.carId"/>
			<h3>ПРОДАЖА АВТОМОБИЛЯ</h3> 
			<table>
				<tr>
					<td>Марка :</td>
					<td>${carInfo.carBrand}</td>
					<td></td>
				</tr>
				<tr> 
					<td>Модель :</td>
					<td>${carInfo.carModel}</td>
					<td></td>
				</tr>
				<tr>
					<td>Год выпуска :</td>
					<td>${carInfo.carYear}</td>
					<td></td>
				</tr>	
				<tr>
					<td>Цена :</td>
					<td>${carInfo.carPrice} у.е.</td>
					<td></td>
				</tr>
				<tr>
					<td>VIN-код :</td>
					<td>${carInfo.carVin}</td>
					<td></td>
				</tr>
				<tr>
					<td>Покупатель :</td>
					<td>
						<form:select path="customer.customerId" multiple="false" size="1" style="width: 155px">
							<form:option value="0" label="NONE"/>
							<form:options items="${customerList}" itemValue="customerId" itemLabel="customerFio"/>
						</form:select>
					</td>
					<td><form:errors path="customer" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Место продажи :</td>
					<td><form:input path="salePlace"/></td>
					<td><form:errors path="salePlace" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Дата продажи :</td>
					<td><form:input path="saleDate"/></td>
					<td><form:errors path="saleDate" cssClass="error"/></td>
				</tr>	
				<tr>
					<td><input type="submit" value="Принять"></td>
					<td colspan="2"><a href="CarList" class="button">Отменить</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>