interface Props {
    online: number;
    offline: number;
}

export default function HealthCard({ online, offline }: Props) {
    return (
        <div className="bg-white border rounded-xl p-6 shadow-sm">
            <h2 className="font-semibold text-slate-700">Cluster Health</h2>

            <div className="mt-4">
                <div className="text-green-600">Online: {online}</div>
                <div className="text-red-600 mt-2">Offline: {offline}</div>
            </div>
        </div>
    );
}
