import { ModeToggle } from './theme-toggle'

export default function AppBar() {
    return (
        <div className="border-b fixed top-0 w-full">
            <div className="flex h-16 items-center px-4 container mx-auto">
                MA
                <div className="ml-auto flex items-center space-x-4">
                    <ModeToggle />
                </div>
            </div>
        </div>
    )
}