package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.OrderStrategySelector;

public final class BundleEnricher {

    public static void dispatch(String value) {
        String tariffRef1 = value;
        OrderStrategySelector.assemble(tariffRef1);
    }
}
