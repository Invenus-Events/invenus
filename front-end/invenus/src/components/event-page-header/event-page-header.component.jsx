import React from "react";

const EventPageHeader = ({event}) => {
    return (
        <div>
            <div>
                <h1> {event.title} </h1>
                <h2> {event.date}, {event.startTime}</h2>
            </div>
            <div>
                <button>Share</button>
                <button>Join</button>
            </div>
        </div>
    );
}

export default EventPageHeader;
