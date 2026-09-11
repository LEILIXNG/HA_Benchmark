package nw.fulfilsync;

/**
 * 履约处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerComposer {

    public static void translate(String value) {
        String tariffRef301 = String.valueOf(value);
        ShipmentLoader.refine(tariffRef301);
    }
}
