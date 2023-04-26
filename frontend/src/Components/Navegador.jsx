import React from 'react'
import '../Styles/Navegador.css'
import Calendar from './Calendar'
import CitySearch from './CitySearch'
import { Link, useLocation } from 'react-router-dom'

export default function Navegador({
  onChange,
  onClick,
  id,
  titulo,
  categoria,
  startDate,
  endDate,
  setDateRange,
}) {
  const location = useLocation()

  return (
    <div className="nav">
      {location.pathname !== `/product/${id}` && (
        <>
          <h1>Busca ofertas en hoteles, casas y mucho más</h1>
          <div className="input-nav">
            <CitySearch setCityId={onChange} />
            <Calendar
              startDate={startDate}
              endDate={endDate}
              setDateRange={setDateRange}
            />
            <button className="button4" onClick={onClick}>
              Buscar
            </button>
          </div>
        </>
      )}
      {titulo && (
        <div className="titulo-nav">
          <div className="titulo-data">
            <h3>{categoria.titulo}</h3>
            <h2>{titulo}</h2>
          </div>
          <div className="titulo-back">
            {location.pathname !== `/product/${id}/reservas` && (
              <Link to={'/'}>
                <img
                  src={require('../Images/path9429.png')}
                  className="back-icon"
                  alt="back"
                />
              </Link>
            )}
            {location.pathname !== `/product/${id}` && (
              <Link to={`/product/${id}`}>
                <img
                  src={require('../Images/path9429.png')}
                  className="back-icon"
                  alt="back"
                />
              </Link>
            )}
          </div>
        </div>
      )}
    </div>
  )
}
