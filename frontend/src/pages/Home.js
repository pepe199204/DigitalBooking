import React, { useEffect, useState, useContext } from 'react'
import Header from '../Components/Header'
import Navegador from '../Components/Navegador'
import ListaCategorias from '../Components/ListaCategorias'
import Footer from '../Components/Footer'
import ProductList from '../Components/ProductList'
import UserContext from '../context/UserContext'

const Home = () => {
  const [categoryIdForFilter, setCategoryIdForFilter] = useState()
  const [cityIdSelected, setCityIdSelected] = useState()
  const [cityIdForFilter, setCityIdForFilter] = useState()
  const { validateUser } = useContext(UserContext)
  const [dateRange, setDateRange] = useState([null, null])
  const [startDate, endDate] = dateRange

  const [dateRangeSelected, setDateRangeSelected] = useState([null, null])
  const [startDateSelected, endDateSelected] = dateRangeSelected

  const filterByCategoryId = (categoryId) => {
    setCategoryIdForFilter(categoryId)
  }

  const setCityId = () => {
    console.log('CLICK', cityIdSelected)
    setCityIdForFilter(cityIdSelected)
    setDateRangeSelected(dateRange)
  }
  useEffect(() => {
    validateUser(true)
  })

  return (
    <div className="Home">
      <Header />
      <Navegador
        onChange={setCityIdSelected}
        onClick={setCityId}
        startDate={startDate}
        endDate={endDate}
        setDateRange={setDateRange}
      />
      <ListaCategorias setCategoryId={filterByCategoryId} />
      <ProductList
        categoryId={categoryIdForFilter}
        cityId={cityIdForFilter}
        startDate={startDateSelected}
        endDate={endDateSelected}
      />
      <Footer />
    </div>
  )
}
export default Home
