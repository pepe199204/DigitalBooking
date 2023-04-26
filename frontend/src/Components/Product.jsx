import React, { useState, useContext } from 'react'
import { useNavigate } from 'react-router-dom'
import UserContext from '../context/UserContext.js'
import ProductInfo from '../Components/ProductInfo'
import ProductCharacteristics from '../Components/ProductCharacteristics'
import ProductPolicies from '../Components/ProductPolicies'
import { createProduct } from '../services/Api'
import { createCharacteristicForProduct } from '../services/characteristicService'
import '../Styles/Product.css'
import SetProductPolitics from './SetProductPolitics'
import { UploadImage } from './UploadImage'

export const Product = () => {
  // const [checked, setChecked] = useState(false);

  // const handleChange = () => {
  //   setChecked(!checked);
  // };
  const { user, jwt } = useContext(UserContext)

  const navigate = useNavigate()
  const initialData = {
    name: '',
    category: '',
    address: '',
    city: '',
    latitude: '',
    longitude: '',
    description: '',
    // house_rules: '',
    // security: '',
    // cancellation: '',
    policies: {
      house_rules: '',
      security: '',
      cancellation: '',
    },
  }
  const [formData, setFormData] = useState(initialData)

  const [checked, setChecked] = useState([])

  const handleChange = (elegidos) => {
    setChecked(elegidos)
  }

  const [checkedState, setCheckedState] = useState([])

  const [imagesUploaded, setImagesUploaded] = useState([])
  const [errorMessage, setErrorMessage] = useState('')

  const handleOnChange = (position) => {
    const updatedCheckedState = checkedState.map((item, index) => {
      // console.log('DENTRO DE ON CHANGEE --', item)
      if (index === position) {
        item.checked = !item.checked
      }
      return item
    })

    setCheckedState(updatedCheckedState)

    console.log('ELEGIDOSS ---', updatedCheckedState)
  }

  const handleSubmit = async (event) => {
    event.preventDefault()

    console.error('FORMMM DATA --', formData)

    const facilitiesSelected = checkedState
      .filter((characteristic) => characteristic.checked === true)
      .map((characteristic) => {
        return { id: characteristic.id }
      })

    console.error('FEATURES ELEGIDAS', facilitiesSelected)

    const images = imagesUploaded.map((img) => {
      return {
        image: img.file.base64,
        name: img.name,
      }
    })
    // console.log('IMAGENES CARGADAS ----', images)

    try {
      const productCreated = await createProduct(
        {
          producto: {
            titulo: formData.name,
            categoria: {
              id: formData.category,
            },
            ciudad: {
              id: formData.city,
            },
            descripcion: formData.description,
            direccion: formData.address,
            latitud: formData.latitude,
            longitud: formData.longitude,
            cancelacion: formData.cancellation,
            normas_de_la_casa: formData.house_rules,
            seguridad: formData.security,
            ubicacion: 'A 800 m del centro',
            usuario: {
              id: user.id,
            },
          },
          imagenes: images,
          // caracteristicas: facilitiesSelected
        },
        jwt
      )

      try {
        facilitiesSelected.forEach(async (facility) => {
          await createCharacteristicForProduct(
            facility.id,
            productCreated.data.id
          )
        })
        navigate(`/administration/ok`)
      } catch (e) {
        setErrorMessage(e.message)
        setFormData(initialData)
      }
    } catch (e) {
      setErrorMessage(e.message)
      setFormData(initialData)
    }
  }

  const handleError = () => {
    setErrorMessage('')
  }

  return (
    <div className="product-create-container">
      {errorMessage && (
        <div className="error-login">
          <img
            src={require(`../Images/Caracter-icons/error-alert.png`)}
            style={{ marginLeft: 10 }}
            alt="error"
          />
          <p className="error-login-message">{errorMessage} </p>
          <span onClick={handleError}>X</span>
        </div>
      )}

      <h2 className="product-subtitle">Crear producto</h2>
      <div className="product-container">
        <form className="product-form" onSubmit={handleSubmit}>
          <ProductInfo formData={formData} setFormData={setFormData} />
          <ProductCharacteristics
            // label="My Value"
            // value={checked}
            // onChange={handleChange}
            actualizarCaract={handleOnChange}
            setElegidos={setCheckedState}
            checkedState={checkedState}
          />

          {/* <ProductPolicies formData={formData} setFormData={setFormData}>
            {' '}
          </ProductPolicies> */}

          <SetProductPolitics formData={formData} setFormData={setFormData} />
          <UploadImage setImagesUploaded={setImagesUploaded} />

          <input type="submit" value="Crear" className="create-button" />
        </form>
      </div>
    </div>
  )
}
