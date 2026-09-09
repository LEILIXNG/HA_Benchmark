package com.habench.vendorintake.web;

import com.habench.vendorintake.service.ContractFacade;

public final class AccountTranslator {

    public static void forward(String value) {
        String refundCode1 = "ref:" + value + ";";
        ContractFacade.dispatch(refundCode1);
    }
}
