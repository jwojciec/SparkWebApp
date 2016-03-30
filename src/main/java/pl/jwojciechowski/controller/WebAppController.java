package pl.jwojciechowski.controller;

import pl.jwojciechowski.model.Product;
import pl.jwojciechowski.model.ProductDAO;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class WebAppController {
    private ProductDAO pDAO;

    public WebAppController() {
        Spark.staticFileLocation("/public");
        setupRoutes();
    }

    private void setupRoutes() {
        get("/", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            pDAO = new ProductDAO();
            attributes.put("products", pDAO.selectAllProducts());
            return new ModelAndView(attributes, "products.ftl");
        }, new FreeMarkerEngine());

        get("/insert", (req, res) -> {
            return new ModelAndView(null, "form.ftl");
        }, new FreeMarkerEngine());

        get("/edit/:id", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            pDAO = new ProductDAO();
            attributes.put("product", pDAO.selectProduct(req.params("id")));
            return new ModelAndView(attributes, "form.ftl");
        }, new FreeMarkerEngine());

        get("/delete/:id", (req, res) -> {
            System.out.println("deleting...");
            Map<String, Object> attributes = new HashMap<>();
            pDAO = new ProductDAO();
            attributes.put("products", pDAO.selectAllProducts());
            return new ModelAndView(attributes, "products.ftl");
        }, new FreeMarkerEngine());

        post("/test", (req, res) -> {
            Map<String, String> attributes = req.params();
            Product p = new Product();
            p.setProduct_name(req.queryParams("product_name"));
            p.setProduct_price(Double.parseDouble(req.queryParams("product_price")));
            p.setCategory(req.queryParams("category"));
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            p.setExpiration_date(format.parse(req.queryParams("expiration_date")));
            p.setDescription(req.queryParams("description"));
            pDAO.insertProduct(p);
            res.redirect("/");
            return null;
        });
    }
}
