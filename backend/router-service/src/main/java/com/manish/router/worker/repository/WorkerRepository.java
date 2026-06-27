package com.manish.router.worker.repository;

import com.manish.router.worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
}
