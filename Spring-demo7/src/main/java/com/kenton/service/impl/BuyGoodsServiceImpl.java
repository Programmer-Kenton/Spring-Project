package com.kenton.service.impl;

import com.alibaba.druid.filter.AutoLoad;
import com.kenton.dao.GoodsDao;
import com.kenton.dao.SaleDao;
import com.kenton.excep.NotEnoughException;
import com.kenton.pojo.Goods;
import com.kenton.pojo.Sale;
import com.kenton.service.BuyGoodsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/23 13:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyGoodsServiceImpl implements BuyGoodsService {


    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void addSale(){}
    public void addGoods(){}

    public void modifyGoods(){}
    public void modifySale(){}

    public void removeGoods(){}
    public void removeSale(){}

    public void queryGoods(){}
    public void searchSale(){}

    public BuyGoodsServiceImpl(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public BuyGoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class, NotEnoughException.class
            }
    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("---buy方法的开始---");
        // 记录销售的信息 向sale表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        // 更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            // 商品不存在
            throw new NullPointerException("编号是:"+goodsId+",商品不存在");
        } else if (goods.getAmount() < nums) {
            // 说明商品的库存不足
            throw new NotEnoughException("编号是:"+goodsId+",商品库存不足");
        }
        // 修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("---buy方法的完成---");
    }


}
