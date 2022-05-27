import React from "react";

import './event-page-header.style.scss';
import 'bootstrap/dist/css/bootstrap.min.css';

const EventPageHeader = ({event}) => {
    return (
        <div className = "rootContainer">
            <div className = "titles">
                <h1 id = "title"> {event.title} </h1>
                <h2 id = "eventDetails"> {event.date}, {event.startTime}</h2>
            </div>
            <div className = "buttons">
                <button type="button" className="btn btn-outline-warning btn-sm rounded-pill">Share</button>
                <button type="button" className="btn btn-primary btn-sm">Join</button>
            </div>
        </div>
    );
}

export default EventPageHeader;
