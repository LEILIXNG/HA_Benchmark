package com.habench.reportposting.web;

import com.habench.reportposting.service.VoucherRouter;

public final class ChannelFacade {

    public static void reconcile(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        VoucherRouter.refine(manifestKey202);
    }
}
