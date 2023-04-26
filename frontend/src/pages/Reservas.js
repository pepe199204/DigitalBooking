import React from 'react'
import Booking from '../Components/Booking'
import Footer from '../Components/Footer'
import Header from '../Components/Header'
import ProductPolitics from '../Components/ProductPolitics'

function Reservas() {
  return (
    <div className="product-booking">
      <Header />
      <Booking />
      <ProductPolitics />
      <Footer />
    </div>
  )
}

export default Reservas
