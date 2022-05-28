import React from 'react';

import mapboxgl from 'mapbox-gl';

import './map-view.styles.scss';

mapboxgl.accessToken = 'pk.eyJ1IjoibGVvbi1saWFuZyIsImEiOiJjbDNwc2hia2wwNWttM2RtMW0xY29saGNsIn0.z-hk73VMrjx34Hdg2O8S1w';

class MapView extends React.PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            lng: 11.5754,
            lat: 48.1374,
            zoom: 12
        };
        this.mapContainer = React.createRef();
    }

    componentDidMount() {
        const { lng, lat, zoom } = this.state;
        const map = new mapboxgl.Map({
            container: this.mapContainer.current,
            style: 'mapbox://styles/mapbox/streets-v11',
            center: [lng, lat],
            zoom: zoom
        });

        map.on('move', () => {
            this.setState({
                lng: map.getCenter().lng.toFixed(4),
                lat: map.getCenter().lat.toFixed(4),
                zoom: map.getZoom().toFixed(2)
            });
        });
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