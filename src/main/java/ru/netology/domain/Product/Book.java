package ru.netology.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {
    protected String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
    @Override
    public boolean matches(String search) {
            if (super.matches(search)) { // вызов метода matches в версии описанной в Product
                return true;
            }
        if (getAuthor().contains(search)) {
            return true;
        } else {
            return false;
        }
        }

}

