package ru.netology.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    protected int id;
    protected String title;
    protected int price;



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && Objects.equals(title, product.title);
    }


    public int hashCode() {
        return Objects.hash(id, title, price);
    }

    public boolean matches(String search) {
        if (getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
