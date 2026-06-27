interface Props {
    title: string;
    description: string;
}

export default function EmptyState({ title, description }: Props) {
    return (
        <div className="bg-white rounded-xl border p-12 text-center">
            <h3 className="text-xl font-semibold text-slate-700">{title}</h3>

            <p className="text-slate-500 mt-2">{description}</p>
        </div>
    );
}
