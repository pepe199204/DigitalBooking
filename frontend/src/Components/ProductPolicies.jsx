import React, { useState, useEffect } from 'react'
import '../Styles/ProductPolicies.css'

export default function ProductPolicies({ formData, setFormData }) {
  const policy = {
    title: 'Normals de la casa',
  }

  return (
    <div className="policies">
      <h2>Políticas del producto</h2>
      <div className="policies-container">
        <div className="policy-container">
          <p className="policy-title">Normas de la casa</p>
          <label htmlFor="policy"> Descripción</label>
          <textarea
            name="policy"
            className="input-form"
            placeholder="Escribir aquí"
            value={formData.house_rules}
            onChange={(e) =>
              setFormData({ ...formData, house_rules: e.target.value })
            }
            required
          ></textarea>
        </div>

        <div className="policy-container">
          <p className="policy-title">Salud y seguridad</p>
          <label htmlFor="policy"> Descripción</label>
          <textarea
            name="policy"
            className="input-form"
            placeholder="Escribir aquí"
            value={formData.security}
            onChange={(e) =>
              setFormData({ ...formData, security: e.target.value })
            }
            required
          ></textarea>
        </div>

        <div className="policy-container">
          <p className="policy-title">Política de cancelación</p>
          <label htmlFor="policy"> Descripción</label>
          <textarea
            name="policy"
            className="input-form"
            placeholder="Escribir aquí"
            value={formData.cancellation}
            onChange={(e) =>
              setFormData({ ...formData, cancellation: e.target.value })
            }
            required
          ></textarea>
        </div>
      </div>
    </div>
  )
}
