import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Signin from './pages/SignIn'
import { UserProvider } from './context/UserContext'
import Administration from './pages/Administration'
import Home from './pages/Home'
import Login from './pages/LogIn'
import Producto from './pages/Producto'
import Reservas from './pages/Reservas'
import ReservaConfirmada from './pages/ReservaConfirmada'
import ProductoConfirmado from './pages/ProductoConfirmado'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <UserProvider>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signup" element={<Signin />} />
            <Route path="/login" element={<Login />} />
            <Route path="/administration" element={<Administration />} />
            <Route path="/administration/ok" element={<ProductoConfirmado />} />
            <Route path={`/product/:id`} element={<Producto />} />
            <Route path={`/product/:id/reservas`} element={<Reservas />} />
            <Route
              path={`/product/:id/reservas/ok`}
              element={<ReservaConfirmada />}
            />
          </Routes>
        </UserProvider>
      </BrowserRouter>
    </div>
  )
}

export default App
