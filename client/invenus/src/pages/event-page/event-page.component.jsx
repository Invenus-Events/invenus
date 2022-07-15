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

    const yelp = [
        {
            image: "data:image/jpeg;base64,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",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        },
        {
            image: "https://p19-sign.tiktokcdn-us.com/tos-useast5-avt-0068-tx/6a64ef014f156f85203c5e89fb2a196a~c5_720x720.jpeg?x-expires=1658037600&x-signature=5dSjYrJ2Ke0SXnmReXCnORdAK7g%3D",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        }
    ]

    const google = [
        {
            image: "https://i.pinimg.com/736x/dd/58/e8/dd58e81dfbd196bd84eb7c04add690dd.jpg",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        },
        {
            image: "https://p16-amd-va.tiktokcdn.com/tos-maliva-avt-0068/f7a7ea73a2d1a223641b6ac17bcbfc77~c5_720x720.jpeg?x-expires=1647010400&x-signature=UTRv5adQoCHffDHVU8dC4rGr9JI%3D",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        }
    ]

    const tripAdvisor = [
        {
            image: "https://www.famousbirthdays.com/faces/antalek-courtney-image.jpg",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        },
        {
            image: "https://m.media-amazon.com/images/I/81hxTtOsu+L._SS500_.jpg",
            author: "Behsad Riemer",
            time: "Saturday, 28th, 2016",
            rating: 3.0,
            description: "Best burger I tried in this kind of restaurants. Nice flavour, nice texture. Best fries I ever tried too. And the Milk Shake? It's like paradise. I had to buy another one when I finished because it was too good."
        }
    ]

    const reviews = {
        google: google,
        yelp: yelp,
        tripAdvisor: tripAdvisor
    }

    //event-page-container-increase
    return (
        <div>
            <div className="event-page-container-increase container d-flex justify-content-center">
                {res ? (
                    <div>
                        <EventHeader event={res}></EventHeader>
                        <EventDescriptionCardComponent event={res}></EventDescriptionCardComponent>
                        <EventClubInformationCardComponent event={res}></EventClubInformationCardComponent>
                        <EventReviewCard eventReviews={reviews}></EventReviewCard>
                        <EventLocationCardComponent event={res}></EventLocationCardComponent>
                        {/*<EventPageInformationCard title = {`EventId ${id}`}></EventPageInformationCard>*/}
                    </div>
                ) : null}
            </div>
        </div>
    )
}

export default EventPage;