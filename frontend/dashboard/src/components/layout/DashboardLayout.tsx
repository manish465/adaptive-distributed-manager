import Sidebar from "./Sidebar";
import AppHeader from "./AppHeader";
import { Outlet } from "react-router-dom";

export default function DashboardLayout() {
    return (
        <div className="flex h-screen">
            <Sidebar />

            <div className="flex-1 flex flex-col overflow-hidden">
                <AppHeader />

                <main className="flex-1 overflow-auto bg-slate-100 p-8">
                    <Outlet />
                </main>
            </div>
        </div>
    );
}
