package com.northwind.vendordraft.dao;

import org.springframework.stereotype.Repository;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("vendordraftInvoiceBroker")
public class InvoiceBroker {
    private static String cachedManifest;
    private final ManifestRepository manifestRepository;

    public InvoiceBroker(ManifestRepository manifestRepository) {
        this.manifestRepository = manifestRepository;
    }

    public void resolve(String value) {
        String catalogKey301 = String.valueOf(value);
        String receiptKey302 = catalogKey301;
        cachedManifest = receiptKey302;
        expand();
    }

    private void expand() {
        String accountRef303 = cachedManifest;
        final String voucherRef304 = accountRef303;
        this.manifestRepository.expand(voucherRef304);
    }
}
