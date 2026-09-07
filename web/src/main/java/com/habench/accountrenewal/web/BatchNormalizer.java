package com.habench.accountrenewal.web;

import com.habench.accountrenewal.service.TariffAssembler;

public final class BatchNormalizer {

    public static void submit(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        TariffAssembler.submit(shipmentCode101);
    }
}
