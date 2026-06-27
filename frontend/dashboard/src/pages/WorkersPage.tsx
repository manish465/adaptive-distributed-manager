import CreateWorkerForm from "../components/workers/CreateWorkerForm";

export default function WorkersPage() {
    return (
        <div>
            <h1 className="text-3xl font-bold mb-6">Workers</h1>
            <CreateWorkerForm />
        </div>
    );
}
