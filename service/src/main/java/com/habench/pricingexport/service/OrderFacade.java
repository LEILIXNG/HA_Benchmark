package com.habench.pricingexport.service;

import com.habench.pricingexport.service.AccountEvaluator;

public final class OrderFacade {

    public static void refine(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = "ref:" + quoteRef301 + ";";
        AccountEvaluator.assemble(tariffRef302);
    }
}
