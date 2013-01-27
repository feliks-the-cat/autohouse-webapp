<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Печать</title>
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
		<form:form  modelAttribute="deal">
		<h3 align="center" >ДОГОВОР №${deal.saleId}</h3>
		<h3 align="center" >О КУПЛИ-ПРОДАЖЕ ТРАНСПОРТНОГО СРЕДСТВА</h3>
		<h3 align="center" >(НОМЕРНОГО АГРЕГАТА)</h3>
		<p>${deal.salePlace}, ${deal.saleDate }</p>
		<p>Мы, продавец, автосалон "ООО СИТИ-КАР" (Свидетельство о государственной регистрации от 14 сентября 2007 г. №820, выданное Минским районным исполнительным комитетом) в лице директора Андреева Виталия Геннадьевича</p>
		<p>и Покупатель ${deal.customer.customerFio}, паспорт ${deal.customer.customerPassportNumber}, выдан ${deal.customer.customerPassportIssuePlace} ${deal.customer.customerPassportIssueDate}, проживающий(ая) ${deal.customer.customerAddress}, тел. ${deal.customer.customerPhoneNumber},</p>
		<p>заключили настоящий договор купли-продажи транспортного средства о нижеследующем:</p>
		<p>Продавец продает принадлежащее ему транспортное средство (номерной агрегат):</p>
		<p><b>Идент. №(VIN):</b> ${deal.car.carVin}</p>
		<p><b>Марка, модель :</b> ${deal.car.carBrand} ${deal.car.carBrand}</p>
		<p><b>Тип кузова :</b> ${deal.car.body.bodyName}</p>
		<p><b>Год выпуска :</b> ${deal.car.carYear}</p>
		<p>стоимостью ${deal.car.carPrice} у.е. и передает его в собственность Покупателю, а Покупатель принимает данное транспортное средство (номерной агрегат) и уплачивает его стоимость. Продавец передает покупателю транспортное средство (номерной агрегат) свободным от любых прав третьих лиц. Право собственности на транспортное средство (номерной агрегат) переходит к Покупателю с момента подписания настоящего договора.</p>
			
		<table>
			<tr>
				<td width = 500px>Транспортное средство (номерной агрегат) получил</td>
				<td>Деньги в сумме ${deal.car.carPrice} у.е. получены</td>
			</tr>
			<tr>
				<td>____________________</td>
				<td>____________________</td>
			</tr>
			<tr>
				<td>(подпись покупателя)</td>
				<td>(подпись продавца)</td>
			</tr>
		</table>
		</form:form>
	</body>
</html>