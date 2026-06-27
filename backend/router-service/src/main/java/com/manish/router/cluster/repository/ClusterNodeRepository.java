package com.manish.router.cluster.repository;

import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.entity.NodeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClusterNodeRepository extends JpaRepository<ClusterNode, UUID> {
    List<ClusterNode> findByStatus(NodeStatus status);
}
