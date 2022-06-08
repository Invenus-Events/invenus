import React from "react";

import { useParams } from "react-router-dom";

import EventHeader from '../../components/event-page-header/event-page-header.component.jsx';
import EventDescriptionCardComponent from "../../components/event-description-card/event-description-card.component";
import EventMediaCardComponent from "../../components/event-media-card/event-media-card.component";
import EventClubInformationCardComponent from "../../components/event-club-information-card/event-club-information-card.component";
import EventLocationCardComponent from "../../components/event-location-card/event-location-card.component";
// import EventPageInformationCard from "../../components/event-page-information-card.component/event-page-information-card.component";

const EventPage = () => {

    const { id } = useParams();

    const eventExample = {
        genre : "Techno",
        club : "Blitz",
        date : "Saturday, 15th August",
        startTime : "10 PM",
        title: "Techno Tuesday",
        description: "This is an event that is going to take place at Blitz",
        address: "Prinzregentenstraße 1\n" + "80538 München",
        lat: "48.1445",
        lng: "11.5853"
    }

    return (
    <div>
        <div>
            <EventHeader event={eventExample}></EventHeader>
            <EventDescriptionCardComponent event = {eventExample}></EventDescriptionCardComponent>
            <EventMediaCardComponent></EventMediaCardComponent>
            <EventClubInformationCardComponent></EventClubInformationCardComponent>
            <EventLocationCardComponent event={eventExample}></EventLocationCardComponent>
            {/*<EventPageInformationCard title = {`EventId ${id}`}></EventPageInformationCard>*/}
        </div>
    </div>
    )
}

export default EventPage;
