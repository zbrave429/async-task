package cn.ygzhangmfh.util.task.example.dao;

import cn.ygzhangmfh.util.task.example.bean.OrderPayItem;
import cn.ygzhangmfh.util.task.example.utils.RandomUtil;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 23:03
 */
public class OrderPayItemDao {

    public OrderPayItem getOrderPayItemByOrderId(String orderId) throws InterruptedException {

        int n = RandomUtil.getRandomNum(300, 500);

        Thread.sleep(n);

        System.out.println("查询订单支付项信息耗时： " + n + "ms");


        return new OrderPayItem();
    }
}
