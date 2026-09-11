package nw.paymentreconcile;

import nw.platform.ValidationException;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ChannelPolicy {

    public static void publish(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.indexOf("localhost") == 0) {
            throw new ValidationException("blocked host");
        }
        ManifestFetcher.forward(value);
    }
}
