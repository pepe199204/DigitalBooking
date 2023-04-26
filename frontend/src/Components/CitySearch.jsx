import React, { useState, useEffect } from 'react'
import '../Styles/CitySearch.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import getCities from '../services/cityService'
import Dropdown from '../Components/Dropdown'

const CitySearch = ({ setCityId }) => {
  const [cities, setCities] = useState([])

  useEffect(() => {
    getCities().then((data) => {
      setCities(
        data.data.map((item) => {
          return {
            value: item.id,
            label: item.nombre,
            subLabel: item.provincia.pais.nombre,
          }
        })
      )
    })
  }, [])

  return (
    <div className="city">
      <Dropdown
        placeHolder="¿A dónde vamos?"
        placeHolderIcon= {<FontAwesomeIcon icon={faLocationDot} />}
        options={cities}
        includeIcon="true"
        onChange={(value) =>
          setCityId(value.value)
        }
      />
    </div>
  )
}
export default CitySearch
