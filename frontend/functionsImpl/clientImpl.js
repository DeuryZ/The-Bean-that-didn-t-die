//------------------- FUNCTIONS -------------------

import { getToken } from "../functions/getToken.js";
import { getAllClients, 
    getClientById, 
    findClientsByCountry, 
    findClientsWithPaymentInAYear,
    findClientsByCityAndSalesRep,
    findAllClientsWithSalesReps,
    findAllClientsWithSalesRepIfPayment,
    findAllClientsWithSalesRepWithoutPayment,
    findAllClientsWithSalesRepAndOfficeIfPayment,
    findAllClientsWithSalesRepAndOfficeWithoutPayment,
    findAllClientsWithSalesRepAndOffice,
    findClientsWithPendingOrdersLaterThanExpected,
    findClientsWithoutPayment,
    findClientsWithoutOrder,
    findClientsWithoutOrderOrWithoutPayment,
    countByCountry,
    count,
    countInMadrid,
    countCitiesStartingWithM,
    withoutSalesRepresentative
    } from "../functions/clients.js";

//------------------- Selectors -------------------
let getAll = document.querySelector('#getAllClients');
let findClientsByCountrySelector = document.querySelector('#findClientsByCountry');
let findClientsWithPaymentInAYearSelector = document.querySelector('#findClientsWithPaymentInAYear');
let findClientsByCityAndSalesRepSelector = document.querySelector('#findClientsByCityAndSalesRep');
let findAllClientsWithSalesRepsSelector = document.querySelector('#findAllClientsWithSalesReps');
let findAllClientsWithSalesRepIfPaymentSelector = document.querySelector('#findAllClientsWithSalesRepIfPayment');
let findAllClientsWithSalesRepWithoutPaymentSelector = document.querySelector('#findAllClientsWithSalesRepWithoutPayment');
let findAllClientsWithSalesRepAndOfficeIfPaymentSelector = document.querySelector('#findAllClientsWithSalesRepAndOfficeIfPayment');
let findAllClientsWithSalesRepAndOfficeWithoutPaymentSelector = document.querySelector('#findAllClientsWithSalesRepAndOfficeWithoutPayment');
let findAllClientsWithSalesRepAndOfficeSelector = document.querySelector('#findAllClientsWithSalesRepAndOffice');
let findClientsWithPendingOrdersLaterThanExpectedSelector = document.querySelector('#findClientsWithPendingOrdersLaterThanExpected');
let findClientsWithoutPaymentSelector = document.querySelector('#findClientsWithoutPayment');
let findClientsWithoutOrderSelector = document.querySelector('#findClientsWithoutOrder');
let findClientsWithoutOrderOrWithoutPaymentSelector = document.querySelector('#findClientsWithoutOrderOrWithoutPayment');
let countByCountrySelector = document.querySelector('#countByCountry');
let countSelector = document.querySelector('#count');
let countInMadridSelector = document.querySelector('#countInMadrid');
let countCitiesStartingWithMSelector = document.querySelector('#countCitiesStartingWithM');
let withoutSalesRepresentativeSelector = document.querySelector('#withoutSalesRepresentative');


//------------------- Containers -------------------
let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');


getAll.addEventListener('click', async (e) => {
	e.preventDefault();
    title.innerHTML = "All clients";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
	if(getToken()) {
        let clients = await getAllClients(getToken());
        console.log(clients);
        contentData.innerHTML = "";
        clients.map((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client.clientName}</h2>
                        <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                        <p>Phone: ${client.phone}</p>
                        <p>Fax: ${client.fax}</p>
                        <p>Address: ${client.addressLine}</p>
                        <p>City: ${client.city}</p>
                        <p>Region: ${client.region}</p>
                        <p>Country: ${client.country}</p>
                        <p>Zip Code: ${client.zipCode}</p>
                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                        <p>Credit Limit: ${client.creditLimit}</p>
                        <p>Client Name: ${client.clientName}</p>
                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    </div>
                </div>
            </div>
            `)
        })
        // Search by id
    let searchImput = document.querySelector('#searchInput');
    let searchBtn = document.querySelector('.search-button');
    searchBtn.addEventListener('click', async (e) => {
        e.preventDefault(searchImput.value);
        if(e.target.id === 'searchAllById') {
            console.log("");
            if(getToken()) {
                let client = await getClientById(getToken(), searchImput.value);
                contentData.innerHTML = "";
                contentData.insertAdjacentHTML("beforeend", `
                <div class="card">
                    <div class="head">
                        <div>
                            <i class="bx bx-user"></i>
                            <h2>${client.clientName}</h2>
                            <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                            <p>Phone: ${client.phone}</p>
                            <p>Fax: ${client.fax}</p>
                            <p>Address: ${client.addressLine}</p>
                            <p>City: ${client.city}</p>
                            <p>Region: ${client.region}</p>
                            <p>Country: ${client.country}</p>
                            <p>Zip Code: ${client.zipCode}</p>
                            <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                            <p>Credit Limit: ${client.creditLimit}</p>
                            <p>Client Name: ${client.clientName}</p>
                            <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                        </div>
                    </div>
                </div>
                `)
            }else {
                console.log("No hay token");
            }
        }
    })

    }else {
        console.log("No hay token");
    }
})

findClientsByCountrySelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Find clients by country";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="findClientsByCountry">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'findClientsByCountry') {
                if(getToken()) {
                    let client = await findClientsByCountry(getToken(), searchImput.value);
                    console.log(client);
                    contentData.innerHTML = "";
                    if(client.length > 0) {
                        client.forEach((client) => {   
                            contentData.insertAdjacentHTML("beforeend", `
                            <div class="card">
                                <div class="head">
                                    <div>
                                        <i class="bx bx-user"></i>
                                        <h2>${client}</h2>
                                    </div>
                                </div>
                            </div>
                            `)
                        })
                    }
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})

findClientsWithPaymentInAYearSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Find clients with payment in a year";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="findClientsWithPaymentInAYear">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'findClientsWithPaymentInAYear') {
                if(getToken()) {
                    let client = await findClientsWithPaymentInAYear(getToken(), searchImput.value);
                    console.log(client);
                    contentData.innerHTML = "";
                    if(client.length > 0) {
                        client.forEach((client) => {   
                            contentData.insertAdjacentHTML("beforeend", `
                            <div class="card">
                                <div class="head">
                                    <div>
                                        <i class="bx bx-user"></i>
                                        <h2>${client}</h2>
                                    </div>
                                </div>
                            </div>
                            `)
                        })
                    }
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})

findClientsByCityAndSalesRepSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Find clients by city and sales rep";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="City">
        <input type="text" id="searchInput2" placeholder="Sales Rep">
        <input type="text" id="searchInput3" placeholder="Sales Rep">
        <button class ="search-button" id="findClientsByCityAndSalesRep">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchImput2 = document.querySelector('#searchInput2');
        let searchImput3 = document.querySelector('#searchInput3');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'findClientsByCityAndSalesRep') {
                if(getToken()) {
                    let client = await findClientsByCityAndSalesRep(getToken(), searchImput.value, searchImput2.value, searchImput3.value);
                    console.log(client);
                    contentData.innerHTML = "";
                    if(client.length > 0) {
                        client.forEach((client) => {   
                            contentData.insertAdjacentHTML("beforeend", `
                            <div class="card">
                                <div class="head">
                                    <div>
                                        <i class="bx bx-user"></i>
                                        <h2>${client.clientName}</h2>
                                        <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                                        <p>Phone: ${client.phone}</p>
                                        <p>Fax: ${client.fax}</p>
                                        <p>Address: ${client.addressLine}</p>
                                        <p>City: ${client.city}</p>
                                        <p>Region: ${client.region}</p>
                                        <p>Country: ${client.country}</p>
                                        <p>Zip Code: ${client.zipCode}</p>
                                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                                        <p>Credit Limit: ${client.creditLimit}</p>
                                        <p>Client Name: ${client.clientName}</p>
                                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                                    </div>
                                </div>
                            </div>
                            `)
                        })
                    }
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})

findAllClientsWithSalesRepsSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps";
    if(getToken()) {
        let clients = await findAllClientsWithSalesReps(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Sales Rep: ${client[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findAllClientsWithSalesRepIfPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps with payment";
    if(getToken()) {
        let clients = await findAllClientsWithSalesRepIfPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Sales Rep: ${client[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findAllClientsWithSalesRepWithoutPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps without payment";
    if(getToken()) {
        let clients = await findAllClientsWithSalesRepWithoutPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Sales Rep: ${client[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findAllClientsWithSalesRepAndOfficeIfPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps and office with payment";
    if(getToken()) {
        let clients = await findAllClientsWithSalesRepAndOfficeIfPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Sales Rep: ${client[1]}</p>
                        <p>Office city: ${client[2]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findAllClientsWithSalesRepAndOfficeWithoutPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps and office without payment";
    if(getToken()) {
        let clients = await findAllClientsWithSalesRepAndOfficeWithoutPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Credit Limit: ${client[1]}</p>
                        <p>Office city: ${client[2]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findAllClientsWithSalesRepAndOfficeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "All clients with sales reps and office";
    if(getToken()) {
        let clients = await findAllClientsWithSalesRepAndOffice(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client[0]}</h2>
                        <p>Sales Rep: ${client[1]}</p>
                        <p>Office city: ${client[2]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findClientsWithPendingOrdersLaterThanExpectedSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "Clients with pending orders later than expected";
    if(getToken()) {
        let clients = await findClientsWithPendingOrdersLaterThanExpected(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${client.clientName}</h2>
                        <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                        <p>Phone: ${client.phone}</p>
                        <p>Fax: ${client.fax}</p>
                        <p>Address: ${client.addressLine}</p>
                        <p>City: ${client.city}</p>
                        <p>Region: ${client.region}</p>
                        <p>Country: ${client.country}</p>
                        <p>Zip Code: ${client.zipCode}</p>
                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                        <p>Credit Limit: ${client.creditLimit}</p>
                        <p>Client Name: ${client.clientName}</p>
                        <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findClientsWithoutPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "Clients without payment";
    if(getToken()) {
        let clients = await findClientsWithoutPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-user"></i>
                    <h2>${client.clientName}</h2>
                    <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                    <p>Phone: ${client.phone}</p>
                    <p>Fax: ${client.fax}</p>
                    <p>Address: ${client.addressLine}</p>
                    <p>City: ${client.city}</p>
                    <p>Region: ${client.region}</p>
                    <p>Country: ${client.country}</p>
                    <p>Zip Code: ${client.zipCode}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    <p>Credit Limit: ${client.creditLimit}</p>
                    <p>Client Name: ${client.clientName}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findClientsWithoutOrderSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "Clients without order";
    if(getToken()) {
        let clients = await findClientsWithoutOrder(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-user"></i>
                    <h2>${client.clientName}</h2>
                    <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                    <p>Phone: ${client.phone}</p>
                    <p>Fax: ${client.fax}</p>
                    <p>Address: ${client.addressLine}</p>
                    <p>City: ${client.city}</p>
                    <p>Region: ${client.region}</p>
                    <p>Country: ${client.country}</p>
                    <p>Zip Code: ${client.zipCode}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    <p>Credit Limit: ${client.creditLimit}</p>
                    <p>Client Name: ${client.clientName}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

findClientsWithoutOrderOrWithoutPaymentSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    searchContent.innerHTML = "";
    title.innerHTML = "Clients without order or without payment";
    if(getToken()) {
        let clients = await findClientsWithoutOrderOrWithoutPayment(getToken());
        console.log(clients);
        clients.forEach((client) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                    <i class="bx bx-user"></i>
                    <h2>${client.clientName}</h2>
                    <p>Contact Name: ${client.contactName} ${client.contactLastName}</p>
                    <p>Phone: ${client.phone}</p>
                    <p>Fax: ${client.fax}</p>
                    <p>Address: ${client.addressLine}</p>
                    <p>City: ${client.city}</p>
                    <p>Region: ${client.region}</p>
                    <p>Country: ${client.country}</p>
                    <p>Zip Code: ${client.zipCode}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    <p>Credit Limit: ${client.creditLimit}</p>
                    <p>Client Name: ${client.clientName}</p>
                    <p>Sales Rep: ${client.salesRepEmployeeId}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

countByCountrySelector.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
        let count = await countByCountry(getToken());
        contentData.innerHTML = "";
        title.innerHTML = "Clients in all countries";
        count.forEach((element) => {
            console.log(element);
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${element[0]}</h2>
                        <p>${element[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

countSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
        let countData = await count(getToken());
        contentData.innerHTML = "";
        title.innerHTML = "All clients";
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${countData}</h2>
                    </div>
                </div>
            </div>
            `)
    }
})

countInMadridSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
        let countData = await countInMadrid(getToken());
        contentData.innerHTML = "";
        title.innerHTML = "All clients";
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${countData}</h2>
                    </div>
                </div>
            </div>
            `)
    }
})

countCitiesStartingWithMSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
        let count = await countCitiesStartingWithM(getToken());
        contentData.innerHTML = "";
        title.innerHTML = "Cities starting with M";
        count.forEach((element) => {
            console.log(element);
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${element[0]}</h2>
                        <p>${element[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }
})

withoutSalesRepresentativeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
            let countData = await withoutSalesRepresentative(getToken());
            contentData.innerHTML = "";
            title.innerHTML = "All clients";
                contentData.insertAdjacentHTML("beforeend", `
                <div class="card">
                    <div class="head">
                        <div>
                            <i class="bx bx-desktop"></i>
                            <h2>${countData}</h2>
                        </div>
                    </div>
                </div>
                `)
        } 
})





let data = {
    "clientId": 1,
    "contactName": "Daniel G",
    "contactLastName": "GoldFish",
    "phone": "5556901745",
    "fax": "5556901746",
    "addressLine": "False Street 52 2 A",
    "addressLine2": null,
    "city": "San Francisco",
    "region": null,
    "country": "USA",
    "zipCode": "24006",
    "salesRepEmployeeId": null,
    "creditLimit": 3000,
    "clientName": "GoldFish Garden"
}
{/* <p>Phone: ${client.phone}</p>
<p>Fax: ${client.fax}</p>
<p>Address: ${client.addressLine}</p>
<p>City: ${client.city}</p>
<p>Region: ${client.region}</p>
<p>Country: ${client.country}</p>
<p>Zip Code: ${client.zipCode}</p>
<p>Credit Limit: ${client.creditLimit}</p>
<p>Sales Rep: ${client.salesRepEmployeeId}</p>
<p>Contact Name: ${client.contactName}</p>
<p>Contact Last Name: ${client.contactLastName}</p>
<p>Client Name: ${client.clientName}</p> */}