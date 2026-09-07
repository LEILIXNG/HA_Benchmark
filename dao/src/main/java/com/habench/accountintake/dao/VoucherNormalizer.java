package com.habench.accountintake.dao;

import com.habench.accountintake.dao.ChannelRepository;

public final class VoucherNormalizer {
    private static String cachedChannel;

    public static void stage(String value) {
        String refundCode301 = value;
        String shipmentCode302 = refundCode301;
        cachedChannel = shipmentCode302;
        collect();
    }

    private static void collect() {
        String manifestKey303 = cachedChannel;
        String invoiceKey304 = manifestKey303;
        ChannelRepository.refine(invoiceKey304);
    }
}
