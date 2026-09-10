package com.northwind.reportexport.dao;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundAdapter {
    private static String cachedPayment;

    public static void refine(String value) {
        StringBuilder accountRef301Buffer = new StringBuilder("ref_");
        accountRef301Buffer.append(value);
        String accountRef301 = accountRef301Buffer.toString();
        cachedPayment = accountRef301;
        attach();
    }

    private static void attach() {
        String voucherRef302 = cachedPayment;
        String paymentTag303 = new StringBuilder(voucherRef302).toString();
        String refundCode304 = paymentTag303;
        TariffValidator.publish(refundCode304);
    }
}
