import React, { useState, useEffect } from 'react'
import { getLocationById } from '../services/Api'
import '../Styles/ProductDescription.css'

const ProductDescription = ({ ciudad, descripcion }) => {
  const [locacion, setLocacion] = useState([])

  useEffect(() => {
    if (ciudad) {
      getLocationById(ciudad.id).then((data) => {
        setLocacion(data.data)
      })
    }
  }, [ciudad])

  return (
    <div className="product-description">
      <h2>Alójate en el corazón de {locacion.nombre}</h2>
      <p>{descripcion}</p>
    </div>
  )
}
export default ProductDescription
