import React from 'react';
import { Link } from "react-router-dom";

import './event-card.styles.scss';

const EventCard = (props) => {
    const { event } = props;
    return (
    <div className='event-card-container'>
      <h1 className='event-card-title'>{event.title}</h1>
      <h4 className='event-card-price'>{`${event.price} €`}</h4>
      <p className='event-card-date'>{event.date}</p>
      <p className='event-card-organizer'>
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-asterisk bootstrap-icon"
               viewBox="0 0 16 16">
              <path
                  d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1z"/>
          </svg>
          {`Event by ${event.organizer}`}</p>
      <p className='event-card-club'>
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
               className="bi bi-geo-alt-fill bootstrap-icon" viewBox="0 0 16 16">
              <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
          </svg>
          {`At ${event.club}`}
      </p>
      <img className='event-card-image' src={event.imageUrl} alt=""/>
      <p className='event-card-description'>{event.description}</p>
        <Link className='event-card-learn-more-link' to={`/event/${event.id}`}>
            <button className='event-card-learn-more-button'>Learn More</button>
        </Link>
    </div>
    );
}

export default EventCard;
