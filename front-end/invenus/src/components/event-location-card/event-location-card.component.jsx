import React from "react";

import './event-location-card.style.scss';
import mapboxgl from "mapbox-gl";

class EventLocationCard extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            lng: this.props.event.lng,
            lat: this.props.event.lat,
            zoom: 15
        };
        this.mapContainer = React.createRef();
    }

    componentDidMount() {
        const {zoom} = this.state;
        const map = new mapboxgl.Map({
            container: this.mapContainer.current,
            style: 'mapbox://styles/leon-liang/cl3pzciel002d16lawlprcelh',
            center: [this.props.event.lng, this.props.event.lat],
            zoom: zoom
        });

        this.setState(() => ({
            map
        }))
    }


    render() {
        return (
            <div className="container-lg EventDescriptionCard">
                <h4> The Location </h4>
                <p>{this.props.event.address}</p>
                <div ref={this.mapContainer} className="map-container" />
            </div>
        );
    }
}

export default EventLocationCard;
