import React, { useEffect, useState } from 'react'
import Checkbox from './Checkbox'
import { getCharacteristics } from '../services/characteristicService'
import '../Styles/ProductCharacteristic.css'
import { publicarCaract } from '../services/Api'

const Icon = () => {
  return (
    <svg height="20" width="20" viewBox="0 0 20 20">
      <path
        d="M4.516 7.548c0.436-0.446 1.043-0.481 1.576 0l3.908 3.747 3.908-3.747c0.533-0.481 1.141-0.446 1.574 0 0.436 0.445 0.408 1.197 0 1.615-0.406 0.418-4.695 4.502-4.695 4.502-0.217 0.223-0.502 0.335-0.787 0.335s-0.57-0.112-0.789-0.335c0 0-4.287-4.084-4.695-4.502s-0.436-1.17 0-1.615z"
        fill="#1DBEB4"
      ></path>
    </svg>
  )
}

export default function ProductCharacteristics({
  actualizarCaract,
  setElegidos,
  checkedState,
}) {
  const [characteristics, setCharacteristics] = useState([])
  const [newCarac, setNewCarac] = useState({
    data: {
      id: null,
      nombre: '',
      url_icono: null,
    },
  })

  useEffect(() => {
    getCharacteristics().then((data) => {
      setCharacteristics(data.data)
      let carac = data.data.map((item) => {
        return {
          id: item.id,
          checked: false,
          nombre: item.nombre,
        }
      })
      // setCheckedState(new Array(data.data.length).fill(false));
      setElegidos(carac)
    })
  }, [])

  const chargeData = () => {
    publicarCaract(newCarac)
    getCharacteristics().then((data) => {
      setCharacteristics(data.data)
      let carac = data.data.map((item) => {
        return {
          id: item.id,
          checked: false,
          nombre: item.nombre,
        }
      })
      // setCheckedState(new Array(data.data.length).fill(false));

      setElegidos(carac)
    })
  }

  return (
    <div className="facilities">
      <h2>Agregar atributos</h2>
      <div className="characteristics-container">
        {characteristics.map((characteristic, index) => {
          // console.log("AAAAAAAAAA --", checkedState[index],  "INDEXXX", index);
          return (
            <div className="characteristic" key={characteristic.id}>
              <p>
                {' '}
                {characteristic.url_icono && (
                  <img
                    src={require(`../Images/Caracter-icons/${characteristic.url_icono}.png`)}
                    alt={`caract ${characteristic.id}`}
                  />
                )}
                {!characteristic.url_icono && <Icon />} {characteristic.nombre}{' '}
              </p>
              <div>
                <Checkbox
                  //  label={label}
                  //  value={value}
                  //  onChange={onChange}
                  //  key={characteristic.id}
                  key={`custom-checkbox-${characteristic.id}`}
                  //  id={characteristic.id}
                  //  checked={ newsletter }
                  //  onChange={ onNewsletterChange }

                  id={characteristic.id}
                  index={index}
                  name={characteristic.nombre}
                  value={characteristic.nombre}
                  //  checked={checkedState[index]}
                  checked={checkedState[index].checked}
                  //  onChange={() => handleOnChange(index)}
                  //  onChange={handleOnChange}
                  onChange={actualizarCaract}
                />
              </div>
            </div>
          )
        })}
                <div className="new-caract-create">
        <div className="new-caract-create-name">
          <label>Nombre</label>
          <input
            type="text"
            className="new-caract-name"
            onChange={(e) =>
              setNewCarac({ ...newCarac, nombre: e.target.value })
            }
          ></input>
        </div>
        <div className="new-caract-create-icon">
          <label>Ícono</label>
          <input
            type="text"
            className="new-caract-icon"
            onChange={(e) =>
              setNewCarac({ ...newCarac, url_icono: e.target.value })
            }
          ></input>
        </div>
        <span className="agregar-atributos" onClick={chargeData}>
          {' '}
          +{' '}
        </span>
        </div>
      </div>
    </div>
  )
}
