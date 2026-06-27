import { useQuery } from "@tanstack/react-query";
import { getStatus } from "../api/statusApi";

export function useStatus() {
    return useQuery({
        queryKey: ["status"],
        queryFn: getStatus,
        refetchInterval: 5000,
    });
}
