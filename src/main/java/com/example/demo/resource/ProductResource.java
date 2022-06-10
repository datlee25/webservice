package com.example.demo.resource;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.MySqlProductModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private final ProductModel productModel;

    public ProductResource() {
        this.productModel = new MySqlProductModel();
    }

    @GET
    public List<Product> findAll(){
        return productModel.findAll();
    }
    @POST
    public Product save(Product product){
        return productModel.save(product);
    }

}
