package com.habench.accountsubmit.service;

import com.habench.accountsubmit.dao.BatchComposer;

public final class ContractComposer {

    public static void stage(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        BatchComposer.compose(catalogKey102);
    }
}
