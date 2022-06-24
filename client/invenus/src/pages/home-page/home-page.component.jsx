import React from "react";
import axios from 'axios';

import MapView from "../../components/map-view/map-view.component";

import EventsList from "../../components/events-list/events-list.component";

import './home-page.styles.scss';
import MapViewLoading from "../../components/map-view-loading/map-view-loading.component";
import EventsListLoading from "../../components/events-list-loading/events-list-loading.component";

class HomePage extends React.Component {

    constructor() {
        super();

        this.state = {
            // accounts for the first setState that shouldn't take place
            counter: 1,
            eventIndex: 0,
            events: []
        }
    }

    componentDidMount() {
        this.setState(() => ({
            eventIndex: 0
        }))

        axios.get('http://localhost:8080/events')
            .then(res => {
                const events = res.data;
                this.setState({events})
            })
    }

    getEventInView = (eventIndex) => {
        // known bug: on initial load of website, second element is set to InView.
        // accounting for the first state change that shouldn't take place

        if (this.state.counter > 0) {
            this.setState((prevState) => ({
                counter: prevState.counter - 1,
            }))
        } else {
            this.setState(() => ({
                eventIndex
            }))
        }
    }

    render() {
        return (
            <div >
                { this.state.events.length === 0 ? (
                    <div>
                        <MapViewLoading />
                        <EventsListLoading />
                    </div>
                    ) :
                    <div className="homepage-container">
                        <MapView events={this.state.events} currentEvent={this.state.eventIndex}/>
                        <EventsList getEventInView={this.getEventInView.bind(this)} events={this.state.events}/>
                    </div>
                }
            </div>
        )
    }

}

export default HomePage;