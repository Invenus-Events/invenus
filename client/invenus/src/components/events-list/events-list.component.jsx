import React, { useRef } from "react";
import { InView } from 'react-intersection-observer';

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';


class EventsList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            filterMessage: "Filter by: ...",
            loadingLocation: false,
            userLocationLongitude: null,
            userLocationLatitude: null,
            filter: "date-newest",
            prevFilter: null,
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

    notifyLocationError = () => toast.error("We need access to your location.", {
        position: "top-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: false,
        draggable: false,
        progress: undefined,

    });

    getLocation(callback) {
        if (!this.state.userLocationLatitude || !this.state.userLocationLongitude) {
            this.setState({loadingLocation: true}, () => {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition((position) => {
                        this.setState({
                            loadingLocation: false,
                            userLocationLongitude: position.coords.longitude,
                            userLocationLatitude: position.coords.latitude
                        }, () => {
                            callback();
                        })
                    }, () => {
                        this.notifyLocationError();
                        setTimeout(() => {
                            this.setState({loadingLocation: false, filter: this.state.prevFilter})
                        }, 500)
                        console.log("Unable to access user's location.")
                    });
                } else {
                    console.log("Unable to access user's location.")
                }
            })
        } else {
            callback();
        }
    }

    selectChanged = (e) => {
        this.setState((prevState) => {
            return { filter: e.target.value, prevFilter: prevState.filter}
        }, () => {
            this.sortEvents()
        })
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
                    this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
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
                    this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
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
                    this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
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
                    this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
                    this.eventCardsContainerRef.current.scrollTo(0, 0);
                })
                break;
            case "distance-closest":
                this.getLocation(() => {
                    this.setState({
                        events: this.props.events.sort((a, b) => {
                            const distanceFromA = Math.sqrt(Math.pow(this.state.userLocationLongitude - a.location.longitude, 2) + Math.pow(this.state.userLocationLatitude - a.location.latitude, 2));
                            const distanceFromB = Math.sqrt(Math.pow(this.state.userLocationLongitude - b.location.longitude, 2) + Math.pow(this.state.userLocationLatitude - b.location.latitude, 2));
                            return distanceFromA - distanceFromB;
                        })
                    }, () => {
                        this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
                        this.props.updateSortedEvents(this.state.events);
                    })
                })
                this.eventCardsContainerRef.current.scrollTo(0, 0);
                break;
            case "distance-furthest":
                this.getLocation(() => {
                    this.setState({
                        events: this.props.events.sort((a, b) => {
                            const distanceFromA = Math.sqrt(Math.pow(this.state.userLocationLongitude - a.location.longitude, 2) + Math.pow(this.state.userLocationLatitude - a.location.latitude, 2));
                            const distanceFromB = Math.sqrt(Math.pow(this.state.userLocationLongitude - b.location.longitude, 2) + Math.pow(this.state.userLocationLatitude - b.location.latitude, 2));
                            return distanceFromB - distanceFromA;
                        })
                    }, () => {
                        this.props.eventUpdateObservers.forEach(observer => observer(this.state.events))
                        this.props.updateSortedEvents(this.state.events);
                    })
                });
                this.eventCardsContainerRef.current.scrollTo(0, 0);
                break;
        }
    }

    render() {
        if (this.state.loadingLocation) {
            return (
                <div className='events-list-loading-container'>
                    <div className='events-list-content'>
                        <h1>Upcoming events.</h1>
                        <input className='events-list-search-field' type="text" placeholder={this.state.filterMessage}/>
                        <div className={`events-list-event-listing ${this.state.isMobile ? null : 'scroll-snap'}`}>
                            <div className='event-card-container'>
                                <h1 className='placeholder-glow'>
                                    <span className="placeholder col-12"></span>
                                </h1>
                                <p className='placeholder-glow'>
                                    <span className="placeholder col-6"></span>
                                </p>
                                <div className="container">
                                    <div className="row">
                                        <div className="col-md placeholder-glow">
                                            <p className='event-card-organizer'>
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-asterisk bootstrap-icon"
                                                     viewBox="0 0 16 16">
                                                    <path
                                                        d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1z"/>
                                                </svg>
                                            </p>
                                            <span className="placeholder col-8"></span>
                                        </div>
                                        <div className="col-md placeholder-glow">
                                            <p className='event-card-club'>
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                     className="bi bi-geo-alt-fill bootstrap-icon" viewBox="0 0 16 16">
                                                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                                                </svg>
                                            </p>
                                            <span className="placeholder col-8"></span>
                                        </div>
                                        <div className="col-md placeholder-glow">
                                            <p className='event-card-price'>
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                     className="bi bi-ticket-perforated-fill bootstrap-icon" viewBox="0 0 16 16">
                                                    <path
                                                        d="M0 4.5A1.5 1.5 0 0 1 1.5 3h13A1.5 1.5 0 0 1 16 4.5V6a.5.5 0 0 1-.5.5 1.5 1.5 0 0 0 0 3 .5.5 0 0 1 .5.5v1.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 11.5V10a.5.5 0 0 1 .5-.5 1.5 1.5 0 1 0 0-3A.5.5 0 0 1 0 6V4.5Zm4-1v1h1v-1H4Zm1 3v-1H4v1h1Zm7 0v-1h-1v1h1Zm-1-2h1v-1h-1v1Zm-6 3H4v1h1v-1Zm7 1v-1h-1v1h1Zm-7 1H4v1h1v-1Zm7 1v-1h-1v1h1Zm-8 1v1h1v-1H4Zm7 1h1v-1h-1v1Z"/>
                                                </svg>
                                            </p>
                                            <span className="placeholder col-8"></span>
                                        </div>
                                    </div>
                                </div>
                                <div className='event-list-loading-image-placeholder'></div>
                                <p className='placeholder-glow'>
                                    <span className="placeholder col-7"></span>
                                    <span className="placeholder col-4"></span>
                                    <span className="placeholder col-4"></span>
                                    <span className="placeholder col-6"></span>
                                    <span className="placeholder col-8"></span>
                                </p>
                                <button className='event-list-loading-learn-more-button'>Learn More</button>
                            </div>
                        </div>
                    </div>
                </div>
            )
        } else {
            return (
                <div className='events-list-container'>
                    <div className='events-list-content'>
                        <h1>Upcoming events.</h1>
                        <form action="">
                            <select value={this.state.filter} name="filter-setting" className='events-list-filter-button' onChange={this.selectChanged}>
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

}

export default EventsList;
