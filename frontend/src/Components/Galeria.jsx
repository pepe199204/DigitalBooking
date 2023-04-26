import React, { useState, useEffect } from 'react'
import ImageGallery from 'react-image-gallery'
import images from '../assets/imagenes.json'
import { getImagesByProductId } from '../services/Api'
import '../Styles/Galeria.css'

const Galeria = ({ id, urlImagenPrincipal }) => {
  const [stateGallery, setStateGallery] = useState(false)
  const [imagesOfProduct, setImages] = useState([])
  const listaimg = [
    {
      original: urlImagenPrincipal,
      thumbnail: urlImagenPrincipal,
      OriginalHeight: 1000,
      OriginalWidth: 600,
      thumbnailHeight: 80,
      thumbnailWidth: 180,
    },
    ...images,
  ]

  useEffect(() => {
    getImagesByProductId(id).then((data) => {
      setImages(data.data)
    })
  }, [])

  const handleGallery = () => {
    setStateGallery(stateGallery ? false : true)
    showGallery()
  }

  const showGallery = () => {
    if (!stateGallery) {
      console.log('show true')
      document.getElementById('galeria-menu').style.display = 'block'
    } else {
      console.log('show false')
      document.getElementById('galeria-menu').style.display = 'none'
    }
  }
  const getImages = () => {
    // console.log("IMGENES DE BASE ", imagesOfProduct, imagesOfProduct.length)
    if (imagesOfProduct.length || imagesOfProduct.length < 4) {
      let imagenes = imagesOfProduct.map((img) => (
        <img key={img.id} src={img.url_imagen} alt="img" id="id" />
      ))
      const limit = 4 - imagesOfProduct.length
      for (let index = 1; index <= limit; index++) {
        imagenes.push(
          <img
            key={index + 1}
            src={listaimg[index].original}
            alt="img"
            id="id"
          />
        )
      }
      return imagenes
    } else {
      return (
        <>
          <img src={listaimg[1].original} alt="img" id="id" />
          <img src={listaimg[2].original} alt="img" id="id" />
          <img src={listaimg[3].original} alt="img" id="id" />
          <img src={listaimg[4].original} alt="img" id="id" />
        </>
      )
    }
  }

  return (
    <div className="galeria-conteiner">
      <div className="galeria-gral">
        <div className="images-left">
          <img
            className="product-img"
            src={urlImagenPrincipal}
            alt="img-main"
          />
        </div>
        <div className="images-right">{getImages()}</div>
      </div>
      <div className="ver-mas">
        <span
          id="galeria-mas"
          className="galeria-mas"
          onClick={() => handleGallery()}
        >
          {' '}
          Ver más
        </span>
      </div>
      <div id="galeria-menu" className="galeria-menu">
        <ImageGallery items={listaimg} className="desktop-gallery" />
        <span
          id="galeria-mas-gallery"
          className="galeria-mas-gallery"
          onClick={() => handleGallery()}
        >
          {' '}
          X
        </span>
      </div>
      <div className="mobile-gallery">
        <ImageGallery
          items={listaimg}
          showPlayButton="false"
          autoPlay="true"
          showIndex="true"
        />
      </div>
    </div>
  )
}
export default Galeria
