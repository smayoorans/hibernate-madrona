package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Stock;
import com.madrona.hibernate.model.Student;

import java.util.List;

public interface StockDao {

    boolean save(Stock stock);

    Stock findById(int id);

    List<Stock> getAll();

    List<Stock> findByProperty(String propertyName, Object value);

    boolean update(Stock stock);

    boolean delete(Stock stock);
}
