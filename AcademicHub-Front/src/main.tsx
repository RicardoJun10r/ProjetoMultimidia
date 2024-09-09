import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import Rotas from "./router/routes.tsx"

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <BrowserRouter>
    <Rotas/>
  </BrowserRouter>

)