import MetricCard from "../components/dashboard/MetricCard";
import PageHeader from "../components/common/PageHeader";

export default function DashboardPage() {
    return (
        <>
            <PageHeader
                title="Cluster Overview"
                subtitle="Distributed control plane overview."
            />

            <div className="grid md:grid-cols-3 gap-6">
                <MetricCard title="Cluster Nodes" value="1" />
                <MetricCard title="Shards" value="0" />
                <MetricCard title="Workers" value="0" />
            </div>
        </>
    );
}
