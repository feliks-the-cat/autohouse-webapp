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
		<form:form action="CarAdd.htm" method="POST" modelAttribute="car">
			<form:hidden path="carId"/>
			<form:hidden path="carIsSold"/>
			<h3>АВТОМОБИЛЬ</h3> 
			<table>
				<tr>
					<td>Марка :</td>
					<td><form:input path="carBrand"/></td>
					<td><form:errors path="carBrand" cssClass="error"/></td>
				</tr>
				<tr> 
					<td>Модель :</td>
					<td><form:input path="carModel"/></td>
					<td><form:errors path="carModel" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Год выпуска :</td>
					<td><form:input path="carYear"/></td>
					<td><form:errors path="carYear" cssClass="error"/></td>
				</tr>	
				<tr>
					<td>Пробег :</td>
					<td><form:input path="carMileage"/> км.</td>
					<td><form:errors path="carMileage" cssClass="error"/></td>
				</tr>	
				<tr>
					<td>Цена :</td>
					<td><form:input path="carPrice"/> у.е.</td>
					<td><form:errors path="carPrice" cssClass="error"/></td>
				</tr>
				<tr>
					<td>VIN-код :</td>
					<td><form:input path="carVin"/></td>
					<td><form:errors path="carVin" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Тип кузова :</td>
					<td>
						<form:select path="body.bodyId" multiple="false" size="1" style="width: 155px">
							<form:option value="0" label="NONE"/>
							<form:options items="${bodyList}" itemValue="bodyId" itemLabel="bodyName"/>
						</form:select>
					</td>
					<td><form:errors path="body" cssClass="error"/></td>
				</tr>	
				<tr>
					<td>Объем двигателя :</td>
					<td><form:input path="carCapacity"/></td>
					<td><form:errors path="carCapacity" cssClass="error"/></td>
				</tr>	
				<tr>
					<td><input type="submit" value="Принять"></td>
					<td colspan="2"><a href="CarList" class="button">Отменить</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>