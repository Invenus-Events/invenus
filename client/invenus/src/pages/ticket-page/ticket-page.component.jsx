import React, { useEffect } from 'react';
import { useParams } from "react-router-dom";
import QRCodeSVG from "qrcode.react";
import backgroundVideo from '../../images/background-video.mp4';

import { decodeToken as parseJwt } from "react-jwt";

import './ticket-page.styles.scss';
import { useState } from "react";

const TicketPage = () => {

    const [data, setData] = useState(null);

    const { id } = useParams();

    useEffect(() => {
        const decodedToken = parseJwt(id);
        setData(decodedToken);
    }, [])

    if (data != null) {
        return (
            <div>
                <video autoPlay muted loop playsInline id="backgroundVideo">
                    <source src={backgroundVideo} type="video/mp4" />
                </video>
                <div className="container-md ticket-page-container">
                    <h1 className='ticket-title'>{data.title}</h1>
                    <p className='ticket-details'>Brought to you by: {data.club} <br/>
                        Event starts at: {new Date(data.from).toLocaleString()} <br/>
                        Entry at: {data.address.replace("Ã", "ß")}, {data.postCode} {data.city}
                    </p>
                    <QRCodeSVG
                        className="qr-code-container"
                        value={id}
                        size={125}
                    />
                </div>
            </div>
        )
    } else {
        return null;
    }

}

export default TicketPage;