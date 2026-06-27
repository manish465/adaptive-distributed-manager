import { FaServer, FaProjectDiagram, FaHome } from "react-icons/fa";
import { NavLink } from "react-router-dom";

export default function Sidebar() {
    const itemClass = ({ isActive }: any) =>
        `flex items-center gap-3 px-4 py-3 rounded-lg transition ${isActive ? "bg-blue-600 text-white" : "text-slate-300 hover:bg-slate-800"}`;

    return (
        <aside className="w-72 bg-slate-900 min-h-screen p-6">
            <h1 className="text-3xl font-bold text-white mb-10">ADDCP</h1>

            <nav className="space-y-2">
                <NavLink to="/" className={itemClass}>
                    <FaHome />
                    Overview
                </NavLink>

                <NavLink to="/nodes" className={itemClass}>
                    <FaServer />
                    Nodes
                </NavLink>

                <NavLink to="/topology" className={itemClass}>
                    <FaProjectDiagram />
                    Topology
                </NavLink>
            </nav>
        </aside>
    );
}
