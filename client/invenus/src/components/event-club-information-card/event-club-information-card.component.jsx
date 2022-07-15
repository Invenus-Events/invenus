import React from "react";

import "./event-club-information-card.styles.scss";
import google from "../../resources/google.png";
import yelp from "../../resources/yelp.png";
import tripadvisor from"../../resources/tripadvisor.png";

const ClubInformationCard = ({event}) => {

    return (
        <div className="EventDescriptionCard">
            <div className = "club-information-header">
               <h4 className = "EventPageHeaderTitle"> {event.club.name} </h4>
                {/*<a href = {event.club.website} target = "_blank"> <button className = "club-visit-button"> Visit </button> </a>*/}
            </div>
            <p className = "event-club-information-card-description-align"> {event.club.description} </p>
            <div className="col-md-3">
                <p className='event-card-price-club-information'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         className="bi bi-clock bootstrap-icon" viewBox="0 0 16 16">
                        <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"/>
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"/>
                    </svg>
                    {`Duration: ${(new Date(event.timeFrame.to) - new Date(event.timeFrame.from))/3600000} hrs`}
                </p>
            </div>
            <div className="col-md-3">
                <p className='event-card-price-club-information'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         className="bi bi-tag bootstrap-icon" viewBox="0 0 16 16">
                        <path d="M6 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm-1 0a.5.5 0 1 0-1 0 .5.5 0 0 0 1 0z"/>
                        <path
                            d="M2 1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 1 6.586V2a1 1 0 0 1 1-1zm0 5.586 7 7L13.586 9l-7-7H2v4.586z"/>
                    </svg>
                    {event.club.priceRange}
                </p>
            </div>
            <div className="col-md-3">
                <p className='event-card-price-club-information'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         className="bi bi-telephone-fill bootstrap-icon" viewBox="0 0 16 16">
                        <path fillRule="evenodd"
                              d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                    </svg>
                    {event.club.phoneNumber}
                </p>
            </div>
            <div className="col">
                <p className='event-card-price-club-information'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         className="bi bi-envelope bootstrap-icon" viewBox="0 0 16 16">
                        <path
                            d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                    </svg>
                    <a href = {"mailto:"+event.club.email}> {event.club.email} </a>
                </p>
                <a href = {event.club.website} target = "_blank"> <button className = "club-visit-button"> Visit </button> </a>
            </div>
        </div>
    );
}

export default ClubInformationCard;
