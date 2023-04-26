import React from 'react'
import DatePicker, { registerLocale, setDefaultLocale } from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import es from 'date-fns/locale/es'

export default function Calendar({ startDate, endDate, setDateRange }) {
  registerLocale('es', es)
  setDefaultLocale('es')

  return (
    <div className="calendar">
      <DatePicker
        placeholderText=" Check in - Check out"
        isInputWithCalendar={true}
        className="inputBanner"
        selectsRange={true}
        startDate={startDate}
        endDate={endDate}
        onChange={(update) => {
          setDateRange(update)
        }}
        minDate={new Date()}
        locale="es"
        monthsShown={2}
        dateFormat="yyyy/M/d"
        changeMonth
      />
    </div>
  )
}
