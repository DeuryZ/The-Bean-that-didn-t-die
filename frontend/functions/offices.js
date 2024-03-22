import { createRequestOptions } from "../functions/getToken.js";

export function getAllOffices(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/offices/all", requestOptions)
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

export function getOfficeById(token, officeId) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/offices/getOfficeById/${officeId}`, requestOptions)
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

export function getCodeAndCityByOffice(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/offices/getCodeAndCityByOffice`, requestOptions)
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

export function getCityAndNumberByCountry(token, country) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/offices/getCityAndNumberByCountry/${country}`, requestOptions)
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

export function getAddressByCity(token, city) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/offices/getAddressByCity/${city}`, requestOptions)
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