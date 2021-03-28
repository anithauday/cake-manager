import React from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { AuthProvider } from './components/context/AuthContext'
import PrivateRoute from './components/misc/PrivateRoute'
import Navbar from './components/misc/Navbar'
import Home from './components/home/Home'
import Login from './components/home/Login'

import AddCake from './components/user/AddCake'
import Download from "./components/user/Download";

function App() {
  return (
    <AuthProvider>
      <Router>
        <Navbar />
        <Route path='/' exact component={Home} />
        <Route path='/login' component={Login} />
        <PrivateRoute path='/addcake' component={AddCake} />
          <PrivateRoute path='/download' component={Download} />
      </Router>
    </AuthProvider>
  )
}

export default App
