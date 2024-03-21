
import { createRequestOptions } from "../functions/getToken.js";
export function getAllClients(token) {
    const requestOptions = createRequestOptions(token);
    console.log(requestOptions);
        return fetch("http://localhost:8080/clients/all", requestOptions)
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

export function getClientById(token, clientId) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientById/${clientId}`, requestOptions)
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

