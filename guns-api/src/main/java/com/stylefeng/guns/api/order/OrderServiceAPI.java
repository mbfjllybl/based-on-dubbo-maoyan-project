package com.stylefeng.guns.api.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.vo.OrderVO;

import java.util.List;

public interface OrderServiceAPI {

    /**
     * 1 验证售出的票是否为真
     */
    boolean isTrueSeats(String fieldId, String seats);

    /**
     * 2 已经销售的座位里，有没有这些座位
     */
    boolean isNotSoldSeats(String fieldId, String seats);

    /**
     * 3 创建订单信息
     */
    OrderVO saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId);

    /**
     * 4 使用当前登陆人获取已经购买的订单
     */
    Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page);

    /**
     * 5 根据FieldId 获取所有已经销售的座位编号
     */
    String getSoldSeatsByFieldId(Integer fieldId);

    /**
     * 6 根据订单编号获取订单信息
     */
    OrderVO getOrderInfoById(String orderId);

    /**
     * 7 支付是否成功
     */
    boolean paySuccess(String orderId);

    /**
     * 8 支付是否失败
     */
    boolean payFail(String orderId);

}