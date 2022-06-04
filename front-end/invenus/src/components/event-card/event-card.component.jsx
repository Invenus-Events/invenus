import React from 'react';
import { Link } from "react-router-dom";

import './event-card.styles.scss';

const EventCard = (props) => {
  return (
    <div>
      <h1 className='event-card-title'>{props.title}</h1>
      <img className='event-card-image' src={props.imageUrl} alt=""/>
      <p className='event-card-description'>{props.description}</p>
        <Link className='event-card-learn-more-link' to={`/event/${props.eventId}`}>
            <button className='event-card-learn-more-button'>Learn More</button>
        </Link>
    </div>
  );
}

export default EventCard;
