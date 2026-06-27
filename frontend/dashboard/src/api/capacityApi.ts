import axios from "axios";
import type { NodeCapacity } from "../types/nodeCapacity";

const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

export async function getCapacities(): Promise<NodeCapacity[]> {
    const response = await api.get("/capacity");
    return response.data;
}
