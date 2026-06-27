package com.manish.router.cluster.mapper;

import com.manish.router.cluster.dto.NodeResponse;
import com.manish.router.cluster.entity.ClusterNode;
import org.springframework.stereotype.Component;

@Component
public class ClusterMapper {
    public NodeResponse map(ClusterNode node) {
        return new NodeResponse(
                node.getId(),
                node.getNodeName(),
                node.getHost(),
                node.getPort(),
                node.getStatus(),
                node.getCpuCores(),
                node.getMemoryMb()
        );
    }
}
