package com.manish.router.worker.service;

import com.manish.router.cluster.entity.ClusterNode;
import com.manish.router.cluster.repository.ClusterNodeRepository;
import com.manish.router.worker.dto.CreateWorkerRequest;
import com.manish.router.worker.dto.WorkerResponse;
import com.manish.router.worker.entity.Worker;
import com.manish.router.worker.entity.WorkerStatus;
import com.manish.router.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final ClusterNodeRepository nodeRepository;
    private final SchedulerService schedulerService;

    @Transactional
    public WorkerResponse create(
            CreateWorkerRequest request
    ) {

        ClusterNode node = schedulerService.schedule(
                        request.cpuRequest(),
                        request.memoryRequestMb()
                );

        node.setAvailableCpuCores(node.getAvailableCpuCores() - request.cpuRequest());
        node.setAvailableMemoryMb(node.getAvailableMemoryMb() - request.memoryRequestMb());

        nodeRepository.save(node);

        Worker worker = Worker.builder()
                        .id(UUID.randomUUID())
                        .name(request.name())
                        .cpuRequest(request.cpuRequest())
                        .memoryRequestMb(request.memoryRequestMb())
                        .status(WorkerStatus.RUNNING)
                        .node(node)
                        .createdAt(Instant.now())
                        .build();

        workerRepository.save(worker);

        return new WorkerResponse(
                worker.getId(),
                worker.getName(),
                worker.getStatus().name(),
                node.getHostname()
        );
    }
}
