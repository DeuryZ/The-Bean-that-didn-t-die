import { getToken } from "../functions/getToken.js";
import * as product from "../functions/product.js";

//------------------- Selectors -------------------
let getAllSelector = document.querySelector('#getAllProducts');
let findProductByGamaAndStockSelector = document.querySelector('#findProductByGamaAndStock');
let findProductsWithoutOrdersSelector = document.querySelector('#findProductsWithoutOrder');
let expensiveCheapSelector = document.querySelector('#expensive-cheap');

let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');

getAllSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "All products";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
    if(getToken()) {
        let products = await product.getAllProducts(getToken());
        console.log(products);
        contentData.innerHTML = "";
        products.forEach(product => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${product.name}</h2>
                        <p>Dimensions: ${product.dimensions}</p>
                        <p>Code: ${product.productCode}</p>
                        <p>Quantity in stock: ${product.quantityInStock}</p>
                        <p>Sale price: ${product.salePrice}</p>
                        <p>Supplier: ${product.supplier}</p>
                        <p>Supplier price: ${product.supplierPrice}</p>
                        <p> </p>
                        <hr>
                        <p>Description: ${product.description}</p>
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
                    let productData = await product.getProductById(getToken(), searchImput.value);
                    console.log(product);
                    contentData.innerHTML = "";
                    contentData.insertAdjacentHTML("beforeend", `
                    <div class="card">
                        <div class="head">
                            <div>
                                <i class="bx bx-user"></i>
                                <h2>${productData.name}</h2>
                                <p>Dimensions: ${productData.dimensions}</p>
                                <p>Code: ${productData.productCode}</p>
                                <p>Quantity in stock: ${productData.quantityInStock}</p>
                                <p>Sale price: ${productData.salePrice}</p>
                                <p>Supplier: ${productData.supplier}</p>
                                <p>Supplier price: ${productData.supplierPrice}</p>
                                <p> </p>
                                <hr>
                                <p>Description: ${productData.description}</p>
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

findProductByGamaAndStockSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Find product by gama and stock";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="gama">
        <input type="text" id="searchInput2" placeholder="Stock">
        <button class ="search-button" id="findProductByGamaAndStock">Search</button> 
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        let searchImput2 = document.querySelector('#searchInput2');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'findProductByGamaAndStock') {
                if(getToken()) {
                    let productData = await product.findProductByGamaAndStock(getToken(), searchImput.value, searchImput2.value);
                    console.log(productData);
                    contentData.innerHTML = "";
                    productData.forEach(product => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-user"></i>
                                    <h2>${product.name}</h2>
                                    <p>Dimensions: ${product.dimensions}</p>
                                    <p>Code: ${product.productCode}</p>
                                    <p>Quantity in stock: ${product.quantityInStock}</p>
                                    <p>Sale price: ${product.salePrice}</p>
                                    <p>Supplier: ${product.supplier}</p>
                                    <p>Supplier price: ${product.supplierPrice}</p>
                                    <p> </p>
                                    <hr>
                                    <p>Description: ${product.description}</p>
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

findProductsWithoutOrdersSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Find products without orders";
    searchContent.innerHTML = "";
                if(getToken()) {
                    let productData = await product.findProductsWithoutOrders(getToken());
                    console.log(productData);
                    contentData.innerHTML = "";
                    productData.forEach(product => {
                        contentData.insertAdjacentHTML("beforeend", `
                        <div class="card">
                            <div class="head">
                                <div>
                                    <i class="bx bx-user"></i>
                                    <h2>${product.name}</h2>
                                    <p>Dimensions: ${product.dimensions}</p>
                                    <p>Code: ${product.productCode}</p>
                                    <p>Quantity in stock: ${product.quantityInStock}</p>
                                    <p>Sale price: ${product.salePrice}</p>
                                    <p>Supplier: ${product.supplier}</p>
                                    <p>Supplier price: ${product.supplierPrice}</p>
                                    <p> </p>
                                    <hr>
                                    <p>Description: ${product.description}</p>
                                    </div>
                            </div>
                        </div>
                        `)
                    })
                }else {
                    console.log("No hay token");
                }
            
})

expensiveCheapSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Expensive cheap";
    searchContent.innerHTML = "";
    if(getToken()) {
        let productData = await product.expensiveCheap(getToken());
        console.log(productData);
        contentData.innerHTML = "";
        productData.forEach(product => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-user"></i>
                        <h2>${product.name}</h2>
                        <p>Dimensions: ${product.dimensions}</p>
                        <p>Code: ${product.productCode}</p>
                        <p>Quantity in stock: ${product.quantityInStock}</p>
                        <p>Sale price: ${product.salePrice}</p>
                        <p>Supplier: ${product.supplier}</p>
                        <p>Supplier price: ${product.supplierPrice}</p>
                        <p> </p>
                        <hr>
                        <p>Description: ${product.description}</p>
                        </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})