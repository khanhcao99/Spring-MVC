package com.example.crud_product.Service;

import java.util.ArrayList;

public interface ICRUDService<E> {
    void create(E e);
    void update(E e);
    void delete(int id);
    ArrayList<E> fillAll();
    E findById(int id);

    ArrayList<E> fillAllByName(String name);
}
