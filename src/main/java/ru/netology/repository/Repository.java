package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {

    private Product[] product = new Product[0];

    public void save(Product prod) {
        int length = product.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = prod;
        product = tmp;
    }


    public void deleteById(int id) {
        int length = product.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : product) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        product = tmp;
    }


    public Product[] getAll() {
        return product;
    }


}
