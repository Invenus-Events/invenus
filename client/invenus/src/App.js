import React from "react";
import { Routes, Route } from "react-router-dom";

import HomePage from "./pages/home-page/home-page.component";
import EventPage from "./pages/event-page/event-page.component";
import PaymentPage from "./pages/payment-page/payment-page.component"
import PaymentMethodPage from "./pages/payment-method/payment-method.component"

import './App.css';

const App = () => {
  return (
    <div>
        <Routes>
            <Route path='/' element={<HomePage />}/>
            <Route path='/event/:id' element={<EventPage />}/>
            <Route path='/payment' element={<PaymentPage />}/>
            <Route path='/payment-method' element={<PaymentMethodPage />}/>
        </Routes>
    </div>
  );
}

export default App;
