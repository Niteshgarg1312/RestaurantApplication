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

    <title>Receptionist</title>
</head>
<script>
function modalOpen() {
		$('#exampleModal').modal();
	}

function timedRefresh(timeoutPeriod) {
	setTimeout("location.reload(true);",timeoutPeriod);
}

window.onload = timedRefresh(30000);


	</script>

<body>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Search Bill detail</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="adminSearchBill" method="post">
                                <div class="form-group">
                            	<label for="edname">Customer Emailid</label>
                                <input type="email" class="form-control"  id="email" name="emailid" required aria-describedby="emailid" placeholder="Email Id">
                            </div>
                            <div class="form-group">
                            	<label for="edtype">Order Id</label>
                                <input type="text" class="form-control" id="id" name="id" required placeholder="Order Id">
                            </div>
                             <button type="submit" class="btn btn-primary">Search</button>
                        </form>
                    </div>
            </div>
                </div>
            </div>
        
    <div class="container py-2">
        <center><h3>Customer Bills!!!!</h3></center><button type="button" class="btn btn-primary" onClick="modalOpen()" data-toggle="modal">
                               Search Bill
                         </button>
        
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Customer Emailid</th>
                    <th scope="col">Order Id</th>
                    <th scope="col">Table No.</th>
                     <th scope="col">Payment Paid</th>
                     <th scope="col">Payment Method</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.name}</th>
                    <td>${l.emailid }</td>
                    <td>${l.id }</td>
                    <td>${l.table }</td>
                    <td>${l.payment }</td>
                    <td>${l.paymentMethod }</td>
                    <td> <form action="adminBill">
                    <input type="hidden" name="emailid" value=${l.emailid}>
                    <input type="hidden" name="id" value=${l.id}>
                    <button type="submit"  class="btn btn-primary">
                     Bill Detail
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