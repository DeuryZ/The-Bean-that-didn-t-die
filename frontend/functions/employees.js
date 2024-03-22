import { createRequestOptions } from "../functions/getToken.js";

export function getAllEmployees(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/employees/all", requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function findEmployeeById(token, id) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/getEmployeeById/${id}`, requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
    
}

export function getEmployeeInfoByReportsTo(token, id) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/getEmployeeInfoByReportsTo/${id}`, requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
    
}

export function findBossCompany(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findBossCompany`, requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
    
}

export function findDifferentByJobTitle(token, jobTitle) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findDifferentByJobTitle/${jobTitle}`, requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
    
}

export function findAllEmployeesWithBoss(token){
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findAllEmployeesWithBoss`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function findAllEmployeesWithBossAndBoss(token){
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findAllEmployeesWithBossAndBoss`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function findAllEmployeesWithoutOffice(token){
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findAllEmployeesWithoutOffice`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function findAllEmployeesWithoutClients(token){
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findAllEmployeesWithoutClients`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function findAllEmployeesWithoutClientsOrOffice(token){
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/findAllEmployeesWithoutClientsOrOffice`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function total (token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/total`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}

export function clientsPerEmployee (token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/employees/clients-per-employee`, requestOptions)
    .then((response) => {
        if (!response.ok) {
          throw new Error("Error al ejecutar la solicitud");
        }
        return response.json();
      })
      .catch((error) => {
        console.error("Error:", error);
        throw error;
      });
}