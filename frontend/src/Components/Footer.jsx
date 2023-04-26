import React from 'react'
import '../Styles/Footer.css'
export default function Footer() {
  return (
    <footer>
      <h3>©2023 Digital Booking</h3>
      <div className="icons-container">
        <a href="https://www.facebook.com/">
          {' '}
          <img
            src={require(`../Images/Icon/facebook-logo.png`)}
            alt="facebook-logo-footer"
          />{' '}
        </a>
        <a href="https://www.linkedin.com">
          <img
            src={require(`../Images/Icon/linkedIn-logo.png`)}
            alt="linkedIn-logo-footer"
          />
        </a>
        <a href="https://www.twitter.com">
          {' '}
          <img
            src={require(`../Images/Icon/twitter-logo.png`)}
            alt="twitter-logo-footer"
          />
        </a>
        <a href="https://www.instagram.com">
          <img
            src={require(`../Images/Icon/instagram-logo.png`)}
            alt="instagram-logo-footer"
          />
        </a>
      </div>
    </footer>
  )
}
