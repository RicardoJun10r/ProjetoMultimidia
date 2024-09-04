import { ReactNode } from "react"
import Sidebar from "./sidebar"
import AppBar from "./appbar"
import { Toaster } from "../ui/sonner"

interface ContentProps {
    children: ReactNode
}

export function Layout({ children }: ContentProps) {
    return (
        <div className="flex flex-col h-screen">
            <AppBar />
            <div className="flex flex-1 overflow-hidden pt-16">
                <Sidebar />
                <main className="flex flex-1 items-center justify-center h-screen overflow-x-hidden overflow-y-auto p-4">
                    {children}
                </main>
                <Toaster />
            </div>
        </div>
    )
}
