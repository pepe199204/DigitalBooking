import React from 'react'
import Categorias from './Categorias'
import '../Styles/ListaCategorias.css'

export default function ListaCategorias({ setCategoryId }) {
  return (
    <div className="listaCat-conteiner">
      <h2>Buscar por tipo de alojamiento</h2>
      <Categorias setCategoryId={setCategoryId} />
    </div>
  )
}
