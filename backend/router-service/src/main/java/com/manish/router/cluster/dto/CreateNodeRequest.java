package com.manish.router.cluster.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateNodeRequest(
        @NotBlank String hostname,
        @NotBlank String address,
        String rack,
        String zone,
        @NotNull Integer cpuCores,
        @NotNull Integer memoryMb
) {
}
