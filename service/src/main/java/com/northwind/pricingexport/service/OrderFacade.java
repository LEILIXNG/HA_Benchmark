package com.northwind.pricingexport.service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderFacade {

    public static void refine(String value) {
        StringBuilder quoteRef301Buffer = new StringBuilder("ref:");
        quoteRef301Buffer.append(value).append(";");
        String quoteRef301 = quoteRef301Buffer.toString();
        String tariffRef302 = "ref:" + quoteRef301 + ";";
        AccountEvaluator.assemble(tariffRef302);
    }
}
