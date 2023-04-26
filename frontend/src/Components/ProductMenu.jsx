import React, { useEffect, useState } from 'react'
import Galeria from './Galeria'
import ProductTitle from './ProductTitle'
import { useParams } from 'react-router-dom'
import ProductDescription from './ProductDescription'
import ProductCalendar from './ProductCalendar'
import { getProductById } from '../services/Api'
import ProductCaracter from './ProductCaracter'
import ProductMap from './ProductMap'
import ProductPolitics from './ProductPolitics'
import '../Styles/ProductMenu.css'
import ProductLocation from './ProductLocation'

const ProductMenu = () => {
  const { id } = useParams()
  const [product, setProduct] = useState({})

  useEffect(() => {
    if (id) {
      getProductById(id).then((data) => {
        setProduct(data.data)
      })
    }
  }, [])

  return (
    <div className="product-menu">
      <ProductTitle {...product} />
      <ProductLocation id={id} {...product} />
      <Galeria id={id} {...product} />
      <ProductDescription id={id} {...product} />
      <ProductCaracter id={id} />
      <ProductCalendar id={id} {...product} />
      <ProductMap id={id} {...product} />
      <ProductPolitics {...product} />
    </div>
  )
}
export default ProductMenu
