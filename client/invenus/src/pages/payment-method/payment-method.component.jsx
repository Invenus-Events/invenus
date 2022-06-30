import React from 'react';

import './payment-method.styles.scss';

const PaymentMethodPage = () => {
    return (
        <div className="payment-method-container">
            <h1 className="payment-method-page-first-header">Checkout Form.</h1>
            <div className="payment-method-row row">
                <div className="payment-method-col-75 col-75">
                    <div className="payment-method-inner-container container">
                        <form>
                            <div className="payment-method-row row">
                                <div className="payment-method-col-50 col-50">
                                    <h3 className="payment-method-page-third-header">Billing Address</h3>
                                    <label htmlFor="fname"><i className="fa fa-user"></i> Full Name</label>
                                    <input className='input-type-text' type="text" id="fname" name="firstname"
                                           placeholder="John M. Doe"/>
                                    <label htmlFor="email"><i className="fa fa-envelope"></i> Email</label>
                                    <input className='input-type-text' type="text" id="email" name="email"
                                           placeholder="john@example.com"/>
                                    <label htmlFor="adr"><i
                                        className="fa fa-address-card-o"></i> Address</label>
                                    <input className='input-type-text' type="text" id="adr" name="address"
                                           placeholder="542 W. 15th Street"/>
                                    <label htmlFor="city"><i className="fa fa-institution"></i> City</label>
                                    <input className='input-type-text' type="text" id="city" name="city"
                                           placeholder="New York"/>

                                    <div className="payment-method-row row">
                                        <div className="payment-method-col-50 col-50">
                                            <label htmlFor="state">State</label>
                                            <input className='input-type-text' type="text" id="state" name="state"
                                                   placeholder="NY"/>
                                        </div>
                                        <div className="payment-method-col-50 col-50">
                                            <label htmlFor="zip">Zip</label>
                                            <input className='input-type-text' type="text" id="zip" name="zip"
                                                   placeholder="10001"/>
                                        </div>
                                    </div>
                                </div>

                                <div className="payment-method-col-50 col-50">
                                    <h3 className="payment-method-page-third-header">Payment</h3>
                                    {/*<label htmlFor="fname">Accepted Cards</label>*/}
                                    {/*<div className="icon-container">*/}
                                    {/*    <i className="fa fa-cc-visa" style={{color:"navy"}}></i>*/}
                                    {/*    <i className="fa fa-cc-amex" style={{color:"blue"}}></i>*/}
                                    {/*    <i className="fa fa-cc-mastercard" style={{color: "red"}}></i>*/}
                                    {/*    <i className="fa fa-cc-discover" style={{color:"orange"}}></i>*/}
                                    {/*</div>*/}
                                    <label htmlFor="cname">Name on Card</label>
                                    <input className='input-type-text' type="text" id="cname" name="cardname"
                                           placeholder="John More Doe"/>
                                    <label htmlFor="ccnum">Credit card number</label>
                                    <input className='input-type-text' type="text" id="ccnum" name="cardnumber"
                                           placeholder="1111-2222-3333-4444"/>
                                    <label htmlFor="expmonth">Exp Month</label>
                                    <input className='input-type-text' type="text" id="expmonth" name="expmonth"
                                           placeholder="September"/>
                                    <div className="payment-method-row row">
                                        <div className="payment-method-col-50 col-50">
                                            <label htmlFor="expyear">Exp Year</label>
                                            <input className='input-type-text' type="text" id="expyear" name="expyear"
                                                   placeholder="2018"/>
                                        </div>
                                        <div className="payment-method-col-50 col-50">
                                            <label htmlFor="cvv">CVV</label>
                                            <input className='input-type-text' type="text" id="cvv" name="cvv"
                                                   placeholder="352"/>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div>
                                <input className='' type="checkbox" checked="checked" name="sameadr"/>
                                <label for="sameadr" className="input-type-text-description"> Shipping address same as billing </label>
                            </div>
                            <input type="submit" value="Continue to checkout"
                                   className="payment-method-continue-button"/>
                        </form>
                    </div>
                </div>
                <div className="payment-method-col-25 col-25">
                    <div className="payment-method-inner-tickets-container container">
                        <h4 className="payment-method-page-third-header">Cart <span className="price"
                                                                                    style={{color: "black"}}><i
                            className="fa fa-shopping-cart"></i></span></h4>
                        <p>Product 1<span className="price">$15</span></p>
                        <p>Product 2<span className="price">$5</span></p>
                        <p>Product 3<span className="price">$8</span></p>
                        <p>Product 4<span className="price">$2</span></p>
                        <hr/>
                        <p>Total <span className="price" style={{color: "black"}}><b>$30</b></span></p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default PaymentMethodPage;