package com.example.crud_product.Service.impl;

import com.example.crud_product.Model.Product;
import com.example.crud_product.Service.ICRUDService;

import java.util.ArrayList;

public class ProductService implements ICRUDService<Product> {

    private final ArrayList<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1,"abc", 12));
        products.add(new Product(2,"abd", 13));
        products.add(new Product(3,"abg", 14));
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
    int id = product.getId();
    products.set(id, product);
    }

    @Override
    public void delete(int id) {
        for (Product product : products){
            if (product.getId() == id){
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public ArrayList<Product> fillAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product: products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> fillAllByName(String name) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        for (Product product : products){
            if (product.getName().contains(name) ){
                productArrayList.add(product);
            }
        }
        return productArrayList;
    }
}
