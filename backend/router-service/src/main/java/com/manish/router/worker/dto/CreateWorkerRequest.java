package com.manish.router.worker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateWorkerRequest(
        @NotBlank
        String name,

        @Min(1)
        Integer cpuRequest,

        @Min(128)
        Integer memoryRequestMb
) {
}
