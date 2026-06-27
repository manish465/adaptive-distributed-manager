import PageHeader from "../components/common/PageHeader";

export default function TopologyPage() {
    return (
        <>
            <PageHeader
                title="Cluster Topology"
                subtitle="Node relationships and placement."
            />
            <div className="bg-white border rounded-xl h-[600px] flex items-center justify-center text-slate-400">
                React Flow topology visualization coming in Phase 2.
            </div>
        </>
    );
}
