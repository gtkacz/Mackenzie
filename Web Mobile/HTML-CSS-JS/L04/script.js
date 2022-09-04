const url = "https://mack-webmobile.vercel.app/api/users";

async function getEmployees() {
    const response = await fetch(url);
    const employees = await response.json();

    createCardRows(employees);
}

function createCardRows(employees) {
    // let row_count = Math.ceil(employees.length / 3);
    let row_count = 0;

    let html = "";

    let html_row = '<div class="card-row">';

    for (let i = 0; i < employees.length; i++) {
        html_row += createNewCard(employees[i]);
        row_count++;

        if (row_count == 3) {
            html += (html_row + "</div>" + "<br>");
            html_row = '<div class="card-row">';
            row_count = 0;
        }
    }

    if (!html.endsWith("</div></div>")) {
        html += (html_row + "</div>");
    }

    document.getElementById("container").innerHTML = html;
}

function createNewCard(employee) {
    let html = `<div class="card ${(employee.status).toLowerCase()}" id="${employee._id}">`;


    html += `<header class="card-header"><img src="${employee.avatar}" alt="${employee.name}" title="${employee.name}" class="avatar"></header>`;

    html += `<img src="images/divider.png" class="divider">`;

    html += `<main class="card-content">`;

    html += `<section class="content-header"><span class="person">${(employee.name).toUpperCase()}</span><small><a href="mailto:${employee.email}">${employee.email}</a></small></section>`;

    html += `<section class="content-grid">`;

    html += `<div class="content-line"><span>Salário: <b>R$ ${numberToMoney(employee.salary)}</b></span><img src="images/edit.png" class="icon"></div>`;

    html += `<div class="content-line"><span>Aniversário: <b>${stringToBrazilianDate(employee.date)}</b></span><img src="images/delete.png" class="icon"></div>`;

    html += `</section>`;

    html += `</main>`;


    html += `</div>`;

    return html;
}

function numberToMoney(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + ",00";
}

function stringToBrazilianDate(x) {
    let dateObject = new Date(x);
    return (dateObject.toLocaleDateString('pt-BR'));
}

getEmployees();