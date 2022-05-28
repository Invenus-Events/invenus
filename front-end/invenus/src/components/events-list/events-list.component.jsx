import React from "react";

import './events-list.styles.scss';

import EventCard from "../event-card/event-card.component";

class EventsList extends React.Component {

    constructor() {
        super();

        this.state = {
            events: [
                {
                    title: "P1 SOMMERFEST 2022",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg",
                    description: "Freunde und Familie kommen wieder zu einem ganz besonderen Fest zusammen, denn das P1 lädt zum Event-Highlight 2022 ein. Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!\n"
                },
                {
                    title: "THE SATURDAYS",
                    imageUrl: "https://www.ruby-danceclub.de/images/club/samstag_head.jpg",
                    description: "The Club w/ Dominik Muélar – Munich Alexander Heilberger – Munich"
                },
                {
                    title: "Pack Ma’s! – Wiesn 2022",
                    imageUrl: "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/P1-Afterwiesn-3.jpg",
                    description: "Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!"
                },
                {
                    title: "PAY ONE DRINK TWO",
                    imageUrl: "https://www.ruby-danceclub.de/images/club/freitag_head.jpg",
                    description: "Jeden Freitag: PAY ONE DRINK TWO organized by DOCH DOCH (Ruby Friday Team)"
                }
            ]
        }
    }

    render() {

        let events = this.state.events.map((event, index) => {
            return <EventCard key={index} title={event.title} imageUrl={event.imageUrl} description={event.description}/>
        })

        return (
            <div className='events-list-container'>
                <h1>Upcoming events.</h1>
                <input className='events-list-search-field' type="text" placeholder="Search..."/>
                <div className='events-list-event-listing'>
                    { events }
                </div>
                <button className='events-list-learn-more-button'>Learn more</button>
            </div>
        )
    }
}

export default EventsList;
