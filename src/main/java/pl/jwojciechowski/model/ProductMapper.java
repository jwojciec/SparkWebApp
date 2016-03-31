package pl.jwojciechowski.model;

import spark.Request;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This class will map reqest from insert or update
 * and map it with given Product
 */
public class ProductMapper {
    public static void req2Product(Product p, Request req) throws ParseException {
        p.setId(req.queryParams("id"));
        p.setProduct_name(req.queryParams("product_name"));
        p.setProduct_price(Double.parseDouble(req.queryParams("product_price")));
        p.setCategory(req.queryParams("category"));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        p.setExpiration_date(format.parse(req.queryParams("expiration_date")));
        p.setDescription(req.queryParams("description"));
    }
}
