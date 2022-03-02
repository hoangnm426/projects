//var token = "8062984eadc7e8069661252c250f30db"; // token to access data 
var token = "55239853a82251fe470634e720604d4c";  // token to access data 
/* 
* load top headlines funtion
*/
function loadTopHeadlinesDoc() {
    createSpinner();
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "https://gnews.io/api/v4/top-headlines?token=" + token);
    xhttp.send();
    xhttp.onload = function () {
        document.getElementById("spinner").remove();
        insertHeadline(JSON.parse(this.responseText));
    }
}

/* 
* search funtion
*/
function searchDoc() {
    var searchText = document.getElementById("searchKeyword").value;
    document.getElementById("main").remove();
    createSpinner();
    if (searchText == "") {
        const mainDiv = document.createElement("div");
        mainDiv.setAttribute("id", "main");
        const notFound = document.createElement("p");
        notFound.setAttribute("id", "not-found");
        const notFoundText = document.createTextNode("Text not found!");
        notFound.appendChild(notFoundText);
        mainDiv.appendChild(notFound);
        document.getElementById("container").appendChild(mainDiv);
        document.getElementById("spinner").remove();
    } else {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "https://gnews.io/api/v4/search?q=" + searchText + "&token=" + token);
        xhttp.send();
        xhttp.onload = function () {
            document.getElementById("spinner").remove();
            insertHeadline(JSON.parse(this.responseText));
            document.getElementById("searchKeyword").value = "";
        };
    }
}

/* 
* insert results into container function
*/
function insertHeadline(news) {
    var headlines = news.articles;
    const containerDiv = document.getElementById("container");
    const mainDiv = document.createElement("div");
    mainDiv.setAttribute("id", "main");
    for (let i in headlines) {
        //create div
        const cardDiv = document.createElement("div");
        cardDiv.setAttribute("class", "card mb-3 border-0");

        //creat row
        const rowDiv = document.createElement("div");
        rowDiv.setAttribute("class", "row g-0");

        //creat image div
        const col3Div = document.createElement("div");
        col3Div.setAttribute("class", "col-3");
        const image = document.createElement("img");
        image.setAttribute("src", headlines[i].image);
        image.setAttribute("width", "100%");
        image.setAttribute("height", "200px");
        image.setAttribute("alt", "image");
        col3Div.appendChild(image);

        //create content div
        const col9Div = document.createElement("div");
        col9Div.setAttribute("class", "col-9");

        const cardBodyDiv = document.createElement("div");
        cardBodyDiv.setAttribute("class", "card-body");

        //create title link
        const cardTitle = document.createElement("h5");
        cardTitle.setAttribute("class", "card-title")
        const cardTitleLink = document.createElement("a");
        cardTitleLink.setAttribute("href", headlines[i].url);
        cardTitleLink.setAttribute("target", "_blank");
        const title = document.createTextNode(headlines[i].title);
        cardTitleLink.appendChild(title);
        cardTitle.appendChild(cardTitleLink);

        //create date div
        const smallCardText = document.createElement("p");
        smallCardText.setAttribute("class", "card-text");
        const dateText = document.createElement("i");
        const updatedDate = document.createTextNode(headlines[i].publishedAt);
        dateText.appendChild(updatedDate);
        smallCardText.appendChild(dateText);

        //create content div
        const content = document.createElement("p");
        content.setAttribute("class", "card-text");
        const strongContent = document.createElement("strong");
        const contentText = document.createTextNode(headlines[i].content);
        strongContent.appendChild(contentText);
        content.appendChild(strongContent);

        cardBodyDiv.appendChild(cardTitle);
        cardBodyDiv.appendChild(smallCardText);
        cardBodyDiv.appendChild(content);

        col9Div.appendChild(cardBodyDiv);

        rowDiv.appendChild(col3Div);
        rowDiv.appendChild(col9Div);

        cardDiv.appendChild(rowDiv);

        //append to main div
        mainDiv.appendChild(cardDiv);
    }
    containerDiv.appendChild(mainDiv);
}

/* 
* create spinner function
*/
function createSpinner() {
    const searchBox = document.getElementById("searchBox");

    const spinnerDiv = document.createElement("div");
    spinnerDiv.setAttribute("class", "d-flex justify-content-center");
    spinnerDiv.setAttribute("id", "spinner");

    const spinnerBorderDiv = document.createElement("div");
    spinnerBorderDiv.setAttribute("class", "spinner-border");
    spinnerBorderDiv.setAttribute("role", "status");

    const spinnerText = document.createElement("span");
    spinnerText.setAttribute("class", "visually-hidden");
    const text = document.createTextNode("Loading......");
    spinnerText.appendChild(text);

    spinnerBorderDiv.appendChild(spinnerText);
    spinnerDiv.appendChild(spinnerBorderDiv)

    searchBox.insertAdjacentElement("beforebegin", spinnerDiv);
}

