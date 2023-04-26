import React from 'react'
import { useState } from 'react'
import '../Styles/SetProductPolitics.css'
export default function SetProductPolitics({ formData, setFormData }) {
  const [politics, setPolitics] = useState({
    house_rules: '',
    security: '',
    cancellation: '',
  })

  return (
    <div>
      <h2 className="politics-title">Políticas del producto</h2>
      <div className="Politics-creation">
        <div className="Normas-creation">
          <h3>Normas de la casa</h3>
          <label className="politics" htmlFor="rules">
            Descripción
          </label>
          <textarea
            id="product-normas"
            name="product-normas"
            className="product-normas"
            value={politics.house_rules}
            onChange={(e) => {
              setPolitics({ ...politics, house_rules: e.target.value })
              setFormData({ ...formData, policies: politics })
            }}
            required
          />
        </div>
        <div className="SyS-creation">
          <h3>Salud y Seguridad</h3>
          <label className="politics" htmlFor="security">
            Descripción
          </label>
          <textarea
            id="product-SyS"
            name="product-SyS"
            className="product-SyS"
            value={politics.security}
            onChange={(e) => {
              setPolitics({ ...politics, security: e.target.value })
              setFormData({ ...formData, policies: politics })
            }}
            required
          />
        </div>
        <div className="cancel-creation">
          <h3>Política de cancelación</h3>
          <label className="politics" htmlFor="cancelation">
            Descripción
          </label>
          <textarea
            id="product-cancel"
            name="product-cancel"
            className="product-cancel"
            value={politics.cancellation}
            onChange={(e) => {
              setPolitics({ ...politics, cancellation: e.target.value })
              setFormData({ ...formData, policies: politics })
            }}
            required
          />
        </div>
      </div>
    </div>
  )
}
