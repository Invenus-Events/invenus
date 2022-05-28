import React from "react";
import MapView from "../../components/map-view/map-view.component";

import EventsList from "../../components/events-list/events-list.component";

import './home-page.styles.scss';

const HomePage = () => {

    return (
        <div>
            <MapView />
            <EventsList />
        </div>
    )
}

export default HomePage;