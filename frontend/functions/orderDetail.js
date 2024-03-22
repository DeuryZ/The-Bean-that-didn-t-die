import { createRequestOptions } from "../functions/getToken.js";

export function bestSelling(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orderDetail/best-selling", requestOptions)
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

export function calculate (token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orderDetail/calculate", requestOptions)
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

export function billingByProduct (token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orderDetail/billing-by-product", requestOptions)
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

export function billingByProductWithOR (token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orderDetail/billing-by-productWithOR", requestOptions)
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

export function getProductsGreaterThan3000 (token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orderDetail/vents-greater-than-3000", requestOptions)
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