import React from "react";
import { Link } from 'react-router-dom';
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi';

import logoImage from '../../assets/user.png'
import './styles.css';

export default function Books(){
  return (
    <div className="book-container">
      <header>
        <img src={logoImage} alt="User logo"/>
        <span>Welcome, <strong>Igor</strong>!</span>
        <Link className="button" to="/book/new">Add new Book</Link>
        <button type="button">
          <FiPower size={18} color="#251FC5" />
        </button>
      </header>
      
      <h1>Registered Books</h1>
      <ul>
        <li>
          <strong>Title:</strong>
          <p>Docker Deep Dive</p>
          <strong>Author:</strong>
          <p>Nigel Poulton</p>
          <strong>Price:</strong>
          <p>R$ 47,90</p>
          <strong>Release Date:</strong>
          <p>12/07/2020</p>
          
          <button type="button">
            <FiEdit size={20} color="#251FC50"/>
          </button>
          
          <button type="button">
            <FiTrash2 size={20} color="#251FC50"/>
          </button>
        </li>
        <li>
          <strong>Title:</strong>
          <p>Docker Deep Dive</p>
          <strong>Author:</strong>
          <p>Nigel Poulton</p>
          <strong>Price:</strong>
          <p>R$ 47,90</p>
          <strong>Release Date:</strong>
          <p>12/07/2020</p>
          
          <button type="button">
            <FiEdit size={20} color="#251FC50"/>
          </button>
          
          <button type="button">
            <FiTrash2 size={20} color="#251FC50"/>
          </button>
        </li>
        <li>
          <strong>Title:</strong>
          <p>Docker Deep Dive</p>
          <strong>Author:</strong>
          <p>Nigel Poulton</p>
          <strong>Price:</strong>
          <p>R$ 47,90</p>
          <strong>Release Date:</strong>
          <p>12/07/2020</p>
          
          <button type="button">
            <FiEdit size={20} color="#251FC50"/>
          </button>
          
          <button type="button">
            <FiTrash2 size={20} color="#251FC50"/>
          </button>
        </li>
      </ul>

    </div>
  )
}