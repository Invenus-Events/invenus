import React from "react";

import './event-description-card.style.scss';

const EventDescriptionCard = ({event}) => {
    return (
        <div className = "EventDescriptionCard container-lg">
            <h4 className = "EventPageHeaderTitle"> Details </h4>
            <div>
                <p> Price: {event.price} €</p>
                <p> Duration: {(new Date(event.timeFrame.to) - new Date(event.timeFrame.from))/3600000} hr</p>
                <p> Organizer: {event.organizer}</p>
                <p> {event.description} </p>
            </div>
        </div>
    );
}

export default EventDescriptionCard;
