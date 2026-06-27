package com.manish.router.cluster.controller;

import com.manish.router.cluster.dto.NodeCapacityResponse;
import com.manish.router.cluster.service.NodeCapacityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/capacity")
@RequiredArgsConstructor
@CrossOrigin
public class NodeCapacityController {
    private final NodeCapacityService service;

    @GetMapping
    public List<NodeCapacityResponse> capacities() {
        return service.capacities();
    }
}
