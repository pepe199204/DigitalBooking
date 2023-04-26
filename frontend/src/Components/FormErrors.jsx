import React from 'react'
import '../Styles/Account.css'

export const FormErrors = ({ formErrors }) => (
  <div className="error-messages">
    {Object.keys(formErrors).map((fieldName, i) => {
      if (formErrors[fieldName].length > 0) {
        return <p key={i}> * {formErrors[fieldName]} </p>
      }
    })}
  </div>
)
