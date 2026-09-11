package nw.reportassign;

/** 报表处理策略。按渠道挑一个实现。 */
public interface TariffPolicy {

    void handle(String value);
}
