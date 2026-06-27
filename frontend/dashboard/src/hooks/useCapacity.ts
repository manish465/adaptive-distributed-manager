import { useQuery } from "@tanstack/react-query";
import { getCapacities } from "../api/capacityApi";

export function useCapacity() {
    return useQuery({
        queryKey: ["capacity"],
        queryFn: getCapacities,
        refetchInterval: 5000,
    });
}
