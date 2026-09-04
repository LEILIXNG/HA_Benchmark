package com.habench.customermanifest.web;

import com.habench.customermanifest.service.ChannelFacade;

public final class InvoiceComposer {

    public static void compose(String value) {
        String shipmentCode101 = value;
        ChannelFacade.forward(shipmentCode101);
    }
}
