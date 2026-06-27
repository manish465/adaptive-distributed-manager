package com.manish.router.cluster.service;

import com.manish.router.cluster.dto.NodeCapacityResponse;
import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NodeCapacityService {
    private final ClusterNodeRepository repository;

    public List<NodeCapacityResponse> capacities() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private NodeCapacityResponse map(ClusterNode node) {
        return new NodeCapacityResponse(
                node.getId(),
                node.getHostname(),
                node.getCpuCores(),
                node.getAvailableCpuCores(),
                node.getMemoryMb(),
                node.getAvailableMemoryMb()
        );
    }
}
