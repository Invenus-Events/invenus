import React from "react";
import { InView } from 'react-intersection-observer';

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";

class EventsList extends React.Component {

    constructor() {
        super();
        this.state = {
            isMobile: window.innerWidth < 992
        }
    }

    componentDidMount() {
        window.addEventListener('resize', () => {
            this.setState({
                isMobile: window.innerWidth < 992
            }, null);
        })
    }

    render() {
        return (
            <div className='events-list-container'>
                <div className='events-list-content'>
                    <h1>Upcoming events.</h1>
                    <div className="filter-accordion accordion">
                        <div className="accordion-item">
                            <h2 className="accordion-header" id="headingOne">
                                <button className="events-list-sort-button accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Sort and filter
                                </button>
                            </h2>
                            <div id="collapseOne" className="accordion-collapse collapse"
                                 aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                <div className="accordion-body">
                                    <strong>This is the first item's accordion body.</strong> It is shown by default,
                                    until the collapse plugin adds the appropriate classes that we use to style each
                                    element. These classes control the overall appearance, as well as the showing and
                                    hiding via CSS transitions. You can modify any of this with custom CSS or overriding
                                    our default variables. It's also worth noting that just about any HTML can go within
                                    the <code>.accordion-body</code>, though the transition does limit overflow.
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={`events-list-event-listing ${this.state.isMobile ? null : 'scroll-snap'}`}>
                        {
                            this.props.events.map((event, index) => {
                                return (
                                    <InView threshold={this.state.isMobile ? null: 0.75} key={index} as="div" onChange={(inView, entry) => {
                                        if (entry.isIntersecting && inView) {
                                            this.props.getEventInView(index)
                                        }
                                    }}>
                                        <EventCard event={event}/>
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
