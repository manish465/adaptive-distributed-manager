import axios from "axios";
import type { Worker } from "../types/worker";

const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

export async function createWorker(request: {
    name: string;
    cpuRequest: number;
    memoryRequestMb: number;
}): Promise<Worker> {
    const response = await api.post("/workers", request);

    return response.data;
}
