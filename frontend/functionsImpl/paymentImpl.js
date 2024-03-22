import { getToken } from "../functions/getToken.js";
import * as payment from "../functions/payment.js";


//------------------- Selectors -------------------

let getAllPaymentsSelector = document.querySelector('#getAllPayments');
let getPaymentsByTypeAndYearOrganizedSelector = document.querySelector('#getPaymentsByTypeAndYearOrganized');
let getPaymentMethodsSelector = document.querySelector('#getPaymentMethods');
let averagePayment2009Selector = document.querySelector('#average-payment-2009');
let totalByYearSelector = document.querySelector('#total-by-year');

let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');


getAllPaymentsSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Get all payments";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="getAllPayments">Search</button>
    `);
    if(getToken()) {
        let payments = await payment.getAllPayments(getToken());
        console.log(payments);
        contentData.innerHTML = "";
        payments.forEach((payment) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-box"></i>
                    <h2>Transaction ID: ${payment.transactionId}</h2>
                    <p>Client Name: ${payment.clientName}</p>
                    <p>Date: ${payment.date}</p>
                    <p>Payment Method: ${payment.paymentMethod}</p>
                    <p>Total: ${payment.total}</h2>
                    <p>Client ID: ${payment.clientId}</p>
                    </div>
                </div>
            </div>
            `)
        })
    
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getAllPayments') {
                if(getToken()) {
                    let payments = await payment.getAllPayments(getToken(), searchImput.value);
                    console.log(payments);
                    contentData.innerHTML = "";
                    payments.forEach((payment) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-box"></i>
                                    <h2>Transaction ID: ${payment.transactionId}</h2>
                                    <p>Client Name: ${payment.clientName}</p>
                                    <p>Date: ${payment.date}</p>
                                    <p>Payment Method: ${payment.paymentMethod}</p>
                                    <p>Total: ${payment.total}</h2>
                                    <p>Client ID: ${payment.clientId}</p>
                                </div>
                            </div>
                        </div>
                        `)
                    })
                }else {
                    
                    console.log("No hay token");
                }
            }
        })
    
    }
})

getPaymentsByTypeAndYearOrganizedSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Get payments by type and year organized";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="method">
        <input type="number" id="yearInput" placeholder="Year">
        <button class ="search-button" id="getPaymentsByTypeAndYearOrganized">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getPaymentsByTypeAndYearOrganized') {
                if(getToken()) {
                    let payments = await payment.getPaymentsByTypeAndYearOrganized(getToken(), yearInput.value, searchImput.value);
                    console.log(payments);
                    contentData.innerHTML = "";
                    payments.forEach((payment) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-box"></i>
                                    <h2>Transaction ID: ${payment.transactionId}</h2>
                                    <p>Client Name: ${payment.clientName}</p>
                                    <p>Date: ${payment.date}</p>
                                    <p>Payment Method: ${payment.paymentMethod}</p>
                                    <p>Total: ${payment.total}</h2>
                                    <p>Client ID: ${payment.clientId}</p>
                                </div>
                            </div>
                        </div>
                        `)
                    })
                }else {

                    console.log("No hay token");

                }
            }
        })
    }
})

getPaymentMethodsSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Get payment methods";
    if(getToken()) {
        let payments = await payment.getPaymentMethods(getToken());
        console.log(payments);
        contentData.innerHTML = "";
        payments.forEach((payment) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-box"></i>
                    <h2>${payment}</h2>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

averagePayment2009Selector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Average payment 2009";
    if(getToken()) {
        let payments = await payment.averagePayment2009(getToken());
        console.log(payments);
        contentData.innerHTML = "";
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-box"></i>
                    <h2>${payments}</h2>
                    </div>
                </div>
            </div>
            `)
        
    }else {
        console.log("No hay token");
    }
})

totalByYearSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Total by year";
    if(getToken()) {
        let payments = await payment.totalByYear(getToken());
        console.log(payments);
        contentData.innerHTML = "";
        payments.forEach((payment) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-box"></i>
                    <h2>year: ${payment[0]}</h2>
                    <p>total: ${payment[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})
