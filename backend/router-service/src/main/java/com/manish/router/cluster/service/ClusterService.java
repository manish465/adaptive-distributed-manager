package com.manish.router.cluster.service;

import com.manish.router.cluster.dto.NodeResponse;
import com.manish.router.cluster.dto.RegisterNodeRequest;
import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.entity.NodeStatus;
import com.manish.router.cluster.mapper.ClusterMapper;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClusterService {
    private final ClusterNodeRepository repository;
    private final ClusterMapper clusterMapper;

    public NodeResponse register(RegisterNodeRequest request) {

        ClusterNode node = ClusterNode.builder()
                .id(UUID.randomUUID())
                .nodeName(request.nodeName())
                .host(request.host())
                .port(request.port())
                .cpuCores(request.cpuCores())
                .memoryMb(request.memoryMb())
                .status(NodeStatus.UP)
                .build();

        repository.save(node);

        return clusterMapper.map(node);
    }

    public List<NodeResponse> getNodes() {
        return repository.findAll()
                .stream()
                .map(clusterMapper::map)
                .toList();
    }
}
