var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function (req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function (req, res) {
    usuarioController.listar(req, res);
});

router.post("/cadastrar", function (req, res) {
    usuarioController.cadastrar(req, res);
})

router.post("/autenticar", function (req, res) {
    usuarioController.entrar(req, res);
});

router.post("/salvar", function (req, res) {
    usuarioController.salvar(req, res);
});

// minhas rotas

router.post("/cadastrarCartas", function (req, res) {
    usuarioController.cadastrar_cartas(req, res);
})

router.get("/pegarDados", function (req, res) {
    usuarioController.pegar_dados(req, res);
});

router.get("/pegarUser", function (req, res) {
    usuarioController.pegar_user(req, res);
});

module.exports = router;