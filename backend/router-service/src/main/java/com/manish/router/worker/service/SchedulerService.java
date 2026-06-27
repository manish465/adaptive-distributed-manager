package com.manish.router.worker.service;

import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.entity.NodeStatus;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final ClusterNodeRepository repository;

    public ClusterNode schedule(
            Integer cpu,
            Integer memory
    ) {

        return repository.findAll()
                .stream()
                .filter(node ->
                        node.getStatus() == NodeStatus.ONLINE)
                .filter(node ->
                        node.getAvailableCpuCores() >= cpu)
                .filter(node ->
                        node.getAvailableMemoryMb() >= memory)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(
                                "No suitable node found"
                        ));
    }
}
