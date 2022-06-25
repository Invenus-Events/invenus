import React, { useRef } from "react";
import { InView } from 'react-intersection-observer';

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";

class EventsList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            filter: "date-newest",
            events: props.events,
            isMobile: window.innerWidth < 992,
            prev: null
        }
        this.eventCardsContainerRef = React.createRef();
    }

    componentDidMount() {
        this.setState({
            events: this.props.events.sort(function (a, b) {
                return new Date(a.timeFrame.from) - new Date(b.timeFrame.from);
            })
        }, () => {
            this.props.updateSortedEvents(this.state.events);
        })

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
            case "date-closest":
                this.setState({
                    events: this.props.events.sort(function (a, b) {
                        return new Date(a.timeFrame.from) - new Date(b.timeFrame.from);
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                    this.eventCardsContainerRef.current.scrollTo(0, 0);
                })
                break;
            case "date-furthest":
                this.setState({
                    events: this.props.events.sort(function (a, b) {
                        return new Date(b.timeFrame.from) - new Date(a.timeFrame.from);
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                    this.eventCardsContainerRef.current.scrollTo(0, 0);
                })
                break;
            case "price-highest":
                this.setState({
                    events : this.props.events.sort(function (a, b) {
                        return b.price - a.price
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                    this.eventCardsContainerRef.current.scrollTo(0, 0);
                });
                break;
            case "price-lowest":
                this.setState({
                    events: this.props.events.sort(function (a, b) {
                        return a.price - b.price
                    })
                }, () => {
                    this.props.updateSortedEvents(this.state.events);
                    this.eventCardsContainerRef.current.scrollTo(0, 0);
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
                            <option value="date-closest">
                                Filter by: Date (Closest first)
                            </option>
                            <option value="date-furthest">
                                Filter by: Date (Furthest first)
                            </option>
                            {/*<option value="rating-highest">*/}
                            {/*    Filter by: Rating (Most popular first)*/}
                            {/*</option>*/}
                            {/*<option value="rating-lowest">*/}
                            {/*    Filter by: Rating (Least popular first)*/}
                            {/*</option>*/}
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
                    <div ref={this.eventCardsContainerRef} className={`events-list-event-listing ${this.state.isMobile ? null : 'scroll-snap'}`}>
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
