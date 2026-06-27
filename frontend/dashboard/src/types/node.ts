export interface ClusterNode {
    id: string;
    hostname: string;
    address: string;
    rack: string;
    zone: string;
    cpuCores: number;
    memoryMb: number;
    status: string;
}
