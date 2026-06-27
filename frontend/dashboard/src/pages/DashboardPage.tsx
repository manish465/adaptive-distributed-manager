import MetricCard from "../components/dashboard/MetricCard";
import PageHeader from "../components/common/PageHeader";
import { useClusterHealth } from "../hooks/useClusterHealth";

export default function DashboardPage() {
    const { data } = useClusterHealth();

    return (
        <>
            <PageHeader
                title="Cluster Overview"
                subtitle="Real-time cluster health."
            />

            <div className="grid lg:grid-cols-3 gap-6">
                <MetricCard title="Total Nodes" value={data?.totalNodes ?? 0} />

                <MetricCard
                    title="Healthy Nodes"
                    value={data?.healthyNodes ?? 0}
                />

                <MetricCard
                    title="Unhealthy Nodes"
                    value={data?.unhealthyNodes ?? 0}
                />
            </div>
        </>
    );
}
