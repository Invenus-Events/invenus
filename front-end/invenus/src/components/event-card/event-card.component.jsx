import './event-card.styles.scss';

const EventCard = (props) => {
  return (
    <div>
      <h1>{props.title}</h1>
      <p>{props.description}</p>
    </div>
  );
}

export default EventCard;
