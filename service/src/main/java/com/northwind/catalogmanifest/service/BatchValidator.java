package com.northwind.catalogmanifest.service;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("catalogmanifestBatchValidator")
public class BatchValidator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchValidator.class);
    private final ChannelRepository channelRepository;

    public BatchValidator(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void expand(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replaceAll("'", "");
        this.channelRepository.publish(cleaned);
    }
}
