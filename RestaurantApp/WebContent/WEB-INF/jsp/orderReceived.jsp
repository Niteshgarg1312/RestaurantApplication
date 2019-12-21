<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Cook</title>
</head>
<body>
         <form action="backtocookmenu">
                    <p align="right"> <button type="submit"  class="w3-button w3-border w3-hover-blue w3-blue">
                    		Go Back
                    	</button></p>
                    	</form>
        
                   
        <center><h3>Order Recevied!!!</h3></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                    <th scope="col">EmailId</th>
                    <th scope="col">Order Id</th>
                    <th scope="col">Table No.</th>
                    <th scope="col">Active</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.emailid}</th>
                    <td>${l.orderid }</td>
                    <td>${l.table }</td>
                    <td>${l.active }</td>
                    
                    <td><form action="checkOrderDetails">
                    <input  type="hidden" name="emailid"  value=${l.emailid}>
                    <input  type="hidden" name="id"  value=${l.orderid}>
                    <input  type="hidden" name="table"  value=${l.table}>
                    
                   <button type="submit"  class="btn btn-primary">
                    		Order Details
                      	</button>
                    	</form></td>
                    	
                     <td><form action="orderprepared">
                    <input  type="hidden" name="emailid"  value=${l.emailid}>
                    <input  type="hidden" name="id"  value=${l.orderid}>
                    <input  type="hidden" name="table"  value=${l.table}>
                    
                   <button type="submit"  class="btn btn-danger">
                    		Order Prepared
                      	</button>
                    	</form></td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>