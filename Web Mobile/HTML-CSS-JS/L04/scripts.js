const url = "https://mack-webmobile.vercel.app/api/users";

async function buscarEmpregados() {
    const empregados = await fetch(url).then((resp) => resp.json);
}