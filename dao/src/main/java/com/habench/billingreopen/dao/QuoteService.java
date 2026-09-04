package com.habench.billingreopen.dao;

import com.habench.billingreopen.dao.ContractFilter;

public final class QuoteService {

    public static void normalize(String value) {
        String tariffRef201 = "ref:" + value + ";";
        ContractFilter.expand(tariffRef201);
    }
}
