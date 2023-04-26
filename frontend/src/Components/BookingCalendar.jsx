import React from 'react'
import DatePicker, { registerLocale, setDefaultLocale } from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import es from 'date-fns/locale/es'
import '../Styles/BookingCalendar.css'

const BookingCalendar = ({ startDate, endDate, setDateRange }) => {
  registerLocale('es', es)
  setDefaultLocale('es')
  return (
    <div className="booking-calendar">
      <h2>Seleccioná tu fecha de reserva</h2>
      <div className="calendar">
        <div className="desk-calendar">
          <DatePicker
            className="product-calendar"
            selectsRange={true}
            startDate={startDate}
            endDate={endDate}
            onChange={(update) => {
              setDateRange(update)
            }}
            minDate={new Date()}
            locale="es"
            monthsShown={2}
            dateFormat="yyyy/M/d"
            changeMonth
            fixedHeight
            inline
          />
        </div>
        <div className="mobile-calendar">
          <DatePicker
            className="mobile-calendar"
            selectsRange={true}
            startDate={startDate}
            endDate={endDate}
            onChange={(update) => {
              setDateRange(update)
            }}
            minDate={new Date()}
            locale="es"
            monthsShown={1}
            dateFormat="yyyy/M/d"
            changeMonth
            inline
          />
        </div>
      </div>
    </div>
  )
}
export default BookingCalendar
