package com.manish.router.cluster.dto;

public record ClusterHealthResponse(
        int totalNodes,
        int healthyNodes,
        int unhealthyNodes
) {
}
