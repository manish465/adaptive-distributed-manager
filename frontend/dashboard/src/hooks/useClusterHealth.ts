import { useQuery } from "@tanstack/react-query";
import { getClusterHealth } from "../api/healthApi";

export function useClusterHealth() {
    return useQuery({
        queryKey: ["cluster-health"],
        queryFn: getClusterHealth,
        refetchInterval: 5000,
    });
}
