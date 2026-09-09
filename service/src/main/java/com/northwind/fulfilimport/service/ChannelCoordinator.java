package com.northwind.fulfilimport.service;

import com.northwind.fulfilimport.dao.ChannelService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("fulfilimportChannelCoordinator")
public class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);
    private final ChannelService channelService;

    public ChannelCoordinator(ChannelService channelService) {
        this.channelService = channelService;
    }

    public void forward(String value) {
        LOG.debug("开始整理履约字段");
        StringBuilder batchTag301Buffer = new StringBuilder("ref:");
        batchTag301Buffer.append(value).append(";");
        String batchTag301 = batchTag301Buffer.toString();
        List<String> orderRef302Attrs = new ArrayList<String>();
        orderRef302Attrs.add("web");
        orderRef302Attrs.add(batchTag301);
        String orderRef302 = orderRef302Attrs.get(1);
        this.channelService.attach(orderRef302);
    }
}
