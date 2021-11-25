
cabeça()
function cabeça(){

    var id_user = localStorage.getItem('ID_USUARIO');
    console.log(id_user)
    if(id_user == undefined){
        console.log(id_user)
        header.style.display = `none`
        header2.style.display = `flex`
    } else {
        header.style.display = `flex`
        header2.style.display = `none`
}

}

function deslogar(){

    var sair = confirm('Tem certeza que deseja sair?',);
    if(sair == true){

        localStorage.clear();
        window.location = "./index.html";

    }


}