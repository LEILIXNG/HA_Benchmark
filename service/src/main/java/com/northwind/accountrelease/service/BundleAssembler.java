package com.northwind.accountrelease.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountreleaseBundleAssembler")
public class BundleAssembler {
    private final ManifestRepository manifestRepository;

    public BundleAssembler(ManifestRepository manifestRepository) {
        this.manifestRepository = manifestRepository;
    }

    public void prepare(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("detail", value);
        String accountRef101 = accountRef101Attrs.get("detail");
        String voucherRef102 = "ref:" + accountRef101 + ";";
        this.manifestRepository.merge(voucherRef102);
    }
}
