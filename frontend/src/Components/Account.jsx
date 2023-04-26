import React, { useState, useEffect, useContext } from 'react'
import '../Styles/Account.css'
import { useNavigate } from 'react-router-dom'
import { FormErrors } from './FormErrors'
import UserContext from '../context/UserContext'
import { login, register } from '../services/userService'

export default function Account() {
  const { loginLogoutEvent } = useContext(UserContext)
  const [formData, setFormData] = useState({
    nombre: '',
    apellido: '',
    email: '',
    password: '',
    passwordConfirm: '',
  })
  const navigate = useNavigate()
  const [formErrors, setFormErrors] = useState({
    email: '',
    password: '',
    passwordConfirm: '',
  })
  const [user, setUser] = useState({})
  const [singInSuccess, setSingInSuccess] = useState(false)
  const [errorMessage, setErrorMessage] = useState('')

  useEffect(() => {
    localStorage.setItem('user', JSON.stringify(user))
  }, [user])

  useEffect(() => {
    const redirectLogin = () => {
      if (singInSuccess) navigate('/login')
    }
    redirectLogin()
  }, [singInSuccess, navigate])

  const handleSubmit = async (e) => {
    e.preventDefault()

    let emailValid = false
    let passwordValid = false
    let passwordConfirmValid = false

    const regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/
    if (regexEmail.test(formData.email)) {
      console.log('ENTREEE 33')
      emailValid = true
    } else {
      setFormErrors({
        ...formErrors,
        email: 'Ingrese un correo electronico válido',
      })
    }

    const regexPassword = /^.{6,15}$/ // 6 a 15 digitos.
    const passValid = () => {
      if (regexPassword.test(formData.password)) {
        passwordValid = true
      } else {
        return (
          <div className="error-messages">
            <FormErrors formErrors={formErrors}>
              {setFormErrors({
                ...formErrors,
                password: 'La contraseña debe tener mínimo 6 caracteres',
              })}
            </FormErrors>
            ;
          </div>
        )
      }
      return passValid
    }
    passValid()
    if (formData.password.length > 0) {
      if (formData.password === formData.passwordConfirm) {
        passwordConfirmValid = true
      } else {
        setFormErrors({
          ...formErrors,
          passwordConfirm: 'Las contraseñas deben coincidir',
        })
      }
    }

    if (emailValid && passwordValid && passwordConfirmValid) {
      try {
        await register({
          nombre: formData.nombre,
          apellido: formData.apellido,
          email: formData.email,
          password: formData.password,
        })

        const userLogged = await login({
          email: formData.email,
          password: formData.password,
        })

        loginLogoutEvent(
          {
            id: userLogged.data.id,
            nombre: userLogged.data.nombre,
            apellido: userLogged.data.apellido,
            email: userLogged.data.email,
            ciudad: '',
            auth: true,
            log: false,
            rol: {
              id: userLogged.data.rol.id,
              nombre: userLogged.data.rol.nombre,
            },
          },
          userLogged.data.jwt
        )
        // setUser({ email: formData.email, password: formData.password });
        setUser(userLogged.data)

        setSingInSuccess(true)
        setFormData({
          nombre: '',
          apellido: '',
          email: '',
          password: '',
          passwordConfirm: '',
        })
        navigate('/')
      } catch (e) {
        setErrorMessage(e.message)
      }
    }
  }

  return (
    <div className="account-container">
      {errorMessage && (
        <div className="error-login">
          <img src={require(`../Images/Caracter-icons/wifi.png`)} alt="error" />{' '}
          <p className="error-login-message">{errorMessage} </p>
        </div>
      )}

      <h2>Crear Cuenta</h2>
      <form onSubmit={handleSubmit} className="account-form">
        {singInSuccess && (
          <div className="success-message">¡Registro exitoso!</div>
        )}

        <div className="form-name">
          <div className="name">
            <label htmlFor="nombre">Nombre</label>
            <input
              type="text"
              id="nombre"
              name="nombre"
              value={formData.nombre}
              onChange={(e) =>
                setFormData({ ...formData, nombre: e.target.value })
              }
              required
            />
          </div>
          <div className="surname">
            <label htmlFor="apellido">Apellido</label>
            <input
              type="text"
              id="apellido"
              name="apellido"
              value={formData.apellido}
              onChange={(e) =>
                setFormData({ ...formData, apellido: e.target.value })
              }
              required
            />
          </div>
        </div>

        <div className="form-mail">
          <label>Correo Electronico</label>
          <input
            type="email"
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

        <div className="form-confirmpassword">
          <label>Confirmar Contraseña</label>
          <input
            type="password"
            id="passwordConfirm"
            name="passwordConfirm"
            value={formData.passwordConfirm}
            onChange={(e) =>
              setFormData({ ...formData, passwordConfirm: e.target.value })
            }
          />
        </div>

        <input type="submit" value="Crear Cuenta" className="button3" />
      </form>

      <p>
        ¿Ya tienes una cuenta? <a href="/login">Iniciar sesión</a>{' '}
      </p>
    </div>
  )
}
