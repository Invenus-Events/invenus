import React from "react";
import { Routes, Route } from "react-router-dom";

import HomePage from "./pages/home-page/home-page.component";
import EventsPage from "./pages/events-page/events-page.component";

import './App.css';

const App = () => {
  return (
    <div>
      <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/events' element={<EventsPage />} />
      </Routes>
    </div>
  );
}

export default App;
