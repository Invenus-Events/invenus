import React from "react";

const eventDescriptionCard = ({event}) => {
    return (
        <div>
            <h3> What's Happening </h3>
            <div className="THIS WILL BE A CARD">
                <p1> {event.description} </p1>
            </div>
        </div>
    );
}

export default eventDescriptionCard;
