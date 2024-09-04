import { Outlet } from 'react-router-dom'
import { Layout } from './components/layout/main-layout'

function App() {
  return (
    <div className='h-screen w-screen'>
      <Layout>
        <Outlet />
      </Layout>
    </div>
  )
}

export default App
