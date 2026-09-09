package com.northwind.catalogadjust.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("catalogadjustVoucherRegistry")
public class VoucherRegistry {

    public void merge(String value) {
        StringBuilder batchTag301Buffer = new StringBuilder("ref:");
        batchTag301Buffer.append(value).append(";");
        String batchTag301 = batchTag301Buffer.toString();
        List<String> orderRef302Attrs = new ArrayList<String>();
        orderRef302Attrs.add("web");
        orderRef302Attrs.add(batchTag301);
        String orderRef302 = orderRef302Attrs.get(1);
        ChannelValidator.publish(orderRef302);
    }
}
