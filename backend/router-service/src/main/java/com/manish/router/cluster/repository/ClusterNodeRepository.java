package com.manish.router.cluster.repository;

import com.manish.router.cluster.entity.ClusterNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClusterNodeRepository extends JpaRepository<ClusterNode, UUID> {
}
