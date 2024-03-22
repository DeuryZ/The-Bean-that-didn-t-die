import { getToken } from "../functions/getToken.js";
import { findRangeProductByClientId } from "../functions/rangeProduct.js";

let findRangeProductByClientIdSelector = document.querySelector('#findRangeProductByClientId');

let contentData = document.querySelector('.info-data');
let searchContent = document.querySelector('.search');
let title = document.querySelector('.title');

findRangeProductByClientIdSelector.addEventListener('click', async (e) => {
    e.preventDefault();
    title.innerHTML = "Range Products";
    searchContent.innerHTML = "";
    searchContent.insertAdjacentHTML("beforeend", `
        <input type="text" id="searchInput" placeholder="Search">
        <button class ="search-button" id="searchAllById">Search</button>
    `);
    if(getToken()) {
        let searchImput = document.querySelector('#searchInput');
        let searchBtn = document.querySelector('.search-button');
        searchBtn.addEventListener('click', async (e) => {
            e.preventDefault(searchImput.value);
            if(e.target.id === 'searchAllById') {
                if(getToken()) {
                    let rangeProduct = await findRangeProductByClientId(getToken(), searchImput.value);
                    console.log(rangeProduct);
                    contentData.innerHTML = "";
                    if(rangeProduct.length > 0) {
                        rangeProduct.forEach((rangeProduct) => {   
                            contentData.insertAdjacentHTML("beforeend", `
                            <div class="card">
                                <div class="head">
                                    <div>
                                        <i class="bx bx-user"></i>
                                        <h2>${rangeProduct.range}</h2>
                                        <p>Description: ${rangeProduct.textDescription}</p>
                                        <p>Image: ${rangeProduct.image}</p>
                                        <p>htmlDescription: ${rangeProduct.clientId}</p>
                                    </div>
                                </div>
                            </div>
                            `)
                        })
                    }
                }else {
                    console.log("No hay token");
                }
            }
        })
    }
})
