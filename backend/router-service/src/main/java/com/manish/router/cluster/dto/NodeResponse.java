package com.manish.router.cluster.dto;

import com.manish.router.cluster.entity.NodeStatus;

import java.util.UUID;

public record NodeResponse(
        UUID id,
        String nodeName,
        String host,
        Integer port,
        NodeStatus status,
        Integer cpuCores,
        Long memoryMb
) {
}
