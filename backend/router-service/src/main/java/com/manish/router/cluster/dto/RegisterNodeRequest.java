package com.manish.router.cluster.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterNodeRequest(
        @NotBlank
        String nodeName,

        @NotBlank
        String host,

        @NotNull
        Integer port,

        Integer cpuCores,

        Long memoryMb
) {
}
