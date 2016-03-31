package pl.jwojciechowski.controller;

import pl.jwojciechowski.model.ProductDAO;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
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
            pDAO = new ProductDAO();
            pDAO.removeProduct(req.params(":id"));
            res.redirect("/");
            return null;
        });

        post("/", (req, res) -> {
            //insert
            if (req.queryParams("id").equals("")) {
                pDAO.insertProduct(req);
            }
            //update
            else {
                pDAO.updateProduct(req);
            }
            res.redirect("/");
            return null;
        });
    }
}
