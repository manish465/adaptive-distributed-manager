package com.manish.router.cluster.dto;

public record NodeSummaryResponse(
        int online,
        int offline,
        int maintenance,
        int draining
) {
}
