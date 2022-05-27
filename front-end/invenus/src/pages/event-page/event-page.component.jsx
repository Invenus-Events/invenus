import React from "react";

import EventHeader from '../../components/event-page-header/event-page-header.component.jsx';

const EventPage = () => {
    const eventExample = {
        genre : "house",
        club : "Pacha",
        date : "Saturday, 15th August",
        startTime : "10 PM",
        title: "House at Pacha"
    }

    return (
    <div>
        <EventHeader event={eventExample}></EventHeader>

    </div>
    )
}

export default EventPage;
