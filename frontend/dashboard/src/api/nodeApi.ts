import axios from "axios";
import type { ClusterNode } from "../types/node";

const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

export async function getNodes(): Promise<ClusterNode[]> {
    const response = await api.get("/nodes");
    return response.data;
}
