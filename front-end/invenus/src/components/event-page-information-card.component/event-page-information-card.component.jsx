import React from "react";

// import './event-page-header.style.scss';

const EventPageInformationCard = ({title}) => {
    return (
        <div className = "event-page-header-container">
            <h1> {title} </h1>
        </div>
    );
}

export default EventPageInformationCard;
