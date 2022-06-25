import React from "react";
import { InView } from 'react-intersection-observer';

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";

class EventsList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            events: props.events,
            isMobile: window.innerWidth < 992,
            prev: null
        }
    }

    componentDidMount() {
        window.addEventListener('resize', () => {
            this.setState({
                isMobile: window.innerWidth < 992
            }, null);
        })
    }

    selectChanged = (e) => {
        this.setState({ filter: e.target.value }, () => {
            this.sortEvents()
        });
    }

    sortEvents = () => {
        switch (this.state.filter) {
            case "price-highest":
                this.setState({
                    events : this.props.events.sort(function (a, b) {
                        return b.price - a.price
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                });
                break;
            case "price-lowest":
                this.setState({
                    events: this.props.events.sort(function (a, b) {
                        return a.price - b.price
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                })
                break;
        }

        this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))

    }

    render() {
        return (
            <div className='events-list-container'>
                <div className='events-list-content'>
                    <h1>Upcoming events.</h1>
                    <form action="">
                        <select name="filter-setting" className='events-list-filter-button' onChange={this.selectChanged}>
                            <option value="date-newest">
                                Filter by: Date (Newest first)
                            </option>
                            <option value="date-lowest">
                                Filter by: Date (Oldest first)
                            </option>
                            <option value="rating-highest">
                                Filter by: Rating (Most popular first)
                            </option>
                            <option value="rating-lowest">
                                Filter by: Rating (Least popular first)
                            </option>
                            <option value="price-highest">
                                Filter by: Price (Highest first)
                            </option>
                            <option value="price-lowest">
                                Filter by: Price (Lowest first)
                            </option>
                            <option value="distance-closest">
                                Filter by: Distance (Closest first)
                            </option>
                            <option value="distance-furthest">
                                Filter by: Distance (Furthest first)
                            </option>
                        </select>
                    </form>
                    <div className={`events-list-event-listing ${this.state.isMobile ? null : 'scroll-snap'}`}>
                        {
                            this.state.events.map((event, index) => {
                                return (
                                    <InView threshold={this.state.isMobile ? null: 0.75} key={index} as="div" onChange={(inView, entry) => {
                                        if (entry.isIntersecting && inView) {
                                            this.props.getEventInView(index);
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
