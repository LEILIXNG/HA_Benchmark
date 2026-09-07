package com.habench.customerexport.web;

import com.habench.customerexport.service.RefundComposer;

public final class ManifestNormalizer {

    public static void forward(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        RefundComposer.reconcile(tariffRef2);
    }
}
