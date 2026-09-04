package com.habench.catalogsync.service;

import com.habench.catalogsync.service.ChannelLoader;

public final class TariffCollector {

    public static void attach(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        ChannelLoader.forward(ledgerEntry302);
    }
}
