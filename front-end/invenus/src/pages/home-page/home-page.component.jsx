import React from "react";
import MapView from "../../components/map-view/map-view.component";

import EventsList from "../../components/events-list/events-list.component";

import './home-page.styles.scss';

class HomePage extends React.Component {

    constructor() {
        super();

        this.state = {
            eventIndex: 0,
            events: [
                {
                    title: "P1 SOMMERFEST 2022",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg",
                    description: "Freunde und Familie kommen wieder zu einem ganz besonderen Fest zusammen, denn das P1 lädt zum Event-Highlight 2022 ein. Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!\n",
                    coordinates: {
                        long: 11.5853,
                        lat: 48.1445
                    }
                },
                {
                    title: "Pack Ma’s! – Wiesn 2022",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/P1-Afterwiesn-3.jpg",
                    description: "Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!",
                    coordinates: {
                        long: 11.6532,
                        lat: 48.2489
                    }
                },

            ]
        }
    }

    getEventInView = (eventIndex) => {
        this.setState(() => ({
            eventIndex
        }))
    }

    render() {
        return (
            <div className="homepage-container">
                <MapView events={this.state.events} long={this.state.events[this.state.eventIndex].coordinates.long} lat={this.state.events[this.state.eventIndex].coordinates.lat}/>
                <EventsList getEventInView={this.getEventInView.bind(this)} events={this.state.events}/>
            </div>
        )
    }

}

export default HomePage;