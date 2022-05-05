package ru.netology.domain.Product.Repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product.Book;
import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Smartphone;

@NoArgsConstructor


public class Repository {
    protected Product[] products = new Product[]{
    };


    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void save(Product product) {
        Product[] newProduct = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            newProduct[i] = products[i];
        }
        newProduct[newProduct.length - 1] = product;
        products = newProduct;
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] removeById(int id) {
        Product[] newProduct = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                newProduct[index] = product;
                index++;
            }
        }
        products = newProduct;
        return products;
    }
}
