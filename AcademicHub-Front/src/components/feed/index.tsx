import React from 'react';
import { CiImageOn, CiVideoOn} from "react-icons/ci";
import { IoDocumentTextOutline } from "react-icons/io5";

const Feed: React.FC = () => {
  return (
    <div className="feed">
      <div className="new-post">
        <input 
          type="text"
          placeholder="Estou procurando por..." 
        />
        <div className="post-options">
          <button>
            <CiImageOn/>
            Imagens
          </button>
          <button>
            <CiVideoOn/>
            Videos
          </button>
          <button>
            <IoDocumentTextOutline/>
            Artigos
          </button>
        </div>
      </div>
      <div className="post">
        <div className="post-header">
          <img className="post-user-pic" src="https://via.placeholder.com/50" alt="User" />
          <p>Eduardo Linhares - 12 minutos</p>
        </div>
        <p>Compartilhando com vcs minha nova criação! 
          #Art #Aesthetics</p>
        <img className="post-image" src="https://via.placeholder.com/300" alt="Post" />
        <div className="post-interactions">
          <span>❤️ 32</span>
          <span>💬 120</span>
          <span>🔁 148</span>
        </div>
      </div>
    </div>
  );
};

export default Feed;
