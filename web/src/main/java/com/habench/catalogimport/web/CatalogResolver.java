package com.habench.catalogimport.web;

import com.habench.catalogimport.web.SessionAssembler;

public final class CatalogResolver {

    public static void stage(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = quoteRef101;
        SessionAssembler.forward(tariffRef102);
    }
}
