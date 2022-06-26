import { useEffect, useState } from "react";
import axios from 'axios';
import { useParams } from "react-router-dom";

import EventHeader from '../../components/event-page-header/event-page-header.component.jsx';
import EventDescriptionCardComponent from "../../components/event-description-card/event-description-card.component";
import EventMediaCardComponent from "../../components/event-media-card/event-media-card.component";
import EventClubInformationCardComponent from "../../components/event-club-information-card/event-club-information-card.component";
import EventLocationCardComponent from "../../components/event-location-card/event-location-card.component";
import EventPageInformationCard from "../../components/event-page-information-card.component/event-page-information-card.component";

const EventPage = () => {

    const { id } = useParams();

    const [res, setRes] = useState(null);
    const [error, setError] = useState('');

    const fetchData = () => {
        axios
            .get(`https://api.invenus.club/event/${ id }`)
            .then((res) => {
                console.log(res)
                setRes(res.data);
            })
            .catch((err) => setError(err))
    }

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div>
            <div>
                { res ? (
                    <div>
                        <EventHeader event={res}></EventHeader>
                        <EventDescriptionCardComponent event = {res}></EventDescriptionCardComponent>
                        <EventMediaCardComponent></EventMediaCardComponent>
                        <EventClubInformationCardComponent></EventClubInformationCardComponent>
                        <EventLocationCardComponent event = {res}></EventLocationCardComponent>
                        {/*<EventPageInformationCard title = {`EventId ${id}`}></EventPageInformationCard>*/}
                    </div>
                ): null}
            </div>
        </div>
    )
}

export default EventPage;