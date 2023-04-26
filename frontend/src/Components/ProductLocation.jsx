import React, { useState, useEffect } from 'react'
import { getLocationById } from '../services/Api'
import '../Styles/ProductLocation.css'

const ProductLocation = ({ ciudad, ubicacion }) => {
  const [locacion, setLocacion] = useState([])

  useEffect(() => {
    if (ciudad) {
      getLocationById(ciudad.id).then((data) => {
        setLocacion(data.data)
      })
    }
  }, [ciudad])
  return (
    <div>
      <div className="product-location">
        <div className="loc-left">
          <img src={require('../Images/localizador.png')} alt="icon" />
          <div>
            <p>{locacion.nombre}</p>
            <p>{ubicacion}</p>
          </div>
        </div>
        <div className="loc-right">
          <div>
            <p>Muy Bueno</p>
            <div>
              <img src={require('../Images/color-star.png')} alt="icon" />
              <img src={require('../Images/color-star.png')} alt="icon" />
              <img src={require('../Images/color-star.png')} alt="icon" />
              <img src={require('../Images/color-star.png')} alt="icon" />
              <img src={require('../Images/grey-star.png')} alt="icon" />
            </div>
          </div>
          <p className="puntuacion">8</p>
        </div>
      </div>
    </div>
  )
}
export default ProductLocation
