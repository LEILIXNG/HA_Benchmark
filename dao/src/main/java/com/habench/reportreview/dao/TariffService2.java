package com.habench.reportreview.dao;

import com.habench.reportreview.dao.ShipmentCollector;

public final class TariffService2 {

    public static void collect(String value) {
        String manifestKey501 = value;
        ShipmentCollector.compose(manifestKey501);
    }
}
