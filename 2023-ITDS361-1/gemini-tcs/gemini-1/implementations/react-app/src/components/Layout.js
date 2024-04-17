import { Outlet } from "react-router-dom"
import Appbar from "./AppBar"
function Layout() {
    return (
        <main className="App">
            <Appbar />
            <Outlet />
        </main>
    )
}

export default Layout;