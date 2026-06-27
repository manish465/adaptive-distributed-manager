CREATE TABLE workers
(
    id UUID PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    cpu_request INTEGER NOT NULL,

    memory_request_mb INTEGER NOT NULL,

    status VARCHAR(30) NOT NULL,

    node_id UUID,

    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_worker_node
        FOREIGN KEY (node_id)
            REFERENCES cluster_nodes(id)
);