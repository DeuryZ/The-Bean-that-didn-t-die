import { getToken } from "../functions/getToken.js";
import * as employee from "../functions/employees.js";

//------------------- Selectors -------------------
let getAllSelector = document.querySelector('#getAllEmployees');
let getEmployeeInfoByReportsToSelector = document.querySelector('#getEmployeeInfoByReportsTo');
let findBossCompanySelector = document.querySelector('#findBossCompany');
let findDifferentByJobTitleSelector = document.querySelector('#findDifferentByJobTitle');
let findAllEmployeesWithBossSelector = document.querySelector('#findAllEmployeesWithBoss');
let findAllEmployeesWithBossAndBossSelector = document.querySelector('#findAllEmployeesWithBossAndBoss');
let findAllEmployeesWithoutOfficeSelector = document.querySelector('#findAllEmployeesWithoutOffice');
let findAllEmployeesWithoutClientsSelector = document.querySelector('#findAllEmployeesWithoutClients');
let findAllEmployeesWithoutClientsOrOfficeSelector = document.querySelector('#findAllEmployeesWithoutClientsOrOffice');
let totalSelector = document.querySelector('#total');
let clientsPerEmployeeSelector = document.querySelector('#clients-per-employee');

let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');

getAllSelector.addEventListener('click', async (e) => {
    console.log("getAll");
    e.preventDefault();
    title.innerHTML = "All employees";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
    if(getToken()) {
        let employees = await employee.getAllEmployees(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${element.employeeId}</h2>
                        <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                        <p>Ext: ${element.extension}</p>
                        <p>Email: ${element.email}</p>
                        <p>jobTitle: ${element.jobTitle}</p>
                    </div>
                </div>
            </div>
            `)
        })
    
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'searchAllById') {
                if(getToken()) {
                    let employeeFound = await employee.findEmployeeById(getToken(), searchImput.value);
                    console.log(employeeFound);
                    contentData.innerHTML = "";
                    contentData.insertAdjacentHTML("beforeend", `
                    <div class="card">
                        <div class="head">
                            <div>
                                <i class="bx bx-user"></i>
                                <h2>${employeeFound.employeeId}</h2>
                                <p>${employeeFound.employeeName} ${employee.employeeLastName1} ${employeeFound.employeeLastName2} </p>
                                <p>Ext: ${employeeFound.extension}</p>
                                <p>Email: ${employeeFound.email}</p>
                                <p>jobTitle: ${employeeFound.jobTitle}</p>
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

getEmployeeInfoByReportsToSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Get employee by reports to";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="getEmployeeByReportsTo">Search</button>
    `);
    let searchImput = document.querySelector('#searchInput');
    let searchBtn = document.querySelector('.search-button');
    searchBtn.addEventListener('click', async (e) => {
        e.preventDefault(searchImput.value);
        if(e.target.id === 'getEmployeeByReportsTo') {
            if(getToken()) {
                let employeeFound = await employee.getEmployeeInfoByReportsTo(getToken(), searchImput.value);
                console.log(employeeFound);
                contentData.innerHTML = "";
                employeeFound.forEach((element) => {
                    contentData.insertAdjacentHTML("beforeend", `
                    <div class="card">
                        <div class="head">
                            <div>
                                <i class="bx bx-user"></i>
                                <h2>Name: ${element[0]}</h2>
                                <p>LastNames: ${element[1]}</p>
                                <p>Email: ${element[2]}</p>
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

})

findBossCompanySelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find employee without boss";
    if(getToken()) {
        let employees = await employee.findBossCompany(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${element.employeeId}</h2>
                        <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                        <p>Ext: ${element.extension}</p>
                        <p>Email: ${element.email}</p>
                        <p>jobTitle: ${element.jobTitle}</p>
                    </div>
                </div>
            </div>
            `)
        })

    }else {
        console.log("No hay token");
    }
})

findDifferentByJobTitleSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find different employees by job title";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="findDifferentByJobTitle">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'findDifferentByJobTitle') {
                if(getToken()) {
                    let employees = await employee.findDifferentByJobTitle(getToken(), searchImput.value);
                    console.log(employees);
                    contentData.innerHTML = "";
                    employees.forEach((element) => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-user"></i>
                                    <h2>${element.employeeId}</h2>
                                    <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                                    <p>Ext: ${element.extension}</p>
                                    <p>Email: ${element.email}</p>
                                    <p>jobTitle: ${element.jobTitle}</p>
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

findAllEmployeesWithBossSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find all employees and their boss";
    if(getToken()) {
        let employees = await employee.findAllEmployeesWithBoss(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>Employee: ${element[0]}</h2>
                        <p>Boss: ${element[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

findAllEmployeesWithBossAndBossSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find all employees and their boss";
    if(getToken()) {
        let employees = await employee.findAllEmployeesWithBossAndBoss(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>Employee: ${element[0]}</h2>
                        <p>Boss: ${element[1]}</p>
                        <p>Boss's boss: ${element[2]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

findAllEmployeesWithoutOfficeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find all employees without office";
    if(getToken()) {
        let employees = await employee.findAllEmployeesWithoutOffice(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${element.employeeId}</h2>
                        <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                        <p>Ext: ${element.extension}</p>
                        <p>Email: ${element.email}</p>
                        <p>jobTitle: ${element.jobTitle}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

findAllEmployeesWithoutClientsSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find all employees without clients";
    if(getToken()) {
        let employees = await employee.findAllEmployeesWithoutClients(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${element.employeeId}</h2>
                        <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                        <p>Ext: ${element.extension}</p>
                        <p>Email: ${element.email}</p>
                        <p>jobTitle: ${element.jobTitle}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

findAllEmployeesWithoutClientsOrOfficeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Find all employees without clients or office";
    if(getToken()) {
        let employees = await employee.findAllEmployeesWithoutClientsOrOffice(getToken());
        console.log(employees);
        contentData.innerHTML = "";
        employees.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${element.employeeId}</h2>
                        <p>${element.employeeName} ${element.employeeLastName1} ${element.employeeLastName2} </p>
                        <p>Ext: ${element.extension}</p>
                        <p>Email: ${element.email}</p>
                        <p>jobTitle: ${element.jobTitle}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

totalSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Total";
    if(getToken()) {
        let total = await employee.total(getToken());
        console.log(total);
        contentData.insertAdjacentHTML("beforeend", `
        <div class="card">
            <div class="head">
                <div>
                    <i class="bx bx-user"></i>
                    <h2>${total}</h2>
                </div>
            </div>
        </div>
        `)
    }else {
        console.log("No hay token");
    }
})

clientsPerEmployeeSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    contentData.innerHTML = "";
    title.innerHTML = "Clients per employee";
    if(getToken()) {
        let clientsPerEmployee = await employee.clientsPerEmployee(getToken());
        console.log(clientsPerEmployee);
        clientsPerEmployee.forEach((element) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>Employee: ${element[0]}</h2>
                        <p>Clients: ${element[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})