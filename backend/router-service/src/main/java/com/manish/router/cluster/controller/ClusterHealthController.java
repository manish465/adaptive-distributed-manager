package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.ClusterHealthResponse;
import com.manish.router.cluster.dto.NodeHealthResponse;
import com.manish.router.cluster.service.ClusterHealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
@CrossOrigin
public class ClusterHealthController {
    private final ClusterHealthService service;

    @GetMapping("/cluster")
    public ClusterHealthResponse cluster() {
        return service.clusterHealth();
    }

    @GetMapping("/nodes")
    public List<NodeHealthResponse> nodes() {
        return service.nodeHealth();
    }
}
