import baseUrl from './Api'

export const login = async (userData) => {
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(userData),
    // mode: 'no-cors'
  }
  const response = await fetch(
    `${baseUrl}/authenticate`,
    //     {
    //   mode: 'no-cors'
    // },
    requestOptions
  )
  const data = await response.json()

  console.log(data, 'APII LOGINNN')
  if (data.status !== 200) {
    const errorMessage = data.message
      ? data.message
      : 'Lamentablemente no ha podido iniciar sesión. Por favor intente más tarde.'
    throw new Error(errorMessage)
  }
  return data
}

export const register = async (userData) => {
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(userData),
  }
  const response = await fetch(`${baseUrl}/usuarios`, requestOptions)
  const data = await response.json()

  console.log(data, 'APII USERS')
  if (data.status !== 201) {
    throw new Error(
      'Lamentablemente no ha podido registrarse. Por favor intente más tarde.'
    )
  }
  return data
}
