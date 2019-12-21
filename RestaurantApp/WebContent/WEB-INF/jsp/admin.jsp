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

    <title>admin</title>
</head>
<script>
function modalOpen(name, type, fullprice, halfprice, id) {
		const edname = document.getElementById('edname');
		//alert(id);
		const edtype = document.getElementById('edtype');
		const edfullprice = document.getElementById('edfullprice');
		const edhalfprice = document.getElementById('edhalfprice');
		/* form.setAttribute('action', 'updateDish?dishId='+ id); */
		edname.value = name;
		edid.value=id;
		edtype.value = type;
		edfullprice.value = fullprice;
		edhalfprice.value = halfprice;
		$('#exampleModal').modal();
		
	}




	</script>
<body>
<br>
         
         <form class="login100"  action="signup" method="post">
				<input type="hidden" id="key" name="key" value="2">
				  <div class="container-login100-form-btn m-t-32">
						<p align="left"><button class="btn btn-danger" type="submit">
							Register for Receptionist
						</button></p>
					</div>
					</form>  
				<form class="login100"  action="signup" method="post">
				<input type="hidden" id="key" name="key" value="3"/>
				  <div class="container-login100-form-btn m-t-32">
						<p align="left"><button class="btn btn-danger" type="submit">
							Register for Cook
						</button></p>
					</div>
					</form>  
					<form class="login100"  action="signup" method="post">
				<input type="hidden" id="key" name="key" value="4"/>
				  <div class="container-login100-form-btn m-t-32">
						<p align="left"><button class="btn btn-danger" type="submit">
							Register for Waiter
						</button></p>
					</div>
					</form>  
                   
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Edit dish details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="updateDish" method="post">
                      <input type="hidden" id="edid" name="dishId">
                            <div class="form-group">
                            	<label for="edname">Dish Name</label>
                                <input type="text" class="form-control"  id="edname" name="dname" required aria-describedby="dish name" placeholder="Edit dish Name">
                            </div>
                            <div class="form-group">
                            	<label for="edtype">Dish Type</label>
                                <input type="text" class="form-control" id="edtype" name="dtype" required placeholder="Edit dish type">
                            </div>
                             <div class="form-group">
                             	<label for="edfullprice">Full Dish Price</label>
                                <input type="text" class="form-control" pattern="{0-9}[3]" id="edfullprice" name="full_price" required placeholder="Edit full price">
                            </div>
                            <div class="form-group">
                             	<label for="edhalfprice">Half Dish Price</label>
                                <input type="text" class="form-control" pattern="{0-9}[3]" id="edhalfprice" name="half_price" required placeholder="Edit half price">
                            </div>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                    </div>
            </div>
                </div>
            </div>
            <div class="modal fade" id="addDishModal" tabindex="-1" role="dialog" aria-labelledby="addDishModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addDishModalLabel">Add dish details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="addDish" method="POST">
                            <div class="form-group">
                            	<label for="addDishName">Dish Name</label>
                                <input type="text" required class="form-control" id="addDishName" name="dname" aria-describedby="dish name" placeholder="add dish Name" required autofocus>
                            </div>
                            <div class="form-group">
                            	<label for="addDishType">Dish Type</label>
                                <input type="text" required class="form-control" id="addDishType" name="dtype" placeholder="add dish type" required autofocus>
                            </div>
                             <div class="form-group">
                             	<label for="addDishfullPrice">Full Dish Price</label>
                                <input type="text" pattern="{0-9}[3]" required class="form-control" name="full_price" placeholder="add full price" value="0">
                            </div>
                            <div class="form-group">
                             	<label for="addDishhalfPrice">Half Dish Price</label>
                                <input type="text"  pattern="{0-9}[3]" required class="form-control" name="half_price" placeholder="add half price" value="0">
                            </div>
                            <button type="submit" class="btn btn-primary">Add Dish</button>
                        </form>
                    </div>
            </div>
                </div>
            </div>
    <div class="container py-2">
        <center><h3>Hotel Menu</h3></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                    <th scope="col">Dish Name</th>
                    <th scope="col">Dish Type</th>
                    <th scope="col">Full Dish Price</th>
                    <th scope="col">Half Dish Price</th>
                    <th scope="col">Status</th>
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
                        <button type="button" class="btn btn-primary" onClick="modalOpen('${l.dname}','${l.dtype}','${l.full_price}','${l.half_price}','${l.dishId}')" data-toggle="modal">
                               Edit
                         </button>
                    </td>
                    <td>
                    <form action="deleteDish">
                    <input type="hidden" name="dishId" value=${l.dishId}>  
                    	<button type="submit" <%-- onClick="deleteDish('${l.dishId}')" --%> class="btn btn-danger">
                    		Delete
                    	</button>
                    	</form>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
              <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addDishModal">
  				Add new dish
			</button>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
	
	
	function deleteDish(id) {
		const form = document.createElement('form');
		form.setAttribute('method', 'post');
	    form.setAttribute('action', 'deleteDish?dishId='+ id);
	    form.style.display = 'hidden';
	    document.body.appendChild(form)
	    form.submit();
	}
</script>
<br>
<form class="login100"  action="adminBillDetail" method="post">
			  <div class="container-login100-form-btn m-t-32">
						<p align="right"><button class="btn btn-danger" type="submit">
							 Customer Bill Detail
						</button></p>
					</div>
					</form>  

</body>
</html>