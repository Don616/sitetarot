var express = require("express");
var router = express.Router();

var arcanosController = require("../controllers/arcanosController");

router.get("/dados/:ID_USER", function (req, res) {
    arcanosController.pegarCartaQueMaisSaiu(req, res);
});

router.post("/salvar", function (req, res) {
    arcanosController.salvar(req, res);
})

router.get("/totalcartas/:user", function (req, res) {
    arcanosController.obterTotalCartas(req, res);
});

module.exports = router;

