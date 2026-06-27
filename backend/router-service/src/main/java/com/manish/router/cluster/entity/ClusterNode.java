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

    @Column(nullable = false, unique = true)
    private String nodeName;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Integer port;

    @Enumerated(EnumType.STRING)
    private NodeStatus status;

    private Integer cpuCores;

    private Long memoryMb;

    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }
}
