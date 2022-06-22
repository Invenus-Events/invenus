import React from "react";

import './events-list-loading-styles.scss';
import EventCard from "../event-card/event-card.component";
import {InView} from "react-intersection-observer";
import {Link} from "react-router-dom";

class EventsListLoading extends React.Component {

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
            <div className='events-list-loading-container'>
                <div className='events-list-content'>
                    <h1>Upcoming events.</h1>
                    <input className='events-list-search-field' type="text" placeholder="Search..."/>
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
    }

}

export default EventsListLoading;
