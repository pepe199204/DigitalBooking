import React, { createContext, useState, useEffect } from 'react'

const UserContext = createContext()

function getInitialState() {
  const authenticateInfo = {
    user: {
      id: '',
      nombre: '',
      apellido: '',
      mail: '',
      ciudad: '',
      auth: false,
      log: false,
      rol: {
        id: '',
        nombre: '',
      },
    },
    jwt: '',
  }
  const userLogged = sessionStorage.getItem('user')
  const jwt = sessionStorage.getItem('jwt')
  if (userLogged && jwt) {
    authenticateInfo.user = JSON.parse(userLogged)
    authenticateInfo.jwt = JSON.parse(jwt)
  }
  return authenticateInfo
}

export const UserProvider = ({ children }) => {
  const [logeado, setlogeado] = useState(true)
  const [city, setCity] = useState()
  const [jwt, setJwt] = useState(getInitialState().jwt)
  const [user, setUser] = useState(getInitialState().user)

  useEffect(() => {
    sessionStorage.setItem('user', JSON.stringify(user))
    sessionStorage.setItem('jwt', JSON.stringify(jwt))
  }, [user, jwt])

  const loginLogoutEvent = (userCredentials, token) => {
    setUser(userCredentials)
    setJwt(token)
  }
  const validateUser = (value) => {
    setlogeado(value)
  }
  const changeCity = (value) => {
    setCity(value)
  }

  return (
    <UserContext.Provider
      value={{
        user,
        loginLogoutEvent,
        jwt,
        logeado,
        validateUser,
        city,
        changeCity,
      }}
    >
      {children}
    </UserContext.Provider>
  )
}

export default UserContext
