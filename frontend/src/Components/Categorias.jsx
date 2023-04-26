import React, { useState, useEffect } from 'react'
import getCategories from '../services/categoryService'
import { getProducts } from '../services/Api'
import '../Styles/Categorias.css'

export default function Categorias({ setCategoryId }) {
  const [categories, setCategories] = useState([])
  const [products, setProducts] = useState([])

  useEffect(() => {
    getCategories().then((data) => {
      setCategories(data.data)
    })
  }, [])

  useEffect(() => {
    getProducts().then((data) => {
      setProducts(data.data)
    })
  }, [])

  const countProductsByCategoryId = (categoryId) => {
    const productFiltered = products.filter(
      (product) => product.categoria.id === categoryId
    )
    // console.log("dataCategoriaFiltrada: ", productFiltered); // ver PORQUE REPITE TANTAS VECES? PORQUE RENDERIZA TANTO?
    return productFiltered.length
  }

  return (
    <div className="container">
      {categories.map((category) => {
        return (
          <div
            className="categoria-container"
            key={category.id}
            onClick={(e) => {
              setCategoryId(category.id)
            }}
          >
            <img
              src={category.url_imagen}
              alt={category.titulo}
              id={category.id}
            />
            <div className="categoria-description">
              <h4>{category.titulo}</h4>
              <p>
                {countProductsByCategoryId(category.id)} {category.titulo}
              </p>
            </div>
          </div>
        )
      })}
    </div>
  )
}
