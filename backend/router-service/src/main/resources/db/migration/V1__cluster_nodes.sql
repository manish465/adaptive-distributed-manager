CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE cluster_nodes (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   hostname VARCHAR(100) NOT NULL,
   address VARCHAR(100) NOT NULL,

   rack VARCHAR(50),
   zone VARCHAR(50),

   cpu_cores INTEGER NOT NULL,
   memory_mb INTEGER NOT NULL,

   status VARCHAR(30) NOT NULL,

   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP NOT NULL
);