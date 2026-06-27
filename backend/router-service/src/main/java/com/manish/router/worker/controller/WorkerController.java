package com.manish.router.worker.controller;

import com.manish.router.worker.dto.CreateWorkerRequest;
import com.manish.router.worker.dto.WorkerResponse;
import com.manish.router.worker.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workers")
@RequiredArgsConstructor
@CrossOrigin
public class WorkerController {
    private final WorkerService service;

    @PostMapping
    public WorkerResponse create(
            @Valid @RequestBody
            CreateWorkerRequest request
    ) {
        return service.create(request);
    }
}
