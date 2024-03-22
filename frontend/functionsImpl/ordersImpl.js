import { getToken } from "../functions/getToken.js";
import * as orders from "../functions/orders.js";

//------------------- Selectors -------------------
let getAllOrdersSelector = document.querySelector("#getAllOrders");
let getStatesSelector = document.querySelector("#getStates");
let getOrdersDeliveredAfterExpectedDateSelector = document.querySelector("#getOrdersDeliveredAfterExpected");
let getOrdersInDeliverySelector = document.querySelector("#getOrdersInDelivery");
let getOrdersByStateAndYearSelector = document.querySelector("#getOrdersByStateAndYear");
let getOrdersByStateAndMonthSelector = document.querySelector("#getOrdersByStateAndMonth");
let getOrdersByStateSelector = document.querySelector("#getAmountByState");
let getOrderByClientSelector = document.querySelector("#first-last-dates-by-client");
let getOrdersBySumTotalQuantityByOrderSelector = document.querySelector("#getOrdersBySumTotalQuantityByOrder");

//------------------- Containers -------------------

let contentData = document.querySelector(".info-data");
let searchContent = document.querySelector(".search");
let title = document.querySelector(".title");

getAllOrdersSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "All orders";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
    if(getToken()) {
        let ordersData = await orders.getAllOrders(getToken());
        console.log(ordersData);
        contentData.innerHTML = "";
        ordersData.map((ordersDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${ordersDataMap.orderCode}</h2>
                        <p>Date: ${ordersDataMap.dateOrder}</p>
                        <p>Expected date: ${ordersDataMap.expectedDate}</p>
                        <p>Delivered date: ${ordersDataMap.deliveredDate}</p>
                        <p>State: ${ordersDataMap.state}</p>
                        <p>Comments: ${ordersDataMap.comments}</p>
                    </div>
                </div>
            </div>
            `);
        })

        // Search by id
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'searchAllById') {
                console.log("");
                if(getToken()) {
                    let ordersData = await orders.getOrderById(getToken(), searchImput.value);
                    contentData.innerHTML = "";
                    contentData.insertAdjacentHTML("beforeend", `
                    <div class="card">
                    <div class="head">
                        <div>
                            <i class="bx bx-desktop"></i>
                            <h2>${ordersData.orderCode}</h2>
                            <p>Date: ${ordersData.dateOrder}</p>
                            <p>Expected date: ${ordersData.expectedDate}</p>
                            <p>Delivered date: ${ordersData.deliveredDate}</p>
                            <p>State: ${ordersData.state}</p>
                            <p>Comments: ${ordersData.comments}</p>
                        </div>
                    </div>
                </div>
                    `);
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})

getStatesSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get states";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()) {
        let ordersData = await orders.getStates(getToken());
        console.log(ordersData);
        contentData.innerHTML = "";
        ordersData.map((ordersDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${ordersDataMap}</h2>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

getOrdersDeliveredAfterExpectedDateSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders delivered after expected date";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()) {
        let ordersData = await orders.getOrdersDeliveredAfterExpectedDate(getToken());
        console.log(ordersData);
        contentData.innerHTML = "";
        ordersData.map((ordersDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>Order Code: ${ordersDataMap[0]}</h2>
                        <p>Client Code: ${ordersDataMap[1]}</p>
                        <p>Expected Date: ${ordersDataMap[2]}</p>
                        <p>Delivered Date: ${ordersDataMap[3]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

getOrdersInDeliverySelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders in delivery";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="getOrdersInDelivery">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getOrdersInDelivery') {
                if(getToken()) {
                    let ordersData = await orders.getOrdersInDelivery(getToken(), searchImput.value);
                    console.log(ordersData);
                    contentData.innerHTML = "";
                    ordersData.map((ordersDataMap) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-desktop"></i>
                                    <h2>Order Code: ${ordersDataMap[0]}</h2>
                                    <p>Client Code: ${ordersDataMap[1]}</p>
                                    <p>Expected Date: ${ordersDataMap[2]}</p>
                                    <p>Delivered Date: ${ordersDataMap[3]}</p>
                                </div>
                            </div>
                        </div>
                        `);
                    })
                }else {
                    
                    console.log("No hay token");
                }
            }
        })
    }
})

getOrdersByStateAndYearSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders by state and year";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <input type="number" id="yearInput" placeholder="Year">
        <button class ="search-button" id="getOrdersByStateAndYear">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getOrdersByStateAndYear') {
                if(getToken()) {
                    let ordersData = await orders.getOrdersByStateAndYear(getToken(), searchImput.value, yearInput.value);
                    console.log(ordersData);
                    contentData.innerHTML = "";
                    ordersData.map((ordersDataMap) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                <i class="bx bx-desktop"></i>
                                <h2>${ordersDataMap.orderCode}</h2>
                                <p>Date: ${ordersDataMap.dateOrder}</p>
                                <p>Expected date: ${ordersDataMap.expectedDate}</p>
                                <p>Delivered date: ${ordersDataMap.deliveredDate}</p>
                                <p>State: ${ordersDataMap.state}</p>
                                <p>Comments: ${ordersDataMap.comments}</p>
                                </div>
                            </div>
                        </div>
                        `);
                    })
                }else {
                    
                    console.log("No hay token");
                }
            }   
        })
    }
})

getOrdersByStateAndMonthSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders by state and month";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <input type="number" id="monthInput" placeholder="Month">
        <button class ="search-button" id="getOrdersByStateAndMonth">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getOrdersByStateAndMonth') {
                if(getToken()) {
                    let ordersData = await orders.getOrdersByStateAndMonth(getToken(), searchImput.value, monthInput.value);
                    console.log(ordersData);
                    contentData.innerHTML = "";
                    ordersData.map((ordersDataMap) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                <i class="bx bx-desktop"></i>
                                <h2>${ordersDataMap.orderCode}</h2>
                                <p>Date: ${ordersDataMap.dateOrder}</p>
                                <p>Expected date: ${ordersDataMap.expectedDate}</p>
                                <p>Delivered date: ${ordersDataMap.deliveredDate}</p>
                                <p>State: ${ordersDataMap.state}</p>
                                <p>Comments: ${ordersDataMap.comments}</p>
                                </div>
                            </div>
                        </div>
                        `);
                    })
                }else {
                    
                    console.log("No hay token");
                }
            }
        })
    }
})

getOrdersByStateSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders by state";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
                if(getToken()) {
                    let ordersData = await orders.amountByState(getToken());
                    console.log(ordersData);
                    contentData.innerHTML = "";
                    ordersData.map((ordersDataMap) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                <i class="bx bx-desktop"></i>
                                <h2>${ordersDataMap[0]}</h2>
                                <p>Amount: ${ordersDataMap[1]}</p>
                                </div>
                            </div>
                        </div>
                        `);
                    })
                }else {
                    console.log("No hay token");
                }

})

getOrderByClientSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders by client";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()) {
        let ordersData = await orders.firstLastDatesByClient(getToken());
        console.log(ordersData);
        contentData.innerHTML = "";
        ordersData.map((ordersDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-desktop"></i>
                    <h2>Client: ${ordersDataMap[0]}</h2>
                    <p>Client contact name: ${ordersDataMap[1]}</p>
                    <p>Client contact last name: ${ordersDataMap[2]}</p>
                    <p>First order date: ${ordersDataMap[3]}</p>
                    <p>Last order date: ${ordersDataMap[4]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

getOrdersBySumTotalQuantityByOrderSelector.addEventListener("click", async (e) => {
    e.preventDefault();
    title.innerHTML = "Get orders by sum total quantity by order";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()) {
        let ordersData = await orders.getOrdersBySumTotalQuantityByOrder(getToken());
        console.log(ordersData);
        contentData.innerHTML = "";
        ordersData.map((ordersDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-desktop"></i>
                    <h2>Name: ${ordersDataMap[0]}</h2>
                    <p>Sum total quantity: ${ordersDataMap[1]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})
