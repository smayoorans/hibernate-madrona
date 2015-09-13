package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Stock;
import com.madrona.hibernate.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDaoImpl extends AbstractRepo<Stock> implements StockDao {

    public StockDaoImpl() {
        super(Stock.class);
    }

    public boolean save(Stock stock) {
        return super.save(stock);
    }

    public Stock findById(int id) {
        return super.getById(id);
    }

    public List<Stock> getAll() {
        return super.getAll();
    }

    public List<Stock> findByProperty(String propertyName, Object value) {
        return super.find(propertyName, value);
    }

    public boolean delete(Stock stock) {
        return super.delete(stock);
    }

    public boolean update(Stock stock) {
        return super.update(stock);
    }
}
