package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.NodeResponse;
import com.manish.router.cluster.dto.RegisterNodeRequest;
import com.manish.router.cluster.service.ClusterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cluster")
@RequiredArgsConstructor
@CrossOrigin
public class ClusterController {
    private final ClusterService service;

    @PostMapping("/nodes")
    public NodeResponse register(
            @Valid
            @RequestBody RegisterNodeRequest request
    ) {
        return service.register(request);
    }

    @GetMapping("/nodes")
    public List<NodeResponse> nodes() {
        return service.getNodes();
    }
}
