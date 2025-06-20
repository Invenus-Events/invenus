import React from "react";

import './event-description-card.style.scss';

const EventDescriptionCard = ({event}) => {
    return (
        <div className="EventDescriptionCard">
            <div className="EventDescriptionCard-style-row row">
                <h4 className="EventPageHeaderTitle"> Details </h4>
                <div>
                    <div className="col-sm">
                        <p className='event-card-organizer-description-card'>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 className="bi bi-ticket-perforated-fill bootstrap-icon" viewBox="0 0 16 16">
                                <path
                                    d="M0 4.5A1.5 1.5 0 0 1 1.5 3h13A1.5 1.5 0 0 1 16 4.5V6a.5.5 0 0 1-.5.5 1.5 1.5 0 0 0 0 3 .5.5 0 0 1 .5.5v1.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 11.5V10a.5.5 0 0 1 .5-.5 1.5 1.5 0 1 0 0-3A.5.5 0 0 1 0 6V4.5Zm4-1v1h1v-1H4Zm1 3v-1H4v1h1Zm7 0v-1h-1v1h1Zm-1-2h1v-1h-1v1Zm-6 3H4v1h1v-1Zm7 1v-1h-1v1h1Zm-7 1H4v1h1v-1Zm7 1v-1h-1v1h1Zm-8 1v1h1v-1H4Zm7 1h1v-1h-1v1Z"/>
                            </svg>
                            {`${event.price} €`}
                        </p>
                    </div>
                    <div className="col-sm">
                        <p className='event-card-organizer-description-card'>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 className="bi bi-clock bootstrap-icon" viewBox="0 0 16 16">
                                <path
                                    d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"/>
                                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"/>
                            </svg>
                            {`Duration: ${(new Date(event.timeFrame.to) - new Date(event.timeFrame.from)) / 3600000} hrs`}
                        </p>
                    </div>
                    <div className="col-sm">
                        <p className='event-card-organizer-description-card'>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 className="bi bi-asterisk bootstrap-icon"
                                 viewBox="0 0 16 16">
                                <path
                                    d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1z"/>
                            </svg>
                            {`Event by ${event.organizer}`}
                        </p>
                    </div>
                    <p> {event.description} </p>
                </div>
            </div>
        </div>
    );
}

export default EventDescriptionCard;
