const url = "https://mack-webmobile.vercel.app/api/users";

async function buscarEmpregados() {
    const response = await fetch(url);
    const employees = await response.json();
    console.log(employees[0])

    let html = "";
    for (let i = 0; i < employees.length; i++) {
        html += createNewCard(employees[i]);
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

    html += `<div class="content-line"><span>Salário: <b>R$ ${employee.salary}</b></span><img src="images/edit.png" class="icon"></div>`;

    html += `<div class="content-line"><span>Aniversário: <b>${employee.date}</b></span><img src="images/delete.png" class="icon"></div>`;

    html += `</section>`;

    html += `</main>`;


    html += `</div>`;

    return html;
}

buscarEmpregados();