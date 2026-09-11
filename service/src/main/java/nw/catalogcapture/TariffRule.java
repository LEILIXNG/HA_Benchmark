package nw.catalogcapture;

/** 商品处理策略。按渠道挑一个实现。 */
public interface TariffRule {

    void handle(String value);
}
