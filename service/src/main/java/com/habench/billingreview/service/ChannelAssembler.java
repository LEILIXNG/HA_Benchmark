package com.habench.billingreview.service;

import com.habench.billingreview.dao.ManifestRouter;

public final class ChannelAssembler {

    public static void refine(String value) {
        String refundCode101 = value;
        ManifestRouter.expand(refundCode101);
    }
}
