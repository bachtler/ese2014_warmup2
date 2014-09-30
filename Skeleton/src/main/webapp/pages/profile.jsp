<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Profile of ${user.id} </h1>
 <div class="form-actions">
 	User-Id: ${user.id}
 	First Name: ${user.firstName}
 	Last Name: ${user.lastName}
 	Team: ${user.team}
 </div>


<c:import url="template/footer.jsp" />