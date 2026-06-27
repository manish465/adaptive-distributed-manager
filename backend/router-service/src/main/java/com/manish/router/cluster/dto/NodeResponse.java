package com.manish.router.cluster.dto;

import com.manish.router.cluster.entity.NodeStatus;

import java.util.UUID;

public record NodeResponse(
        UUID id,
        String hostname,
        String address,
        String rack,
        String zone,
        Integer cpuCores,
        Integer memoryMb,
        Integer availableCpuCores,
        Integer availableMemoryMb,
        NodeStatus status
) {
}
