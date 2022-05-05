package ru.netology.domain.Product.Manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product.Book;
import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Repo.Repository;
import ru.netology.domain.Product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    protected Repository repository = new Repository();
    protected Manager manager = new Manager(repository);

    protected Book Book1 = new Book(1, "Двойник", 500, "Достоевский");
    protected Book Book2 = new Book(3, "Дубровский", 350, "Пушкин");
    protected Book Book3 = new Book(5, "Книжный вор", 400, "Зузук");
    protected Book Book4 = new Book(7, "Двойник", 350, "Жозе Сарамаго");
    protected Smartphone Smartphone1 = new Smartphone(10, "Iphone 11", 70000, "Apple");
    protected Smartphone Smartphone2 = new Smartphone(15, "alaxy S21 FE 5G", 70000, "Samsung");
    protected Smartphone Smartphone3 = new Smartphone(20, "Redmi 10C", 25000, "Xiaomi");

    @Test
    public void shouldSaveProduct() {
        manager.save(Book1);
        manager.save(Smartphone1);
        Product[] expected = {Book1, Smartphone1};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByExistingNameBook() {
        manager.save(Book1);
        manager.save(Book2);
        Product[] actual = manager.searchBy("Двойник");
        Product[] expected = {Book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByExistingNameSmartphone() {
        manager.save(Smartphone2);
        manager.save(Smartphone3);

        Product[] actual = manager.searchBy("Redmi 10C");
        Product[] expected = {Smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNameSearchWithError() {
        manager.save(Book3);
        manager.save(Book2);
        Product[] actual = manager.searchBy("Дуровский");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMultipleBookTitleSearch() {
        manager.save(Book3);
        manager.save(Book4);
        manager.save(Book1);
        Product[] actual = manager.searchBy("Двойник");
        Product[] expected = {Book4, Book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        manager.save(Book3);
        manager.save(Book4);
        manager.save(Book1);
        Product[] actual = manager.searchBy("Достоевский");
        Product[] expected = {Book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        manager.save(Smartphone3);
        manager.save(Smartphone2);
        manager.save(Smartphone1);
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = {Smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerWithAnError() {
        manager.save(Smartphone3);
        manager.save(Smartphone2);
        manager.save(Smartphone1);
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}