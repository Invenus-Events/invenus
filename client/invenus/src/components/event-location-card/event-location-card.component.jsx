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
            zoom: zoom,
            interactive: false
        });


        map.on('load', () => {
            map.addSource('points', {
                'type': 'geojson',
                'data': {
                    'type': 'FeatureCollection',
                    'features': [
                        {
                            'type': 'Feature',
                            'geometry': {
                                'type': 'Point',
                                'coordinates': [
                                    this.props.event.location.longitude, this.props.event.location.latitude
                                ]
                            },
                            'properties': {
                                'title': 'Mapbox DC'
                            }
                        },
                    ]
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
    }

    render() {
        return (
            <div className="EventDescriptionCard">
                <h4 className = "EventPageHeader-Event-Location-Card"> Location </h4>
                <div className="col-md-5">
                    <p className='event-card-club'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-geo-alt-fill bootstrap-icon" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                        </svg>
                        {this.props.event.location.address}
                    </p>
                </div>
                <div ref={this.mapContainer} className="event-location-card-map-container" />
            </div>
        );
    }
}

export default EventLocationCard;
