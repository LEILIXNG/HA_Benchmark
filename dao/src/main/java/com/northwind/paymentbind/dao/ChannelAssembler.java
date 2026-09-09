package com.northwind.paymentbind.dao;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelAssembler {

    public static void prepare(String value) {
        String quoteRef501 = "ref:" + value + ";";
        StringBuilder tariffRef502Buffer = new StringBuilder("ref:");
        tariffRef502Buffer.append(quoteRef501).append(";");
        String tariffRef502 = tariffRef502Buffer.toString();
        ChannelEnricher.compose(tariffRef502);
    }
}
