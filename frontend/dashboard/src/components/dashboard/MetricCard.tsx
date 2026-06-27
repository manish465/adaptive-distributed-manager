interface Props {
    title: string;
    value: string | number;
}

export default function MetricCard({ title, value }: Props) {
    return (
        <div className="bg-white rounded-xl shadow-sm border p-6">
            <div className="text-slate-500 text-sm">{title}</div>
            <div className="mt-3 text-3xl font-bold text-slate-800">
                {value}
            </div>
        </div>
    );
}
