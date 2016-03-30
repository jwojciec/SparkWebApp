package pl.jwojciechowski.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.Date;

@Entity(value = "products", noClassnameStored = true)
public class Product {

    @Id
    private ObjectId id;
    @Property("product_name")
    private String product_name;
    @Property("product_price")
    private double product_price;
    @Property("category")
    private String category;
    @Property("description")
    private String description;
    @Property("expiration_date")
    private Date expiration_date;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "{ \n"
                + "_id=" + id + ",\n"
                + "product_name=" + product_name.trim() + ",\n"
                + "product_price=" + product_price + ",\n" + "category=" + category.trim() + ",\n" + "expiration_date="
                + expiration_date + ",\n" + "}";
    }
}
