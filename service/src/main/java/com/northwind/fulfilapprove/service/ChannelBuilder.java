package com.northwind.fulfilapprove.service;

import com.northwind.fulfilapprove.dao.AccountService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilapproveChannelBuilder")
public class ChannelBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBuilder.class);

    public void forward(String value) {
        LOG.debug("开始整理履约字段");
        Map<String, String> tariffRef301Attrs = new LinkedHashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("detail", value);
        String tariffRef301 = tariffRef301Attrs.getOrDefault("detail", "");
        AccountService.normalize(tariffRef301);
    }
}
