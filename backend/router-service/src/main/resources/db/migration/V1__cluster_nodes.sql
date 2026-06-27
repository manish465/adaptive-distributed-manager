CREATE TABLE cluster_nodes (
       id UUID PRIMARY KEY,
       node_name VARCHAR(100) UNIQUE,
       host VARCHAR(255),
       port INTEGER,
       status VARCHAR(30),
       cpu_cores INTEGER,
       memory_mb BIGINT,
       created_at TIMESTAMP,
       updated_at TIMESTAMP
);