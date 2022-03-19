package cn.ygzhangmfh.util.task.example.context;

import cn.ygzhangmfh.util.task.example.bean.Order;
import cn.ygzhangmfh.util.task.example.bean.OrderItem;
import cn.ygzhangmfh.util.task.example.bean.OrderPayItem;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 23:28
 */
public class OrderQueryRequestContext {

    private Order order;

    private OrderItem orderItem;

    private OrderPayItem orderPayItem;

    public Order build(){
        order.setOrderItems(new ArrayList<>());
        order.setOrderPayItems(new ArrayList<>());

        return order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderPayItem getOrderPayItem() {
        return orderPayItem;
    }

    public void setOrderPayItem(OrderPayItem orderPayItem) {
        this.orderPayItem = orderPayItem;
    }
}
