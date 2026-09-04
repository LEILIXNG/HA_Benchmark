package com.habench.reportmerge.dao;

import com.habench.reportmerge.dao.QuoteAssembler;

public final class ChannelNormalizer {

    public static void dispatch(String value) {
        String channelTag201 = value;
        String catalogKey202 = "ref:" + channelTag201 + ";";
        QuoteAssembler.route(catalogKey202);
    }
}
