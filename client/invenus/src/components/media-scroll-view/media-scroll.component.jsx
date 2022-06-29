import React from 'react';

import './media-scroll.styles.scss';

const mediaScrollComponent = (props) => {

    props.forEach(x => {
        return(
            <img src={x}></img>
        )
    })

}

export default mediaScrollComponent;
