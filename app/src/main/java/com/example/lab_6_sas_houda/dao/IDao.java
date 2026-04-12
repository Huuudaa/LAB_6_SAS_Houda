package com.example.lab_6_sas_houda.dao;
import java.util.List;

public interface IDao<T> {
    T create(T t);
    T update(T t);
    boolean delete(long id);
    T findById(long id);
    List<T> findAll();
}