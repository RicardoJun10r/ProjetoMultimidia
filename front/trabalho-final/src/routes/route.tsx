import App from "@/App";
import ErrorPage from "@/pages/error/error-page";
import LoginPage from "@/pages/login/login-page";
import {
    createBrowserRouter,
} from "react-router-dom";

export const router = createBrowserRouter([
    {
        path: '/login',
        element: <LoginPage />
    },
    {
        path: '/',
        element: < App/>,
        errorElement: < ErrorPage/>,
        children: [
            {
                path: '/home',
                element: (
                    <LoginPage />
                )
            }
        ],
    },
])
