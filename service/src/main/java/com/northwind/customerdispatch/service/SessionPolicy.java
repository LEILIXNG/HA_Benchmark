package com.northwind.customerdispatch.service;

import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("customerdispatchSessionPolicy")
public class SessionPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(SessionPolicy.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final TariffEnricher tariffEnricher;

    public SessionPolicy(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    public void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.tariffEnricher.submit(value);
    }
}
