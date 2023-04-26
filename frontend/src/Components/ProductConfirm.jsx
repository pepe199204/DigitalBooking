import React from 'react'
import { Link } from 'react-router-dom'
import '../Styles/Booking.css'

const ProductConfirm = () => {
  return (
    <div className="booking-info">
      <div className="confirmation-container">
        <img src={require('../Images/vectorok.png')} alt="okvector" />
        <span className="gracias">¡Muchas gracias!</span>
        <p> Su producto fue creado con exito</p>
        <Link to={'/'} className="button3">
          ok
        </Link>
      </div>
    </div>
  )
}

export default ProductConfirm
