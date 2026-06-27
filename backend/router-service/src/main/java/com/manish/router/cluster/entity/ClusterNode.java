package com.manish.router.cluster.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "cluster_nodes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterNode {
    @Id
    private UUID id;

    private String hostname;

    private String address;

    private String rack;

    private String zone;

    private Integer cpuCores;

    private Integer memoryMb;

    private Integer availableCpuCores;

    private Integer availableMemoryMb;

    @Enumerated(EnumType.STRING)
    private NodeStatus status;

    private Instant lastHeartbeat;

    private Integer heartbeatTimeoutSeconds;

    private Instant createdAt;

    private Instant updatedAt;
}
