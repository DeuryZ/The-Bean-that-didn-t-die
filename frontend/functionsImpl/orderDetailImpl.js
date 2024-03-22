import { getToken } from "../functions/getToken.js";
import * as orderDetail from "../functions/orderDetail.js";

//------------------- Selectors -------------------

let bestSellingSelector = document.querySelector('#best-selling');
let calculateSelector = document.querySelector('#calculate');
let billingByProductSelector = document.querySelector('#billing-by-product');
let billingByProductWithORSelector = document.querySelector('#billing-by-productWithOR');
let getProductsGreaterThan3000Selector = document.querySelector('#get-products-greater-than-3000');

let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');

bestSellingSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Best selling";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()){
        let bestSellingData = await orderDetail.bestSelling(getToken());
        contentData.innerHTML = "";
        console.log(bestSellingData);
        bestSellingData.map((bestSellingDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${bestSellingDataMap[0]}</h2>
                        <p>${bestSellingDataMap[1]}</p>
                    </div>
                </div>
            </div>
            `);            
        })
    }

})

calculateSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Calculate";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()){
        let calculateData = await orderDetail.calculate(getToken());
        contentData.innerHTML = "";
        console.log(calculateData);
        calculateData.map((calculateDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>Price :${calculateDataMap[0]}</h2>
                        <p>Iva: ${calculateDataMap[1]}</p>
                        <p>Total: ${calculateDataMap[2]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

billingByProductSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Billing by product";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()){
        let billingByProductData = await orderDetail.billingByProduct(getToken());
        contentData.innerHTML = "";
        console.log(billingByProductData);
        billingByProductData.map((billingByProductDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>Code: ${billingByProductDataMap[0]}</h2>
                        <p>Price: ${billingByProductDataMap[1]}</p>
                        <p>Iva: ${billingByProductDataMap[2]}</p>
                        <p>Total: ${billingByProductDataMap[3]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

billingByProductWithORSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Billing by product with OR";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()){
        let billingByProductWithORData = await orderDetail.billingByProductWithOR(getToken());
        contentData.innerHTML = "";
        console.log(billingByProductWithORData);
        billingByProductWithORData.map((billingByProductWithORDataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>Code: ${billingByProductWithORDataMap[0]}</h2>
                        <p>Price: ${billingByProductWithORDataMap[1]}</p>
                        <p>Iva: ${billingByProductWithORDataMap[2]}</p>
                        <p>Total: ${billingByProductWithORDataMap[3]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})

getProductsGreaterThan3000Selector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Get products greater than 3000";
    searchContent.innerHTML = "";
    contentData.innerHTML = "";
    if(getToken()){
        let getProductsGreaterThan3000Data = await orderDetail.getProductsGreaterThan3000(getToken());
        contentData.innerHTML = "";
        console.log(getProductsGreaterThan3000Data);
        getProductsGreaterThan3000Data.map((getProductsGreaterThan3000DataMap) => {
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>Code: ${getProductsGreaterThan3000DataMap[0]}</h2>
                        <p>Price: ${getProductsGreaterThan3000DataMap[1]}</p>
                        <p>Iva: ${getProductsGreaterThan3000DataMap[2]}</p>
                        <p>Total: ${getProductsGreaterThan3000DataMap[3]}</p>
                    </div>
                </div>
            </div>
            `);
        })
    }
})