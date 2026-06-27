export interface NodeCapacity {
    nodeId: string;
    hostname: string;
    totalCpu: number;
    availableCpu: number;
    totalMemory: number;
    availableMemory: number;
}
