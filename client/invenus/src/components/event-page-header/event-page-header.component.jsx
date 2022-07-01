import React from "react";

import "./event-page-header.style.scss"
import 'bootstrap/dist/css/bootstrap.css';

const EventPageHeader = ({event}) => {
    return (
        <div className="EventPageHeader">
            <div className="row">
                <div className="col-sm">
                    <h1 className="EventPageHeaderTitle-Main-title"> {event.title} </h1>
                    <h2 className="EventPageHeaderDateAndTime"> {new Date(event.timeFrame.from).toLocaleString()}</h2>
                </div>
                <div className="col-sm eventPageHeaderButtons">
                    <button className='event-page-header-button event-page-header-share'>Share</button>
                    <button className='event-page-header-button'>Join</button>
                    <button className='event-page-header-button event-page-header-share'>Buy</button>
                </div>
                <img src={event.imageUrl} className="event-banner"></img>
            </div>
        </div>
    );
}

export default EventPageHeader;
