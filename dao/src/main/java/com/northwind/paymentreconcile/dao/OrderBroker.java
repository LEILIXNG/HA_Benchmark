package com.northwind.paymentreconcile.dao;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderBroker {

    public static void normalize(String value) {
        StringBuilder ledgerEntry301Buffer = new StringBuilder("ref:");
        ledgerEntry301Buffer.append(value).append(";");
        String ledgerEntry301 = ledgerEntry301Buffer.toString();
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        ChannelPolicy.publish(channelTag302);
    }
}
