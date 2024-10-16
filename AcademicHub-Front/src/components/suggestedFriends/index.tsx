import React from 'react';

const SuggestedFriends: React.FC = () => {
  return (
    <div className="suggested-friends">
      <h4>Sugestões de amizade</h4>
      <ul>
        <li>Eduarda <button>Follow</button></li>
        <li>Vinicius Lima <button>Follow</button></li>
        <li>Rafael Aires <button>Follow</button></li>
        <li>Pedro Reis <button>Follow</button></li>
      </ul>
    </div>
  );
};

export default SuggestedFriends;
