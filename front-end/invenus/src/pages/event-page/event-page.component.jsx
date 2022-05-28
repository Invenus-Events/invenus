import React from "react";

import EventHeader from '../../components/event-page-header/event-page-header.component.jsx';
import EventPageInformationCard from "../../components/event-page-information-card.component/event-page-information-card.component";

const EventPage = () => {
    const eventExample = {
        genre : "house",
        club : "Enter the Dragon",
        date : "Saturday, 15th August",
        startTime : "10 PM",
        title: "House at 089 Bar"
    }

    return (
    <div>
        <div className="">
            <EventHeader event={eventExample}></EventHeader>
            <EventPageInformationCard title = "What's happening"></EventPageInformationCard>
        </div>
    </div>
    )
}

export default EventPage;
