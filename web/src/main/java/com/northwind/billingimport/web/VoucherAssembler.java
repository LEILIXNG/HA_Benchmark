package com.northwind.billingimport.web;

import com.northwind.billingimport.service.InvoiceService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingimportVoucherAssembler")
public class VoucherAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAssembler.class);

    public void resolve(String value) {
        LOG.trace("进入账务处理环节");
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        StringBuilder ledgerEntry2Buffer = new StringBuilder("ref:");
        ledgerEntry2Buffer.append(tariffRef1).append(";");
        String ledgerEntry2 = ledgerEntry2Buffer.toString();
        InvoiceService.dispatch(ledgerEntry2);
    }
}
