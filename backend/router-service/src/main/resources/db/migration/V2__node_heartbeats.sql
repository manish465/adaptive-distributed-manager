ALTER TABLE cluster_nodes
    ADD COLUMN last_heartbeat TIMESTAMP;

ALTER TABLE cluster_nodes
    ADD COLUMN heartbeat_timeout_seconds INTEGER NOT NULL DEFAULT 30;