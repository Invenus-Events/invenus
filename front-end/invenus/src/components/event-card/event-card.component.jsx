import React from 'react';
import './event-card.styles.scss';

const EventCard = (props) => {
  return (
    <div>
      <h1 className='event-card-title'>{props.title}</h1>
      <img className='event-card-image' src={props.imageUrl} alt=""/>
      <p className='event-card-description'>{props.description}</p>
      <button className='event-card-learn-more-button'>Learn more</button>
    </div>
  );
}

export default EventCard;
