package com.manish.router.cluster.service;

import com.manish.router.cluster.dto.NodeSummaryResponse;
import com.manish.router.cluster.entity.NodeStatus;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClusterStatusService {
    private final ClusterNodeRepository repository;

    public NodeSummaryResponse summary() {
        return new NodeSummaryResponse(
                repository.findByStatus(NodeStatus.ONLINE).size(),
                repository.findByStatus(NodeStatus.OFFLINE).size(),
                repository.findByStatus(NodeStatus.MAINTENANCE).size(),
                repository.findByStatus(NodeStatus.DRAINING).size()
        );
    }
}
