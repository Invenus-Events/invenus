import React, {useEffect, useState} from "react";
import axios from "axios";

import "./event-page-header.style.scss"
import 'bootstrap/dist/css/bootstrap.css';

const EventPageHeader = ({event}) => {

    const [res, setRes] = useState(null);
    const [error, setError] = useState('');

    const fetchData = () => {
        axios
            .post("https://api.invenus.club/checkout", {
                products: [
                    {
                        ticketId: event.ticketId,
                        amount: 1
                    }
                ]
            })
            .then(res => {
                window.location.href = res.data.checkoutUrl;
            })
            .catch(err => setError(err))
    }

    return (
        <div className="EventPageHeader">
            <div className="row">
                <div className="col-sm">
                    <h1 className="EventPageHeaderTitle-Main-title"> {event.title} </h1>
                    <h2 className="EventPageHeaderDateAndTime"> {new Date(event.timeFrame.from).toLocaleString()}</h2>
                </div>
                <div className="col-sm eventPageHeaderButtons">
                    {/*<button className='event-page-header-button event-page-header-share'>Share</button>*/}
                    {/*<button className='event-page-header-button'>Join</button>*/}
                    <button onClick={fetchData} className='event-page-header-button event-page-header-share'>Buy</button>
                </div>
                <img src={event.imageUrl} className="event-banner"></img>
            </div>
        </div>
    );
}

export default EventPageHeader;
