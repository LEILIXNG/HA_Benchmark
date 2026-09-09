package com.northwind.reportdraft.service;

import com.northwind.reportdraft.dao.ChannelNormalizer;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportdraftPaymentService")
public class PaymentService {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
    private final ChannelNormalizer channelNormalizer;

    public PaymentService(ChannelNormalizer channelNormalizer) {
        this.channelNormalizer = channelNormalizer;
    }

    public void assemble(String value) {
        LOG.debug("开始整理报表字段");
        List<String> ledgerEntry101Attrs = new ArrayList<String>();
        ledgerEntry101Attrs.add("web");
        ledgerEntry101Attrs.add(value);
        String ledgerEntry101 = ledgerEntry101Attrs.get(1);
        this.channelNormalizer.compose(ledgerEntry101);
    }
}
