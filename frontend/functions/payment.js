import { createRequestOptions } from "../functions/getToken.js";

export function getAllPayments(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/payments/all", requestOptions)
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

export function getPaymentsByTypeAndYearOrganized(token, year, type) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/payments/getPaymentsByTypeAndYearOrganized/${year}/${type}`, requestOptions)
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

export function getPaymentMethods(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/payments/getPaymentMethods", requestOptions)
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

export function averagePayment2009(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/payments/average-payment-2009", requestOptions)
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

export function totalByYear(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/payments/total-by-year", requestOptions)
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