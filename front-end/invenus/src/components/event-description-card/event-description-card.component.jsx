import React from "react";

import './event-description-card.style.scss';

const EventDescriptionCard = ({event}) => {
    return (
        <div className = "EventDescriptionCard container-lg">
            <h4> What's Happening </h4>
            <div>
                <p1> {event.description} </p1>
            </div>
        </div>
    );
}

export default EventDescriptionCard;
