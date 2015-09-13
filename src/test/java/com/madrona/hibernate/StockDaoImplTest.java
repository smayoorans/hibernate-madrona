package com.madrona.hibernate;


import com.madrona.hibernate.dao.StockDao;
import com.madrona.hibernate.dao.StudentDao;
import com.madrona.hibernate.model.Address;
import com.madrona.hibernate.model.Stock;
import com.madrona.hibernate.model.StockDetail;
import com.madrona.hibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;


@ContextConfiguration(locations = {"/applicationContext.xml"})
public class StockDaoImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StockDao stockDao;

    @Test
    public void testSave() throws Exception {

        Stock stock = new Stock("7052", "PADINI");



        StockDetail stockDetail = new StockDetail();
        stockDetail.setCompName("PADINI Holding Malaysia");
        stockDetail.setCompDesc("one stop shopping");
        stockDetail.setRemark("vinci vinci");
        stockDetail.setListedDate(new Date());

        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);



        boolean saved1 = stockDao.save(stock);
        Assert.assertEquals(saved1, true);

}
}