import React from 'react'
import '../Styles/ProductCard.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHeart } from '@fortawesome/free-solid-svg-icons'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'

const ProductCard = ({
  id,
  urlImagenPrincipal,
  categoria,
  titulo,
  ubicacion,
  descripcion,
}) => {
  return (
    <div id="product-card" className="card">
      <div className="product-image">
        <div className="imagen">
          {/*<div className="favorite">
            <FontAwesomeIcon icon={faHeart} />
          </div>*/}
          <img
            className="product-img"
            src={urlImagenPrincipal}
            alt="producto"
          />
        </div>
      </div>

      <div className="product-details">
        <div className="header-description">
          <div className="name">
            <span className="category-product">{categoria.titulo}</span>
            <span className="name-product">{titulo}</span>
          </div>
          <div className="calification">
            <div className="calification-number">8</div>

            <span>Muy bueno</span>
          </div>
        </div>
        <div className="description-container">
          <p className="location-product">
            <FontAwesomeIcon icon={faLocationDot} /> {ubicacion}{' '}
            <a
              href="https://www.w3schools.com"
              target="_blank"
              rel="noopener noreferrer"
            >
              MOSTRAR EN EL MAPA
            </a>
          </p>

          <div className="description-product">{descripcion}</div>
        </div>
        <Link to={`/product/${id}`}>
          <button className="button3">Ver mas</button>
        </Link>
      </div>
    </div>
  )
}

export default ProductCard
