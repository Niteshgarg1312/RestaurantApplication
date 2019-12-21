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
     <form action="orderreceived">
                   <p align="right"> <button type="submit"  class="btn btn-primary">
                    		Check Order
                    	</button></p>
                    	</form>
     
    <div class="container py-2">
        <center><h3>Hotel Menu</h3></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                    <th scope="col">Dish Name</th>
                    <th scope="col">Dish Type</th>
                    <th scope="col">Full Dish Price</th>
                    <th scope="col">Half Dish Price</th>
                    <th scope="col">Availability
                                    (InStock=1 & OutStock=0)</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.dname}</th>
                    <td>${l.dtype}</td>
                    <td>${l.full_price}</td>
                    <td>${l.half_price }</td>
                    <td>${l.status }</td>
                    <td>
                        <form action="InStockDish">
                    <input type="hidden" name="status" value="1">
                      <input type="hidden" name="dishId" value=${l.dishId}>
                    	<button type="submit" <%-- onClick="deleteDish('${l.dishId}')" --%> class="btn btn-danger">
                    		InStock
                    	</button>
                    	</form>
                    </td>
                    <td>
                    <form action="outofstockDish">
                    <input type="hidden" name="dishId" value=${l.dishId}>
                    <input type="hidden" name="status" value="0">  
                    	<button type="submit" <%-- onClick="deleteDish('${l.dishId}')" --%> class="btn btn-danger">
                    		OutOfStock
                    	</button>
                    	</form>
                    </td>
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