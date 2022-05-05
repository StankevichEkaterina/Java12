package ru.netology.domain.Product.Repo;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product.Book;
import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();
    protected Book Book1 = new Book(1, "Бесы", 500, "Достоевский");
    protected Book Book2 = new Book(3, "Дубровский", 350, "Пушкин");
    protected Book Book3 = new Book(5, "Книжный вор", 400, "Зузук");
    protected Smartphone Smartphone1 = new Smartphone(10, "Iphone 11", 70000, "Apple");
    protected Smartphone Smartphone2 = new Smartphone(15, "alaxy S21 FE 5G", 50000, "Samsung");
    protected Smartphone Smartphone3 = new Smartphone(20, "Redmi 10C", 25000, "Xiaomi");

    @Test
    public void shouldSaveProduct() {
        repo.save(Book1);
        repo.save(Smartphone2);
        Product[] expected = {Book1, Smartphone2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAnotherProduct() {
        Product[] product = new Product[]{Book1, Smartphone3};
        repo.setProducts(product);
        repo.save(Book2);
        Product[] expected = {Book1, Smartphone3, Book2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProduct() {
        Product[] product = new Product[]{Book1, Smartphone3};
        repo.setProducts(product);
        repo.save(Book2);
        Product[] expected = {Book1, Smartphone3, Book2};
        Product[] actual = repo.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(Book1);
        repo.save(Smartphone2);
        repo.save(Smartphone1);
        repo.removeById(1);
        Product[] expected = {Smartphone2, Smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingByIddByFromAnExistingList() {
        Product[] product = new Product[]{Book1, Smartphone3};
        repo.setProducts(product);
        repo.removeById(1);
        Product[] expected = {Smartphone3};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

}