package com.kenton.dao;

import com.kenton.pojo.Goods;

public interface GoodsDao {
    // 更新库存
    int updateGoods(Goods goods);

    // 查询商品的信息
    Goods selectGoods(Integer id);
}
