package cn.ygzhangmfh.util.task.example.bean;

import java.util.List;

/**
 * 订单
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 23:02
 */
public class Order {

    private String orderId;

    private String createTime;

    private int status;

    private String userId;

    private Long shopId;

    private List<OrderItem> orderItems;

    private List<OrderPayItem> orderPayItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderPayItem> getOrderPayItems() {
        return orderPayItems;
    }

    public void setOrderPayItems(List<OrderPayItem> orderPayItems) {
        this.orderPayItems = orderPayItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
