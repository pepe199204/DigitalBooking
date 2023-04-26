import React from 'react'
import '../Styles/ProductoPolitics.css'

const ProductPolitics = () => {
  return (
    <div className="politicas">
      <h2>Qué tenés que saber </h2>
      <hr className="linea-producto" />
      <div className="rules">
        <div className="div-rules">
          <h3>Normas de la casa</h3>
          <ul>
            <li>Check-out: 10:00 </li>
            <li>No se permiten fiestas</li>
            <li>No fumar</li>
          </ul>
        </div>
        <div className="div-rules">
          <h3>Salud y seguridad</h3>
          <ul>
            <li>
              Se aplican las pautas del distanciamiento social y otras normas
              relacionadas con el coronavirus
            </li>
            <li>Detector de humo</li>
            <li>Deposito de Seguridad</li>
          </ul>
        </div>
        <div className="div-rules">
          <h3>Política de cancelación</h3>
          <ul>
            <li>
              Agregá las fechas de tu viaje para obtener los detalles de
              cancelación de tu estatdia{' '}
            </li>
          </ul>
        </div>
      </div>
    </div>
  )
}
export default ProductPolitics
