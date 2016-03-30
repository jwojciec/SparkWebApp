<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
        <link rel="stylesheet" type="text/css" href="/form.css">
		<title>Product list</title>
	</head>

	<body>
		<form class="form-style" action="products" method="post">
			<h2>Product form</h2>	
			<label>
				<span>product id:</span>
				<input class="faded" type="text" name="id" value="${(product["id"])!}" readonly>
			</label>
			<label>
				<span>product name:</span>
				<input type="text" name="product_name" value="${(product["product_name"])!}" >
			</label>
			<label>
				<span>product price:</span>
				<input type="text" name="product_price" value="${(product["product_price"])!}" >
			</label>
			<label>
				<span>category:</span>
				<input type="text" name="category" value="${(product["category"])!}" >
			</label>
			<label>
				<span>expiration date: </span>
				<input type="text" name="expiration_date" value="${(product["expiration_date"]?datetime)!}" >
			</label>
			<label>
				<span>description:</span>  			  		
				<textarea name="description">${(product["description"])!}</textarea>
			</label>
			<label>
				<span>&nbsp;</span> 
				<input type="submit" class="button" value="Send" /> 
			</label>  			
		</form>
	</body>
</html>
