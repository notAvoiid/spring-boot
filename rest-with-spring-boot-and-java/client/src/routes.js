import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import Login from './pages/login'
import Book from './pages/book'

export default function AppRoutes() {

  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" exact element={<Login />}/>
          <Route path="/book" exact element={<Book />}/>
        </Routes>
      </BrowserRouter>
  ) 

}