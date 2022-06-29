package com.kenton.dao;

import com.kenton.pojo.Sale;

public interface SaleDao {
    // 增加销售记录
    int insertSale(Sale sale);
}
