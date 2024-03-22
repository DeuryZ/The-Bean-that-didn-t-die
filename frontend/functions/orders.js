import { createRequestOptions } from "../functions/getToken.js";

export function getAllOrders(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/orders/all", requestOptions)
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

export function getOrderById(token, orderId) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/findOrderById/${orderId}`, requestOptions)
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

export function getStates (token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/getStates`, requestOptions)
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

export function getOrdersDeliveredAfterExpectedDate(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/getOrdersDeliveredAfterExpected`, requestOptions)
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

export function getOrdersInDelivery(token, days) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/getOrdersInDelivery/${days}`, requestOptions)
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

export function getOrdersByStateAndYear(token, state, year) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/getOrdersByStateAndYear/${state}/${year}`, requestOptions)
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

export function getOrdersByStateAndMonth(token, state, month) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/getOrdersByStateAndMonth/${state}/${month}`, requestOptions)
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

export function amountByState(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/amount-by-state`, requestOptions)
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

export function firstLastDatesByClient(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/first-last-dates-by-client`, requestOptions)
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

export function getOrdersBySumTotalQuantityByOrder (token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/orders/sum-total-quantity-by-order`, requestOptions)
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