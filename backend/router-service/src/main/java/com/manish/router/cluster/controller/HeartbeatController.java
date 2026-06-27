package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.HeartbeatRequest;
import com.manish.router.cluster.service.ClusterNodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/heartbeats")
@RequiredArgsConstructor
@CrossOrigin
public class HeartbeatController {
    private final ClusterNodeService service;

    @PostMapping
    public void heartbeat(
            @Valid @RequestBody HeartbeatRequest request
    ) {
        service.updateHeartbeat(request.nodeId());
    }
}
