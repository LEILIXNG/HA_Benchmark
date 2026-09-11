package nw.accountmanifest;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentFacade {

    public static void submit(String value) {
        LedgerCoordinator.dispatch(value);
    }
}
