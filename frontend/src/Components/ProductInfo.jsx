import React, { useState, useEffect } from 'react'
import getCategories from '../services/categoryService'
import getCities from '../services/cityService'
import Dropdown from '../Components/Dropdown'

export default function ProductInfo({ formData, setFormData }) {
  const [categories, setCategories] = useState([])
  const [cities, setCities] = useState([])

  useEffect(() => {
    getCategories().then((data) => {
      setCategories(
        data.data.map((item) => {
          return {
            value: item.id,
            label: item.titulo,
          }
        })
      )
    })

    getCities().then((data) => {
      setCities(
        data.data.map((item) => {
          return {
            value: item.id,
            label: item.nombre,
            subLabel: item.provincia.nombre,
          }
        })
      )
    })
  }, [])

  return (
    <div className="form-name">
      <div className="product-gral-info">
        <div className="name">
          <label className="product-attribute" htmlFor="productName">
            Nombre de la propiedad
          </label>
          <input
            type="text"
            id="productName"
            name="productName"
            value={formData.name}
            onChange={(e) => setFormData({ ...formData, name: e.target.value })}
            required
          />
        </div>

        <div className="name">
          <label className="product-attribute" htmlFor="productCategory">
            Categoría
          </label>
          <Dropdown
            placeHolder="Hotel"
            options={categories}
            onChange={(value) =>
              setFormData({ ...formData, category: value.value })
            }
          />
        </div>
      </div>

      <div className="product-gral-info">
        <div className="name">
          <label className="product-attribute" htmlFor="productAddress">
            Dirección
          </label>
          <input
            type="text"
            id="productAddress"
            name="productAddress"
            value={formData.address}
            onChange={(e) =>
              setFormData({ ...formData, address: e.target.value })
            }
            required
          />
        </div>

        <div className="name">
          <label className="product-attribute" htmlFor="productCity">
            Ciudad
          </label>
          <Dropdown
            isSearchable
            placeHolder="Ciudad"
            options={cities}
            onChange={(value) =>
              setFormData({ ...formData, city: value.value })
            }
          />
        </div>
      </div>

      <div className="product-gral-info">
        <div className="name">
          <label className="product-attribute" htmlFor="productAddress">
            Latitud
          </label>
          <input
            type="text"
            id="productAddress"
            name="productAddress"
            value={formData.latitude}
            onChange={(e) =>
              setFormData({ ...formData, latitude: e.target.value })
            }
            required
          />
        </div>

        <div className="name">
          <label className="product-attribute" htmlFor="productCity">
            Longitud
          </label>
          <input
            type="text"
            id="productCity"
            name="productCity"
            value={formData.longitude}
            onChange={(e) =>
              setFormData({ ...formData, longitude: e.target.value })
            }
            required
          />
        </div>
      </div>

      <div className="description">
        <label className="product-attribute" htmlFor="productDescription">
          Descripción
        </label>
        <textarea
          id="productDescription"
          name="productDescription"
          className="product-description"
          placeholder="Escribir aquí"
          value={formData.description}
          onChange={(e) =>
            setFormData({ ...formData, description: e.target.value })
          }
          required
        ></textarea>
      </div>
    </div>
  )
}
