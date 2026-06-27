package com.manish.router.cluster.service;

import com.manish.router.cluster.dto.CreateNodeRequest;
import com.manish.router.cluster.dto.NodeResponse;
import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.entity.NodeStatus;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClusterNodeService {
    private final ClusterNodeRepository repository;

    public NodeResponse create(CreateNodeRequest request) {
        Instant now = Instant.now();

        ClusterNode node = ClusterNode.builder()
                .id(UUID.randomUUID())
                .hostname(request.hostname())
                .address(request.address())
                .rack(request.rack())
                .zone(request.zone())
                .cpuCores(request.cpuCores())
                .memoryMb(request.memoryMb())
                .status(NodeStatus.ONLINE)
                .lastHeartbeat(now)
                .heartbeatTimeoutSeconds(30)
                .createdAt(now)
                .updatedAt(now)
                .build();

        repository.save(node);

        return map(node);
    }

    public List<NodeResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public void updateHeartbeat(UUID nodeId) {

        ClusterNode node = repository.findById(nodeId)
                .orElseThrow();

        node.setLastHeartbeat(Instant.now());

        repository.save(node);
    }

    private NodeResponse map(ClusterNode node) {
        return new NodeResponse(
                node.getId(),
                node.getHostname(),
                node.getAddress(),
                node.getRack(),
                node.getZone(),
                node.getCpuCores(),
                node.getMemoryMb(),
                node.getStatus()
        );
    }
}
