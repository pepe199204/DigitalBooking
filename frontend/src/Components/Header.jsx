import React, { useState, useContext, useEffect } from 'react'
import UserContext from '../context/UserContext.js'
import { Link, useLocation, useNavigate } from 'react-router-dom'
import logo1 from '../Images/logo1.png'
import menu from '../Images/menu.png'
import '../Styles/Header.css'

export default function Header() {
  const [stateMenu, setStateMenu] = useState(false)
  const { user, loginLogoutEvent, jwt } = useContext(UserContext)
  const [isAuthenticatedMenu, setIsAuthenticatedMenu] = useState(false)
  const location = useLocation()
  const navigate = useNavigate()

  useEffect(() => {
    setIsAuthenticatedMenu(jwt)
  }, [jwt])

  console.log(user)
  const handleLateralMenu = () => {
    setStateMenu(stateMenu ? false : true)
    showMenu()
  }
  const handleIsAuthMenu = () => {
    if (isAuthenticatedMenu) {
      ////const { nombre, apellido } = JSON.parse(localStorage.getItem('user'));
      return (<>
        <div className='header-cell'>
                  <a id="menu-cellphone-logo" onClick={() => handleLateralMenu()}>
                  <img src={menu} alt="menu-cell" />
                  </a>
        <div className="header-right">
          {user.rol.id === 1 && (
            <div className="header-der-admin">
              <a href="/administration">Administración</a>
            </div>
          )}

          <div className="header-der-log">
            <button className="cruz" onClick={handleClick}>
              X
            </button>
            <div>
              <div className="header-user">
                <span className="iniciales">
                  {user.nombre.charAt(0)}
                  {user.apellido.charAt(0)}
                </span>
                <div className="nombreComp">
                  <p className="saludo">Hola,</p>
                  <p className="nombreCompletoMenu">
                    {`${user.nombre}`} {`${user.apellido}`}
                  </p>
                  {/* <p className="nombreCompletoMenu"></p> */}

                </div>
              </div>
            </div>
          </div>
          
        </div>
        </div>
        <div id="menu-cellphone" className="menu-cellphone">
          <div className="desplegable-top">
            <span
              className="desplegable-cross "
              onClick={() => handleLateralMenu()}
            >
              X
            </span>
            <div className="nombreComp-log">
                <span className="iniciales">
                  {user.nombre.charAt(0)}
                  {user.apellido.charAt(0)}
                </span>
                  <p className="saludo">Hola,</p>
                  <p className="nombreCompletoMenu">
                    {`${user.nombre}`} {`${user.apellido}`}
                  </p>
                  {/* <p className="nombreCompletoMenu"></p> */}

            </div>
          </div>
          <div className="desplegable-logueado">
            <div className="desplegable-options">
            <span className="cruz" onClick={handleClick}>
              Cerrar sesión
            </span>
            <hr></hr>
            </div>
            <div className="desplegable-icons">
              <a href="https://www.facebook.com/">
                {' '}
                <img
                  src={require(`../Images/Desplegable-icons/atomo/fc-dark.png`)}
                  alt="facebook-logo-desplegable"
                />{' '}
              </a>
              <a href="https://www.linkedin.com">
                <img
                  src={require(`../Images/Desplegable-icons/atomo/link-dark.png`)}
                  alt="linkedIn-logo-footer"
                />
              </a>
              <a href="https://www.twitter.com">
                {' '}
                <img
                  src={require(`../Images/Desplegable-icons/atomo/tw-dark.png`)}
                  alt="twitter-logo-footer"
                />
              </a>
              <a href="https://www.instagram.com">
                <img
                  src={require(`../Images/Desplegable-icons/atomo/ig-dark.png`)}
                  alt="instagram-logo-footer"
                />
              </a>
            </div>
          </div>
        </div>
        </>
      )
    } else {
      return (<>
        <div className="header-der">
          {location.pathname !== '/signup' && (
            <Link to="/signup">
              <button className="button2">Crear Cuenta</button>
            </Link>
          )}
          {location.pathname !== '/login' && (
            <Link to="/login">
              <button className="button2">Iniciar sesión</button>
            </Link>
          )}
          <a id="menu-cellphone-logo" onClick={() => handleLateralMenu()}>
            <img src={menu} alt="menu-cell" />
          </a>
        </div>
        <div id="menu-cellphone" className="menu-cellphone">
        <div className="desplegable-top">
          <span
            className="desplegable-cross "
            onClick={() => handleLateralMenu()}
          >
            X
          </span>
          <h3>MENÚ</h3>
        </div>
        <div className="desplegable">
          <div className="desplegable-options">
            {location.pathname !== '/signup' && (
              <Link to="/signup">
                <p>Crear Cuenta</p>
              </Link>
            )}
            <hr></hr>
            {location.pathname !== '/login' && (
              <Link to="/login">
                {' '}
                <p>Iniciar sesión</p>{' '}
              </Link>
            )}
          </div>
          <div className="desplegable-icons">
            <a href="https://www.facebook.com/">
              {' '}
              <img
                src={require(`../Images/Desplegable-icons/atomo/fc-dark.png`)}
                alt="facebook-logo-desplegable"
              />{' '}
            </a>
            <a href="https://www.linkedin.com">
              <img
                src={require(`../Images/Desplegable-icons/atomo/link-dark.png`)}
                alt="linkedIn-logo-footer"
              />
            </a>
            <a href="https://www.twitter.com">
              {' '}
              <img
                src={require(`../Images/Desplegable-icons/atomo/tw-dark.png`)}
                alt="twitter-logo-footer"
              />
            </a>
            <a href="https://www.instagram.com">
              <img
                src={require(`../Images/Desplegable-icons/atomo/ig-dark.png`)}
                alt="instagram-logo-footer"
              />
            </a>
          </div>
        </div>
      </div>
        </>
      )
    }
  }
  const handleClick = () => {
    const cleanUserData = {
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
    }

    loginLogoutEvent(
      {
        ...cleanUserData,
        log: false,
      },
      ''
    )
    navigate(`/`)
  }

  const showMenu = () => {
    if (!stateMenu) {
      console.log('show true')
      document.getElementById('menu-cellphone').style.display = 'block'
    } else {
      console.log('show false')
      document.getElementById('menu-cellphone').style.display = 'none'
    }
  }
  if (isAuthenticatedMenu) {
  return (
    <header>
      <div className="header-izq">
        <Link to="/">
          <img src={logo1} className="header-logo1" alt="logo1" />
        </Link>
        <span className='title-logo'>Sentite como en tu hogar</span>
      </div>

      {handleIsAuthMenu()}


    </header>
  )}
  else{
    return (
      <header>
        <div className="header-izq">
          <Link to="/">
            <img src={logo1} className="header-logo1" alt="logo1" />
          </Link>
          <span className='title-logo'>Sentite como en tu hogar</span>
        </div>
  
        {handleIsAuthMenu()}
  

      </header>)
  }
}
