const url = "https://mack-webmobile.vercel.app/api/users";

async function getEmployees() {
    const response = await fetch(url);
    const employees = await response.json();
    console.log(employees[0])

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
    let html = `<div class="card" id="${employee._id}">`;


    html += `<header class="card-header"><img src="${employee.avatar}" class="avatar"></header>`;

    html += `<img src="images/divider.png" class="divider">`;

    html += `<main class="card-content">`;

    html += `<section class="content-header"><span class="person">${employee.name}</span><small>${employee.email}</small></section>`;

    html += `<section class="content-grid">`;

    html += `<div class="content-line"><span>Salário: <b>R$ ${thousandSeparator(employee.salary)}</b></span><img src="images/edit.png" class="icon"></div>`;

    html += `<div class="content-line"><span>Aniversário: <b>${employee.date}</b></span><img src="images/delete.png" class="icon"></div>`;

    html += `</section>`;

    html += `</main>`;


    html += `</div>`;

    return html;
}

function thousandSeparator(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + ",00";
}

getEmployees();