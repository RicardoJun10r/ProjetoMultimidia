import { Link } from 'react-router-dom'
import { Button } from '../ui/button'
import { Plus, CreditCard, Boxes, DollarSign, LogOut } from 'lucide-react'

export default function Sidebar() {

  return (
    <div className="pb-12 w-1/5">
      <div className="space-y-4 py-4 h-full border-r-2 border-gray-300">
        <div className="px-3 py-2">
          <h2 className="mb-2 px-4 text-4xl font-semibold tracking-tight">
            Gerenciador
          </h2>
          <div className="space-y-1">
            <Button
              asChild
              variant="ghost"
              className="w-full text-2xl justify-start flex gap-2"
            >
              <Link to="/estoque">
                <Boxes />
                ESTOQUE
              </Link>
            </Button>
            <Button
              asChild
              variant="ghost"
              className="w-full text-2xl justify-start flex gap-2"
            >
              <Link to="/caixa">
                <DollarSign />
                CAIXA
              </Link>
            </Button>
            <Button
              asChild
              variant="ghost"
              className="w-full text-2xl justify-start flex gap-2"
            >
              <Link to="/entradas">
                <Plus />
                ENTRADAS
              </Link>
            </Button>
            <Button
              asChild
              variant="ghost"
              className="w-full text-2xl justify-start flex gap-2"
            >
              <Link to="/dividas">
                <CreditCard />
                DIVIDAS
              </Link>
            </Button>
            <Button
              asChild
              variant="ghost"
              className="w-full text-2xl justify-start flex gap-2"
            >
              <Link to="/login">
                <LogOut />
                SAIR
              </Link>
            </Button>
          </div>
        </div>
      </div>
    </div>
  )
}