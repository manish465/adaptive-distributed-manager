import Loading from "../components/common/Loading";
import ErrorMessage from "../components/common/ErrorMessage";
import NodeTable from "../components/nodes/NodeTable";
import { useNodes } from "../hooks/useNodes";

export default function NodesPage() {
    const { data, isLoading, error } = useNodes();

    if (isLoading) {
        return <Loading />;
    }

    if (error) {
        return <ErrorMessage message="Failed to load nodes." />;
    }

    return (
        <div>
            <h1 className="text-3xl font-bold mb-6">Cluster Nodes</h1>
            <NodeTable nodes={data ?? []} />
        </div>
    );
}
