import React, { useState, useEffect, useContext } from 'react'
import ProductCard from './ProductCard'
import '../Styles/ProductList.css'
import {
  getProducts,
  getProductsByCityId,
  getProductsByFilters,
  getProductsByCategoryId,
} from '../services/Api'
import UserContext from '../context/UserContext.js'

const ProductList = ({ categoryId, cityId, startDate, endDate }) => {
  const [products, setProducts] = useState([])
  const { user } = useContext(UserContext)

  useEffect(() => {
    // console.log(
    //   'PRODUCT LIST',
    //   startDate,
    //   endDate,
    //   'CITY',
    //   cityId,
    //   'CATEGORY',
    //   categoryId
    // )

    if (cityId) {
      getProductsByCityId(cityId).then((data) => {
        setProducts(
          !user.log ? data.data.sort(() => Math.random() - 0.5) : data.data
        )
      })
    } else if (startDate && endDate) {
      const fechaInicio = new Date(startDate).toISOString().slice(0, 10)
      const fechaFinal = new Date(endDate).toISOString().slice(0, 10)
      const filters = {
        startDate: fechaInicio,
        endDate: fechaFinal,
      }
      getProductsByFilters(filters).then((data) => {
        setProducts(
          !user.log ? data.data.sort(() => Math.random() - 0.5) : data.data
        )
      })
    } else {
      getProducts().then((data) => {
        setProducts(
          !user.log ? data.data.sort(() => Math.random() - 0.5) : data.data
        )
      })
    }
  }, [cityId, startDate, endDate, user])

  useEffect(() => {
    if (categoryId) {
      getProductsByCategoryId(categoryId).then((data) => {
        setProducts(data.data)
      })
    }
  }, [categoryId])

  return (
    <div className="container-list-recomendaciones">
      <h2>Recomendaciones</h2>
      <div id="list" className="list">
        {products.map((product) => {
          return <ProductCard {...product} key={product.id}></ProductCard>
        })}
      </div>
    </div>
  )
}

export default ProductList
