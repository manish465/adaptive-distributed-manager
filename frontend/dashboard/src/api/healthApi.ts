import axios from "axios";
import type { ClusterHealth } from "../types/clusterHealth";

const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

export async function getClusterHealth(): Promise<ClusterHealth> {
    const response = await api.get("/health/cluster");
    return response.data;
}
