// Elementy pobierane z dokumentu HTML.

const conditionElem = document.querySelector(".status");
const resetElm = document.querySelector(".reset");
const boardElements = document.querySelectorAll(".game-cell");

// Alert element (z dokumentu HTML).
const alertInfo = document.querySelector('div');

// Zmienne stałe, których wartość nie może się zmienić.
// Wykorzystywane do sprawdzania warunków.

const xSymbol = "x";
const oSymbol = "o";

// game variables

let gameIsLive = true; // jeżeli zmienna 'gameIsLive === true' to gra trwa, jak ma wartość false to niestety się kończy :(
let xIsNext = true;
let winner = null;
let xcounter = 0;
let ocounter = 0;
let first_p = document.querySelector('.first');
let second_p = document.querySelector('.second');
let up = document.querySelector('.up');
let scorereset = document.querySelector('.scorereset')

const letterToSymbol = (letter) => (letter === "x" ? xSymbol : oSymbol);

/* funcion letterToSymbol(letter) {
  if(letter === "x"){
    letter = xSymbol;
  }else{
    letter = oSymbol;
  }
}
*/ 

const handleWin = (letter) => {
  gameIsLive = false;
  winner = letter;

  if (winner === "x") {
    conditionElem .innerHTML = `${letterToSymbol(winner)} has won!`;
    xcounter++;
    localStorage.setItem("X wons", xcounter);
    // console.log(`${xcounter}`);
    first_p.textContent = `Player "X" wons: ${xcounter}`;
    window.scrollTo(0, document.body.scrollHeight);

  
    
  } else {
    conditionElem .innerHTML = `<span>${letterToSymbol(winner)} has won!</span>`;
    ocounter++;
    localStorage.setItem("O wons", ocounter);
    // console.log(`wygrane O (gracz 2): ${ocounter}`);
    second_p.textContent = `Player "O" wons: ${ocounter}`;
    window.scrollTo(0, document.body.scrollHeight);


  }
};

const checkGameStatus = () => {
  const topLeft = boardElements[0].classList[2];
  const topMiddle = boardElements[1].classList[2];
  const topRight = boardElements[2].classList[2];
  const middleLeft = boardElements[3].classList[2];
  const middleMiddle = boardElements[4].classList[2];
  const middleRight = boardElements[5].classList[2];
  const bottomLeft = boardElements[6].classList[2];
  const bottomMiddle = boardElements[7].classList[2];
  const bottomRight = boardElements[8].classList[2];

  // Cała logika gry.
  // Instrukcja warunkowa, która zawiera wszystkie możliwości wygranej w grze.
  // Jeżeli jeden z tych warunków będzie 'Prawdą' to dodatkowo na te wybrane elementy jest nadawana klasa CSS (zdefiniowana w pliku CSS).

  if (topLeft && topLeft === topMiddle && topLeft === topRight) {
    handleWin(topLeft);
    boardElements[0].classList.add("won");
    boardElements[1].classList.add("won");
    boardElements[2].classList.add("won");

    boardElements[3].disabled = true;
    boardElements[4].disabled = true;
    boardElements[5].disabled = true;
    boardElements[6].disabled = true;
    boardElements[7].disabled = true;
    boardElements[8].disabled = true;

  } else if (middleLeft && middleLeft === middleMiddle && middleLeft === middleRight) {
    handleWin(middleLeft);
    boardElements[3].classList.add("won");
    boardElements[4].classList.add("won");
    boardElements[5].classList.add("won");

    boardElements[0].disabled = true;
    boardElements[1].disabled = true;
    boardElements[2].disabled = true;
    boardElements[6].disabled = true;
    boardElements[7].disabled = true;
    boardElements[8].disabled = true;
  } else if (bottomLeft && bottomLeft === bottomMiddle && bottomLeft === bottomRight) {
    handleWin(bottomLeft);
    boardElements[6].classList.add("won");
    boardElements[7].classList.add("won");
    boardElements[8].classList.add("won");

    boardElements[0].disabled = true;
    boardElements[1].disabled = true;
    boardElements[2].disabled = true;
    boardElements[3].disabled = true;
    boardElements[4].disabled = true;
    boardElements[5].disabled = true;
  } else if (topLeft && topLeft === middleLeft && topLeft === bottomLeft) {
    handleWin(topLeft);
    boardElements[0].classList.add("won");
    boardElements[3].classList.add("won");
    boardElements[6].classList.add("won");

    boardElements[1].disabled = true;
    boardElements[2].disabled = true;
    boardElements[4].disabled = true;
    boardElements[5].disabled = true;
    boardElements[7].disabled = true;
    boardElements[8].disabled = true;
  } else if (topMiddle && topMiddle === middleMiddle && topMiddle === bottomMiddle) {
    handleWin(topMiddle);
    boardElements[1].classList.add("won");
    boardElements[4].classList.add("won");
    boardElements[7].classList.add("won");

    boardElements[0].disabled = true;
    boardElements[2].disabled = true;
    boardElements[3].disabled = true;
    boardElements[5].disabled = true;
    boardElements[6].disabled = true;
    boardElements[8].disabled = true;
  } else if (topRight && topRight === middleRight && topRight === bottomRight) {
    handleWin(topRight);
    boardElements[2].classList.add("won");
    boardElements[5].classList.add("won");
    boardElements[8].classList.add("won");

    boardElements[0].disabled = true;
    boardElements[1].disabled = true;
    boardElements[3].disabled = true;
    boardElements[4].disabled = true;
    boardElements[6].disabled = true;
    boardElements[7].disabled = true;
  } else if (topLeft && topLeft === middleMiddle && topLeft === bottomRight) {
    handleWin(topLeft);
    boardElements[0].classList.add("won");
    boardElements[4].classList.add("won");
    boardElements[8].classList.add("won");

    boardElements[1].disabled = true;
    boardElements[2].disabled = true;
    boardElements[3].disabled = true;
    boardElements[5].disabled = true;
    boardElements[6].disabled = true;
    boardElements[7].disabled = true;
  } else if (topRight && topRight === middleMiddle && topRight === bottomLeft) {
    handleWin(topRight);
    boardElements[2].classList.add("won");
    boardElements[4].classList.add("won");
    boardElements[6].classList.add("won");

    boardElements[0].disabled = true;
    boardElements[1].disabled = true;
    boardElements[3].disabled = true;
    boardElements[5].disabled = true;
    boardElements[7].disabled = true;
    boardElements[8].disabled = true;
  } else if (topLeft && topMiddle && topRight && middleLeft && middleMiddle && middleRight && bottomLeft && bottomMiddle && bottomRight) {
    gameIsLive = false;
    conditionElem .innerHTML = "Game over!";
  } else {
    xIsNext = !xIsNext;
    if (xIsNext) {
      conditionElem .innerHTML = `First player turn!`;
    } else {
      conditionElem .innerHTML = `<span>Second player turn!</span>`;
    }
  }
};

  // Funkcja handleReset() jest odpowiedzialna za resetowanie naszej tzw. 'planszy gry' == jej zawartości.
  // Dodatkowo mamy funkcję setTimeout(), której zadaniem jest odebranie klasy naszemu alertowi oraz wyczyszczenie jego zawartości,
  // podpiąłem jeszcze styl ('transition'), aby fajnie znikał element po 3 sekundach ;).

const resetGame = () => {
  xIsNext = true;
  conditionElem .innerHTML = `First player turn!`;
  for (const boardElement of boardElements) {
    boardElement.classList.remove("x");
    boardElement.classList.remove("o");
    boardElement.classList.remove("won");

    boardElements[0].disabled = false;
    boardElements[1].disabled = false;
    boardElements[2].disabled = false;
    boardElements[3].disabled = false;
    boardElements[4].disabled = false;
    boardElements[5].disabled = false;
    boardElements[6].disabled = false;
    boardElements[7].disabled = false;
    boardElements[8].disabled = false;
    alertInfo.classList.add('alert');
    alertInfo.textContent = "Reset complete!";
    
    setTimeout(() => {
      alertInfo.classList.remove('alert');
      alertInfo.textContent = "";
      alertInfo.style.transition = "0.8s";
      
    }, 2500);
    
  }
};

const handleCellClick = (e) => {
  const classList = e.target.classList;
  // const location = e.target.classList[1];
  // console.log(`location: ${location}`);
  
  if (classList[2] === "x" || classList[2] === "o") {
    return;
  }

  // Instrukacja warunkowa, która sprawdza czy x jest prawdziwe 
  // (jak tak to nadaj klasę 'x', która jest w pliku CSS, a jak x jest fałszywe to nadaj klasę o nazwie 'o').
  // Tyczy się to znaków X i Y.
  if (xIsNext) {
    // jeżeli x jest prawdą, nadaj klasę o nazwie 'x'.
    e.target.classList.add("x");
    checkGameStatus();
  } else {
    // jeżeli x jest fałszem, nadaj klasę 'o'.
    e.target.classList.add("o");
    checkGameStatus();
  }
};

// Nasłuchiwania na dane elementy.
resetElm.addEventListener("click", resetGame);

for (const boardElement of boardElements) {
  boardElement.addEventListener("click", handleCellClick);
}

//Funkcja UP

function upscroll () {
  window.scrollTo(0, 0);
}

up.addEventListener('click', upscroll);

function resetscore () {
  first_p.textContent = `Player "X" wons: 0`;
  second_p.textContent= `Player "O" wons: 0`;
  xcounter = 0;
  ocounter = 0;
}
scorereset.addEventListener('click', resetscore);
