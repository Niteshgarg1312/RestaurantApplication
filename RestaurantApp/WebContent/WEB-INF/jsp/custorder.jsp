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

    <title>Customer</title>
</head>
<body>
                   
                    <form action="backtoorder">
                    <input  type="hidden" name="emailid"  value=${list2}>
                    <input  type="hidden" name="id"  value=${list3}>
                    <input  type="hidden" name="table"  value=${list4}>
                   <p align="right"> <button type="submit"  class="btn btn-primary">
                    		Go Back
                    	</button></p>
                    	</form>
    
    <label><b style=color:Black>Name:</b></label><b style=color:Blue >${list1 }</b>
    <br>
    <label><b style=color:Black>EmailId:</b></label><b style=color:Blue>${list2 }</b>
    <br>
    <label><b style=color:Black>Table No.:</b></label><b style=color:Blue>${list4 }</b>
    <br>
    <label><b style=color:Black>Order id:</b></label><b style=color:Blue>${list3 }</b>
    <div class="container py-2">
        <center><h3>Your Order</h3></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                    <th scope="col">Dish Name</th>
                    <th scope="col">Dish Type</th>
                    <th scope="col">Full Dish Price</th>
                    <th scope="col">Half Dish Price</th>
                  <th scope="col">Full Quantity</th>
                  <th scope="col">Half Quantity</th>
                  <th scope="col">Total Price</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.dname}</th>
                    <td>${l.dtype }</td>
                    <td>${l.full_price }</td>
                    <td>${l.half_price }</td>
                    <td>${l.full_quantity }</td>
                    <td>${l.half_quantity }</td>
                    <td>${l.totalPrice }</td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
               <center><b style=color:black><label>Total Paid:</label></b><b style=color:blue>${payment }</b><lablel>*Include all tax</lablel></center>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>