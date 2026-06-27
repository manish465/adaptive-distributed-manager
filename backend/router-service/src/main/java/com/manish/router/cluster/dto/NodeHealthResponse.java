package com.manish.router.cluster.dto;

import java.time.Instant;
import java.util.UUID;

public record NodeHealthResponse(
        UUID nodeId,
        String hostname,
        String status,
        Instant lastHeartbeat,
        boolean healthy
) {
}
