import { createRequestOptions } from "../functions/getToken.js";

export function findRangeProductByClientId(token, clientId) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/rangeProduct/findRangeProductByClientId/${clientId}`, requestOptions)
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