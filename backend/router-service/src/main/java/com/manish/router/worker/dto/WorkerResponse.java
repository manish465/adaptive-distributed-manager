package com.manish.router.worker.dto;

import java.util.UUID;

public record WorkerResponse(
        UUID id,
        String name,
        String status,
        String node
) {
}
