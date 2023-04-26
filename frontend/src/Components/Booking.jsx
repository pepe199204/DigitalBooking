import React, { useEffect, useState } from 'react'
import ProductTitle from './ProductTitle'
import { useParams } from 'react-router-dom'
import { getProductById } from '../services/Api'
import BookingForm from './BookingForm'
import BookingCalendar from './BookingCalendar'
import BookingSummary from './BookingSummary'
import '../Styles/Booking.css'
import BookingTimer from './BookingTimer'

const Booking = () => {
  const { id } = useParams()
  const [product, setProduct] = useState({})
  const [errorMessage, setErrorMessage] = useState('')
  const [dateRange, setDateRange] = useState([null, null])
  const [startDate, endDate] = dateRange
  useEffect(() => {
    if (id) {
      getProductById(id).then((data) => {
        setProduct(data.data)
      })
    }
  }, [])

  const handleError = () => {
    setErrorMessage('')
  }
  return (
    <div className="booking-page">
      <ProductTitle {...product} />
      {errorMessage && (
        <div className="error-login">
          <img
            src={require(`../Images/Caracter-icons/error-alert.png`)}
            style={{ marginLeft: 10 }}
            alt="error"
          />
          <p className="error-login-message">{errorMessage} </p>
          <span onClick={handleError} className="error-close">X</span>
        </div>
      )}
      <div className="booking-info">
        <div className="booking-info-left">
          <h2>Completá tus datos</h2>
          <BookingForm />
          <BookingCalendar
            dateRange={dateRange}
            setDateRange={setDateRange}
            startDate={startDate}
            endDate={endDate}
          />
          <BookingTimer />
        </div>
        <div className="booking-info-right">
          <BookingSummary
            {...product}
            startDate={startDate}
            endDate={endDate}
            errorMessage={errorMessage}
            setErrorMessage={setErrorMessage}
          />
        </div>
      </div>
    </div>
  )
}

export default Booking
