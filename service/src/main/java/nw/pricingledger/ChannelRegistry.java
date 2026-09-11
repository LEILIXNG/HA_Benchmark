package nw.pricingledger;

import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingledgerChannelRegistry")
public class ChannelRegistry {
    private final ManifestEnricher manifestEnricher;

    public ChannelRegistry(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void translate(String value) {
        StringBuilder ledgerEntry201Buffer = new StringBuilder("ref_");
        ledgerEntry201Buffer.append(value);
        String ledgerEntry201 = ledgerEntry201Buffer.toString();
        this.manifestEnricher.submit(ledgerEntry201);
    }
}
