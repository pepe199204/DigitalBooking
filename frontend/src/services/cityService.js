import baseUrl from './Api'

const getCities = async () => {
  const response = await fetch(`${baseUrl}/ciudades`)
  const data = await response.json()
  //   if (data.status !== 200) {
  //     throw new Error("Error al obtener la información, intente más tarde.");
  //   }
  return data
}

export default getCities
