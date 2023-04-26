import React from 'react'
import '../Styles/BookingTimer.css'

const BookingTimer = () => {
  return (
    <div className="booking-timer">
      <h2>Tu horario de llegada</h2>
      <div className="booking-timer-container">
        <p>
          Tu habitación va a estar lista para el check-in entre las 10:00AM y
          las 11:00 PM
        </p>
        <h4>Indicá tu horario estimado de llegada</h4>
        <select className="time-selector">
          <option value="">Seleccionar hora de llegada</option>
          <option value="10:00">10:00 AM</option>
          <option value="11:00">11:00 AM</option>
          <option value="12:00">00:00 PM</option>
          <option value="13:00">01:00 PM</option>
          <option value="14:00">02:00 PM</option>
          <option value="15:00">03:00 PM</option>
          <option value="16:00">04:00 PM</option>
          <option value="17:00">05:00 PM</option>
          <option value="18:00">06:00 PM</option>
          <option value="19:00">07:00 PM</option>
          <option value="20:00">08:00 PM</option>
          <option value="21:00">09:00 PM</option>
          <option value="22:00">10:00 PM</option>
          <option value="23:00">11:00 PM</option>
          <option value="00:00">00:00 AM</option>
          <option value="01:00">01:00 AM</option>
          <option value="02:00">02:00 AM</option>
          <option value="03:00">03:00 AM</option>
          <option value="04:00">04:00 AM</option>
          <option value="05:00">05:00 AM</option>
          <option value="06:00">06:00 AM</option>
          <option value="07:00">07:00 AM</option>
          <option value="08:00">08:00 AM</option>
          <option value="09:00">09:00 AM</option>
        </select>
      </div>
    </div>
  )
}
export default BookingTimer
