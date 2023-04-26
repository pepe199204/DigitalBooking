const baseUrl = 'http://ec2-18-191-223-136.us-east-2.compute.amazonaws.com:8080'
// const baseUrl = 'http://localhost:8080'
export default baseUrl

export const getProductById = async (id) => {
  const response = await fetch(`${baseUrl}/productos/${id}/`)
  // console.log(response, "api product");
  const data = await response.json()
  return data
}

export const getProducts = async () => {
  const response = await fetch(
    `${baseUrl}/productos/listAll`
    //  {
    //   mode: 'no-cors'
    // }
  )
  const data = await response.json()
  return data
}

export const createProduct = async (productData, userToken) => {
  const requestOptions = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${userToken}`,
    },
    body: JSON.stringify(productData),
  }
  const response = await fetch(`${baseUrl}/productos/create`, requestOptions)
  const data = await response.json()

  console.log(data, 'APII PRODUCT CREATE')
  if (data.status !== 200) {
    const errorMessage = data.message
      ? data.message
      : 'Ocurrió un error inesperado al crear el product. Por favor intente más tarde.'
    throw new Error(errorMessage)
  }
  return data
}

export const getProductsByCityId = async (cityId) => {
  const response = await fetch(
    `${baseUrl}/productos/ProductoByCiudad/${cityId}`
  )
  const data = await response.json()
  return data
}

export const getProductsByCategoryId = async (categoryId) => {
  const response = await fetch(
    `${baseUrl}/productos/ProductoByCategoria/${categoryId}`
  )
  const data = await response.json()
  return data
}

export const getCaractById = async (prodId) => {
  const response = await fetch(`${baseUrl}/productos/Caracteristicas/${prodId}`)
  const data = await response.json()
  return data
}

export const getLocationById = async (locId) => {
  const response = await fetch(`${baseUrl}/ciudades/${locId}`)
  const data = await response.json()
  return data
}

export const getProductsByFilters = async (filters) => {
  const response = await fetch(
    // `${baseUrl}/productos/productosFiltersTest?` + new URLSearchParams(filters)
    `${baseUrl}/productos/ProductoByFechas/${filters.startDate}/${filters.endDate}`
  )
  const data = await response.json()
  return data
}

export const getProvinciaById = async (provId) => {
  const response = await fetch(`${baseUrl}/provincias/${provId}`)
  // console.log(response, "api product");
  const data = await response.json()
  return data
}

export const publicarReserva = async (value) => {
  try {
    const response = await fetch(`${baseUrl}/reservas/newBooking`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(value),
    })
    if (response.ok) {
      const result = await response.json()
      console.log(result)
    }
  } catch (e) {
    console.log(e)
  }
}

export const publicarCaract = async (value) => {
  try {
    const response = await fetch(
      `${baseUrl}/caracteristicas/NewCaracteristicas`,
      {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(value),
      }
    )
    if (response.ok) {
      const result = await response.json()
      console.log(result)
    }
  } catch (e) {
    console.log(e)
  }
}

export const getImagesByProductId = async (productId) => {
  const response = await fetch(`${baseUrl}/imagenes/producto/${productId}`)
  // console.log(response, "api product");
  const data = await response.json()
  return data
}
