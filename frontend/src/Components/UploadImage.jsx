import React from 'react'
import { useState } from 'react'
import '../Styles/UploadImage.css'

export const UploadImage = ({ setImagesUploaded }) => {
  const [urlImagen, setUrlImagen] = useState([])
  const [arrayUrlImagen, setArrayUrlImagen] = useState([])
  const [base, setBase] = useState()
  const getBase64 = (file) => {
    return new Promise((resolve) => {
      let fileInfo
      let baseURL = ''
      // Make new FileReader
      let reader = new FileReader()

      // Convert the file to base64 text
      reader.readAsDataURL(file)

      // on reader load somthing...
      reader.onload = () => {
        // Make a fileInfo Object
        // console.log("Called", reader);
        baseURL = reader.result
        // console.log(baseURL);
        resolve(baseURL)
      }
      // console.log(fileInfo);
    })
  }
  const changeInput = (e) => {
    let indexImg

    if (arrayUrlImagen.length > 0) {
      indexImg = arrayUrlImagen[arrayUrlImagen.length - 1].index + 1
    } else {
      indexImg = 0
    }

    let newImgsToState = readmultifiles(e, indexImg)
    let newImgsState = [...arrayUrlImagen, ...newImgsToState]
    setArrayUrlImagen(newImgsState)

    console.log(newImgsState)
    setImagesUploaded(newImgsState)
  }

  function readmultifiles(e, indexInicial) {
    const files = e.currentTarget.files

    //el array con las imagenes nuevas
    const arrayImages = []

    Object.keys(files).forEach((i) => {
      const file = files[i]

      getBase64(file)
        .then((result) => {
          file['base64'] = result
          setBase(result)
          // console.log("File Is", file);
        })
        .catch((err) => {
          console.log(err)
        })

      //console.log(file);
      arrayImages.push({
        index: indexInicial,
        name: file.name,
        file,
      })
      indexInicial++
    })
    return arrayImages
  }
  const handleRemoveImagen = (urlImg) => {
    const newUrlsImagen = arrayUrlImagen.filter((img) => img.name !== urlImg)
    console.log(newUrlsImagen)
    setArrayUrlImagen(newUrlsImagen)
  }

  return (
    <div className="uploader-main-cointainer">
      <h2 className="cargar-imagenes">Cargar Imágenes</h2>
      {arrayUrlImagen.map((img) => (
        <div className="uploader-container" key={img.index}>
          <div className="upload-image">
            <input
              key={img.index}
              type="text"
              placeholder={img.name}
              readOnly
            />
            <label className="btn btn-warning">
              <input
                key={img.index}
                type="file"
                name="img"
                accept="image/*"
                hidden
              />
            </label>
            <span
              onClick={(e) => handleRemoveImagen(img.name)}
              id="remove-button"
            >
              {' '}
              X{' '}
            </span>
          </div>
        </div>
      ))}

      <div className="uploader-container">
        <div className="upload-image">
          <input type="text" placeholder="insertar https://" readOnly />
          <label className="btn btn-warning">
            <span> + </span>
            <input
              value={urlImagen}
              type="file"
              name="img"
              hidden
              onChange={changeInput}
            />
          </label>
        </div>
      </div>
    </div>
  )
}
