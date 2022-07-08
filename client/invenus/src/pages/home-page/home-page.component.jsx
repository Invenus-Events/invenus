import React from "react";
import axios from 'axios';

import MapView from "../../components/map-view/map-view.component";

import EventsList from "../../components/events-list/events-list.component";

import './home-page.styles.scss';
import MapViewLoading from "../../components/map-view-loading/map-view-loading.component";
import EventsListLoading from "../../components/events-list-loading/events-list-loading.component";
import { ToastContainer } from "react-toastify";

class HomePage extends React.Component {

    constructor() {
        super();

        this.state = {
            // accounts for the first setState that shouldn't take place
            counter: 1,
            eventIndex: 0,
            events: [],
            shouldUpdateMap: false,
            eventUpdateObservers: []
        }
    }

    componentDidMount() {
        this.setState(() => ({
            eventIndex: 0
        }))

        axios.get('https://api.invenus.club/events')
            .then(res => {
                const events = res.data;
                const sortedEvents = events.sort(function (a, b) {
                    return new Date(a.timeFrame.from) - new Date(b.timeFrame.from);
                })
                this.setState({events: sortedEvents}, () => {
                    console.log(this.state.events);
                })
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

    updateSortedEvents = (events) => {
        this.setState({
            events
        }, () => {
            this.setState({
                eventIndex: 0
            })
        })
    }

    render() {
        return (
            <div >
                <ToastContainer
                    position="top-right"
                    autoClose={5000}
                    hideProgressBar={false}
                    newestOnTop={false}
                    closeOnClick
                    rtl={false}
                    pauseOnFocusLoss
                    draggable={false}
                    pauseOnHover={false}
                />
                { this.state.events.length === 0 ? (
                    <div>
                        <MapViewLoading />
                        <EventsListLoading />
                    </div>
                    ) :
                    <div className="homepage-container">
                        <MapView events={this.state.events} currentEvent={this.state.eventIndex} eventUpdateObservers={this.state.eventUpdateObservers}/>
                        <EventsList
                            getEventInView={this.getEventInView.bind(this)}
                            eventUpdateObservers={this.state.eventUpdateObservers}
                            updateSortedEvents={this.updateSortedEvents.bind(this)}
                            events={this.state.events}
                        />
                    </div>
                }
            </div>
        )
    }

}

export default HomePage;