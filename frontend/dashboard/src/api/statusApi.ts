import axios from "axios";
import type { NodeSummary } from "../types/nodeSummary";

const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

export async function getStatus(): Promise<NodeSummary> {
    const response = await api.get("/status");
    return response.data;
}
