import type { ClusterNode } from "../../types/node";
import StatusBadge from "../common/StatusBadge";

interface Props {
    nodes: ClusterNode[];
}

export default function NodeTable({ nodes }: Props) {
    return (
        <div className="bg-white rounded-xl shadow-sm border overflow-hidden">
            <table className="w-full">
                <thead className="bg-slate-50">
                    <tr>
                        <th className="text-left p-4">Hostname</th>
                        <th className="text-left p-4">Status</th>
                        <th className="text-left p-4">CPU</th>
                        <th className="text-left p-4">Memory</th>
                        <th className="text-left p-4">Zone</th>
                    </tr>
                </thead>
                <tbody>
                    {nodes.map((node) => (
                        <tr
                            key={node.id}
                            className="border-t hover:bg-slate-50"
                        >
                            <td className="p-4 font-medium">{node.hostname}</td>
                            <td className="p-4">
                                <StatusBadge status={node.status} />
                            </td>
                            <td className="p-4">{node.cpuCores}</td>
                            <td className="p-4">{node.memoryMb} MB</td>
                            <td className="p-4">{node.zone}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
