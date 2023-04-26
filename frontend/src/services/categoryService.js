import baseUrl from './Api'

const getCategories = async () => {
  const response = await fetch(`${baseUrl}/categorias`)
  const data = await response.json()
  //   if (data.status !== 200) {
  //     throw new Error("Error al obtener la información, intente más tarde.");
  //   }
  return data
}

export default getCategories
