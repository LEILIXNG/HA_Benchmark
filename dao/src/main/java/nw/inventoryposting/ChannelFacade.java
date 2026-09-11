package nw.inventoryposting;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelFacade {

    public static void expand(String value) {
        String manifestKey301 = new StringBuilder(value).toString();
        ContractGateway.dispatch(manifestKey301);
    }
}
