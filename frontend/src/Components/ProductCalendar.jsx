import React, { useState } from 'react'
import DatePicker, { registerLocale, setDefaultLocale } from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import es from 'date-fns/locale/es'
import '../Styles/ProductCalendar.css'
import { useNavigate } from 'react-router-dom'
import { useContext } from 'react'
import UserContext from '../context/UserContext'

const ProductCalendar = (product) => {
  const [dateRange, setDateRange] = useState([null, null])
  const [startDate, endDate] = dateRange
  const { user, validateUser } = useContext(UserContext)
  const navigate = useNavigate()

  const onSubmit = () => {
    {
      if (user.log) {
        navigate(`/product/${product.id}/reservas`)
        validateUser(true)
      } else {
        navigate(`/login`)
        validateUser(false)
      }
    }
  }

  registerLocale('es', es)
  setDefaultLocale('es')
  return (
    <div className="titulo-calendar">
      <h2>Fechas disponibles</h2>
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
        <div className="texto-fechas">
          <span>Agregá tus fechas de viaje para obtener precios exactos</span>
          <button type="submit" onClick={onSubmit} className="button3">
            {' '}
            Iniciar Reserva
          </button>
        </div>
      </div>
    </div>
  )
}
export default ProductCalendar
