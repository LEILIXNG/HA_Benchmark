package com.northwind.fulfilcapture.service;

import com.northwind.platform.ValidationException;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ManifestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestFilter.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        TariffLoader.expand(value);
    }
}
