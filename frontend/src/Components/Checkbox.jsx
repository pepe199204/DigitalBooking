import React from 'react'
import '../Styles/Checkbox.scss'

const Checkbox = ({ id, name, checked, onChange, small, disabled, index }) => {
  return (
    <div className={'toggle-switch' + (small ? ' small-switch' : '')}>
      <input
        type="checkbox"
        name={name}
        className="toggle-switch-checkbox"
        id={id}
        checked={checked}
        // onChange={e => onChange(e.target.checked)}
        onChange={() => onChange(index)}
        disabled={disabled}
      />
      {id ? (
        <label className="toggle-switch-label" htmlFor={id}>
          <span
            className={
              disabled
                ? 'toggle-switch-inner toggle-switch-disabled'
                : 'toggle-switch-inner'
            }
            //   data-yes={optionLabels[0]}
            //   data-no={optionLabels[1]}
          />
          <span
            className={
              disabled
                ? 'toggle-switch-switch toggle-switch-disabled'
                : 'toggle-switch-switch'
            }
          />
        </label>
      ) : null}
    </div>
  )
}

export default Checkbox
