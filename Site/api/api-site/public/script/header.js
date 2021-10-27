    // mudar pagina no select
    let selectEl = document.getElementsByTagName('select');

    selectEl[0].addEventListener('change', function() {
        location.href=this.value;
    });

    menu.value = "";
    // sistema do carrossel de imagens