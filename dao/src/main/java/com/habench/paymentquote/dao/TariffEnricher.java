package com.habench.paymentquote.dao;

import com.habench.paymentquote.dao.ChannelRepository;

public final class TariffEnricher {

    public static void submit(String value) {
        String catalogKey401 = value;
        ChannelRepository.resolve(catalogKey401);
    }
}
