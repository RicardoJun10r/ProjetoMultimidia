import React from 'react';

const Profile: React.FC = () => {
  return (
    <div className="profile-card">
      <img className="profile-pic" src="https://via.placeholder.com/100" alt="User" />
      <h3>Eduardo Linhares</h3>
      <p>@EdLinhares_</p>
      <div className="stats">
        <div>
          <span>250</span>
          <p>Arquivos</p>
        </div>
        <div>
          <span>2022</span>
          <p>Seguidores</p>
        </div>
        <div>
          <span>590</span>
          <p>Seguindo</p>
        </div>
      </div>
      <button className="btn-profile">Meu Perfil</button>
    </div>
  );
};

export default Profile;
