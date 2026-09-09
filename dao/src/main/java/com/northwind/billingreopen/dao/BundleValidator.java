package com.northwind.billingreopen.dao;

import org.springframework.stereotype.Repository;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingreopenBundleValidator")
public class BundleValidator {
    private final ChannelRepository channelRepository;

    public BundleValidator(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void submit(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value;
        if (cleaned.indexOf("'") >= 0) {
            cleaned = cleaned.replace("'", "");
        }
        this.channelRepository.compose(cleaned);
    }
}
