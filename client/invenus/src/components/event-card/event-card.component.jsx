import React from 'react';
import { Link } from "react-router-dom";

import './event-card.styles.scss';

const EventCard = (props) => {
    const { event, userLocationLongitude, userLocationLatitude } = props;

    const getDistanceFromLatLonInKm = (lat1,lon1,lat2,lon2) => {
        const R = 6371; // Radius of the earth in km
        const dLat = deg2rad(lat2-lat1);
        const dLon = deg2rad(lon2-lon1);
        const a =
            Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
            Math.sin(dLon/2) * Math.sin(dLon/2)
        ;
        const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        const d = R * c; // Distance in km
        return d;
    }

    const deg2rad = (deg) => {
        return deg * (Math.PI/180)
    }

    const getDistance = () => {
        if (userLocationLongitude && userLocationLatitude) {
            const distance = getDistanceFromLatLonInKm(
                userLocationLatitude,
                userLocationLongitude,
                event.location.latitude,
                event.location.longitude
            )
            return Math.round(distance * 10) / 10;
        }
    }

    return (
    <div className='event-card-container'>
      <h1 className='event-card-title'>{event.title}</h1>
      <p className='event-card-date'>
          {new Date(event.timeFrame.from).toLocaleString()}
      </p>
        <div className="container">
            <div className=".no-gutters row">
                <div className="col-md-4">
                    <p className='event-card-organizer'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-asterisk bootstrap-icon"
                             viewBox="0 0 16 16">
                            <path
                                d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1z"/>
                        </svg>
                        {`Event by ${event.organizer}`}
                    </p>
                </div>
                <div className="col-md-5">
                    <p className='event-card-club'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-geo-alt-fill bootstrap-icon" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                        </svg>
                        {`At ${event.club.name}`} {getDistance() ? `(${getDistance()} km away)` : ""}
                    </p>
                </div>
                <div className="col-md-3">
                    <p className='event-card-price'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-ticket-perforated-fill bootstrap-icon" viewBox="0 0 16 16">
                            <path
                                d="M0 4.5A1.5 1.5 0 0 1 1.5 3h13A1.5 1.5 0 0 1 16 4.5V6a.5.5 0 0 1-.5.5 1.5 1.5 0 0 0 0 3 .5.5 0 0 1 .5.5v1.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 11.5V10a.5.5 0 0 1 .5-.5 1.5 1.5 0 1 0 0-3A.5.5 0 0 1 0 6V4.5Zm4-1v1h1v-1H4Zm1 3v-1H4v1h1Zm7 0v-1h-1v1h1Zm-1-2h1v-1h-1v1Zm-6 3H4v1h1v-1Zm7 1v-1h-1v1h1Zm-7 1H4v1h1v-1Zm7 1v-1h-1v1h1Zm-8 1v1h1v-1H4Zm7 1h1v-1h-1v1Z"/>
                        </svg>
                        {`${event.price} €`}
                    </p>
                </div>
            </div>
        </div>
        <img className='event-card-image' src={event.imageUrl} alt=""/>
        <p className='event-card-description'>{event.description}</p>
            <Link className='event-card-learn-more-link' to={`/event/${event.id}`}>
                <button className='event-card-learn-more-button'>Learn More</button>
            </Link>
    </div>
    );
}

export default EventCard;
