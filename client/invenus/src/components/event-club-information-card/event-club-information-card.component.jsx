import React from "react";

import "./event-club-information-card.styles.scss";

const ClubInformationCard = ({event}) => {
    return (
        <div className="EventDescriptionCard container-lg">
            <div className = "club-information-header">
               <h4 className = "EventPageHeaderTitle"> {event.club.name} </h4>
                <a href = {event.club.website} target = "_blank"> <button className = "club-visit-button"> Visit </button> </a>
            </div>
            <p> {event.club.description} </p>
            <p> Price Range: {event.club.priceRange} </p>
            <div className = "container-sm">

            </div>
            <p> Phone: {event.club.phoneNumber} </p>
            <p> Email: <a href = {"mailto:"+event.club.email}> {event.club.email} </a></p>
        </div>
    );
}

export default ClubInformationCard;
