<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<jsp:include page="./includes/header.jsp"/>


<form method="POST" id="form" name="form">
	<label for="username">username:</label><input type="text" name="username" id="username"/>
	<label for="password">password</label><input type="text" name="password" id="password"/> 
	<label for="email">email</label><input type="text" name="email" id="email"/> 
	<button type="submit" >edit</button>
</form>

<script type="text/javascript">

	$("#form").submit(function(event) {

		alert(${'#username'});
		//var json = {"username":${'#username'}, "password":${'#password'}, "email":${'#email'}};
		//alert(json);
		}
	});
	alert("hi");
</script>
<jsp:include page="./includes/footer.jsp"/>