import React, { useState, useEffect } from 'react'
import { getCaractById } from '../services/Api'
import '../Styles/ProductCaracter.css'

const ProductCaracter = ({ id }) => {
  const [caract, setCaract] = useState([])

  useEffect(() => {
    if (id) {
      getCaractById(id).then((data) => {
        setCaract(data.data)
      })
    }
  }, [id])

  return (
    <div className="titulo-caract">
      <h2>¿Qué ofrece este lugar?</h2>
      <hr className="linea-producto" />
      <div className="caract-container">
        {caract.map((caracteristica) => {
          return (
            <p key={caracteristica.id}>
              {' '}
              <img
                src={require(`../Images/Caracter-icons/${caracteristica.url_icono}.png`)}
                alt={`caract ${caracteristica.id}`}
              />{' '}
              {caracteristica.nombre}{' '}
            </p>
          )
        })}
      </div>
    </div>
  )
}
export default ProductCaracter
