package nw.fulfilsettle;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilsettleAccountPolicyStandard")
public class AccountPolicyStandard implements AccountPolicy {
    private final ManifestComposer manifestComposer;

    public AccountPolicyStandard(ManifestComposer manifestComposer) {
        this.manifestComposer = manifestComposer;
    }

    @Override
    public void handle(String value) {
        this.manifestComposer.forward(value);
    }
}
