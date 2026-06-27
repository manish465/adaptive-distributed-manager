import MetricCard from "../components/dashboard/MetricCard";
import PageHeader from "../components/common/PageHeader";
import { useClusterHealth } from "../hooks/useClusterHealth";
import HealthCard from "../components/dashboard/HealthCard";
import { useStatus } from "../hooks/useStatus";
import NodeCapacityTable from "../components/dashboard/NodeCapacityTable";
import { useCapacity } from "../hooks/useCapacity";

export default function DashboardPage() {
    const health = useClusterHealth();
    const status = useStatus();
    const capacity = useCapacity();

    return (
        <>
            <PageHeader
                title="Cluster Overview"
                subtitle="Real-time cluster monitoring."
            />
            <div className="grid lg:grid-cols-4 gap-6">
                <MetricCard
                    title="Nodes"
                    value={health.data?.totalNodes ?? 0}
                />
                <MetricCard
                    title="Healthy"
                    value={health.data?.healthyNodes ?? 0}
                />
                <MetricCard
                    title="Unhealthy"
                    value={health.data?.unhealthyNodes ?? 0}
                />
                <HealthCard
                    online={status.data?.online ?? 0}
                    offline={status.data?.offline ?? 0}
                />
            </div>
            <div className="mt-8">
                <NodeCapacityTable nodes={capacity.data ?? []} />
            </div>
        </>
    );
}
