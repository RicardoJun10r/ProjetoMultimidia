import React from 'react';
import Navbar from '../../components/navBar';
import Profile from '../../components/profile/index';
import Shortcuts from '../../components/shortcuts/index';
import Feed from '../../components/feed/index';
import Activity from '../../components/activity/index';
import SuggestedFriends from '../../components/suggestedFriends/index';
import './style.css';

function Home() {
  return (
    <div className='corpoHome'>
      <Navbar/>
      <div className="dashboard-container">
        <aside className="left-sidebar">
          <Profile />
          <Shortcuts />
        </aside>
        <main className="feed-area">
          <Feed />
        </main>
        <aside className="right-sidebar">
          <Activity />
          <SuggestedFriends />
        </aside>
      </div>
    </div>
  );
};

export default Home;
