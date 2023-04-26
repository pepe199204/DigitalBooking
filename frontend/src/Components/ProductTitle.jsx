import React from 'react'
import '../Styles/Navegador.css'

import { Link } from 'react-router-dom'

export default function ProductTitle({ titulo, categoria }) {
  return (
    <div className="nav">
      {titulo && (
        <div className="titulo-nav">
          <div className="titulo-data">
            <h3>{categoria.titulo}</h3>
            <h2>{titulo}</h2>
          </div>
          <div className="titulo-back">
            <Link to="/">
              <img
                src={require('../Images/path9429.png')}
                className="back-icon"
                alt="back"
              />
            </Link>
          </div>
        </div>
      )}
    </div>
  )
}
