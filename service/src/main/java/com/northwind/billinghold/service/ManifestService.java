package com.northwind.billinghold.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("billingholdManifestService")
public class ManifestService {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestService.class);
    private final PaymentNormalizer paymentNormalizer;

    public ManifestService(PaymentNormalizer paymentNormalizer) {
        this.paymentNormalizer = paymentNormalizer;
    }

    public void collect(String value) {
        LOG.debug("开始整理账务字段");
        String manifestKey301 = value;
        this.paymentNormalizer.compose(manifestKey301);
    }
}
