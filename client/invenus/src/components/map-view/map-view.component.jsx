import React from 'react';

import mapboxgl from 'mapbox-gl';

import './map-view.styles.scss';

// For development
mapboxgl.accessToken = 'pk.eyJ1IjoibGVvbi1saWFuZyIsImEiOiJja2s2d3B3aGMwM3U1MnZvNDZ1eWRreTBkIn0.v36rtfP7kOlwQQx30MLqdw';

// For production
// mapboxgl.accessToken = 'pk.eyJ1IjoibGVvbi1saWFuZyIsImEiOiJjbDNwc2hia2wwNWttM2RtMW0xY29saGNsIn0.z-hk73VMrjx34Hdg2O8S1w';

class MapView extends React.PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            lng: this.props.events[this.props.currentEvent].location.longitude,
            lat: this.props.events[this.props.currentEvent].location.latitude,
            zoom: 15
        };
        this.mapContainer = React.createRef();
    }

    updateMap(lng, lat) {
        if (this.state.map) {
            this.state.map.flyTo({
                center: [
                    lng,
                    lat
                ],
                zoom: this.state.zoom,
            })
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        this.updateMap(this.props.events[this.props.currentEvent].location.longitude, this.props.events[this.props.currentEvent].location.latitude);
    }

    componentDidMount() {
        const { zoom } = this.state;
        const map = new mapboxgl.Map({
            container: this.mapContainer.current,
            style: 'mapbox://styles/leon-liang/cl3pzciel002d16lawlprcelh',
            center: [this.props.events[this.props.currentEvent].location.longitude, this.props.events[this.props.currentEvent].location.latitude],
            zoom
        });

        const features = this.props.events.map((event) => {
            return  {
                'type': 'Feature',
                'properties': {},
                'geometry': {
                    'type': 'Point',
                    'coordinates': [event.location.longitude, event.location.latitude]
                }
            }
        })

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
            <div>
                <div ref={this.mapContainer} className="map-container" />
            </div>
        )
    }

}

export default MapView;