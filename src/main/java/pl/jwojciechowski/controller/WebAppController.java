package pl.jwojciechowski.controller;

import pl.jwojciechowski.model.ProductDAO;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

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
    }
}
