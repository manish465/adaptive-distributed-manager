package com.manish.router.cluster.dto;

import java.util.UUID;

public record NodeCapacityResponse(
        UUID nodeId,
        String hostname,
        Integer totalCpu,
        Integer availableCpu,
        Integer totalMemory,
        Integer availableMemory
) {
}
