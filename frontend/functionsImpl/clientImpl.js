//------------------- FUNCTIONS -------------------

import { getToken } from "../functions/getToken.js";
import { getAllClients } from "../functions/client.js";

let getAll = document.querySelector('#getAllClients');
let contentData = document.querySelector('.info-data');
getAll.addEventListener('click', async (e) => {
	e.preventDefault();
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
                        <h2>${client.clientId}</h2>
                        <p>${client.clientName}</p>
                    </div>
                </div>
            </div>
            `)
        })

    }else {
        console.log("No hay token");
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