package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fujang
 * @since 2022-06-20
 */
public interface MoocOrderTMapper extends BaseMapper<MoocOrderT> {
    String getSeatsByFieldId(@Param("fieldId") String fieldId);

    OrderVO getOrderInfoById(@Param("orderId") String orderId);

    List<OrderVO> getOrdersByUserId(@Param("userId")Integer userId, Page<OrderVO> page);

    String getSoldSeatsByFieldId(@Param("fieldId")Integer fieldId);
}
