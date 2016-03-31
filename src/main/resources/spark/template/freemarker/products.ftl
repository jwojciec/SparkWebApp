<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="/products.css">
  </head>
  <body>
    <h2>Product list:</h2>
        <table class="table-style">
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Exp date</th>
                <th colspan=2></th>
            </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td>${product["id"]}</td>
                    <td>${product["product_name"]}</td>
                    <td>${product["product_price"]}</td>
                    <td>${product["category"]}</td>
                    <td>${product["expiration_date"]?datetime}</td>
                    <td><a href="/edit/${product["id"]}">Edit</a></td>
                    <td><a href="/delete/${product["id"]}">Delete</a></td>
                </tr>
            </#list>
        </tbody>
    </table>
    <p><a href="/insert">Add new product</a></p>

  </body>
</html>