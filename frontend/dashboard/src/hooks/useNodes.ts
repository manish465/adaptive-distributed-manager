import { useQuery } from "@tanstack/react-query";
import { getNodes } from "../api/nodeApi";

export function useNodes() {
    return useQuery({
        queryKey: ["nodes"],
        queryFn: getNodes,
    });
}
