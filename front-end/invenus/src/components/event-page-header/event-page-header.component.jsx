import React from "react";

import "./event-page-header.style.scss"
import 'bootstrap/dist/css/bootstrap.css';

const EventPageHeader = ({event}) => {
    return (
        <div className="EventPageHeader container-lg">
            <div className="row">
                <div className="col-sm">
                    <h1 className = "EventPageHeaderTitle"> {event.title} </h1>
                    <h2 className = "EventPageHeaderDateAndTime"> {event.date}, {event.startTime}</h2>
                </div>
                <div className="col-sm eventPageHeaderButtons">
                    <button className='event-page-header-button event-page-header-share'>Share</button>
                    <button className='event-page-header-button'>Join</button>
                </div>
            </div>
        </div>
    );
}

export default EventPageHeader;
