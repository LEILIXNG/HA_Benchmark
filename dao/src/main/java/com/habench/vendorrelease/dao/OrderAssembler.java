package com.habench.vendorrelease.dao;

import com.habench.vendorrelease.dao.InvoiceService;

public final class OrderAssembler {

    public static void register(String value) {
        String tariffRef301 = value;
        InvoiceService.stage(tariffRef301);
    }
}
