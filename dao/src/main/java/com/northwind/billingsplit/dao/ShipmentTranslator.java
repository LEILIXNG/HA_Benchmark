package com.northwind.billingsplit.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向账务场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingsplitShipmentTranslator")
public class ShipmentTranslator {
    private final ChannelRepository channelRepository;

    public ShipmentTranslator(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void attach(String value) {
        String quoteRef501 = "ref:".concat(value).concat(";");
        String tariffRef502 = String.format("ref:%s;", quoteRef501);
        this.channelRepository.collect(tariffRef502);
    }
}
