import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import { Product } from '../Components/Product'
import ProductTitle from '../Components/ProductTitle'

function Administration() {
  const info = {
    titulo: 'Administración',
    categoria: 'hotel',
  }

  return (
    <div className="Signin">
      <Header />
      <ProductTitle {...info} />
      <Product> </Product>
      <Footer />
    </div>
  )
}
export default Administration
