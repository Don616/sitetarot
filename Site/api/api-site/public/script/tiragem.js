var modalidade;
var myIndex = 0;
var x;
var carta_escolhida;

function continuar(){

    modalidade = modalidades.value;

    caixa1.style.display = 'none';
    caixa2.style.display = 'flex';

    if(modalidade == 'todos'){
        todosArcanos()
    } else if(modalidade == 'maiores'){
        arcanosMaiores()
    } else if(modalidade == 'menores'){
        arcanosMenores()
    }
    

    

    
}
function voltar1(){


    window.location = "./tiragem.html";

}
function carousel() {
    
        
    x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {
        myIndex = 1
    }    
    x[myIndex-1].style.display = "block";
    setTimeout(carousel, 50);    
}

function todosArcanos(){
    
    for(let i = 0; i < 77; i++){

        var cartas = document.getElementById('cartas')
        var item = document.createElement('img');
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        item.addEventListener('click', ()=>{

            carta_escolhida = `./imagens/Toth/${i}.png` 
            caixa2.style.display = 'none';
            caixa3.style.display = 'flex';
            carta_sorteada.src = `${carta_escolhida}`
            console.log(carta_escolhida)

        })
        cartas.appendChild(item);

    }
    carousel();
}

function arcanosMaiores(){

    for(let i = 0; i < 21; i++){

        var cartas = document.getElementById('cartas')
        var item = document.createElement('img');
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        item.addEventListener('click', ()=>{

            carta_escolhida = `./imagens/Toth/${i}.png` 
            caixa2.style.display = 'none';
            caixa3.style.display = 'flex';
            carta_sorteada.src = `${carta_escolhida}`
            console.log(carta_escolhida)

        })
        cartas.appendChild(item);

    }
    carousel();
}

function arcanosMenores(){

    for(let i = 22; i < 77; i++){

        var cartas = document.getElementById('cartas')
        var item = document.createElement('img');
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        item.addEventListener('click', ()=>{

            carta_escolhida = `./imagens/Toth/${i}.png` 
            caixa2.style.display = 'none';
            caixa3.style.display = 'flex';
            carta_sorteada.src = `${carta_escolhida}`
            console.log(carta_escolhida)

        })
        cartas.appendChild(item);

    }
    carousel();
}

