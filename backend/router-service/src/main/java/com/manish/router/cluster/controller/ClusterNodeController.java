package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.CreateNodeRequest;
import com.manish.router.cluster.dto.NodeResponse;
import com.manish.router.cluster.service.ClusterNodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nodes")
@RequiredArgsConstructor
@CrossOrigin
public class ClusterNodeController {
    private final ClusterNodeService service;

    @PostMapping
    public NodeResponse create(@Valid @RequestBody CreateNodeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<NodeResponse> getAll() {
        return service.findAll();
    }
}
