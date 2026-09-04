package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.ContractRepository;

public final class RefundCoordinator {

    public static void normalize(String value) {
        String receiptKey301 = "ref:" + value + ";";
        ContractRepository.submit(receiptKey301);
    }
}
