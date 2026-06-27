interface Props {
    status: string;
}

export default function StatusBadge({ status }: Props) {
    const color = {
        ONLINE: "bg-green-100 text-green-700",
        OFFLINE: "bg-red-100 text-red-700",
        DRAINING: "bg-yellow-100 text-yellow-700",
        MAINTENANCE: "bg-blue-100 text-blue-700",
    }[status];

    return (
        <span className={`px-3 py-1 rounded-full text-sm font-medium ${color}`}>
            {status}
        </span>
    );
}
