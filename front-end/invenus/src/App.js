import React from "react";
import { Routes, Route } from "react-router-dom";

import HomePage from "./pages/home-page/home-page.component";
import EventPage from "./pages/event-page/event-page.component";

import './App.css';

const App = () => {
  return (
    <div>
        <Routes>
            <Route path='/' element={<HomePage />}/>
            <Route path='/event' element={<EventPage />}/>
        </Routes>
    </div>
  );
}

export default App;
