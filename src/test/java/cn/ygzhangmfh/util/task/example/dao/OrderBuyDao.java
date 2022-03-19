package cn.ygzhangmfh.util.task.example.dao;

import cn.ygzhangmfh.util.task.example.bean.Order;
import cn.ygzhangmfh.util.task.example.utils.RandomUtil;

/**
 * 购买域-订单详情
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 23:01
 */
public class OrderBuyDao {

    public Order getOrderByOrderId(String orderId) throws InterruptedException {

        int n = RandomUtil.getRandomNum(500, 1000);

        Thread.sleep(n);

        System.out.println("查询订单信息耗时： " + n + "ms");


        return new Order();
    }


}
