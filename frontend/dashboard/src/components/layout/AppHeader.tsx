import { FaCircle } from "react-icons/fa";

export default function AppHeader() {
    return (
        <header className="h-16 bg-white border-b flex items-center justify-between px-8">
            <div>
                <h2 className="font-semibold text-slate-800">
                    Adaptive Distributed Data & Compute Platform
                </h2>
            </div>

            <div className="flex items-center gap-3">
                <FaCircle className="text-green-500 text-xs" />

                <span className="text-sm text-slate-600">Cluster Healthy</span>
            </div>
        </header>
    );
}
