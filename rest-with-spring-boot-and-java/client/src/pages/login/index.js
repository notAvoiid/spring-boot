import React from "react";
import './styles.css';

import padlock from '../../assets/padlock.png'

export default function Lgoin(){
  return (
    <div className="logint-container">
      <section className="form">
        <form>
          <h1>Access your Account</h1>
          <input placeholder="Username"/>
          <input type= "password" placeholder="Password"/>

          <button type="submit">Login</button>
        </form>
      </section>

      <img src={padlock} alt="Login"/>
      
    </div>
  );
}