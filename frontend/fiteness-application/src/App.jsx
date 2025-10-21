import { useState } from 'react'

import './App.css'
import LandingPage from './components/landingPage/LandingPage'
import LoginPage from './components/userLogin/LoginPage'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';


function App() {
  const [count, setCount] = useState(0)

  return (
    <>

    <Routes>
    

      <Route path="/" element={<LandingPage />} />
      <Route path="/Login" element={<LoginPage />} />
    </Routes>

    </>
  )
}

export default App
