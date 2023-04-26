import React from 'react'
import { useParams } from 'react-router-dom'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import ProductMenu from '../Components/ProductMenu'

function Producto() {
  const { id } = useParams()

  return (
    <div className="product-page">
      <Header />
      <ProductMenu {...id} />
      <Footer />
    </div>
  )
}
export default Producto
