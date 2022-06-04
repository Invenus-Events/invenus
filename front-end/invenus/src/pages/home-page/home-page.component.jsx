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
                    id: '57d534a6-09d0-4427-ab98-75c206f98789',
                    date: "FRIDAY, JUNE 3, 2022 AT 10:00 PM UTC+02",
                    club: "Melusina",
                    organizer: "Melusina",
                    title: "Tequila Night 03.06.2022",
                    imageUrl: "https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg",
                    description: "🍋TEQUILA NIGHT 🍋",
                    coordinates: {
                        long:  6.14137,
                        lat: 49.61143
                    }
                },
                {
                    id: 'd1d3c5a6-e91f-4f05-9668-7491a815cb95',
                    title: "P1 SOMMERFEST 2022",
                    date: "WEDNESDAY, JUNE 22, 2022 AT 10:00 PM UTC+02",
                    club: "P1 Club",
                    organizer: "P1 Club",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg",
                    description: "Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!\n",
                    coordinates: {
                        long: 11.5853,
                        lat: 48.1445
                    }
                },
                {
                    id: '6b2d28f7-283d-481d-bd7a-82f92e042bd0',
                    date: "FRIDAY, JULY 1, 2022 AT 10:00 PM UTC+02",
                    club: "P1 Club",
                    organizer: "P1 Club",
                    title: "Pack Ma’s! – Wiesn 2022",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/P1-Afterwiesn-3.jpg",
                    description: "Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!",
                    coordinates: {
                        long: 11.6532,
                        lat: 48.2489
                    }
                }
            ]
        }
    }

    componentDidMount() {
        this.setState(() => ({
            eventIndex: 0
        }))
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