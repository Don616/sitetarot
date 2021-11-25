var user = localStorage.getItem('ID_USUARIO');

if(user == undefined){
    
    alert('Erro no Login. Redirecionando...')
    document.location = './login.html';
    
}

var modalidade;
var myIndex = 0;
var x;
var carta_escolhida;
var rand;


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
    setTimeout(carousel, 1);    
}

function todosArcanos(){
    
    for(let i = 0; i < 77; i++){

        var cartas = document.getElementById('cartas')
        var sorteada = document.getElementById('carta_sorteada')
        var item = document.createElement('img');
        var botao = document.getElementById('escolher')
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        botao.addEventListener('click', ()=>{

            rand = (Math.random() *77).toFixed(0)
            carta_escolhida = `./imagens/Toth/${rand}.png` 
            caixa2.style.display = 'none';
            caixa3.style.display = 'flex';
            sorteada.src = `${carta_escolhida}`
            sorteada.id = `${rand}`
            

        })

        cartas.appendChild(item);
        

    }
    carousel();
}
/*
function arcanosMaiores(){

    for(let i = 0; i < 21; i++){

        var cartas = document.getElementById('cartas')
        var item = document.createElement('img');
        var botao = document.getElementById('escolher')
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        botao.addEventListener('click', ()=>{

            let rand = (Math.random() *21).toFixed(0)
            carta_escolhida = `./imagens/Toth/${rand}.png` 
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
        var botao = document.getElementById('escolher')
        item.setAttribute('id',`img${i}`);
        item.setAttribute('class',`mySlides slider_animacao`);
        item.setAttribute('src',`./imagens/Toth/${i}.png`);
        botao.addEventListener('click', ()=>{

            let rand = (Math.random() *56 +21).toFixed(0)
            carta_escolhida = `./imagens/Toth/${rand}.png` 
            caixa2.style.display = 'none';
            caixa3.style.display = 'flex';
            carta_sorteada.src = `${carta_escolhida}`
            console.log(carta_escolhida)

        })

        cartas.appendChild(item);

    }
    carousel();
}
*/


// Lógica para Começar a usar API

function salvar() {

    console.log('Enviando... ' + user)
    console.log('Enviando... ' + rand)

    fetch("/arcanos/salvar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userServer: user,
            sorteadaServer: rand,

        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Carta salva com sucesso");
            //window.location = "./dashboard.html";
            
            //finalizarAguardar();
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false;
}

