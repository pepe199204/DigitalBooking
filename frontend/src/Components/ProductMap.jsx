import React, { useState, useEffect } from 'react'
import { getLocationById } from '../services/Api'
import '../Styles/ProductMap.css'
import { Loader } from '@googlemaps/js-api-loader'

const ProductMap = ({ ciudad, titulo }) => {
  const [locacion, setLocacion] = useState([])
  let map
  let marker
  // [START maps_programmatic_load_promise]
  const loader = new Loader({
    apiKey: 'AIzaSyAiYylXAYovmvUIWkVeQcDdUHonP97gCRE',
    version: 'weekly',
    libraries: ['places'],
  })

  const location = {
    lat: -34.604166937348126,
    lng: -58.39403391565249,
  }

  const mapOptions = {
    center: location,
    zoom: 14,
    fullscreenControl: false,
  }
  useEffect(() => {
    //console.log(id, "casita");
    if (ciudad) {
      getLocationById(ciudad.id).then((data) => {
        //console.log(data , "casaaaa");
        setLocacion(data.data)
      })
    }
  }, [ciudad])

  loader.load().then(() => {
    map = new window.google.maps.Map(document.getElementById('map'), mapOptions)
    marker = new window.google.maps.Marker({
      position: location,
      map,
      title: titulo,
    })
  })

  return (
    <div className="map">
      <h2>¿Dónde vas a estar? </h2>
      <hr className="linea-producto" />
      <p>{locacion.nombre}</p>
      <div id="map"></div>
    </div>
  )
}

export default ProductMap
