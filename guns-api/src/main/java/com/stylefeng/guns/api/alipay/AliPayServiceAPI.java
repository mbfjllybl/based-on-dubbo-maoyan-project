package com.stylefeng.guns.api.alipay;

import com.stylefeng.guns.api.alipay.vo.AliPayInfoVO;
import com.stylefeng.guns.api.alipay.vo.AliPayResultVO;

public interface AliPayServiceAPI {
    /**
     * 1 获得验证码
     */

    AliPayInfoVO getQRCode(String orderId);

    /**
     * 2 获得订单状态
     */

    AliPayResultVO getOrderStatus(String orderId);

}
