import React from 'react';

import './map-view-loading.styles.scss';

const MapViewLoading = () => {
    return (
        <div>
            <div className="map-view-loading-map-container">
                <div className="spinner-border" role="status">
                    <span className="sr-only"></span>
                </div>
            </div>
        </div>
    )
}

export default MapViewLoading;