import { useState } from "react";
import { createWorker } from "../../api/workerApi";

export default function CreateWorkerForm() {
    const [name, setName] = useState("");
    const [cpu, setCpu] = useState(1);
    const [memory, setMemory] = useState(512);

    async function submit() {
        await createWorker({
            name,
            cpuRequest: cpu,
            memoryRequestMb: memory,
        });

        setName("");
    }

    return (
        <div className="bg-white p-6 rounded-xl border">
            <h2 className="font-semibold mb-4">Launch Worker</h2>

            <input
                className="border p-2 w-full mb-3"
                placeholder="worker-name"
                value={name}
                onChange={(e) => setName(e.target.value)}
            />

            <input
                type="number"
                className="border p-2 w-full mb-3"
                value={cpu}
                onChange={(e) => setCpu(Number(e.target.value))}
            />

            <input
                type="number"
                className="border p-2 w-full mb-3"
                value={memory}
                onChange={(e) => setMemory(Number(e.target.value))}
            />

            <button
                onClick={submit}
                className="bg-blue-600 text-white px-4 py-2 rounded"
            >
                Schedule Worker
            </button>
        </div>
    );
}
