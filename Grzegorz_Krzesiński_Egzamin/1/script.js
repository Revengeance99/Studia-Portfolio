let jaka_liczba = 0;
let ile_liczb = 0;

for(let j=0; j<1000000; j++) {
    let first = j;
    let second = 0;
    let ile = 1;
    let n = 1;
    //console.log(first);
    do {
        if (first % 2 == 0) {
            second = first / 2;
        } else if (first % 2 != 0) {
            second = 3 * first + 1;

        }
        first = second;
        //console.log(second);
        ile++;
    } while (second > 1);


    if(ile>ile_liczb){
        ile_liczb=ile;
        jaka_liczba=j;
    }
}
console.log("Najdłuższy łańcuch jest dla liczby: " + jaka_liczba + " oraz wynosi  " + ile_liczb);

let paragraph = document.querySelector('p');

paragraph.textContent=`Najdłuższy łańcuch jest dla liczby: ${jaka_liczba} oraz wynosi ${ile_liczb}.`;




