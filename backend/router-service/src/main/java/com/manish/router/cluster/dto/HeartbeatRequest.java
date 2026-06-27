package com.manish.router.cluster.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record HeartbeatRequest(
        @NotNull UUID nodeId
) {
}
