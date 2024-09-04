import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function LoginPage() {
    const email = useRef<HTMLInputElement | null>(null);
    const password = useRef<HTMLInputElement | null>(null);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        if (email.current && password.current) {
            navigate('/estoque');
        } else {
            setError("Por favor, preencha todos os campos.");
        }
    };

    return (
        <div className="flex min-h-screen items-center justify-center bg-gray-100">
            <Card className="max-w-md w-full p-6">
                <div className="text-center">
                    <h1 className="text-2xl font-bold mb-4">FAÇA LOGIN</h1>
                </div>
                <div>
                    <form onSubmit={handleLogin}>
                        <div className="mb-4">
                            <Label>
                                E-MAIL
                            </Label>
                            <Input 
                                placeholder="DIGITE O E-MAIL"
                                ref={email}
                                type="email"
                                className="mt-1"
                            />
                        </div>
                        <div className="mb-4">
                            <Label>
                                SENHA
                            </Label>
                            <Input 
                                type="password"
                                placeholder="DIGITE A SENHA"
                                ref={password}
                                className="mt-1"
                            />
                        </div>
                        {error && <p className="text-red-500">{error}</p>}
                        <div>
                            <Button type="submit" className="w-full">ENTRAR</Button>
                        </div>
                    </form>
                </div>
            </Card>
        </div>
    );
}
