import {useEffect, useState} from "react";
import axios from 'axios';
import {useParams} from "react-router-dom";

import EventHeader from '../../components/event-page-header/event-page-header.component.jsx';
import EventDescriptionCardComponent from "../../components/event-description-card/event-description-card.component";
import EventClubInformationCardComponent
    from "../../components/event-club-information-card/event-club-information-card.component";
import EventLocationCardComponent from "../../components/event-location-card/event-location-card.component";
import './event-page-container-edit.css'
import EventPageInformationCard
    from "../../components/event-page-information-card.component/event-page-information-card.component";
import EventReviewCard from "../../components/event-review-card/event-review-card.component";
import Review from "../../components/event-review-card/Review.jsx";

const EventPage = () => {

    const {id} = useParams();

    const [res, setRes] = useState(null);
    const [error, setError] = useState('');

    const fetchData = () => {
        axios
            .get(`https://api.invenus.club/event/${id}`)
            .then((res) => {
                setRes(res.data);
            })
            .catch((err) => setError(err))
    }

    useEffect(() => {
        fetchData();
    });

    //event-page-container-increase
    return (
        <div>
            <div className="event-page-container-increase container d-flex justify-content-center">
                {res ? (
                    <div>
                        <EventHeader event={res}></EventHeader>
                        <EventDescriptionCardComponent event={res}></EventDescriptionCardComponent>
                        <EventClubInformationCardComponent event={res}></EventClubInformationCardComponent>
                        <EventReviewCard event={res}/>
                        <EventLocationCardComponent event={res}></EventLocationCardComponent>
                        {/*<EventPageInformationCard title = {`EventId ${id}`}></EventPageInformationCard>*/}
                    </div>
                ) : null}
            </div>
        </div>
    )
}

export default EventPage;