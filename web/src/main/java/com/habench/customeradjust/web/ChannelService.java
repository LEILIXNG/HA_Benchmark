package com.habench.customeradjust.web;

import com.habench.customeradjust.service.VoucherComposer;

public final class ChannelService {

    public static void submit(String value) {
        String voucherRef1 = value;
        VoucherComposer.resolve(voucherRef1);
    }
}
