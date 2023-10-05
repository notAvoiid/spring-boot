import React from "react";
import './styles.css';

import padlock from '../../assets/padlock.png'
import logoImage from '../../assets/user.png'

export default function Lgoin(){
  return (
    <div className="login-container">
      <section className="form">
        <img src={logoImage} alt="User logo"/>
        <form>
          <h1>Access your Account</h1>
          <input placeholder="Username"/>
          <input type= "password" placeholder="Password"/>

          <button className="button" type="submit">Login</button>
        </form>
      </section>

      <img src={padlock} alt="Login"/>
      
    </div>
  );
}