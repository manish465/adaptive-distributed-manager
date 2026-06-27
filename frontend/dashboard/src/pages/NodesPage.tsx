import { useEffect, useState } from "react";
import { getNodes } from "../api/clusterApi";

export default function NodesPage() {
    const [nodes, setNodes] = useState([]);

    useEffect(() => {
        getNodes().then(setNodes);
    }, []);

    return (
        <div className="p-8">
            <h1 className="text-3xl font-bold mb-4">Cluster Nodes</h1>

            <table className="table-auto border">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Status</th>
                        <th>CPU</th>
                    </tr>
                </thead>

                <tbody>
                    {nodes.map((node: any) => (
                        <tr key={node.id}>
                            <td>{node.nodeName}</td>
                            <td>{node.status}</td>
                            <td>{node.cpuCores}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
