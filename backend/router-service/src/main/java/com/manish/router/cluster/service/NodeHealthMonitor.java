package com.manish.router.cluster.service;

import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.entity.NodeStatus;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NodeHealthMonitor {
    private final ClusterNodeRepository repository;

    @Scheduled(fixedDelay = 5000)
    public void monitorNodes() {
        List<ClusterNode> nodes = repository.findAll();
        Instant now = Instant.now();

        for (ClusterNode node : nodes) {
            if (node.getLastHeartbeat() == null) {
                markOffline(node);
                continue;
            }

            Instant timeout = now.minusSeconds(node.getHeartbeatTimeoutSeconds());
            boolean healthy = node.getLastHeartbeat()
                            .isAfter(timeout);

            if (healthy && node.getStatus() == NodeStatus.OFFLINE) {
                node.setStatus(NodeStatus.ONLINE);
                repository.save(node);
                log.info("Node {} is ONLINE", node.getHostname());
            }

            if (!healthy && node.getStatus() == NodeStatus.ONLINE) {
                markOffline(node);
            }
        }
    }

    private void markOffline(ClusterNode node) {
        node.setStatus(NodeStatus.OFFLINE);
        repository.save(node);
        log.warn("Node {} became OFFLINE", node.getHostname());
    }
}
