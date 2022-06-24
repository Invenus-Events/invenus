import React from "react";

import '../map-view/map-view.styles.scss';
import './event-location-card.style.scss';

import mapboxgl from "mapbox-gl";

// For development
mapboxgl.accessToken = 'pk.eyJ1IjoibGVvbi1saWFuZyIsImEiOiJja2s2d3B3aGMwM3U1MnZvNDZ1eWRreTBkIn0.v36rtfP7kOlwQQx30MLqdw';

// For production
// mapboxgl.accessToken = 'pk.eyJ1IjoibGVvbi1saWFuZyIsImEiOiJjbDNwc2hia2wwNWttM2RtMW0xY29saGNsIn0.z-hk73VMrjx34Hdg2O8S1w';

class EventLocationCard extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            longitude: this.props.event.location.longitude,
            lat: this.props.event.location.latitude,
            zoom: 15
        };
        this.mapContainer = React.createRef();
    }

    componentDidMount() {
        const {zoom} = this.state;
        const map = new mapboxgl.Map({
            container: this.mapContainer.current,
            style: 'mapbox://styles/leon-liang/cl3pzciel002d16lawlprcelh',
            center: [this.props.event.location.longitude, this.props.event.location.latitude],
            zoom: zoom
        });

        const features = {
                'type': 'Feature',
                'properties': {},
                'geometry': {
                    'type': 'Point',
                    'coordinates': [this.props.event.location.longitude, this.props.event.location.latitude]
                }
        }

        map.on("load", () => {
            map.addSource('points', {
                'type': 'geojson',
                'data': {
                    'type': 'FeatureCollection',
                    'features': features
                }
            });
            map.addLayer({
                'id': 'points',
                'type': 'circle',
                'source': 'points',
                'paint': {
                    'circle-color': '#000',
                    'circle-radius': 6,
                    'circle-stroke-width': 2,
                    'circle-stroke-color': '#ffffff'
                }
            });
        })

        this.setState(() => ({
            map
        }))
    }


    render() {
        return (
            <div className="container-lg EventDescriptionCard">
                <h4> The Location </h4>
                <p>{this.props.event.location.address.address}</p>
                <div ref={this.mapContainer} className="event-location-card-map-container" />
            </div>
        );
    }
}

export default EventLocationCard;
