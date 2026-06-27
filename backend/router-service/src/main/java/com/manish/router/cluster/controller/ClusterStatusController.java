package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.NodeSummaryResponse;
import com.manish.router.cluster.service.ClusterStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
@RequiredArgsConstructor
@CrossOrigin
public class ClusterStatusController {
    private final ClusterStatusService service;

    @GetMapping
    public NodeSummaryResponse status() {
        return service.summary();
    }
}
