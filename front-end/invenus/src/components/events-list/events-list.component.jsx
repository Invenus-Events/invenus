import React from "react";
import { InView } from 'react-intersection-observer';

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";

class EventsList extends React.Component {

    render() {
        return (
            <div className='events-list-container'>
                <div className='events-list-content'>
                    <h1>Upcoming events.</h1>
                    <input className='events-list-search-field' type="text" placeholder="Search..."/>
                    <div className='events-list-event-listing'>
                        {
                            this.props.events.map((event, index) => {
                                return (
                                    <InView key={index} as="div" onChange={(inView, entry) => {
                                        if (entry.isIntersecting) {
                                            this.props.getEventInView(index)
                                        }
                                    }}>
                                        <EventCard title={event.title} imageUrl={event.imageUrl} description={event.description}/>
                                    </InView>
                                )
                            })
                        }
                    </div>
                </div>
            </div>
        )
    }

}

export default EventsList;
