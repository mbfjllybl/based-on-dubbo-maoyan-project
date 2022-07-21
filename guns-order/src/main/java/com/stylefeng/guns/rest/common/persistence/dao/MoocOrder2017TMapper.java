package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrder2017T;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fujang
 * @since 2022-06-20
 */
public interface MoocOrder2017TMapper extends BaseMapper<MoocOrder2017T> {

    String getSeatsByFieldId(@Param("fieldId") String fieldId);

    OrderVO getOrderInfoById(@Param("orderId") String orderId);

    List<OrderVO> getOrdersByUserId(@Param("userId")Integer userId, Page<OrderVO> page);

    String getSoldSeatsByFieldId(@Param("fieldId")Integer fieldId);
}
