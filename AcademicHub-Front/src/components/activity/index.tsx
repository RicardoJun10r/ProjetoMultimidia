import React from 'react';

const Activity: React.FC = () => {
  return (
    <div className="activity">
      <h4>Atividade recente</h4>
      <ul>
        <li>Você fez um novo post. 12 min</li>
        <li>João Carlos curtiu um post seu. 1 dia</li>
        <li>Clara curtiu um post seu. 1 dia</li>
      </ul>
    </div>
  );
};

export default Activity;
