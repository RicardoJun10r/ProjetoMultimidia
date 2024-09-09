import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './style.css';

import { FcGoogle } from "react-icons/fc";

function Login() {
  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const navigate = useNavigate();

  const handleSignUp = (e: React.FormEvent) => {
    e.preventDefault();
    // Lógica para realizar o cadastro
    console.log('Email:', email, 'Password:', password);

    navigate('/home');

  };

  return (
    <div className='corpo'>
      <div className="container">
        <div className="signup-box">
          <h2>Login</h2>
          <p>Entre, guarde e compartilher seus documentos</p>
          <button className="google-signup">
            <FcGoogle className='imagem'/>
            Use Google account
          </button>
          <p className="or-text">or</p>
          <form onSubmit={handleSignUp}>
            <div className="input-group">
              <input
                type="email"
                id="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div className="input-group">
              <input
                type="password"
                id="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <button type="submit" className="signup-btn">
              Entrar
            </button>
          </form>
          <p className="signin-text">
            É novo por aqui? <a href="#">Cadastre-se</a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;
