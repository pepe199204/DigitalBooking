import React, { useContext, useEffect } from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import Account from '../Components/Account'
import UserContext from '../context/UserContext'

const Signin = () => {
  const { validateUser } = useContext(UserContext)
  useEffect(() => {
    validateUser(true)
  })
  return (
    <div className="Signin">
      <Header />
      <Account />
      <Footer />
    </div>
  )
}
export default Signin
