import React from 'react';
import { useParams } from "react-router-dom";
import QRCodeSVG from "qrcode.react";

import './ticket-page.styles.scss';

const TicketPage = () => {

    const { id } = useParams();

    return (
        <div className='ticket-page-container'>
            <QRCodeSVG value={id} />
        </div>
    )
}

export default TicketPage;