package pl.jwojciechowski.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import pl.jwojciechowski.dbutils.DBUtils;

import java.util.List;

public class ProductDAO {

    private final Datastore ds;

    public ProductDAO() {
        ds = DBUtils.getDatastore(Product.class, "products");
    }

    public Product selectProduct(String id) {
        ObjectId objId = new ObjectId(id);
        return ds.get(Product.class, objId);
    }

    public List<Product> selectAllProducts() {
        return ds.find(Product.class).asList();
    }

    public void insertProduct(Product p) {
        ds.save(p);
    }

    public void updateProduct(ObjectId id, Product updated) {
        Query<Product> query = ds.createQuery(Product.class).field("_id").equal(id);
        UpdateOperations<Product> uops = ds.createUpdateOperations(Product.class)
                .set("product_name", updated.getProduct_name())
                .set("product_price", updated.getProduct_price())
                .set("category", updated.getCategory())
                .set("expiration_date", updated.getExpiration_date());
        ds.update(query, uops);
    }

    public void removeProduct(ObjectId id) {
        ds.delete(Product.class, id);
    }

    public void closeConnection() {
        DBUtils.closeConnection();
    }
}
