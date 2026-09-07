package com.habench.catalogrevise.web;

public final class ManifestPlanStandard implements ManifestPlan {
    @Override
    public void handle(String value) {
        ChannelService.normalize(value);
    }
}
