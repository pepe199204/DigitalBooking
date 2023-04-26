import baseUrl from './Api'

export const getCharacteristics = async () => {
  const response = await fetch(`${baseUrl}/caracteristicas`)
  const data = await response.json()
  //   if (data.status !== 200) {
  //     throw new Error("Error al obtener la información, intente más tarde.");
  //   }
  return data
}

export const createCharacteristicForProduct = async (
  characteristicId,
  productId
) => {
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      productoId: productId,
      caracteristicaId: characteristicId,
    }),
    // mode: 'no-cors'
  }
  const response = await fetch(
    `${baseUrl}/caracteristicas_producto/addCaracteristicaProducto`,
    requestOptions
  )
  const data = await response.json()

  console.log(data, 'APII CARACTERISTICAS')
  if (data.status !== 200) {
    const errorMessage = data.message
      ? data.message
      : 'Ocurrió un error inesperado al asociar la caracteristica. Por favor intente más tarde.'
    throw new Error(errorMessage)
  }
  return data
}
