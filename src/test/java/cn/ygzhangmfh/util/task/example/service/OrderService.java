package cn.ygzhangmfh.util.task.example.service;

import cn.ygzhangmfh.util.task.AsyncFactory;
import cn.ygzhangmfh.util.task.example.bean.Order;
import cn.ygzhangmfh.util.task.example.bean.OrderItem;
import cn.ygzhangmfh.util.task.example.bean.OrderPayItem;
import cn.ygzhangmfh.util.task.example.context.OrderQueryRequestContext;
import cn.ygzhangmfh.util.task.example.dao.OrderBuyDao;
import cn.ygzhangmfh.util.task.example.dao.OrderBuyItemDao;
import cn.ygzhangmfh.util.task.example.dao.OrderPayItemDao;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 22:58
 */
public class OrderService {

    private OrderBuyDao orderBuyDao = new OrderBuyDao();

    private OrderBuyItemDao orderBuyItemDao = new OrderBuyItemDao();

    private OrderPayItemDao orderPayItemDao = new OrderPayItemDao();


    static {
        AsyncFactory.init();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderService orderService = new OrderService();

        for(int i = 0; i < 10; i++){
            Object order = orderService.getOrder("12321232");

            System.out.println(order);
        }


        AsyncFactory.destroy();


    }

    public Object getOrder(String orderId) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        FutureTask<Order> orderFutureTask = AsyncFactory.submit(() -> orderBuyDao.getOrderByOrderId(orderId));

        FutureTask<OrderItem> orderItemFutureTask = AsyncFactory.submit(() -> orderBuyItemDao.getOrderItemByOrderId(orderId));

        FutureTask<OrderPayItem> orderPayItemFutureTask = AsyncFactory.submit(() -> orderPayItemDao.getOrderPayItemByOrderId(orderId));

        Order order = orderFutureTask.get();
        OrderItem orderItem = orderItemFutureTask.get();

        OrderPayItem orderPayItem = orderPayItemFutureTask.get();

        OrderQueryRequestContext context = new OrderQueryRequestContext();
        context.setOrder(order);
        context.setOrderItem(orderItem);
        context.setOrderPayItem(orderPayItem);

        System.out.println("接口总耗时： " + (System.currentTimeMillis() - start) + "ms");
        return context.build();
    }


}
