<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="/form.css">
        <title>Product list</title>
    </head>

    <body>
        <form class="form-style" action="/" method="post">
            <h2>Product form</h2>
            <label>
                <span>product id:</span>
                <input class="faded" type="text" name="id" value="${(product["id"])!}" readonly>
            </label>
            <label>
                <span>product name:</span>
                <input type="text" name="product_name" value="${(product["product_name"])!}" required>
            </label>
            <label>
                <span>product price:</span>
                <input type="text" name="product_price" pattern="[0-9]+[.[0-9]+]?" value="${(product["product_price"])!}" required>
            </label>
            <label>
                <span>category:</span>
                <input type="text" name="category" value="${(product["category"])!}" required>
            </label>
            <label>
                <span>expiration date: </span>
                <input type="text" name="expiration_date" pattern="\d{1,2}/\d{1,2}/\d{4}" placeholder="dd/mm/yyyy" value="${(product["expiration_date"]?string("dd/MM/yyyy"))!}" required>
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
