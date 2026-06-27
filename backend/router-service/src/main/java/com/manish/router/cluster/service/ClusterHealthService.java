package com.manish.router.cluster.service;

import com.manish.router.cluster.dto.ClusterHealthResponse;
import com.manish.router.cluster.dto.NodeHealthResponse;
import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClusterHealthService {
    private final ClusterNodeRepository repository;

    public ClusterHealthResponse clusterHealth() {
        List<ClusterNode> nodes = repository.findAll();

        int healthy = (int) nodes.stream()
                .filter(this::isHealthy)
                .count();

        return new ClusterHealthResponse(
                nodes.size(),
                healthy,
                nodes.size() - healthy
        );
    }

    public List<NodeHealthResponse> nodeHealth() {
        return repository.findAll()
                .stream()
                .map(node -> new NodeHealthResponse(
                        node.getId(),
                        node.getHostname(),
                        node.getStatus().name(),
                        node.getLastHeartbeat(),
                        isHealthy(node)
                ))
                .toList();
    }

    private boolean isHealthy(ClusterNode node) {
        if (node.getLastHeartbeat() == null) {
            return false;
        }

        Instant timeout = Instant.now().minusSeconds(node.getHeartbeatTimeoutSeconds());

        return node.getLastHeartbeat().isAfter(timeout);
    }
}
