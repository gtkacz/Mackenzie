
window.onload = reset;
const player1 = 'o';
const player2 = 'x';
const vazio = '';
let ganhou = false;
let ganhador = '';

let jogador = player1;
let tabuleiro =
  [vazio, vazio, vazio,
    vazio, vazio, vazio,
    vazio, vazio, vazio];

function reset() {
  jogador = player1;
  ganhou = false;
  for (let i = 0; i < 9; i++) {
    let cell = document.getElementById(`celula_${i}`);
    cell.innerHTML = '';
    tabuleiro[i] = vazio
  }
  updateRound();
}

function gameOver(type) {
  if (type === 'ganhou'){
    jogador = (jogador === player1) ? player2 : player1;
    alert(`${jogador.toUpperCase()} ganhou`);
    updateScore('winner');
  }
  else if (type === 'empate'){
    alert('empate');
    updateScore('tie');
  }
  ganhou = true;
} 

function verificaGanhador() {
  if ((tabuleiro[0] !== vazio &&
    tabuleiro[0] === tabuleiro[4] && tabuleiro[0] === tabuleiro[8]) || (tabuleiro[2] !== vazio &&
      tabuleiro[2] === tabuleiro[4] && tabuleiro[2] === tabuleiro[6])) {
    gameOver('ganhou');
  }

  for (let i = 0; i < 9; i+=3) {
    if (tabuleiro[0+i] !== vazio &&
      tabuleiro[0+i] === tabuleiro[1+i] && tabuleiro[0+i] === tabuleiro[2+i]) {
      gameOver('ganhou');
    }
  }

  for (let i = 0; i < 3; i++) {
    if (tabuleiro[i] !== vazio &&
      tabuleiro[i] === tabuleiro[i+3] && tabuleiro[i] === tabuleiro[i+6]) {
      gameOver('ganhou');
    }
  }
}

function jogada(numero) {
  if (ganhou === true) {
    alert("O Jogo acabou");
    return;
  }

  let cell = document.getElementById(`celula_${numero}`);

  if (tabuleiro[numero] === vazio) {
    cell.innerHTML = `<img src="${jogador}.svg" alt='jogador ${jogador}' />`;
    tabuleiro[numero] = jogador;
    jogador = (jogador === player1) ? player2 : player1;

    verificaGanhador();
  }

  updateRound();
}

function updateRound(){
  let rodada = document.getElementById('rodada').innerHTML;
  let update = getNextPlayer(rodada);
  let newPlayer = update[0];
  let oldPlayer = update[1];
  let result = rodada.replace(oldPlayer, newPlayer);
  document.getElementById('rodada').innerHTML = result;
}

function getNextPlayer(phrase){
  let oldPlayer = phrase.split(' ')[0];
  console.log(oldPlayer)

  if (oldPlayer === 'X'){
    return ['O', 'X']
  }
  else {
    return ['X', 'O']
  }
}

function updateScore(type){
  if (type === 'tie'){
    let cell = document.getElementById('tie-score');
    let counter = cell.innerHTML+1;
    cell.innerHTML = counter;
  }
  else{
    let cell = document.getElementById(`${jogador}-score`);
    let counter = Number(cell.innerHTML)+1;
    cell.innerHTML = counter;
  }
}