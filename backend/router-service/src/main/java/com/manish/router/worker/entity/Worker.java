package com.manish.router.worker.entity;

import com.manish.router.cluster.entity.ClusterNode;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "workers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    @Id
    private UUID id;

    private String name;

    private Integer cpuRequest;

    private Integer memoryRequestMb;

    @Enumerated(EnumType.STRING)
    private WorkerStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "node_id")
    private ClusterNode node;

    private Instant createdAt;
}
