package pl.jwojciechowski.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import pl.jwojciechowski.dbutils.DBUtils;
import spark.Request;

import java.text.ParseException;
import java.util.List;

import static pl.jwojciechowski.model.ProductMapper.req2Product;

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

    public void insertProduct(Request req) throws ParseException {
        Product p = new Product();
        req2Product(p, req);
        ds.save(p);
    }

    public void updateProduct(Request req) throws ParseException {
        Product p = new Product();
        req2Product(p, req);
        Query<Product> query = ds.createQuery(Product.class).field(Mapper.ID_KEY).equal(new ObjectId(p.getId()));
        UpdateOperations<Product> uops = ds.createUpdateOperations(Product.class)
                .set("product_name", p.getProduct_name())
                .set("product_price", p.getProduct_price())
                .set("category", p.getCategory())
                .set("expiration_date", p.getExpiration_date())
                .set("description", p.getDescription());
        ds.update(query, uops);
    }

    public void removeProduct(String id) {
        ds.delete(Product.class, new ObjectId(id));
    }

    public void closeConnection() {
        DBUtils.closeConnection();
    }
}
