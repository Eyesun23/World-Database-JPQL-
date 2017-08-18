<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>COUNTRIES</title>
</head>
<body>
	<h1> MySQL Countries</h1>
	<%-- <ul>
	<c:forEach items="${countries}" var="row">
	<li>${row[0]} - ${row[1]}</li>
	</c:forEach>
	</ul> --%>
	<p>Percentage of countries that speaks Slovenian:</p>
	<ol>
	<c:forEach items="${sloveneCountries}" var="row">
		<li>${row[0].name} - ${row[1].language} - ${row[1].percentage}%</li>
	</c:forEach>
	</ol>
	<p>Total number of cities for each country:</p>
	<ol>
	<c:forEach items="${cityCountByCountry}" var="row">
		<li>${row[0].name} - ${row[1]}</li>
	</c:forEach>
	</ol>
	<p>Cities in Mexico with population greater than 500,000</p>
	<ol>
	<c:forEach items="${cityMexico}" var="row">
		<li>${row.name} - ${row.population}</li>
	</c:forEach>
	</ol>
	<p>All languages in each country with a percentage greater than 89%</p>
	<ol>
	<c:forEach items="${languagesByCountry}" var="row">
		<li>${row[0]} ${row[2]}</li>
	</c:forEach>
	</ol>
	<p>Countries with Surface Area below 501 and Population greater than 100,000</p>
	<ol>
	<c:forEach items="${smallCountries}" var="row">
		<li>${row.name} - ${row.surface_area} - ${row.population}</li>
	</c:forEach>
	</ol>
	<p> Countries with only Constitutional Monarchy with a capital greater 
	than 200 and a life expectancy greater than 75 years.</p>
	<ol>
	<c:forEach items="${govMonarchy}" var="row">
		<li>${row.name} - ${row.gnp} - ${row.life_expectancy}</li>
	</c:forEach>
	</ol>
	<p>Cities in Argentina in the Buenos Aires district with population greater than 500,000.</p>
	<ol>
	<c:forEach items="${buenosAiresCities}" var="row">
		<li>${row[1]} - ${row[2]} - ${row[3]}</li>
	</c:forEach>
	</ol>
	<p>Number of countries in each region!</p>
	<ol>
	<c:forEach items="${numberCountries}" var="row">
		<li>${row[0]} - ${row[1]}</li>
	</c:forEach>
	</ol>
</body>
</html>