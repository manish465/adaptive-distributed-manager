import type { NodeCapacity } from "../../types/nodeCapacity";

interface Props {
    nodes: NodeCapacity[];
}

export default function NodeCapacityTable({ nodes }: Props) {
    return (
        <div className="bg-white rounded-xl border shadow-sm overflow-hidden">
            <div className="p-5 border-b font-semibold">Node Capacity</div>

            <table className="w-full">
                <thead className="bg-slate-50">
                    <tr>
                        <th className="text-left p-4">Node</th>
                        <th className="text-left p-4">CPU</th>
                        <th className="text-left p-4">Memory</th>
                    </tr>
                </thead>

                <tbody>
                    {nodes.map((node) => (
                        <tr key={node.nodeId} className="border-t">
                            <td className="p-4">{node.hostname}</td>
                            <td className="p-4">
                                {node.availableCpu} / {node.totalCpu}
                            </td>
                            <td className="p-4">
                                {node.availableMemory} MB / {node.totalMemory}{" "}
                                MB
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
