package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    Product zero = new Product(0, "zero", 200);
    private Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Book first = new Book(1, "first", 150, "author1");
    Book second = new Book(2, "second", 120, "author");
    Book third = new Book(3, "third", 230, "author");
    Book fourth = new Book(4, "fourth", 175, "author1");

    Smartphone number1 = new Smartphone(10, "number1", 19000, "maker");
    Smartphone number2 = new Smartphone(20, "number2", 5000, "maker2");
    Smartphone number3 = new Smartphone(30, "number3", 3900, "maker2");
    Smartphone number4 = new Smartphone(40, "number4", 4900, "maker");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(number1);
        manager.add(number2);
        manager.add(number3);
        manager.add(number4);
    }


    @Test
    void searchByBook() {

        Product[] actual = manager.searchBy(first.getName());
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphone() {


        Product[] actual = manager.searchBy(number1.getName());
        Product[] expected = new Product[]{number1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByMaker() {

        String search = "maker2";
        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{number2, number3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAuthor() {

        String search = "author1";
        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{first, fourth};
        assertArrayEquals(expected, actual);

    }

    @Test
    void deleteByIdBook() {
        int idToDelete = 1;

        repo.deleteById(idToDelete);
        Product[] actual = manager.searchBy(first.getName());
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }


    @Test
    void deleteByIdSmartphone() {
        int idToDelete = 30;

        repo.deleteById(idToDelete);

        Product[] actual = manager.searchBy(number3.getName());
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchByNameProduct() {

        manager.add(zero);

        Product[] actual = manager.searchBy(zero.getName());
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }


}