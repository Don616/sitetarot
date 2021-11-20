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

// ARRAYS COM DADOS DAS CARTAS

var nome_arcano = ['O Louco','O Mago','A Sacerdotiza', 'A Imperatriz', 'O Imperador', 'O Hierofante', 'Os Amantes', 'O Carro','A Justiça','O Eremita','A Fortuna','A Força','O Enforcado',
'A Morte','A Temperança','O Diabo','A Torre','A Estrela','A Lua','O Sol','O Julgamento','O Mundo','Ás de Paus', '2 de Paus','3 de Paus','4 de Paus','5 de Paus','6 de Paus','7 de Paus',
'8 de Paus','9 de Paus','10 de Paus','Cavaleiro de Paus','Rainha de Paus','Príncipe de Paus','Princesa de Paus','Ás de Copas','2 de Copas','3 de Copas','4 de Copas','5 de Copas','6 de Copas','7 de Copas','8 de Copas','9 de Copas','10 de Copas',
'Cavaleiro de Copas','Rainha de Copas','Príncipe de Copas','Princesa de Copas','Ás de Espadas','2 de Espadas','3 de Espadas','4 de Espadas','5 de Espadas','6 de Espadas','7 de Espadas','8 de Espadas','9 de Espadas','10 de Espadas',
'Cavaleiro de Espadas','Rainha de Espadas','Príncipe de Espadas','Princesa de Espadas','Ás de Moedas','2 de Moedas','3 de Moedas','4 de Moedas','5 de Moedas','6 de Moedas','7 de Moedas','8 de Moedas','9 de Moedas','10 de Moedas',
'Cavaleiro de Moedas','Rainha de Moedas','Príncipe de Moedas','Princesa de Moedas'];

var naipe_arcano = ['Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito','Espírito',
'Espírito','Espírito','Espírito','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Fogo','Água','Água','Água','Água','Água','Água','Água','Água','Água','Água','Água','Água','Água','Água',
'Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Ar','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra','Terra']



// Lógica para Começar a usar API

function salvar(){

    fetch("/usuarios/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            numeroArcanoServer: rand,
            nomeArcanoServer: nome_arcano[rand],
            naipeArcanoServer: naipe_arcano[rand]

        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "./tiragem.html";
            limparFormulario();
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

