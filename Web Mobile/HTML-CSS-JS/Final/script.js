
window.onload = reset;
const player1 = 'o';
const player2 = 'x';
const vazio = '';
let ganhou = false;

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
}

function gameOver(type) {
  if (type === 'ganhou'){
    alert('ganhou');
  }
  else if (type === 'empate'){
    alert('empate');
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

}







