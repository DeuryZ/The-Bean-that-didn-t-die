import { getToken } from "../functions/getToken.js";
import * as offices from "../functions/offices.js";

//------------------- Selectors -------------------
let getAll = document.querySelector('#getAllOffices');
let getCodeAndCityByOfficeSelector = document.querySelector('#getCodeAndCityByOffice');
let getCityAndNumberByCountrySelector = document.querySelector('#getCityAndNumberByCountry');
let getAddressByCitySelector = document.querySelector('#getAddressByCity');


let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');

getAll.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "All offices";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
    if(getToken()) {
        let officesData = await offices.getAllOffices(getToken());
        console.log(officesData);
        contentData.innerHTML = "";
        officesData.map((officesDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${officesDataMap.officeCode}</h2>
                        <p>${officesDataMap.city}</p>
                        <p>${officesDataMap.country}</p>
                        <p>${officesDataMap.phone}</p>
                        <p>${officesDataMap.addressLine1}</p>
                        <p>${officesDataMap.addressLine2}</p>
                        <p>${officesDataMap.postalCode}</p>
                        <p>${officesDataMap.region}</p>
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
                    let office = await offices.getOfficeById(getToken(), searchImput.value);
                    contentData.innerHTML = "";
                    contentData.insertAdjacentHTML("beforeend", `
                    <div class="card">
                        <div class="head">
                            <div>
                                <i class="bx bx-desktop"></i>
                                <h2>${office.officeCode}</h2>
                                <p>${office.city}</p>
                                <p>${office.country}</p>
                                <p>${office.phone}</p>
                                <p>${office.addressLine1}</p>
                                <p>${office.addressLine2}</p>
                                <p>${office.postalCode}</p>
                                <p>${office.region}</p>
                            </div>
                        </div>
                    </div>
                    `)
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})

getCodeAndCityByOfficeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    title.innerHTML = "Get code and city";
    if(getToken()){
        let office = await offices.getCodeAndCityByOffice(getToken());
        console.log(office);
        office.forEach((office) => {
            
        contentData.insertAdjacentHTML("beforeend", `
        <div class="card">
            <div class="head">
                <div>
                    <i class="bx bx-desktop"></i>
                    <h2>${office[0]}</h2>
                    <p>${office[1]}</p>
                </div>
            </div>
        </div>
        `)
        })
    }
})

getCityAndNumberByCountrySelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Get city and number by country";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="getCityAndNumberByCountry">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            contentData.innerHTML = "";
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getCityAndNumberByCountry') {
                if(getToken()) {
                    let office = await offices.getCityAndNumberByCountry(getToken(), searchImput.value);
                    console.log(office);
                    office.forEach((office) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-desktop"></i>
                                    <h2>${office[0]}</h2>
                                    <p>${office[1]}</p>
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

getAddressByCitySelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Get address by city";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="getAddressByCity">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            contentData.innerHTML = "";
            e.preventDefault(searchImput.value);
            if(e.target.id === 'getAddressByCity') {
                if(getToken()) {
                    let office = await offices.getAddressByCity(getToken(), searchImput.value);
                    console.log(office);
                    office.forEach((office) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-desktop"></i>
                                    <h2>${office[0]}</h2>
                                    <p>${office[1]}</p>
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