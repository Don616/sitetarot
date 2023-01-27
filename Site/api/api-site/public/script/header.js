
cabeça()
function cabeça(){

    var id_user = localStorage.getItem('ID_USUARIO');
    
    
    //console.log(id_user)
    if(id_user != undefined){
        //console.log(id_user)
        header.style.display = `none`
        header2.style.display = `flex`
    } else {
        header.style.display = `flex`
        header2.style.display = `none`
}
    //nome_logado.innerHTML = `Olá, ${nome_user}`

}

function deslogar(){
    var nome_user = localStorage.getItem('NOME_USUARIO');
    var sair = confirm(`Tem certeza que deseja sair, ${nome_user}?`,);
    if(sair == true){

        localStorage.clear();
        window.location = "./index.html";

    }


}