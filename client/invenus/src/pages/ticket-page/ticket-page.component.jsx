import React, { useEffect } from 'react';
import { useParams } from "react-router-dom";
import QRCodeSVG from "qrcode.react";

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

    console.log(data)

    return (
        <div className='ticket-page-container'>
            <QRCodeSVG value={id} />
        </div>
    )
}

export default TicketPage;