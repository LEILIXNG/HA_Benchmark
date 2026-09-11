package nw.reportsync;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelCoordinator {

    public static void translate(String value) {
        String channelTag201 = "ref_" + value;
        StringBuilder catalogKey202Buffer = new StringBuilder("ref_");
        catalogKey202Buffer.append(channelTag201);
        String catalogKey202 = catalogKey202Buffer.toString();
        RefundExecutor.route(catalogKey202);
    }
}
