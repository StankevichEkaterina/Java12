package ru.netology.domain.Product.Manager;

import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Repo.Repository;

public class Manager {
    protected Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        return repository.findAll();
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] newProduct = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    newProduct[i] = result[i];
                }
                newProduct[newProduct.length - 1] = product;
                result = newProduct;
            }

        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }


//    public boolean matches(Product product, String search) {
//        if (product.getTitle().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }

    }
}
