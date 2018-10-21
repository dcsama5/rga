<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<jsp:include page="./includes/header.jsp"/>


<form method="POST" id="form" name="form" onSubmit="return doSomething();">
	<label for="username">username:</label><input type="text" name="username" id="username"/>
	<label for="password">password</label><input type="text" name="password" id="password"/> 
	<label for="email">email</label><input type="text" name="email" id="email"/> 
	<button type="submit" >edit</button>
</form>

<script type="text/javascript">
	
	function doSomething() {
		var data = {}
		data["username"] = $("#username").val();
		data["password"] = $("#password").val();
		data["email"] = $("#email").val();
		
		//alert(data["username"] + ";" + data["password"] + data["email"]);
		
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/update",
            data: JSON.stringify(data),
            dataType: 'html',
            timeout: 600000,
            success: function (data) {
            	location.href = "list"
            },
            error: function (jqXHR, textStatus, errorThrown ) {
               alert(errorThrown +";"+textStatus+";"+jqXHR);
               console.log(jqXHR.responseText);
            }
	});
		return false;
	}
	
	
</script>
<jsp:include page="./includes/footer.jsp"/>