package com.kenton.service;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/23 13:08
 */
public interface BuyGoodsService {
    // 购买商品的方法 goodsId是购买商品编号 nums是商品数量
    void buy(Integer goodsId,Integer nums);
}
