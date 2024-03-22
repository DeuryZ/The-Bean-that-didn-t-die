import { createRequestOptions } from "../functions/getToken.js";

export function getAllProducts(token) {
    const requestOptions = createRequestOptions(token);
    return fetch("http://localhost:8080/product/all", requestOptions)
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

export function getProductById(token, id) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/product/findProductById/${id}`, requestOptions)
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

export function findProductByGamaAndStock(token, gama, stock) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/product/findProductByGamaAndStock/${gama}/${stock}`, requestOptions)
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

export function findProductsWithoutOrders(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/product/findProductsWithoutOrder`, requestOptions)
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

export function expensiveCheap(token) {
    const requestOptions = createRequestOptions(token);
    return fetch(`http://localhost:8080/product/expensive-cheap`, requestOptions)
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