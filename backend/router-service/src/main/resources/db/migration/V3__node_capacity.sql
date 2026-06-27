ALTER TABLE cluster_nodes
    ADD COLUMN available_cpu_cores INTEGER NOT NULL DEFAULT 0;

ALTER TABLE cluster_nodes
    ADD COLUMN available_memory_mb INTEGER NOT NULL DEFAULT 0;