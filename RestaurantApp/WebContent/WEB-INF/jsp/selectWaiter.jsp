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

    <title>cook</title>
</head>
<body>
                   
    <label><b style=color:Black>Table No.:</b></label><b style=color:Blue>${list4 }</b>
    <br>
    <label><b style=color:Black>Order id:</b></label><b style=color:Blue>${list3 }</b>
    <div class="container py-2">
        <center><h3>Select Waiter For This Order!!!</h3></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                  <th scope="col">Waiter Id</th>
                    <th scope="col">Waiter Name</th>
                    <th scope="col">Waiter Emailid</th>
                    <th scope="col">Availability</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.w_id}</th>
                    <td>${l.w_name }</td>
                    <td>${l.w_emailid }</td>
                    <td>${l.w_status }</td>
                    <td><form action="assignWaiter">
                    <input  type="hidden" name="emailid"  value=${list2}>
                    <input  type="hidden" name="id"  value=${list3}>
                    <input  type="hidden" name="table"  value=${list4}>
                    <input  type="hidden" name="w_id"  value=${l.w_id}>
                    <input  type="hidden" name="key"  value=${l.w_key}>
                   <button type="submit"  class="btn btn-danger">
                    		Assign
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