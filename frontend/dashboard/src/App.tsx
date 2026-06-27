import { BrowserRouter, Routes, Route } from "react-router-dom";

import DashboardLayout from "./components/layout/DashboardLayout";
import DashboardPage from "./pages/DashboardPage";
import NodesPage from "./pages/NodesPage";
import TopologyPage from "./pages/TopologyPage";

export default function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<DashboardLayout />}>
                    <Route path="/" element={<DashboardPage />} />
                    <Route path="/nodes" element={<NodesPage />} />
                    <Route path="/topology" element={<TopologyPage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
