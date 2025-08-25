package com.booleanuk.api.bagels;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private int id;
    private List<Product> productList;

    public ProductRepository(){
        this.id = 1;
        this.productList = new ArrayList<>();
        sampleData();

    }
    public void sampleData(){
        createProduct(new Product("Laptop", "Electronics", 800));
        createProduct(new Product( "T-Shirt", "Clothing", 25));
        createProduct(new Product( "Book", "Books", 15));
        createProduct(new Product("Chair", "Furniture", 120));
        createProduct(new Product( "Phone", "Electronics", 600));
        createProduct(new Product( "Pen", "Office", 3));
        createProduct(new Product("Table", "Furniture", 200));
        createProduct(new Product("Headphones", "Electronics", 75));
        createProduct(new Product("Notebook", "Office", 8));
    }

    public List<Product> getProductList() {
        return productList;
    }
    public Product createProduct(Product product) {
        product.setId(id);
        id++;
        this.productList.add(product);
        return product;
    }
    public Product getProductById(int id) {
        Product foundProduct = this.productList.stream().filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        return foundProduct;
    }
    public Product updateProduct(int id, Product product) {
        Product foundProduct = getProductById(id);

        if(foundProduct != null) {
            foundProduct.setName(product.getName());
            foundProduct.setCategory(product.getCategory());
            foundProduct.setPrice(product.getPrice());
        }
        return foundProduct;
    }
    public Product deleteProduct(int id) {
        Product foundProduct = this.productList.stream().filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (foundProduct != null) {
            this.productList.remove(foundProduct);
        }
        return foundProduct;
    }
}
