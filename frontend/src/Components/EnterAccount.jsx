import React, { useState, useContext } from 'react'
import { useNavigate } from 'react-router-dom'
import UserContext from '../context/UserContext.js'
import { login } from '../services/userService'
import '../Styles/Account.css'

export default function EnterAccount() {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  })
  const { user, loginLogoutEvent, logeado } = useContext(UserContext)
  const navigate = useNavigate()
  const [errorMessage, setErrorMessage] = useState('')

  const handleSubmit = async (event) => {
    console.log('ENTREEE LOGIN', user)
    event.preventDefault()

    if (formData.password && formData.email) {
      try {
        const response = await login({
          email: formData.email,
          password: formData.password,
        })
        const userFromApi = {
          id: response.data.id,
          nombre: response.data.nombre,
          apellido: response.data.apellido,
          mail: response.data.email,
          auth: true,
          rol: {
            id: response.data.rol.id,
            nombre: response.data.rol.nombre,
          },
        }
        loginLogoutEvent(
          { ...userFromApi, log: true, ciudad: '' },
          response.data.jwt
        )
        navigate('/')
      } catch (e) {
        setErrorMessage(e.message)
        setFormData({
          email: '',
          password: '',
        })
      }
    }
  }

  const handleError = () => {
    setErrorMessage('')
  }

  return (
    <div className="account-container">
      {logeado === false && (
        <div className="error-login">
          <p className="error-login-message">
            Para iniciar una reserva debe iniciar sesion
          </p>
        </div>
      )}

      {errorMessage && (
        <div className="error-login">
          <img
            src={require(`../Images/Caracter-icons/error-alert.png`)}
            style={{ marginLeft: 10 }}
            alt="error"
          />
          <p className="error-login-message">{errorMessage} </p>
          <span onClick={handleError} className="error-close">X</span>
        </div>
      )}

      <h2>Iniciar sesión</h2>
      <form onSubmit={handleSubmit} className="account-form">
        <div className="form-mail">
          <label>Correo Electronico</label>
          <input
            // type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={(e) =>
              setFormData({ ...formData, email: e.target.value })
            }
          />
        </div>

        <div className="form-password">
          <label>Contraseña</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={(e) =>
              setFormData({ ...formData, password: e.target.value })
            }
          />
        </div>

        <input type="submit" value="Ingresar" className="button3" />
      </form>

      <p>
        ¿Aún no tienes una cuenta? <a href="/signup">Registrarse</a>{' '}
      </p>
    </div>
  )
}
