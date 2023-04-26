import React, { useRef, useContext, useEffect } from 'react'
import UserContext from '../context/UserContext.js'
import '../Styles/BookingForm.css'
import { Loader } from '@googlemaps/js-api-loader'

const BookingForm = () => {
  const { user, changeCity, city } = useContext(UserContext)
  const loader = new Loader({
    apiKey: 'AIzaSyAiYylXAYovmvUIWkVeQcDdUHonP97gCRE',
    version: 'weekly',
    libraries: ['places'],
  })
  // setTimeout('5000')
  const autoCompleteRef = useRef()
  const inputRef = useRef()
  const options = {
    fields: ['address_components', 'geometry', 'icon', 'name'],
    types: ['(cities)'],
  }
  useEffect(() => {
    loader.load().then(() => {
      autoCompleteRef.current = new window.google.maps.places.Autocomplete(
        inputRef.current,
        options
      )
    })
    console.log(city)
  })

  return (
    <form className="booking-form-container">
      <div className="booking-form">
        <label htmlFor="nombre">Nombre</label>
        <input
          type="text"
          id="nombre"
          name="nombre"
          value={user.nombre}
          readOnly
        />
      </div>
      <div className="booking-form">
        <label htmlFor="apellido">Apellido</label>
        <input
          type="text"
          id="apellido"
          name="apellido"
          value={user.apellido}
          readOnly
        />
      </div>
      <div className="booking-form">
        <label htmlFor="mail">Correo Electronico</label>
        <input type="mail" id="mail" name="mail" value={user.mail} readOnly />
      </div>
      <div className="booking-form-city">
        <label htmlFor="city">Ciudad</label>

        <input
          ref={inputRef}
          placeholder="Insertar ciudad..."
          onSelect={(e) => changeCity({ city: e.target.value })}
        />
      </div>
    </form>
  )
}

export default BookingForm
